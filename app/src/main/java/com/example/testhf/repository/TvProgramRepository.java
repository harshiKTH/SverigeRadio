package com.example.testhf.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.testhf.model.Programs;
import com.example.testhf.model.TvProgram;
import com.example.testhf.module.NetWorkModule;
import com.example.testhf.network.TvProgramApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvProgramRepository {
    private static final String TAG = "TvprogramRepository";
    private List<Programs> programs;
    private MutableLiveData<List<Programs>> mutableLiveData = new MutableLiveData<>();



    public TvProgramRepository() {
    }

    public MutableLiveData<List<Programs>> getMutableLiveData() {

        final TvProgramApi userDataService = NetWorkModule.getService();

        Call<TvProgram> call = userDataService.getProgrames();
        call.enqueue(new Callback<TvProgram>() {
            @Override
            public void onResponse(Call<TvProgram> call, Response<TvProgram> response) {
                TvProgram tvProgram = response.body();

                if (tvProgram != null && tvProgram.getPrograms()!= null) {
                    programs = tvProgram.getPrograms();
                    System.out.println("KKKKKKKKK " + programs.get(0).getDescription());
                    mutableLiveData.setValue(programs);
                }
            }

            @Override
            public void onFailure(Call<TvProgram> call, Throwable t) {
            }
        });

        return mutableLiveData;
    }
}
