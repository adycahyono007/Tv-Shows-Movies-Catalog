package com.example.cataloguemovie2;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FilmFragment extends Fragment {
    View v;
    private RecyclerView recyclerView;
    private ArrayList<Film> films;
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    //private FilmAdapter filmAdapter;


    public FilmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_film, container, false);

        recyclerView = v.findViewById(R.id.film_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));

        //ambil data
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);

        films = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Film film = new Film();
            film.setPhoto(dataPhoto.getResourceId(i, -1));
            film.setName(dataName[i]);
            film.setDescription(dataDescription[i]);
            films.add(film);
        }
        final FilmAdapter filmAdapter = new FilmAdapter(v.getContext(), films);
        recyclerView.setAdapter(filmAdapter);

        filmAdapter.setFilms(films);

        filmAdapter.setOnItemClickCallback(new FilmAdapter.OnItemClickCallback(){
            @Override
            public void onItemClicked(Film film) {
                Intent filmDetailIntent = new Intent(v.getContext(), DetailFilmActivity.class);
                filmDetailIntent.putExtra(DetailFilmActivity.EXTRA_PERSON, film);
                startActivity(filmDetailIntent);
            }
        });
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

}
