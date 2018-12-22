package com.example.android.inventure.Cairo;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.inventure.MainFragment.RecyclerView_dAdapter;
import com.example.android.inventure.R;
import com.example.android.inventure.findhome_amir.ModelList;
import com.example.android.inventure.findhome_amir.ModelListAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class Flats extends Fragment {
    public Flats() {
    }

    public void setFlatsNamePlaces(String[] flatsNamePlaces) {
        this.flatsNamePlaces = flatsNamePlaces;
    }

    public void setFlatsPrices(String[] flatsPrices) {
        this.flatsPrices = flatsPrices;
    }

    public void setFlatsDuration(String[] flatsDuration) {
        this.flatsDuration = flatsDuration;
    }

    private String[] flatsNamePlaces, flatsPrices, flatsDuration;

    public Flats(String[] namePlaces, String[] prices, String[] duration) {
        this.flatsNamePlaces = namePlaces;
        this.flatsPrices = prices;
        this.flatsDuration = duration;
    }

    ModelListAdapter adapter;
    public static   ArrayList<ModelList> flatsArrayList = new ArrayList<ModelList>();
    boolean[] likes = new boolean[3];
    ListView listView;

    private RecyclerView recyclerView;
    private RecyclerView_dAdapter recyclerviewaAdapter;

    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.flats_fragment, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.listFlats);
        recyclerView.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);



//        for (int i = 0; i<Data.mainImage.length; i++){
//            ModelList model = new ModelList(Data.mainImage[i], flatsNamePlaces[i], flatsPrices[i], flatsDuration[i],Data.rating[i]);
//            //bind all strings in an array
//            flatsArrayList.add(model);
//        }



        recyclerviewaAdapter= new RecyclerView_dAdapter(flatsArrayList, getActivity());
        recyclerView.setAdapter(recyclerviewaAdapter);



        return  view;

    }
}

