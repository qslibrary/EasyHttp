package com.shqiansha.library.easyhttp.interceptor;


import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public abstract class HeaderInterceptor implements Interceptor {

    @NotNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder requestBuilder = original.newBuilder();
        Map<String, String> headers = new HashMap<>();
        onAdd(headers);
        for (Map.Entry<String, String> header : headers.entrySet()) {
            requestBuilder.header(header.getKey(), header.getValue());
        }
        return chain.proceed(requestBuilder.build());
    }

    public abstract void onAdd(Map<String, String> headers);
}
