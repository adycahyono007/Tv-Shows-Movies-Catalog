package com.example.cataloguemovie2;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

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
public class TvShowFragment extends Fragment {
    View v;
    private RecyclerView recyclerView;
    private ArrayList<TvShow> tvShows;
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;


    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_tv_show, container, false);

        recyclerView = v.findViewById(R.id.tvShow_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));

        //ambil data
        dataName = getResources().getStringArray(R.array.data_name_tv);
        dataDescription = getResources().getStringArray(R.array.data_description_tv);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo_tv);

        tvShows = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            TvShow tvShow = new TvShow();
            tvShow.setPhoto(dataPhoto.getResourceId(i, -1));
            tvShow.setName(dataName[i]);
            tvShow.setDescription(dataDescription[i]);
            tvShows.add(tvShow);
        }
        final TvShowAdapter tvShowAdapter = new TvShowAdapter(v.getContext(), tvShows);
        recyclerView.setAdapter(tvShowAdapter);

        tvShowAdapter.setTvShows(tvShows);

        tvShowAdapter.setOnItemClickCallback(new TvShowAdapter.OnItemClickCallback(){
            @Override
            public void onItemClicked(TvShow tvShow) {
                Intent tvShowDetailIntent = new Intent(v.getContext(), DetailTvShowActivity.class);
                tvShowDetailIntent.putExtra(DetailTvShowActivity.EXTRA_TV, tvShow);
                startActivity(tvShowDetailIntent);
            }
        });
        return v;
    }

}
