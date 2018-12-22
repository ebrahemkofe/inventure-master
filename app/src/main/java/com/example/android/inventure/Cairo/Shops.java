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
public class Shops extends  Fragment {
    public Shops() {
    }

    private String[] namePlaces  = {"Loading","Loading","Loading"}
            , prices = {"Loading","Loading","Loading"}
            , duration = {"Loading","Loading","Loading"};


    @SuppressLint("ValidFragment")
    public Shops(String[] namePlaces, String[] prices, String[] duration) {
        this.namePlaces = namePlaces;
        this.prices = prices;
        this.duration = duration;
    }

    ModelListAdapter adapter;
    ArrayList<ModelList> arrayList = new ArrayList<ModelList>();
    boolean[] likes = new boolean[3];
    ListView listView;

    private RecyclerView recyclerView;
    private RecyclerView_dAdapter recyclerviewaAdapter;

    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shops_fragment, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.listShops);
        recyclerView.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);


//        for (int i = 0; i<Data.mainImage.length; i++){
//            ModelList model = new ModelList(Data.mainImage[i],namePlaces[i],prices[i],duration[i],Data.rating[i]);
//            //bind all strings in an array
//            arrayList.add(model);
//        }


        recyclerviewaAdapter= new RecyclerView_dAdapter(Flats.flatsArrayList, getActivity());
        recyclerView.setAdapter(recyclerviewaAdapter);

        // if (container== null){container.removeAllViews();}


        return  view;

    }
}

