package com.example.android.inventure;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.inventure.findhome_amir.Booking;
import com.example.android.inventure.youssef.Contact_Us;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TextView textViewOFDiscription;
    ViewPager viewPager ;
    ListView listView ;
    TextView textView ;
    ProgressBar progressBar;
    private int progressStatus = 0;
    private Handler handler = new Handler();








    listAdapter listAdapter;
    listAdapter listAdapter2;
    listAdapter listAdapter3;
    listAdapter listAdapter4;
    listAdapter listAdapter5;



     int q , w , e , r ,t ;



    String[] arr1 = {"space" , "price" , "address" , "metar price" };
    String[] arr2 = {"300 m2" , "3,500,000" , "new cairo" , "15000"};



    String[] arr2_2 = {"80 m2" , "500,000" , "alex" , "4000" };

    String[] arr2_3 = {"55 m2" , "900,000" , "north coast " , "10,000" , };

    String[] arr2_4 = {"90 m2" , "300,000" , " cairo " , "2,000" , };

    String[] arr2_5 = {"120 m2" , "1000,000" , " sharm " , "11,000" , };






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



progressBar=findViewById(R.id.simpleProgressBar);
        viewPager = findViewById(R.id.vp);
        textViewOFDiscription = findViewById(R.id.textOfDiscription);
        listView =findViewById(R.id.informationList);
         textView = findViewById(R.id.discription);


         textView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if ( q != 0 ){

                     Intent intent = new Intent(MainActivity.this ,  Main2Activity.class);
                     startActivity(intent);
                 }else if (w != 0 ){
                     Intent intent = new Intent(MainActivity.this ,  Main3Activity.class);
                     startActivity(intent);

                 }else if (e != 0 ){
                     Intent intent = new Intent(MainActivity.this ,  Main4Activity.class);
                     startActivity(intent);

                 }else if (r != 0 ){
                     Intent intent = new Intent(MainActivity.this ,  Main5Activity.class);
                     startActivity(intent);

                 }else if (t != 0 ){
                     Intent intent = new Intent(MainActivity.this ,  Main6Activity.class);
                     startActivity(intent);

                 }




             }
         });



        ArrayList<model> models = new ArrayList<>();


        for (int  x = 0 ; x < arr1.length ; x++){
            models.add  ( new model( arr1[x] , arr2 [x]) );

        }
        listAdapter = new listAdapter(this , R.layout.row_of_listview ,models);



        ArrayList<model> models2 = new ArrayList<>();



        for (int  x = 0 ; x < arr1.length ; x++){
            models2.add  ( new model( arr1[x] , arr2_2 [x]) );

        }
        listAdapter2 = new listAdapter(this , R.layout.row_of_listview ,models2);



        ArrayList<model> models3= new ArrayList<>();

        for (int  x = 0 ; x < arr1.length ; x++){
            models3.add  ( new model( arr1[x] , arr2_3 [x]) );

        }
        listAdapter3 = new listAdapter(this , R.layout.row_of_listview ,models3);



        ArrayList<model> models4= new ArrayList<>();

        for (int  x = 0 ; x < arr1.length ; x++){
            models4.add  ( new model( arr1[x] , arr2_4 [x]) );

        }
        listAdapter4 = new listAdapter(this , R.layout.row_of_listview ,models4);



        ArrayList<model> models5= new ArrayList<>();

        for (int  x = 0 ; x < arr1.length ; x++){
            models5.add  ( new model( arr1[x] , arr2_5 [x]) );

        }
        listAdapter5 = new listAdapter(this , R.layout.row_of_listview ,models5);

















        adapt_vp adapt = new adapt_vp(getApplicationContext());
        viewPager.setAdapter(adapt);


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {



                if (i == 0 ){

                    q++; w=0; e=0 ; r=0 ; t=0 ;

                    listView.setAdapter(listAdapter);
                    textViewOFDiscription.setText("luxury apartment in new cairo it has 4 rooms, 1 living rooms , 3 bathrooms and reception"  );



                }else if(i==1){
                    q=0; w++; e=0 ; r=0 ; t=0 ;


                    listView.setAdapter(listAdapter2);
                    textViewOFDiscription.setText("apartment in alex it has 2 rooms and reception ");

                }
                else if(i==2){
                    q=0; w=0; e++ ; r=0 ; t=0 ;
                    listView.setAdapter(listAdapter3);
                    textViewOFDiscription.setText("hotel apartment in north coast it has 1 room and reception ");

                }
                else if(i==3){

                    q=0; w=0; e=0 ; r++ ; t=0 ;
                    listView.setAdapter(listAdapter4);
                    textViewOFDiscription.setText("apartment in cairo it has 2 rooms and reception");

                }




                else if(i==4){

                    q=0; w=0; e=0 ; r=0 ; t++ ;
                    listView.setAdapter(listAdapter5);
                    textViewOFDiscription.setText("apartment in sharm it has 3 rooms and reception");

                }



            }

            @Override
            public void onPageSelected(int i) {




            }

            @Override
            public void onPageScrollStateChanged(int i) {




            }

        });

    }

    public void request(View view) {
        startActivity(new Intent(this,Contact_Us.class));
    }

    public void book(View view) {
        startActivity(new Intent(this, Booking.class));
    }



    //------------------------------------------------------------------------------------------------------
     //Adapter for ViewPager



    public class adapt_vp extends PagerAdapter {

        int [] arr1 ={R.drawable.photo1,R.drawable.photo2,R.drawable.photo3,R.drawable.photo4,R.drawable.photo5,};



        Context cont;
        LayoutInflater inf = null;

        public adapt_vp(Context cont){
            this.cont=cont;
            inf = (LayoutInflater) cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public int getCount() {
            return arr1.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == (LinearLayout) o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {

            View view = inf.inflate(R.layout.row_of_viewpager,container,false);
            ImageView img = view.findViewById(R.id.ImageOfViewPager);




            img.setImageResource(arr1[position]);


            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView( (LinearLayout) object );
        }
    }

    //--------------------------------------------------------------------------------------------------
    // adapter for listView


    public class listAdapter extends ArrayAdapter {


         ArrayList<model> m ;


        public listAdapter (@NonNull Context context , int i , @NonNull ArrayList object){
            super(context , i , object);

      m = object ;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inf = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.row_of_listview , parent , false );


            TextView textView1 = convertView.findViewById(R.id.textView_1);
            TextView textView2 = convertView.findViewById(R.id.textView_2);

            textView1.setText(m.get(position).text );
            textView2.setText(m.get(position).text2);






            return convertView ;
        }
    }

}
