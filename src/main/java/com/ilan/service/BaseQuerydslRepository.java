package com.ilan.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.core.types.dsl.PathBuilder;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.springframework.data.jpa.repository.support.Querydsl;


public abstract class BaseQuerydslRepository<T> {

    protected final EntityManager entityManager;
    protected final JPAQueryFactory queryFactory;

    @Getter
    protected final Querydsl querydsl;
    protected final PathBuilder<T> pathBuilder;

    protected BaseQuerydslRepository(EntityManager entityManager, Class<T> entityClass) {
        this.entityManager = entityManager;
        this.queryFactory = new JPAQueryFactory(entityManager);
        this.pathBuilder = new PathBuilder<>(entityClass, entityClass.getSimpleName().toLowerCase());
        this.querydsl = new Querydsl(entityManager, pathBuilder);
    }
}
