package com.jeje.wordcloud.converter;

import com.jeje.wordcloud.dto.Comment;
import com.jeje.wordcloud.entity.CommentEntity;
import org.springframework.core.convert.ConversionException;

public class CommentToDtoConverter extends AbstractDataConverter<CommentEntity, Comment> {
    @Override
    protected Comment createTarget() {
        return new Comment();
    }

    @Override
    public Comment convert(CommentEntity source, Comment target) throws ConversionException {
        target.setContent(source.getContent());
        target.setCreate_date(source.getCreate_date());

        return target;
    }
}
