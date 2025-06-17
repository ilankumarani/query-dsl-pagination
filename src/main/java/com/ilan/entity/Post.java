package com.ilan.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"user", "comments"})
@EqualsAndHashCode(exclude = {"user", "comments"})
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 5000)
    private String content;

    private String category;
    private boolean published;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;
}
