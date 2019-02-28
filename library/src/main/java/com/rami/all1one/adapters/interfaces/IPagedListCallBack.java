package com.rami.all1one.adapters.interfaces;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public interface IPagedListCallBack<T extends Object,VH extends RecyclerView.ViewHolder> {

     VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType);
     void onBindViewHolder(@NonNull VH holder, int position);
     void item (T item, int pos);
}
