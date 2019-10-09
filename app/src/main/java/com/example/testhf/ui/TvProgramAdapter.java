package com.example.testhf.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.testhf.R;
import com.example.testhf.databinding.ListItemsBinding;
import com.example.testhf.interfaces.ItemOnClick;
import com.example.testhf.model.Data;
import com.example.testhf.model.Programs;
import com.example.testhf.model.TvProgram;

import java.util.List;


public class TvProgramAdapter
            extends RecyclerView.Adapter<TvProgramAdapter.ProgramViewHolder>
{

    private List<Data> chanel;
    private List<Programs> programs;
    private Context context;


    @Nullable
    private final ItemOnClick ItemOnClickCallback;

    public TvProgramAdapter(@Nullable ItemOnClick ItemOnClickCallback) {
        this.ItemOnClickCallback=ItemOnClickCallback;
    }


    @NonNull
        @Override
        public ProgramViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            ListItemsBinding programListItemBinding =
                    DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                            R.layout.list_items, viewGroup, false);
            programListItemBinding.setItemOnClickCallBack(ItemOnClickCallback);
            return new ProgramViewHolder(programListItemBinding);

        }

    private void refreshItems() {
        return;
    }


    @Override
        public void onBindViewHolder(@NonNull ProgramViewHolder programViewHolder, int i) {
            Programs chanelName = programs.get(i);
            programViewHolder.programListItemBinding.setTvprograms(chanelName);
            //programViewHolder.programListItemBinding.;

        }

        @Override
        public int getItemCount() {
            if (programs != null) {
                return programs.size();
            } else {
                return 0;
            }
        }

        public void setTvProgramList(List<Programs> programs) {
            this.programs = programs;
            notifyDataSetChanged();
        }



    class ProgramViewHolder extends RecyclerView.ViewHolder {

            private ListItemsBinding programListItemBinding;

            public ProgramViewHolder(@NonNull ListItemsBinding programtListItemBinding) {
                super(programtListItemBinding.getRoot());

                this.programListItemBinding = programtListItemBinding;
            }


        }


}


