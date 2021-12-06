package com.example.cataloguemovie2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<TvShow> tvShows;
    private TvShowAdapter.OnItemClickCallback onItemClickCallback;

    public TvShowAdapter(Context context, ArrayList<TvShow> tvShows) {
        this.context = context;
        tvShows = new ArrayList<>();
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(TvShow tvShow);
    }

    public void setTvShows(ArrayList<TvShow> tvShows) {
        this.tvShows = tvShows;
    }


    @NonNull
    @Override
    public TvShowAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tvshow, parent, false);
        return new TvShowAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TvShowAdapter.MyViewHolder holder, int position) {

        TvShow tvShow= tvShows.get(position);
        Glide.with(holder.itemView.getContext())
                .load(tvShow.getPhoto())
                .apply(new RequestOptions().override(200, 200))
                .into(holder.imgPhoto);
        holder.txtName.setText(tvShow.getName());
        holder.txtDescription.setText(tvShow.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(tvShows.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.tvShows.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtDescription = itemView.findViewById(R.id.txt_description);
            imgPhoto = itemView.findViewById(R.id.img_photo);
        }
    }
}
