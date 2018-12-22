package com.example.android.inventure.MainFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.inventure.Cairo.Flats;
import com.example.android.inventure.Cairo.Offices;
import com.example.android.inventure.Cairo.Shops;
import com.example.android.inventure.Cairo.Villas;
import com.example.android.inventure.R;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class CairoParent extends Fragment {
    public CairoParent() {
    }

    private String[]
    // CairoParent
    flatsName, flatsPrices, flatsDuration,
    // Villas
    villasName, villasPrices, villasDuration,
    //offices
    officesName,officesPrice,officesDuration,
    //Shops
    shopsName, shopsPrice,shopsDuration;

    public CairoParent(String[] flatsName, String[] flatsPrices, String[] flatsDuration, String[] villasName, String[] villasPrices, String[] villasDuration, String[] officesName, String[] officesPrice, String[] officesDuration, String[] shopsName, String[] shopsprice, String[] shopsDuration) {
        this.flatsName = flatsName;
        this.flatsPrices = flatsPrices;
        this.flatsDuration = flatsDuration;
        this.villasName = villasName;
        this.villasPrices = villasPrices;
        this.villasDuration = villasDuration;
        this.officesName = officesName;
        this.officesPrice = officesPrice;
        this.officesDuration = officesDuration;
        this.shopsName = shopsName;
        this.shopsPrice = shopsprice;
        this.shopsDuration = shopsDuration;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one,container, false);
        // Setting ViewPager for each Tabs
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) view.findViewById(R.id.result_tabs);
        tabs.setupWithViewPager(viewPager);


        if (container== null){container.removeAllViews();}



        return view;

    }


    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {


        CairoParent.Adapter adapter = new CairoParent.Adapter(getChildFragmentManager());
        adapter.addFragment(new Flats(flatsName, flatsPrices, flatsDuration), "Flats");
        adapter.addFragment(new Villas(villasName, villasPrices, villasDuration), "Villas");
        adapter.addFragment(new Offices(officesName,officesPrice,officesDuration), "Offices");
        adapter.addFragment(new Shops( shopsName, shopsPrice,shopsDuration), "Shops");
        viewPager.setAdapter(adapter);





    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return mFragmentTitleList.get(position);
        }
    }



}