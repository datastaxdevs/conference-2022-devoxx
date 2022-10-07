package com.datastax.samples;

import static com.datastax.samples.schema.SchemaUtils.createTableVideo;
import static com.datastax.samples.schema.SchemaUtils.createUdtVideoFormat;
import static com.datastax.samples.schema.SchemaUtils.truncateTable;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.core.type.codec.TypeCodec;
import com.datastax.oss.driver.api.core.type.codec.registry.MutableCodecRegistry;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.samples.codec.JsonJacksonTypeCodec;
import com.datastax.samples.dto.VideoDto;
import com.datastax.samples.schema.SchemaConstants;

public class E07_Json implements SchemaConstants {
    
    private static Logger LOGGER = LoggerFactory.getLogger(E07_Json.class);
    
    public static void main(String[] args) {
        try(CqlSession cqlSession = CqlSessionProvider.getInstance().getSession()) {
            createUdtVideoFormat(cqlSession);
            createTableVideo(cqlSession);
            truncateTable(cqlSession, VIDEO_TABLENAME);
            
            // Insert as a String - with regular Core CQL
            UUID videoid1 = UUID.randomUUID();
            cqlSession.execute(""
                    + "INSERT INTO " + VIDEO_TABLENAME + "(videoid, email, title, upload, url, tags, frames, formats) "
                    + "VALUES("+ videoid1.toString() +", "
                    + "  'clu@sample.com', 'sample video',"
                    + "  toTimeStamp(now()), 'http://google.fr', "
                    + "  { 'cassandra','accelerate','2020'}, "
                    + "  [ 1, 2, 3, 4], "
                    + "  { 'mp4':{width:1,height:1}, "
                    + "    'ogg':{width:1,height:1} "
                    + "  });");
            LOGGER.info("+ Video 'e7ae5cf3-d358-4d99-b900-85902fda9bb0' has been inserted");
            
            // Insert as a String - with a Column as JSON
            UUID videoid2 = UUID.randomUUID();
            cqlSession.execute(SimpleStatement.builder(
                      "INSERT INTO " + VIDEO_TABLENAME + "(videoid, email, title, upload, url, tags, frames, formats) "
                    + "VALUES(?,?,?,?,?,?,?,fromJson(?))")
                    .addPositionalValue(videoid2)
                    .addPositionalValue("clu@sample.com")
                    .addPositionalValue("sample video")
                    .addPositionalValue(Instant.now())
                    .addPositionalValue("http://google.fr")
                    .addPositionalValue(new HashSet<>())
                    .addPositionalValue(Arrays.asList(1,2,3,4))
                    .addPositionalValue("{ \"mp4\":{\"width\":1,\"height\":1}, \"ogg\":{\"width\":1,\"height\":1} }")
                    .build());
            LOGGER.info("+ Video '{}' has been inserted", videoid2);
            
            // Insert as a JSON String
            UUID videoid3 = UUID.randomUUID();
            cqlSession.execute(""
                    + "INSERT INTO " + VIDEO_TABLENAME + " JSON '{"
                    + "\"videoid\":\""+videoid3.toString()+"\"," 
                    + "\"email\":\"clu@sample.com\"," 
                    + "\"title\":\"sample video\"," 
                    + "\"upload\":\"2020-02-26 15:09:22 +00:00\"," 
                    + "\"url\":\"http://google.fr\","
                    + "\"frames\": [1,2,3,4],"
                    + "\"tags\": [\"cassandra\",\"accelerate\", \"2020\"],"
                    + "\"formats\": {" 
                    + "   \"mp4\":{\"width\":1,\"height\":1},"
                    + "   \"ogg\":{\"width\":1,\"height\":1}"
                    + "}}'");
            LOGGER.info("+ Video '{}' has been inserted", videoid3);
            
            // Insert as a JSON Param
            UUID videoid4 = UUID.randomUUID();
            cqlSession.execute(SimpleStatement.builder("INSERT INTO " + VIDEO_TABLENAME + " JSON ? ")
                    .addPositionalValue("{"
                        + "\"videoid\":\""+ videoid4.toString() + "\"," 
                        + "\"email\":\"clu@sample.com\"," 
                        + "\"title\":\"sample video\"," 
                        + "\"upload\":\"2020-02-26 15:09:22 +00:00\"," 
                        + "\"url\":\"http://google.fr\","
                        + "\"frames\": [1,2,3,4],"
                        + "\"tags\": [\"cassandra\",\"accelerate\", \"2020\"],"
                        + "\"formats\": {" 
                        + "   \"mp4\":{\"width\":1,\"height\":1},"
                        + "   \"ogg\":{\"width\":1,\"height\":1}"
                        + "}}")
                    .build());
            LOGGER.info("+ Video '{}' has been inserted", videoid4);
            
            // Insert with QueryBuilder - as a JSON String
            UUID videoid5 = UUID.randomUUID();
            cqlSession.execute(QueryBuilder.insertInto(VIDEO_TABLENAME)
                    .json("{"
                        + "\"videoid\":\""+ videoid5.toString() + "\"," 
                        + "\"email\":\"clu@sample.com\"," 
                        + "\"title\":\"sample video\"," 
                        + "\"upload\":\"2020-02-26 15:09:22 +00:00\"," 
                        + "\"url\":\"http://google.fr\","
                        + "\"frames\": [1,2,3,4],"
                        + "\"tags\": [\"cassandra\",\"accelerate\", \"2020\"],"
                        + "\"formats\": {" 
                        + "   \"mp4\":{\"width\":1,\"height\":1},"
                        + "   \"ogg\":{\"width\":1,\"height\":1}"
                        + "}}")
                    .build());
            LOGGER.info("+ Video '{}' has been inserted", videoid5);
            LOGGER.info("[OK] - All video Inserted");
            
            /** 
             * Register a Codec at runtime
             * Can also be achieved at session init with 
             * .addTypeCodecs(new JsonJacksonTypeCodec<VideoDto>(VideoDto.class))
             */
            MutableCodecRegistry registry = (MutableCodecRegistry) cqlSession.getContext().getCodecRegistry();
            TypeCodec<VideoDto> jsonCodec = new JsonJacksonTypeCodec<VideoDto>(VideoDto.class);
            registry.register(jsonCodec);
            
            // Insert with QueryBuilder - As an object + Jackson Codec
            UUID videoid6 = UUID.randomUUID();
            VideoDto dto  = new VideoDto(videoid6, "sample video", "clu@sample.com", "http://google.fr");
            cqlSession.execute(QueryBuilder
                    .insertInto(VIDEO_TABLENAME)
                    .json(dto, jsonCodec).build());
            LOGGER.info("+ Video '{}' has been inserted", videoid5);
            
            // Read with QueryBuilder - As an object + Jackson Codec
            ResultSet rows = cqlSession.execute(QueryBuilder.selectFrom(VIDEO_TABLENAME).json().all().build());
            for (Row row : rows) {
                VideoDto myVideo = row.get(0, VideoDto.class);
                LOGGER.info("+ Video '{}' has been read ", myVideo.getVideoid());
            }
            LOGGER.info("[OK] - All video read");
        }
    }
}
