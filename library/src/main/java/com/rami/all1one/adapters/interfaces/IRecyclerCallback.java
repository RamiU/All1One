package com.rami.all1one.adapters.interfaces;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public interface IRecyclerCallback <T extends RecyclerView.ViewHolder,X> {

    T onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    void onBindViewHolder(@NonNull T holder, int position);

    void getItemViewType(int position);

    void item(X item, int pos);

}
