package com.datastax.samples;

import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.literal;
import static com.datastax.samples.schema.SchemaUtils.createTableVideo;
import static com.datastax.samples.schema.SchemaUtils.createUdtVideoFormat;
import static com.datastax.samples.schema.SchemaUtils.truncateTable;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.data.UdtValue;
import com.datastax.oss.driver.api.core.type.UserDefinedType;
import com.datastax.oss.driver.api.core.type.codec.registry.MutableCodecRegistry;
import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.samples.codec.UdtVideoFormatCodec;
import com.datastax.samples.dto.VideoDto;
import com.datastax.samples.dto.VideoFormatDto;
import com.datastax.samples.schema.SchemaConstants;

public class E06_ListSetMapAndUdt implements SchemaConstants {
	
    private static Logger LOGGER = LoggerFactory.getLogger(E06_ListSetMapAndUdt.class);
    
	private static UserDefinedType videoFormatUdt;
    
    private static PreparedStatement stmtCreateVideo;
    private static PreparedStatement stmtReadVideoTags;
    
    public static void main(String[] args) {
        try(CqlSession cqlSession = CqlSessionProvider.getInstance().getSession()) {
            
            // Create table
            createUdtVideoFormat(cqlSession);
            createTableVideo(cqlSession);
            
            // Empty tables for tests
            truncateTable(cqlSession, VIDEO_TABLENAME);
            
            // User define type
            videoFormatUdt = cqlSession.getMetadata()
                .getKeyspace(KEYSPACE_NAME)
                .flatMap(ks -> ks.getUserDefinedType(UDT_VIDEO_FORMAT_NAME))
                .orElseThrow(() -> new IllegalArgumentException("Missing UDT definition"));
            
            // Prepare your statements once and execute multiple times 
            prepareStatements(cqlSession);
            
            // ========= CREATE ============
            
            UUID myVideoId = Uuids.random();
            
            // Dto wrapping all data but no object Mapping here, QueryBuilder only
            VideoDto dto = new VideoDto();
            dto.setVideoid(myVideoId);
            dto.setTitle("The World’s Largest Apache Cassandra™ NoSQL Event | DataStax Accelerate 2020");
            dto.setUrl("https://www.youtube.com/watch?v=7afxKEH7t8Q");
            dto.setEmail("clun@sample.com");
            dto.getTags().add("cassandra");
            dto.getFrames().addAll(Arrays.asList(2, 3, 5, 8, 13, 21));
            dto.getTags().add("accelerate");
            dto.getFormats().put("mp4", new VideoFormatDto(640, 480));
            dto.getFormats().put("ogg", new VideoFormatDto(640, 480));
            createVideo(cqlSession, dto);
            
            // Operations on SET (add/remove)
            LOGGER.info("+ Tags before adding 'OK' {}", listTagsOnVideo(cqlSession, myVideoId));
            addTagToVideo(cqlSession, myVideoId,  "OK");
            LOGGER.info("+ Tags after adding 'OK' {}", listTagsOnVideo(cqlSession, myVideoId));
            removeTagFromVideo(cqlSession, myVideoId,  "accelerate");
            LOGGER.info("+ Tags after removing 'accelerate' {}", listTagsOnVideo(cqlSession, myVideoId));
            
            // Operations on MAP (add/remove)
            LOGGER.info("+ Formats before {}", listFormatsOnVideo(cqlSession, myVideoId));
            removeFormatFromVideo(cqlSession, myVideoId, "ogg");
            LOGGER.info("+ Formats after removing 'ogg' {}", listFormatsOnVideo(cqlSession, myVideoId));
            LOGGER.info("+ Formats after removing 'ogg' {}", listFormatsOnVideoWithCustomCodec(cqlSession, myVideoId));
            
            // Operations on LIST (replaceAll, append, replace one
            LOGGER.info("+ Formats frames before {}", listFramesOnVideo(cqlSession, myVideoId));
            updateAllFrames(cqlSession, myVideoId, Arrays.asList(1,2,3));
            LOGGER.info("+ Formats frames after update all {}", listFramesOnVideo(cqlSession, myVideoId));
            appendFrame(cqlSession, myVideoId, 4);
            LOGGER.info("+ Formats frames after append 4 {}", listFramesOnVideo(cqlSession, myVideoId));
        }
    }
    
    private static void createVideo(CqlSession cqlSession, VideoDto dto) {

        MutableCodecRegistry registry = (MutableCodecRegistry) cqlSession.getContext().getCodecRegistry();
        registry.register(new UdtVideoFormatCodec(registry.codecFor(videoFormatUdt), VideoFormatDto.class));
        
        cqlSession.execute(stmtCreateVideo.bind()
                 .setUuid(VIDEO_VIDEOID, dto.getVideoid())
                 .setString(VIDEO_TITLE, dto.getTitle())
                 .setString(VIDEO_USER_EMAIL, dto.getEmail())
                 .setInstant(VIDEO_UPLOAD, Instant.ofEpochMilli(dto.getUpload()))
                 .setString(VIDEO_URL, dto.getUrl())
                 .setSet(VIDEO_TAGS, dto.getTags(), String.class)
                 .setList(VIDEO_FRAMES, dto.getFrames(), Integer.class)
                 .setMap(VIDEO_FORMAT, dto.getFormats(), String.class, VideoFormatDto.class));
    }
    
    // SET
    
    private static void addTagToVideo(CqlSession cqlSession,UUID videoId, String newTag) {
       // Note that this statement is not prepared, not supported for add
        cqlSession.execute(QueryBuilder
               .update(VIDEO_TABLENAME)
               .appendSetElement(VIDEO_TAGS, literal(newTag))
               .whereColumn(VIDEO_VIDEOID).isEqualTo(literal(videoId))
               .build());
    }
    
    private static void removeTagFromVideo(CqlSession cqlSession,UUID videoId, String oldTag) {
        // Note that this statement is not prepared, not supported for add
        cqlSession.execute(QueryBuilder
                .update(VIDEO_TABLENAME)
                .removeSetElement(VIDEO_TAGS, literal(oldTag))
                .whereColumn(VIDEO_VIDEOID).isEqualTo(literal(videoId))
                .build());
    }
    
    // LIST
    
    private static void updateAllFrames(CqlSession cqlSession, UUID videoId, List<Integer> values) {
        cqlSession.execute(QueryBuilder.update(VIDEO_TABLENAME)
                .setColumn(VIDEO_FRAMES, literal(values))
                .whereColumn(VIDEO_VIDEOID).isEqualTo(literal(videoId))
                .build());
    }
    
    private static void appendFrame(CqlSession cqlSession, UUID videoId, Integer lastItem) {
        cqlSession.execute(QueryBuilder.update(VIDEO_TABLENAME)
                .appendListElement(VIDEO_FRAMES, literal(lastItem))
                .whereColumn(VIDEO_VIDEOID).isEqualTo(literal(videoId))
                .build());
    }
    
    // UDT
    
    private static void removeFormatFromVideo(CqlSession cqlSession,UUID videoId, String key) {
        cqlSession.execute(QueryBuilder.update(VIDEO_TABLENAME)
                 .remove(VIDEO_FORMAT, literal(Set.of(key)))
                 .whereColumn(VIDEO_VIDEOID).isEqualTo(literal(videoId))
                 .build());
    }
    
    private static Set < String > listTagsOnVideo(CqlSession cqlSession, UUID videoid) {
        Row row = cqlSession.execute(stmtReadVideoTags.bind(videoid)).one();
        return (null == row)  ? new HashSet<>() : row.getSet(VIDEO_TAGS, String.class);
    }
    
    private static List < Integer > listFramesOnVideo(CqlSession cqlSession, UUID videoid) {
        Row row = cqlSession.execute(stmtReadVideoTags.bind(videoid)).one();
        return (null == row)  ? new ArrayList<>() : row.getList(VIDEO_FRAMES, Integer.class);
    }
    
    private static Map < String, VideoFormatDto > listFormatsOnVideo(CqlSession cqlSession, UUID videoId) {
        Map < String, VideoFormatDto > mapOfFormats = new HashMap<>();
        Row row = cqlSession.execute(stmtReadVideoTags.bind(videoId)).one();
        if (null != row) {
            Map < String, UdtValue> myMap = row.getMap(VIDEO_FORMAT, String.class, UdtValue.class);
            for (Map.Entry<String, UdtValue> entry : myMap.entrySet()) {
                mapOfFormats.put(entry.getKey(), new VideoFormatDto(
                        entry.getValue().getInt(UDT_VIDEO_FORMAT_WIDTH),
                        entry.getValue().getInt(UDT_VIDEO_FORMAT_HEIGHT)));
            }
        }
        return mapOfFormats;
    }

    private static Map < String, VideoFormatDto > listFormatsOnVideoWithCustomCodec(CqlSession cqlSession, UUID videoId) {
        Map < String, VideoFormatDto > mapOfFormats = new HashMap<>();
        Row row = cqlSession.execute(stmtReadVideoTags.bind(videoId)).one();
        if (null != row) {
            return row.getMap(VIDEO_FORMAT, String.class, VideoFormatDto.class);
        }
        return mapOfFormats;
    }
    
    private static void prepareStatements(CqlSession cqlSession) {
        stmtCreateVideo = cqlSession.prepare(QueryBuilder.insertInto(VIDEO_TABLENAME)
                .value(VIDEO_VIDEOID,    QueryBuilder.bindMarker(VIDEO_VIDEOID))
                .value(VIDEO_TITLE,      QueryBuilder.bindMarker(VIDEO_TITLE))
                .value(VIDEO_USER_EMAIL, QueryBuilder.bindMarker(VIDEO_USER_EMAIL))
                .value(VIDEO_UPLOAD,     QueryBuilder.bindMarker(VIDEO_UPLOAD))
                .value(VIDEO_URL,        QueryBuilder.bindMarker(VIDEO_URL))
                .value(VIDEO_TAGS,       QueryBuilder.bindMarker(VIDEO_TAGS))
                .value(VIDEO_FRAMES,     QueryBuilder.bindMarker(VIDEO_FRAMES))
                .value(VIDEO_FORMAT,     QueryBuilder.bindMarker(VIDEO_FORMAT))
                .build());
        stmtReadVideoTags = cqlSession.prepare(QueryBuilder
                .selectFrom(VIDEO_TABLENAME)
                .column(VIDEO_TAGS).column(VIDEO_FORMAT).column(VIDEO_FRAMES)
                .whereColumn(VIDEO_VIDEOID).isEqualTo(QueryBuilder.bindMarker())
                .build());
    }
    
}
