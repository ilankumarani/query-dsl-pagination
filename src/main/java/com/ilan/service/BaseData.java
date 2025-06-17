package com.ilan.service;



import com.ilan.sqlQueryDsl.BComments;
import com.ilan.sqlQueryDsl.BPosts;
import com.ilan.sqlQueryDsl.BUsers;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseData {

    public static Timestamp timestamp = Timestamp.valueOf("2025-06-15 12:34:56");
    public static Date date = Date.valueOf("2025-06-15");
    public static Time time = Time.valueOf("12:34:56");


    public List<BUsers> generateUsers(int usersCount) {
        return IntStream.rangeClosed(1, usersCount)
                .mapToObj(i ->
                        BUsers.builder()
                                .id((long) i)
                                .username("user" + i)
                                .fullName("User " + i)
                                .email("user" + i + "@example.com")
                                .password("pass" + i)
                                .registeredAt(Timestamp.from(Instant.now()))
                                .active(true)
                                .build()
                )
                .collect(Collectors.toList());
    }

    public List<BPosts> generatePosts(List<BUsers> users, int postsPerUser) {
        List<BPosts> posts = new ArrayList<>();
        long postId = 1L;
        for (BUsers user : users) {
            for (int j = 1; j <= postsPerUser; j++) {
                BPosts post = BPosts.builder()
                        .id(postId++)
                        .title("Post " + j + " by " + user.getUsername())
                        .content("Content of post " + j)
                        .category("Category " + (j % 5))
                        .createdAt(Timestamp.from(Instant.now()))
                        .updatedAt(Timestamp.from(Instant.now()))
                        .published(j % 2 == 0)
                        .userId(user.getId())
                        .build();
                posts.add(post);
            }
        }
        return posts;
    }

    public List<BComments> generateComments(List<BPosts> posts, int commentsPerPost) {
        List<BComments> comments = new ArrayList<>();
        long commentId = 1L;
        for (BPosts post : posts) {
            for (int k = 1; k <= commentsPerPost; k++) {
                BComments comment = BComments.builder()
                        .id(commentId++)
                        .author("Commenter " + k)
                        .email("commenter" + k + "@mail.com")
                        .text("Comment " + k + " on post " + post.getId())
                        .postedAt(Timestamp.from(Instant.now()))
                        .approved(k % 2 == 0)
                        .postId(post.getId())
                        .build();
                comments.add(comment);
            }
        }
        return comments;
    }
}
