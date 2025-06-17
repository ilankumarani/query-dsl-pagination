package com.ilan.sqlQueryDsl;

import lombok.Builder;

import javax.annotation.processing.Generated;

/**
 * BPosts is a Querydsl bean type
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.BeanSerializer")
@Builder
public class BPosts {

    public BPosts() {
    }

    public BPosts(String category, String content, java.sql.Timestamp createdAt, Long id, Boolean published, String title, java.sql.Timestamp updatedAt, Long userId) {
        this.category = category;
        this.content = content;
        this.createdAt = createdAt;
        this.id = id;
        this.published = published;
        this.title = title;
        this.updatedAt = updatedAt;
        this.userId = userId;
    }

    private String category;

    private String content;

    private java.sql.Timestamp createdAt;

    private Long id;

    private Boolean published;

    private String title;

    private java.sql.Timestamp updatedAt;

    private Long userId;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public java.sql.Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public java.sql.Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(java.sql.Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
         return "category = " + category + ", content = " + content + ", createdAt = " + createdAt + ", id = " + id + ", published = " + published + ", title = " + title + ", updatedAt = " + updatedAt + ", userId = " + userId;
    }

}

