package com.bawei.wangjiangwei20200102.utils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpUtils {

    private OkHttpClient okHttpClient;
    private static OkhttpUtils okhttpUtils;

    private OkhttpUtils() {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .build();
    }

    public static OkhttpUtils getInstance() {
        if (okhttpUtils == null) {
            synchronized (OkhttpUtils.class){
                if (okhttpUtils == null) {
                    okhttpUtils = new OkhttpUtils();
                }
            }
        }
        return okhttpUtils;
    }

    public void doGet(String url, final OkHttpCallback okHttpCallback){
        Request request  = new Request.Builder()
                .url(url)
                .get()
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                okHttpCallback.error(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                okHttpCallback.success(response.body().string());
            }
        });
    }

    public OkHttpCallback okHttpCallback;

    public OkhttpUtils(OkHttpCallback okHttpCallback) {
        this.okHttpCallback = okHttpCallback;
    }

    public interface OkHttpCallback{
        void success(String data);
        void error(Throwable throwable);
    }


}
