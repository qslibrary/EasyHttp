package com.lieni.library.easyhttp;

import android.content.Context;

import com.lieni.library.easyhttp.cookie.CookieJarHelper;

import java.util.ArrayList;
import java.util.List;

import okhttp3.CookieJar;
import okhttp3.Interceptor;
import retrofit2.Converter;

public class EasyBuilder {
    private int readTimeout=60000;
    private int writeTimeout=60000;
    private int connectTimeout=60000;
    private final String baseUrl;
    private final List<Interceptor> interceptors=new ArrayList<>();
    private Converter.Factory convertFactory;
    private boolean cache=false;
    private CookieJar cookieJar;
    private boolean log=true;

    public EasyBuilder(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public EasyBuilder setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public int getWriteTimeout() {
        return writeTimeout;
    }

    public EasyBuilder setWriteTimeout(int writeTimeout) {
        this.writeTimeout = writeTimeout;
        return this;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public EasyBuilder setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }


    public List<Interceptor> getInterceptors() {
        return interceptors;
    }

    public EasyBuilder addInterceptor(Interceptor interceptor) {
        this.interceptors.add(interceptor);
        return this;
    }

    public boolean isCache() {
        return cache;
    }

    public EasyBuilder setCache(boolean cache) {
        this.cache = cache;
        return this;
    }

    public EasyBuilder setCookieJar(CookieJar cookieJar) {
        this.cookieJar = cookieJar;
        return this;
    }

    public CookieJar getCookieJar() {
        return cookieJar;
    }

    public EasyBuilder enableCookie(Context context, boolean load){
        this.cookieJar=new CookieJarHelper(context,load);
        return this;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public boolean isLog() {
        return log;
    }

    public void setLog(boolean log) {
        this.log = log;
    }

    public Converter.Factory getConvertFactory() {
        return convertFactory;
    }

    public EasyBuilder setConvertFactory(Converter.Factory convertFactory) {
        this.convertFactory = convertFactory;
        return this;
    }


}
