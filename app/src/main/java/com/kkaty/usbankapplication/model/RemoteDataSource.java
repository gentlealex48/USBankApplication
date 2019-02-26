package com.kkaty.usbankapplication.model;

import com.kkaty.usbankapplication.model.entities.Person;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RemoteDataSource {
    public static final String BASE_URL = "https://api.myjson.com";



    private Retrofit createClient() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(120, TimeUnit.SECONDS)
                .connectTimeout(120, TimeUnit.SECONDS)
                .build();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private RemoteService getService(){

    }





    interface RemoteService{

        @GET("bins/n8jxy")
        Observable<Person> getPersonDetail();
    }

    interface Callback{

        void onSuccess(Person person);
        void onFailure(String error);

    }

}
