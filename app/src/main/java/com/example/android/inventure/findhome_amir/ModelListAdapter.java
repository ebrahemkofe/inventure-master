package com.example.android.inventure.findhome_amir;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.android.inventure.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;



public class ModelListAdapter extends ArrayAdapter<ModelList> {

    //boolean likes[] = {false, false, false};

    boolean[] likes = new boolean[3];

    ArrayList<ModelList> arrayList;
    List<ModelList> list;


    public ModelListAdapter(Context context, ArrayList<ModelList> words) {
        super(context, 0, words);
        this.list = words;
        this.arrayList = new ArrayList<ModelList>();
        this.arrayList.addAll(words);
    }


    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {

        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.home_model, parent, false);
        }

        // for loop boolean like

        for (int x = 0; x < likes.length; x++) {
            likes[x] = false;
        }

        // Get the {@link Word} object located at this position in the list
        ModelList currentModel = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.model_main_image);
        Glide.with(parent).load(currentModel.getImageResourceID()).into(imageView);

        TextView mainPlaces = (TextView) listItemView.findViewById(R.id.model_txt_main_place_name);
        mainPlaces.setText(currentModel.getMainPlaceName());

        TextView price = (TextView) listItemView.findViewById(R.id.model_txt_price);
        price.setText(currentModel.getPrice());

        TextView duration = (TextView) listItemView.findViewById(R.id.model_txt_duration);
        duration.setText(currentModel.getDuration());

        RatingBar ratingBar = listItemView.findViewById(R.id.book_rating_ba);
        ratingBar.setRating(currentModel.getRating());




        final ImageButton like = listItemView.findViewById(R.id.model_like);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (likes[position] == false) {
            likes[position] = true;
                    Toast.makeText(getContext(), "Loved " + FindHome.namePlaces[position], Toast.LENGTH_SHORT).show();
            like.setImageResource(R.drawable.like_on);
            return;

        } else if (likes[position] == true) {
            likes[position] = false;
            like.setImageResource(R.drawable.like_off);
            }
        }});


        final RelativeLayout relativeLayout = listItemView.findViewById(R.id.model_relative);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BookNow bookNow = new BookNow();



              /*  bookNow.setBookMainImage(FindHome.mainImage[position]);
                bookNow.setBookNamePlaces(FindHome.namePlaces[position]);
                bookNow.setBookPrices(FindHome.prices[position]);
                bookNow.setBookDuration(FindHome.duration[position]);
                bookNow.setBookRating(FindHome.rating[position]);

                BookNow.unitPosition = position ;
                bookNow.unitLat = FindHome.unitLocationLat[position];
                bookNow.unitLng = FindHome.unitLocationLng[position];
*/

                Intent intent = new Intent(getContext(), BookNow.class);
                getContext().startActivity(intent);






        }
        });






        return listItemView;
    }

    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        list.clear();
        if (charText.length()==0){
            list.addAll(arrayList);
        }
        else {
            for (ModelList model : arrayList){
                if (model.getMainPlaceName().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    list.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }




}
