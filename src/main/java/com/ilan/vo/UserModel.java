package com.ilan.vo;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {

    private Long id;
    private String username;
    private String email;
    private String fullName;
    private boolean active;
    private LocalDateTime registeredAt;

    private List<Post> posts;
}
