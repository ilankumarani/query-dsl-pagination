package com.ilan.service;

import com.google.common.base.Preconditions;
import com.ilan.entity.QComment;
import com.ilan.entity.QPost;
import com.ilan.entity.QUser;
import com.ilan.sqlQueryDsl.*;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.dml.SQLInsertClause;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DataLoadService extends BaseData {

    public static final int USERS_COUNT = 5;
    public static final int POSTS_PER_USER = 25;
    public static final int COMMENTS_PER_POST = 1;
    private final SQLQueryFactory sqlQueryFactory;
    private final SUsers sUsers = SUsers.users;
    private final SPosts sPosts = SPosts.posts;
    private final SComments sComments = SComments.comments;
    private JPAQuery jpaQuery;
    @PersistenceContext
    private EntityManager entityManager;

    private final QUser qUser = QUser.user;
    private final QPost qPost = QPost.post;
    private final QComment qComment = QComment.comment;

    public void init() {
        jpaQuery = new JPAQuery<>(entityManager);
    }

    public void dataLoad() {
        jpaQuery = new JPAQuery<>(entityManager);
        List<BUsers> users = generateUsers(USERS_COUNT);
        bulkInsertUsers(users);
        List<BPosts> posts = generatePosts(users, POSTS_PER_USER);
        bulkInsertPosts(posts);
        List<BComments> comments = generateComments(posts, COMMENTS_PER_POST);
        bulkInsertComments(comments);
    }

    @SneakyThrows
    public void bulkInsertUsers(List<BUsers> users) {
        SQLInsertClause insert = sqlQueryFactory.insert(sUsers);
        for (BUsers buser : users) {
            insert.populate(buser).addBatch();
        }
        insert.execute();
    }


    @SneakyThrows
    public void bulkInsertPosts(List<BPosts> posts) {
        SQLInsertClause insert = sqlQueryFactory.insert(sPosts);

        for (BPosts post : posts) {
            insert.populate(post)
                    .addBatch();
        }
        insert.execute();
    }


    @SneakyThrows
    public void bulkInsertComments(List<BComments> comments) {
        SQLInsertClause insert = sqlQueryFactory.insert(sComments);
        for (BComments comment : comments) {
            insert.populate(comment)
                    .addBatch();
        }
        insert.execute();
    }

    public void isDataLoaded() {
        Preconditions.checkState(USERS_COUNT == jpaQuery.select(qUser.id.count())
                .from(qUser).fetchCount(), "load User Count does not match");
        Preconditions.checkState(USERS_COUNT * USERS_COUNT * POSTS_PER_USER == jpaQuery.select(qPost.id.count())
                .from(qPost).fetchCount(), "load Post Count does not match");
        Preconditions.checkState(USERS_COUNT * USERS_COUNT * USERS_COUNT * POSTS_PER_USER * POSTS_PER_USER == jpaQuery.select(qComment.id.count())
                .from(qComment).fetchCount(), "load Comment Count does not match");
    }
}
