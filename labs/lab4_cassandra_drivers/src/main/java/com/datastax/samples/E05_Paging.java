package com.datastax.samples;

import static com.datastax.samples.schema.SchemaUtils.createTableUser;
import static com.datastax.samples.schema.SchemaUtils.truncateTable;

import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import com.datastax.samples.schema.SchemaConstants;

public class E05_Paging implements SchemaConstants {

    private static Logger LOGGER = LoggerFactory.getLogger(E05_Paging.class);

    public static void main(String[] args) {
        try(CqlSession cqlSession = CqlSessionProvider.getInstance().getSession()) {
            
            createTableUser(cqlSession);
            
            truncateTable(cqlSession, USER_TABLENAME);
            
            PreparedStatement stmtCreateUser = 
                    cqlSession.prepare(QueryBuilder.insertInto(USER_TABLENAME)
                    .value(USER_EMAIL, QueryBuilder.bindMarker())
                    .value(USER_FIRSTNAME, QueryBuilder.bindMarker())
                    .value(USER_LASTNAME, QueryBuilder.bindMarker())
                    .build());

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
