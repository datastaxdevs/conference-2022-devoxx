package com.datastax.devoxx;

import static com.datastax.devoxx.schema.SchemaUtils.createTableUser;
import static com.datastax.devoxx.schema.SchemaUtils.truncateTable;

import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.devoxx.schema.SchemaConstants;
import com.datastax.oss.driver.api.core.ConsistencyLevel;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.BatchStatement;
import com.datastax.oss.driver.api.core.cql.BatchStatementBuilder;
import com.datastax.oss.driver.api.core.cql.DefaultBatchType;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.protocol.internal.util.Bytes;

/**
 * !! WARNING Tests with no Assertions here (I assume) !!
 * 
 * @author cedricklunven
 */
public class E09_ResultPagingTest implements SchemaConstants {

    private static Logger LOGGER = LoggerFactory.getLogger(E09_ResultPagingTest.class);

    private static PreparedStatement stmtCreateUser;
    
    @BeforeAll
    public static void shout_init_statements() {
    	try(CqlSession cqlSession = CqlSession.builder().build()) {
            
            createTableUser(cqlSession);
            
            truncateTable(cqlSession, USER_TABLENAME);
            
            stmtCreateUser = 
                    cqlSession.prepare(QueryBuilder.insertInto(USER_TABLENAME)
                    .value(USER_EMAIL, QueryBuilder.bindMarker())
                    .value(USER_FIRSTNAME, QueryBuilder.bindMarker())
                    .value(USER_LASTNAME, QueryBuilder.bindMarker())
                    .build());
    	}
    }
    
    @Test
    public void should_run_batch() {
    	try(CqlSession cqlSession = CqlSession.builder().build()) {
            // Adding 50 records in the table
            BatchStatementBuilder bb = BatchStatement.builder(DefaultBatchType.LOGGED);
            for (int i = 0; i < 50; i++) {
                bb.addStatement(stmtCreateUser.bind("user_" + i + "@sample.com", "user_" + i, "lastname"));
			}
            cqlSession.execute(bb.build());
            LOGGER.info("+ {} users have been created", 50);
            
            // Paged query
            SimpleStatement statement = QueryBuilder.selectFrom(USER_TABLENAME).all().build()
                .setPageSize(10)                    // 10 per pages
                .setTimeout(Duration.ofSeconds(1))  // 1s timeout
                .setConsistencyLevel(ConsistencyLevel.ONE);
            ResultSet page1 = cqlSession.execute(statement);
            
            // Checking
            LOGGER.info("+ Page 1 has {} items", page1.getAvailableWithoutFetching());
            Iterator<Row> page1Iter = page1.iterator();
            while (0 <  page1.getAvailableWithoutFetching()) {
            	LOGGER.info("Page1: " + page1Iter.next().getString(USER_EMAIL));
            }
            
            // Notice that items are NOT ordered (it uses the hashed token)
            // From this point if you invoke .next() driver will look for page2.
            // But we can invoke page2 directly: (useful for delay between calls)
            ByteBuffer pagingStateAsBytes = page1.getExecutionInfo().getPagingState();
            
            // If you need to to externalize this as a STRING
            Bytes.toHexString(pagingStateAsBytes);
            // If you need to go back to byteBuffer
            // ByteBuffer pagingStateAsBytesBack = Bytes.fromHexString(pageStateAsString);
            
            statement.setPagingState(pagingStateAsBytes);
            ResultSet page2 = cqlSession.execute(statement);
            LOGGER.info("+ Page 2 has {} items", page2.getAvailableWithoutFetching());
        }
    }
   
}
