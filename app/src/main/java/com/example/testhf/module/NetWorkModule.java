package com.example.testhf.module;

import com.example.testhf.network.TvProgramApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.example.testhf.utils.Constants.BASE_URL;

public class NetWorkModule {

    private static Retrofit retrofit;

    public static TvProgramApi getService() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(TvProgramApi.class);
    }
}
