package com.jeje.wordcloud.converter;

import org.springframework.core.convert.ConversionException;

public interface DataConverter<Source, Target> {
    Target convert(Source source, Target target) throws ConversionException;
    Target convert(Source source) throws ConversionException;

}
