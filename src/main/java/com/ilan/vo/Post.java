package com.ilan.vo;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    private Long id;
    private String title;
    private String content;
    private String category;
    private boolean published;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private UserModel user;
    private List<Comment> comments;
}