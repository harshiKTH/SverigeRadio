package com.example.testhf.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.testhf.R;
import com.example.testhf.databinding.ActivityMainBinding;
import com.example.testhf.interfaces.ItemOnClick;
import com.example.testhf.model.Programs;
import com.example.testhf.model.TvProgram;
import com.example.testhf.viewmodel.TvProgramViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TvProgramViewModel tvProgramViewModel;
    private TvProgramAdapter tvProgramAdapter;
    ItemOnClick ItemOnClickCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

// bind RecyclerView
        RecyclerView recyclerView = activityMainBinding.viewProgram;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        tvProgramViewModel = ViewModelProviders.of(this).get(TvProgramViewModel.class);
        tvProgramAdapter = new TvProgramAdapter( ItemOnClickCallback);
        recyclerView.setAdapter(tvProgramAdapter);
        getAllPrograms();
    }

    private void getAllPrograms() {
        tvProgramViewModel.getAllPrograms().observe(this, new Observer<List<Programs>>() {
            @Override
            public void onChanged(@Nullable List<Programs> programs) {

                tvProgramAdapter.setTvProgramList(programs);
            }
        });
    }

    private final ItemOnClick itemOnClicklickCallback = new ItemOnClick() {
        @Override
        public void cardClicked(TvProgram program) {
            System.out.println("UuUUUUUUUUUUU");
        }
    };
}

