package com.example.android.inventure.MainFragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.android.inventure.Cairo.Flats;
import com.example.android.inventure.R;
import com.example.android.inventure.findhome_amir.ModelList;

import java.util.ArrayList;

public class MainF extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;


    public static ArrayList<ModelList> cairoFlats = new ArrayList<ModelList>();
    public static ArrayList<ModelList> newCairoFlats = new ArrayList<ModelList>();
    public static ArrayList<ModelList> alexFlats = new ArrayList<ModelList>();
    public static ArrayList<ModelList> sharmFlats = new ArrayList<ModelList>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_f);


        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);




        ArrayList<ModelList> arrayList  = new ArrayList<ModelList>();



        for (int i = 0; i<Data.mainImage.length; i++){
            ModelList model = new ModelList(Data.mainImage[i],
                    Data.FlatsCairoNamePlaces[i], Data.FlatsCairoPrices[i], Data.FlatsCairoDuration[i],
                    Data.rating[i]);
            //bind all strings in an array
            cairoFlats.add(model);
        }

        for (int i = 0; i<Data.mainImage.length; i++){
            ModelList model = new ModelList(Data.mainImage[i],
                    Data.newCairoNamePlaces[i],
                    Data.newCairoPrices[i],
                    Data.newCairoDuration[i], Data.rating[i]);
            //bind all strings in an array
            newCairoFlats.add(model);
        }

        for (int i = 0; i<Data.mainImage.length; i++){
            ModelList model = new ModelList(Data.mainImage[i],
                    Data.AlexandriaNamePlaces[i],
                    Data.AlexandriaPrices[i],
                    Data.AlexandriaDuration[i], Data.rating[i]);
            //bind all strings in an array
            alexFlats.add(model);

        }for (int i = 0; i<Data.mainImage.length; i++){
            ModelList model = new ModelList(Data.mainImage[i],
                    Data.Sharm_ElshiekNamePlaces[i],
                    Data.Sharm_ElshiekPrices[i],
                    Data.Sharm_ElshiekDuration[i], Data.rating[i]);
            //bind all strings in an array
            sharmFlats.add(model);
        }




        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0: // Cairo
                        Flats.flatsArrayList = cairoFlats;
                        break;
                    case 1: // New Cairo
                        Flats.flatsArrayList = newCairoFlats;
                        break;
                    case 2: // Alex
                        Flats.flatsArrayList = alexFlats;
                        break;
                    case 3:
                        Flats.flatsArrayList = sharmFlats;
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        Toast.makeText(getApplicationContext(), "One Again", Toast.LENGTH_SHORT).show();
                }

            }
        });

        Flats.flatsArrayList = cairoFlats ;

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        // Cairo Fragments And Data
        adapter.addFrag(new CairoParent(// CairoParent
                Data.FlatsCairoNamePlaces, Data.FlatsCairoPrices, Data.FlatsCairoDuration,
                // Villas
                Data.VillasCairoNamePlaces,Data.VillasCairoPrices,Data.villasCairoDuration,

                // Offices
                Data.OfficesCairoNamePlaces,Data.OfficesCairoPrices,Data.OfficesCairoDuration,

                // Shops
                Data.ShopsCairoNamePlaces,Data.ShopsCairoPrices,Data.ShopsCairoDuration
        ), "Cairo" );

        adapter.addFrag(new CairoParent(
                // CairoParent
                Data.newCairoNamePlaces, Data.newCairoPrices, Data.newCairoDuration,
                // Villas
                Data.newCairoNamePlaces, Data.newCairoPrices, Data.newCairoDuration,

                // Offices
                Data.newCairoNamePlaces, Data.newCairoPrices, Data.newCairoDuration,

                // Shops
                Data.newCairoNamePlaces, Data.newCairoPrices, Data.newCairoDuration

        ), "New Cairo");

        adapter.addFrag(new CairoParent(
                Data.AlexandriaNamePlaces, Data.AlexandriaPrices, Data.AlexandriaDuration,
                // Villas
                Data.AlexandriaNamePlaces, Data.AlexandriaPrices, Data.AlexandriaDuration,

                // Offices
                Data.AlexandriaNamePlaces, Data.AlexandriaPrices, Data.AlexandriaDuration,

                // Shops
                Data.AlexandriaNamePlaces, Data.AlexandriaPrices, Data.AlexandriaDuration
        ), "Alexandria");

        adapter.addFrag(new CairoParent(
                Data.Sharm_ElshiekNamePlaces, Data.Sharm_ElshiekPrices, Data.Sharm_ElshiekDuration,
                // Villas
                Data.Sharm_ElshiekNamePlaces, Data.Sharm_ElshiekPrices, Data.Sharm_ElshiekDuration,

                // Offices
                Data.Sharm_ElshiekNamePlaces, Data.Sharm_ElshiekPrices, Data.Sharm_ElshiekDuration,

                // Shops
                Data.Sharm_ElshiekNamePlaces, Data.Sharm_ElshiekPrices, Data.Sharm_ElshiekDuration
        ), "Sharm Elshiek");

//        adapter.addFrag(new CairoParent(
//                // CairoParent
//                Data.North_CoastNamePlaces, Data.North_CoastPrices, Data.North_CoastDuration,
//                // Villas
//                Data.North_CoastNamePlaces, Data.North_CoastPrices, Data.North_CoastDuration,
//
//                // Offices
//                Data.North_CoastNamePlaces, Data.North_CoastPrices, Data.North_CoastDuration,
//
//                // Shops
//                Data.North_CoastNamePlaces, Data.North_CoastPrices, Data.North_CoastDuration
//        ), "North Coast");
//
//        adapter.addFrag(new CairoParent(
//                // CairoParent
//                Data.DahabNamePlaces, Data.DahabPrices, Data.DahabDuration,
//                // Villas
//                Data.DahabNamePlaces, Data.DahabPrices, Data.DahabDuration,
//
//                // Offices
//                Data.DahabNamePlaces, Data.DahabPrices, Data.DahabDuration,
//
//                // Shops
//                Data.DahabNamePlaces, Data.DahabPrices, Data.DahabDuration
//        ), "Dahab");

        viewPager.setAdapter(adapter);





    }

}

