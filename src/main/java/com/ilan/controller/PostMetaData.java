package com.ilan.controller;

import com.ilan.model.PostModel;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PostMetaData {

    @Setter(onMethod_ = @Value("${default.size}"))
    @Getter
    Integer size = 0;

    @Setter(onMethod_ = @Value("${default.page}"))
    @Getter
    Integer page = 30;




    @GetMapping("/api/posts")
    Page<PostModel> getPostsByUserIds(@RequestParam @NotNull List<Long> userIds, @PageableDefault(size = size, page = page) Pageable pageable);
}
