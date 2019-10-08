package com.example.testhf.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testhf.R;
import com.example.testhf.databinding.ListItemsBinding;
import com.example.testhf.model.Data;
import com.example.testhf.model.Programs;

import java.util.List;


public class TvProgramAdapter
            extends RecyclerView.Adapter<TvProgramAdapter.ProgramViewHolder> {

    private List<Data> chanel;
    private List<Programs> programs;


        @NonNull
        @Override
        public ProgramViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            ListItemsBinding programListItemBinding =
                    DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                            R.layout.list_items, viewGroup, false);
            return new ProgramViewHolder(programListItemBinding);
        }

        @Override
        public void onBindViewHolder(@NonNull ProgramViewHolder programViewHolder, int i) {
            Programs chanelName = programs.get(i);
            programViewHolder.programListItemBinding.setTvprograms(chanelName);
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


