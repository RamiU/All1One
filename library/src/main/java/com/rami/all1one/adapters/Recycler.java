package com.rami.all1one.adapters;

import android.view.ViewGroup;

import com.rami.all1one.adapters.interfaces.IRecyclerCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Recycler<T extends RecyclerView.ViewHolder, X >
                       extends RecyclerView.Adapter <T> {

    private IRecyclerCallback<T,X> callback;
    private List<X> lista;

    public Recycler(List<X> lista,IRecyclerCallback<T,X> callback){
        this.lista = lista;
        this.callback = callback;
    }
    @NonNull
    @Override
    public T onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return this.callback.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull T holder, int position) {

      callback.item(this.lista.get(position),position);

      callback.onBindViewHolder( holder, position);
    }
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
       return this.lista.size();
    }
}