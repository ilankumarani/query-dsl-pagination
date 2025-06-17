package com.ilan.controller;


import com.ilan.entity.Post;
import com.ilan.service.PostRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository postRepository;

    @GetMapping
    public Page<Post> getPostsByUserIds(@RequestParam @NotNull List<Long> userIds, Pageable pageable) {
        return postRepository.findAllPostByUserId(userIds, pageable);
    }
}
