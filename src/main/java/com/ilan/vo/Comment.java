package com.ilan.vo;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {

    private Long id;
    private String author;
    private String email;
    private String text;
    private boolean approved;
    private LocalDateTime postedAt;

    private Post post; // or use PostModel if full post info is needed
}
