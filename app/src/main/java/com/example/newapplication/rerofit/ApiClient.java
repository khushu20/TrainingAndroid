package com.example.newapplication.rerofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {



        private static Retrofit retrofit = null;
        private static String BaseUrl = "http://qa11.cgg.gov.in/cmnwebservicesmobile/attwsapi/";
        public static Retrofit getClient() {

            OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(120, TimeUnit.SECONDS)
                    .writeTimeout(120, TimeUnit.SECONDS)
                    .readTimeout(120, TimeUnit.SECONDS);

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//            if (BuildConfig.BUILD_TYPE.equalsIgnoreCase("release")) {
//                interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
//            } else {
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
          //  }

            okHttpClient.addInterceptor(interceptor).build();

            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BaseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(okHttpClient.build())
                        .build();

            }
            return retrofit;
        }
    }
