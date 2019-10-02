package com.jeje.wordcloud.converter;

import com.jeje.wordcloud.dto.Comment;
import com.jeje.wordcloud.dto.Post;
import com.jeje.wordcloud.entity.PostEntity;
import org.springframework.core.convert.ConversionException;

import java.util.stream.Collectors;

public class PostToDtoConverter extends AbstractDataConverter<PostEntity, Post> {
    @Override
    protected Post createTarget() {
        return new Post();
    }

    @Override
    public Post convert(PostEntity source, Post target) throws ConversionException {
        CommentToDtoConverter converter = new CommentToDtoConverter();
        target.setTitle(source.getTitle());
        target.setContent(source.getContent());
        target.setCreate_date(source.getCreate_date());
        target.setCommentList(
                source.getCommentList()
                        .stream()
                        .map(converter::convert)
                        .collect(Collectors.toList()));
        return target;
    }
}
