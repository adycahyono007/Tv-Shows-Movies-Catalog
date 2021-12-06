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

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Film> films;
    private OnItemClickCallback onItemClickCallback;

    public FilmAdapter(Context context, ArrayList<Film> films) {
        this.context = context;
        films = new ArrayList<>();
    }

    public interface OnItemClickCallback {
        void onItemClicked(Film film);
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }


    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_film, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        Film film= films.get(position);
        Glide.with(holder.itemView.getContext())
                .load(film.getPhoto())
                .apply(new RequestOptions().override(200, 200))
                .into(holder.imgPhoto);
        holder.txtName.setText(film.getName());
        holder.txtDescription.setText(film.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(films.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.films.size();
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
