package com.example.android.inventure.MainFragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.android.inventure.R;
import com.example.android.inventure.findhome_amir.BookNow;
import com.example.android.inventure.findhome_amir.FindHome;
import com.example.android.inventure.findhome_amir.ModelList;

import java.util.List;


public class RecyclerView_dAdapter extends RecyclerView.Adapter<RecyclerView_dAdapter.ViewHolder>{

    boolean[] likes = new boolean[3];


    private List<ModelList> List_Item;
    private Context context;

    public RecyclerView_dAdapter(List<ModelList> list_Item, Context context) {
        List_Item = list_Item;
        this.context = context;
    }

    @Override
    public RecyclerView_dAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_model, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView_dAdapter.ViewHolder holder, final int position) {

        Glide.with(context).load(List_Item.get(position).getImageResourceID()).into(holder.imageView);

        holder.mainPlaces.setText(List_Item.get(position).getMainPlaceName());

        holder.price.setText(List_Item.get(position).getPrice());

        holder.duration.setText(List_Item.get(position).getDuration());

        holder.ratingBar.setRating(List_Item.get(position).getRating());


        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (likes[position] == false) {
                    likes[position] = true;
                    Toast.makeText(context, "Loved " + FindHome.namePlaces[position], Toast.LENGTH_SHORT).show();
                    holder.like.setImageResource(R.drawable.like_on);
                    return;

                } else if (likes[position] == true) {
                    likes[position] = false;
                    holder.like.setImageResource(R.drawable.like_off);
                }
            }});

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BookNow bookNow = new BookNow();



               /* bookNow.setBookMainImage(FindHome.mainImage[position]);
                bookNow.setBookNamePlaces(FindHome.namePlaces[position]);
                bookNow.setBookPrices(FindHome.prices[position]);
                bookNow.setBookDuration(FindHome.duration[position]);
                bookNow.setBookRating(FindHome.rating[position]);

                BookNow.unitPosition = position ;
                bookNow.unitLat = FindHome.unitLocationLat[position];
                bookNow.unitLng = FindHome.unitLocationLng[position];
*/

                Intent intent = new Intent(context, BookNow.class);
                context.startActivity(intent);






            }
        });



    }

    @Override
    public int getItemCount() {
        return (null != List_Item ? List_Item.size() : 0);
    }

    protected class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        private ImageView imageView;
        private TextView mainPlaces, price, duration;
        RatingBar ratingBar;
        ImageButton like;
        final RelativeLayout relativeLayout;

        public ViewHolder(View view) {
            super(view);

            relativeLayout = view.findViewById(R.id.model_relative);


            imageView = (ImageView) view.findViewById(R.id.model_main_image);

             mainPlaces = (TextView) view.findViewById(R.id.model_txt_main_place_name);

             price = (TextView) view.findViewById(R.id.model_txt_price);

             duration = (TextView) view.findViewById(R.id.model_txt_duration);

             ratingBar = view.findViewById(R.id.book_rating_ba);
             like = view.findViewById(R.id.model_like);

             cardView = (CardView) view.findViewById(R.id.card_view);
        }
    }
}

