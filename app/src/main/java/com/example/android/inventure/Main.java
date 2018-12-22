package com.example.android.inventure;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.android.inventure.Cairo.Flats;
import com.example.android.inventure.MainFragment.CairoParent;
import com.example.android.inventure.MainFragment.Data;
import com.example.android.inventure.MainFragment.MainF;
import com.example.android.inventure.MainFragment.ViewPagerAdapter;
import com.example.android.inventure.ali.AccountFragment;
import com.example.android.inventure.ali.HomeFragment;
import com.example.android.inventure.ali.NotificationFragment;
import com.example.android.inventure.ali.Setup;
import com.example.android.inventure.findhome_amir.BookNow;
import com.example.android.inventure.findhome_amir.FindHome;
import com.example.android.inventure.findhome_amir.ModelList;
import com.example.android.inventure.maps_amir.MapsActivity;
import com.example.android.inventure.youssef.Login;
import com.example.android.inventure.youssef.Payment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar mainToolbar;
    private FirebaseAuth mAuth;
    private FirebaseFirestore firebaseFirestore;

    private String current_user_id;
    private MediaPlayer mp;
    private FloatingActionButton addPostBtn;

    private BottomNavigationView mainbottomNav;

    private HomeFragment homeFragment;
    private NotificationFragment notificationFragment;
    private AccountFragment accountFragment;


    private TabLayout tabLayout;
    private ViewPager viewPager;


    public static ArrayList<ModelList> cairoFlats = new ArrayList<ModelList>();
    public static ArrayList<ModelList> newCairoFlats = new ArrayList<ModelList>();
    public static ArrayList<ModelList> alexFlats = new ArrayList<ModelList>();
    public static ArrayList<ModelList> sharmFlats = new ArrayList<ModelList>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mainToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // start


        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        for (int i = 0; i<Data.mainImage.length; i++){
            ModelList model = new ModelList(Data.mainImage[i],
                    Data.FlatsCairoNamePlaces[i], Data.FlatsCairoPrices[i], Data.FlatsCairoDuration[i],
                    Data.rating[i]);
            //bind all strings in an array
            cairoFlats.add(model);
        }


        Flats.flatsArrayList = cairoFlats ;





//        mAuth = FirebaseAuth.getInstance();
//        firebaseFirestore = FirebaseFirestore.getInstance();
//        mp = MediaPlayer.create(this, R.raw.nafegation);
//        mainToolbar = (Toolbar) findViewById(R.id.main_toolbar);
//        setSupportActionBar(mainToolbar);
//
//        getSupportActionBar().setTitle("Search");
//
//        if (mAuth.getCurrentUser() != null) {
//
//            mainbottomNav = findViewById(R.id.mainBottomNav);
//
//            // FRAGMENTS
//            homeFragment = new HomeFragment();
//            notificationFragment = new NotificationFragment();
//            accountFragment = new AccountFragment();
//
//            initializeFragment();
//
//            mainbottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                    Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.main_container);
//
//                    switch (item.getItemId()) {
//
//                        case R.id.bottom_action_home:
//                            FloatingActionButton floatingActionButton3 = findViewById(R.id.add_post_btn);
//                            floatingActionButton3.setVisibility(View.VISIBLE);
//                            replaceFragment(homeFragment, currentFragment);
//                            return true;
//                        case R.id.bottom_action_account:
//                            FloatingActionButton floatingActionButton = findViewById(R.id.add_post_btn);
//                            floatingActionButton.setVisibility(View.GONE);
//                            replaceFragment(accountFragment, currentFragment);
//                            return true;
//
//                        case R.id.bottom_action_notif:
//                            FloatingActionButton floatingActionButton1 = findViewById(R.id.add_post_btn);
//                            floatingActionButton1.setVisibility(View.GONE);
//                            replaceFragment(notificationFragment, currentFragment);
//                            return true;
//
//                        default:
//                            return false;
//
//
//                    }
//
//                }
//            });
//
//
//            addPostBtn = findViewById(R.id.add_post_btn);
//            addPostBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    startActivity(new Intent(Main.this, Post.class));
//                }
//            });
//        }
//

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.find_home) {
            // Handle the camera action
            startActivity(new Intent(this, FindHome.class));
        } else if (id == R.id.service) {
            BookNow bookNow = new BookNow();

          /*  bookNow.setBookMainImage(FindHome.mainImage[0]);
            bookNow.setBookNamePlaces(FindHome.namePlaces[0]);
            bookNow.setBookPrices(FindHome.prices[0]);
            bookNow.setBookDuration(FindHome.duration[0]);
            bookNow.setBookRating(FindHome.rating[0]);
            */

            startActivity(new Intent(this, BookNow.class));

        } else if (id == R.id.gps) {
            startActivity(new Intent(this, MapsActivity.class));

        } else if (id == R.id.contact_us) {
            startActivity(new Intent(this, MainActivity.class));

        } else if (id == R.id.sign_in) {
            startActivity(new Intent(this, Login.class));

        } else if (id == R.id.payment) {
            startActivity(new Intent(this, Payment.class));

        } else if (id == R.id.news_events) {

            startActivity(new Intent(this, MainF.class));

        } else if (id == R.id.notification) {
            Toast.makeText(this, "make navegation", Toast.LENGTH_SHORT).show();
            mp.start();
            clicme();
        } else if (id == R.id.recent_viewed) {
            startActivity(new Intent(this, FindHome.class));


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
//        if (currentUser == null) {
//
//            sendToLogin();
//
//        } else {
//
//            current_user_id = mAuth.getCurrentUser().getUid();
//
//            firebaseFirestore.collection("Users").document(current_user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                @Override
//                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//
//                    if (task.isSuccessful()) {
//
//                        if (!task.getResult().exists()) {
//
//                            startActivity(new Intent(Main.this, Setup.class));
//                            finish();
//
//                        }
//
//                    } else {
//
//                        String errorMessage = task.getException().getMessage();
//                        Toast.makeText(Main.this, "Error : " + errorMessage, Toast.LENGTH_LONG).show();
//
//
//                    }
//
//                }
//            });
//
//
//        }
//
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_logout_btn:
                logOut();

                return true;
            case R.id.action_settings_btn:


                startActivity(new Intent(Main.this, Setup.class));

                return true;


            default:
                return false;


        }

    }

    private void logOut() {


        mAuth.getInstance().signOut();
        sendToLogin();

    }

    private void sendToLogin() {

        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();

    }

    private void initializeFragment() {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.add(R.id.main_container, homeFragment);
        fragmentTransaction.add(R.id.main_container, notificationFragment);
        fragmentTransaction.add(R.id.main_container, accountFragment);


        fragmentTransaction.hide(notificationFragment);
        fragmentTransaction.hide(accountFragment);

        fragmentTransaction.commit();

    }

    private void replaceFragment(Fragment fragment, Fragment currentFragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (fragment == homeFragment) {


            fragmentTransaction.hide(accountFragment);
            fragmentTransaction.hide(notificationFragment);


        }

        if (fragment == accountFragment) {

            fragmentTransaction.hide(homeFragment);
            fragmentTransaction.hide(notificationFragment);


        }

        if (fragment == notificationFragment) {

            fragmentTransaction.hide(homeFragment);
            fragmentTransaction.hide(accountFragment);
        }
        fragmentTransaction.show(fragment);

        fragmentTransaction.replace(R.id.main_container, fragment);
        fragmentTransaction.commit();
    }

    //for nevegation
    private void clicme() {


        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this).setSmallIcon(R.drawable.download1).setContentTitle("notification")
                .setContentText("thise my aqar applecation ");
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, mBuilder.build());
    }

    // start - amir

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