package com.rami.all1one.adapters;


import android.view.ViewGroup;

import com.rami.all1one.adapters.interfaces.IPagedListCallBack;
import com.rami.all1one.adapters.interfaces.IRecyclerCallback;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorUtils {

     //////////////////////
     //   RECYCLER VIEW
    /////////////////////
    public static class Recycler<T extends RecyclerView.ViewHolder, X>
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

            callback.onBindViewHolder( holder, position);
            callback.item(this.lista.get(position),position);
        }
        @Override
        public int getItemViewType(int position) {
            return callback.getItemViewType(position);
        }

        @Override
        public int getItemCount() {
            return this.lista.size();
        }
    }

    //////////////////////
    //   PAGEG LIST
    /////////////////////

    public static class pagedList<T extends Object,VH extends
                          RecyclerView.ViewHolder> extends PagedListAdapter<T,VH>{


        IPagedListCallBack<T,VH> callBack;
        public pagedList(@NonNull DiffUtil.ItemCallback<T> diffCallback,IPagedListCallBack<T,VH> callBack) {
            super(diffCallback);
            this.callBack = callBack;
        }

        @NonNull
        @Override
        public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return callBack.onCreateViewHolder(parent, viewType);
        }
        @Override
        public void onBindViewHolder(@NonNull VH holder, int position) {
            callBack.item(getItem(position) , position);
            callBack.onBindViewHolder(holder, position);
        }
        public static PagedList.Config.Builder pagedConfig(){
            return new PagedList.Config.Builder()
                            .setEnablePlaceholders(false);
        }
        public static <K,V> LivePagedListBuilder pagedListBuilder(
                DataSource.Factory<K,V>  factory,PagedList.Config config){
            return new LivePagedListBuilder<>(factory, config);
        }
    }

}
