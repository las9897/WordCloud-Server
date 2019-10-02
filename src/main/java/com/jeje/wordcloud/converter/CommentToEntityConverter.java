package com.jeje.wordcloud.converter;

import com.jeje.wordcloud.dto.Comment;
import com.jeje.wordcloud.entity.CommentEntity;
import org.springframework.core.convert.ConversionException;

public class CommentToEntityConverter extends AbstractDataConverter<Comment, CommentEntity> {
    @Override
    protected CommentEntity createTarget() {
        return new CommentEntity();
    }

    @Override
    public CommentEntity convert(Comment source, CommentEntity target) throws ConversionException {
        target.setContent(source.getContent());
        target.setCreate_date(source.getCreate_date());

        return target;
    }
}
