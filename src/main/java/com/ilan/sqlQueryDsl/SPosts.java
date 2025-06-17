package com.ilan.sqlQueryDsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;

import io.github.openfeign.querydsl.sql.json.types.*;
import io.github.openfeign.querydsl.sql.json.*;



/**
 * SPosts is a Querydsl query type for BPosts
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class SPosts extends com.querydsl.sql.RelationalPathBase<BPosts> {

    private static final long serialVersionUID = 277915510;

    public static final SPosts posts = new SPosts("POSTS");

    public final StringPath category = createString("category");

    public final StringPath content = createString("content");

    public final DateTimePath<java.sql.Timestamp> createdAt = createDateTime("createdAt", java.sql.Timestamp.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath published = createBoolean("published");

    public final StringPath title = createString("title");

    public final DateTimePath<java.sql.Timestamp> updatedAt = createDateTime("updatedAt", java.sql.Timestamp.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public SPosts(String variable) {
        super(BPosts.class, forVariable(variable), "PUBLIC", "POSTS");
        addMetadata();
    }

    public SPosts(String variable, String schema, String table) {
        super(BPosts.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public SPosts(String variable, String schema) {
        super(BPosts.class, forVariable(variable), schema, "POSTS");
        addMetadata();
    }

    public SPosts(Path<? extends BPosts> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "POSTS");
        addMetadata();
    }

    public SPosts(PathMetadata metadata) {
        super(BPosts.class, metadata, "PUBLIC", "POSTS");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(category, ColumnMetadata.named("CATEGORY").withIndex(7).ofType(Types.VARCHAR).withSize(255));
        addMetadata(content, ColumnMetadata.named("CONTENT").withIndex(6).ofType(Types.VARCHAR).withSize(5000));
        addMetadata(createdAt, ColumnMetadata.named("CREATED_AT").withIndex(2).ofType(Types.TIMESTAMP).withSize(26).withDigits(6));
        addMetadata(id, ColumnMetadata.named("ID").withIndex(3).ofType(Types.BIGINT).withSize(64).notNull());
        addMetadata(published, ColumnMetadata.named("PUBLISHED").withIndex(1).ofType(Types.BOOLEAN).withSize(1).notNull());
        addMetadata(title, ColumnMetadata.named("TITLE").withIndex(8).ofType(Types.VARCHAR).withSize(255));
        addMetadata(updatedAt, ColumnMetadata.named("UPDATED_AT").withIndex(4).ofType(Types.TIMESTAMP).withSize(26).withDigits(6));
        addMetadata(userId, ColumnMetadata.named("USER_ID").withIndex(5).ofType(Types.BIGINT).withSize(64));
    }

}

