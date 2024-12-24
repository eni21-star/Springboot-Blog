package com.coen.demo.dto;

import com.coen.demo.models.Author;

public record UploadBlogDto(
        String title,
        String body,
        int authorId
) {
}
