package com.ilan.controller;


import com.ilan.model.PostModel;
import com.ilan.service.PostPaginationRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController implements PostMetaData{

    private final PostPaginationRepository postPaginationRepository;

    @Override
    public Page<PostModel> getPostsByUserIds(@RequestParam @NotNull List<Long> userIds, Pageable pageable) {
        return postPaginationRepository.findAllPostByUserId(userIds, pageable);
    }
}
