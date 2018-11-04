package com.example.rickyahmad.ligagojek.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rickyahmad.ligagojek.DetailActivity;
import com.example.rickyahmad.ligagojek.R;
import com.example.rickyahmad.ligagojek.model.MainModel;

import java.util.LinkedList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ListMenuViewHolder> {

    private Context context;
    private final LinkedList<MainModel>listTim;

    public MainAdapter(Context context, LinkedList<MainModel>listTim){
        this.context = context;
        this.listTim = listTim;
    }

    @Override
    public ListMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_tim, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mItemView.setLayoutParams(layoutParams);

        return new ListMenuViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(ListMenuViewHolder holder, int position) {
        final MainModel mCurrent = listTim.get(position);
        holder.nama_tim.setText(mCurrent.getNama());
        holder.kota_tim.setText(mCurrent.getKota());
        holder.gambar_tim.setImageResource(mCurrent.getGambarTim());
    }

    @Override
    public int getItemCount() {
        return listTim.size();
    }

    public class ListMenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nama_tim, kota_tim;
        private ImageView gambar_tim;
        private CardView cdView;

        final MainAdapter mainAdapter;
        public ListMenuViewHolder(View itemView, MainAdapter adapter){
            super(itemView);
            cdView = itemView.findViewById(R.id.detail);
            nama_tim = itemView.findViewById(R.id.listNama);
            kota_tim = itemView.findViewById(R.id.listKota);
            gambar_tim = itemView.findViewById(R.id.listGambar);
            //bind
            this.mainAdapter = adapter;
            cdView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            int mPosition = getLayoutPosition();
            MainModel element = listTim.get(mPosition);

            Intent i = new Intent(context, DetailActivity.class);

            i.putExtra("nama",element.getNama());
            i.putExtra("kota",element.getKota());
            i.putExtra("deskripsi",element.getDeskTim());
            i.putExtra("foto",element.getGambarTim());

            context.startActivity(i);
            mainAdapter.notifyDataSetChanged();
        }
    }
}
