package com.ilan.service;


import com.ilan.entity.Post;
import com.ilan.entity.QComment;
import com.ilan.entity.QPost;
import com.ilan.entity.QUser;
import com.ilan.model.PostModel;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QBean;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Optional.ofNullable;

@Repository
@RequiredArgsConstructor
public class PostPaginationRepository {//} extends BaseQuerydslRepository<Post>{

    private final QUser qUser = QUser.user;
    private final QPost qPost = QPost.post;
    private final QComment qComment = QComment.comment;
    @PersistenceContext
    private EntityManager entityManager;
    private JPAQueryFactory jpaQueryFactory;


    @PostConstruct
    public void init() {
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    //Arrays.asList(1L)
    public Page<PostModel> findAllPostByUserId(@NotNull List<Long> userIds, Pageable pageable) {
        //Here we are firing one query to get the total Count of Rows for the Query

        Long totalCount = findPostByUserId(qUser.id.count(), userIds).fetchOne();

        QBean<PostModel> combined = Projections.bean(PostModel.class, qUser.id, qUser.username, qPost.title, qPost.content, qComment.author, qComment.approved);
        JPAQuery<PostModel> query = findPostByUserId(combined, userIds);

        //Querydsl querydsl = new Querydsl(entityManager, new PathBuilder<>(Book.class, "book"));

        Querydsl querydsl = new Querydsl(entityManager, new PathBuilder<>(PostModel.class, "post"));
        ofNullable(querydsl).ifPresent(q -> q.applyPagination(pageable, query));

        List<PostModel> pagedData = query.fetch();

        return PageableExecutionUtils.getPage(pagedData, pageable, () -> totalCount);
    }

    private <T> JPAQuery<T> findPostByUserId(Expression<T> expression, List<Long> userIds) {
        return jpaQueryFactory
                .select(expression)
                .from(qUser)
                .join(qPost)
                .on(qUser.id.eq(qPost.user.id))
                .join(qComment)
                .on(qComment.post.id.eq(qPost.id))
                .where(qPost.user.id.in(userIds));
    }

    private <T> JPAQuery<T> findPostByUserId(QBean<T> qBean, List<Long> userIds) {
        return jpaQueryFactory
                .select(qBean)
                .from(qUser)
                .join(qPost)
                .on(qUser.id.eq(qPost.user.id))
                .join(qComment)
                .on(qComment.post.id.eq(qPost.id))
                .where(qPost.user.id.in(userIds));
    }
}
