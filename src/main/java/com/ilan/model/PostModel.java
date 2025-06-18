package com.ilan.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostModel {
    private Long id;
    private String username;
    private String title;
    private String content;
    private String author;
    private boolean approved;
}
