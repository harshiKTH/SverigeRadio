package com.example.testhf.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.testhf.model.Programs;
import com.example.testhf.repository.TvProgramRepository;


import java.util.List;

public class TvProgramViewModel extends AndroidViewModel {
    private TvProgramRepository tvProgramRepository;

    public TvProgramViewModel(@NonNull Application application) {
        super(application);
        tvProgramRepository = new TvProgramRepository();
    }

    public LiveData<List<Programs>> getAllPrograms(int page) {
        return tvProgramRepository.getMutableLiveData(page);
    }
}
