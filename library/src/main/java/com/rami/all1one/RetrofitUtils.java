package com.rami.all1one;

import java.io.IOException;

import androidx.annotation.NonNull;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    private static Retrofit.Builder builder(){
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
    }
    /**
     *  configura los distintos parametros del retrofit, usa gsonConverterFactory por defecto
     * @return el objecto retrofit builder
     */
    public static <T> T getRetrofitRest(Class<T> service) {
                return builder()
                .build().create(service);
    }

    public static <T> T getRetrofitRest(Class<T> service,OkHttpClient client) {
        return builder()
                .client(client)
                .build().create(service);
    }

    public static OkHttpClient getClienteHttp() {

              OkHttpClient.Builder builder = new OkHttpClient.Builder()
                      .addInterceptor(new httpInterceptor());

              return builder.build();
          }
           private static class httpInterceptor implements Interceptor {

                   @Override
                   public Response intercept(@NonNull Chain chain) throws IOException {
                       Request original = chain.request();
                       HttpUrl originalHttpUrl = original.url();

                       HttpUrl url = originalHttpUrl.newBuilder()
                              // .addQueryParameter("api_key", Constantes.TMDB_API_KEY)
                               .build();

                       Request request = original.newBuilder().url(url).build();
                       return chain.proceed(request);
                   }
               }


}
