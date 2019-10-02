package com.jeje.wordcloud.converter;

import com.jeje.wordcloud.dto.Post;
import com.jeje.wordcloud.entity.CommentEntity;
import com.jeje.wordcloud.entity.PostEntity;
import org.springframework.core.convert.ConversionException;

import java.util.stream.Collectors;

public class PostToEntityConverter extends AbstractDataConverter<Post, PostEntity> {
    @Override
    protected PostEntity createTarget() {
        return new PostEntity();
    }

    @Override
    public PostEntity convert(Post source, PostEntity target) throws ConversionException {
        CommentToEntityConverter converter = new CommentToEntityConverter();
        target.setTitle(source.getTitle());
        target.setContent(source.getContent());
        target.setCreate_date(source.getCreate_date());
        target.setCommentList(
                source.getCommentList()
                        .stream()
                .map(converter::convert)
                .collect(Collectors.toList())
        );
        return target;
    }
}
