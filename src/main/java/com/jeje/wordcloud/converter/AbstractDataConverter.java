package com.jeje.wordcloud.converter;

import org.springframework.core.convert.ConversionException;

public abstract class AbstractDataConverter<Source, Target> implements DataConverter<Source, Target> {


    protected abstract Target createTarget();

    @Override
    public Target convert(Source source) throws ConversionException {
        return convert(source, createTarget());
    }

}
