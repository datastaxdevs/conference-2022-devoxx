package com.datastax.devoxx.objectmapping;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.mapper.MapperBuilder;
import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;
import com.datastax.samples.objectmapping.CommentDaoMapperBuilder;

/**
 * Definition of operation for mapping.
 */
@Mapper
public interface CommentDaoMapper {

    @DaoFactory
    CommentDao commentDao();

    static MapperBuilder<CommentDaoMapper> builder(CqlSession session) {
        return new CommentDaoMapperBuilder(session);
    }
}

