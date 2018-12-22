package com.example.android.inventure.findhome_amir;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.android.inventure.R;

import java.util.ArrayList;

public class FindHome extends AppCompatActivity {

    private Toolbar mainToolbar;

    ModelListAdapter adapter;

    ArrayList<ModelList> arrayList = new ArrayList<ModelList>();

    boolean[] likes = new boolean[3];


    public static int mainImage[] = {R.drawable.villa, R.drawable.villa_tow, R.drawable.villa_three};
    public static String namePlaces[] = {"New Cairo", "New Capital", "El Rehab"};
    public static String prices[] = {"5000 EGP", "15000 EGP", "8000 EGP"};
    public static String duration[] = {"3 Years", "6 Years", "4 Years"};
    public static Float rating[] = { 4f, 5f, 3f};
    public static double unitLocationLat[] = {30.0081696, 30.0087918, 30.0653278};
    public static double unitLocationLng[] = {31.4741359, 31.728635, 31.4794939};



    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_home);




        final ArrayList<ModelList> list = new ArrayList<ModelList>();


//        list.add(new ModelList(mainImage[0], namePlaces[0], prices[0], duration[0], rating[0]));
//        list.add(new ModelList(mainImage[1], namePlaces[1], prices[1], duration[1], rating[1]));
//        list.add(new ModelList(mainImage[2], namePlaces[2], prices[2], duration[2], rating[2]));
//

        for (int i = 0; i<namePlaces.length; i++){
            ModelList model = new ModelList(mainImage[i],namePlaces[i],prices[i],duration[i],rating[i]);
            //bind all strings in an array
            arrayList.add(model);
        }

        adapter = new ModelListAdapter(this, arrayList);

        listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);



    }


    public  void LoveList(View view) { startActivity(new Intent(getApplicationContext(), BookNow.class)); }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else {
                    adapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.action_settings){
            //do your functionality here
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




}
