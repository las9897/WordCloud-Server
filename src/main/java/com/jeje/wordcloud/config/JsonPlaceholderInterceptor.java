package com.jeje.wordcloud.config;


import okhttp3.Interceptor;
import okhttp3.Response;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JsonPlaceholderInterceptor implements Interceptor {

    /*
    * interceptor 구현체는 필수가 아닌 옵션이며, 전체 Rest Request에 있어
    * 반복되게 나타나는 동일 파라미터를 한번에 처리하기 위한 용도로 주로 사용한다.
    * 아래 구현은 모든 Request에 공통 헤더 파라미터를 추가한 것 뿐임.
    * */
    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(
                chain.request().newBuilder()
                        .addHeader("Content-type", MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .addHeader("Cache-Control", "no-cache")
                        .addHeader("Cache-Control", "no-store")
                        .build()
        );
    }
}
