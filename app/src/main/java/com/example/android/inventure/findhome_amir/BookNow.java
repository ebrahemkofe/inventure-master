package com.example.android.inventure.findhome_amir;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.android.inventure.R;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionButton;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionHelper;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionLayout;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RFACLabelItem;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RapidFloatingActionContentLabelList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookNow extends AppCompatActivity implements RapidFloatingActionContentLabelList.OnRapidFloatingActionContentLabelListListener, View.OnTouchListener {


//    private SectionsPagerAdapter mSectionsPagerAdapter;


    private ViewPager mViewPager;

    private RapidFloatingActionLayout rfaLayout;

    private RapidFloatingActionButton rfaBtn;

    private RapidFloatingActionHelper rfabHelper;
    private SliderLayout slider;
    private ArrayList<Integer> images;
    public RelativeLayout frameLayout;
    private TextView LongText;
    float dX, dY;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_now);

        LongText=findViewById(R.id.LongText);
        frameLayout = findViewById(R.id.layout_counter);
        rfaLayout = findViewById(R.id.activity_main_rfal);
        rfaBtn = findViewById(R.id.activity_main_rfab);
        frameLayout.setOnTouchListener(this);
        makeTextViewResizable(LongText,3,"View More",true);



        Rabd(getApplicationContext());



    }


    private void SliderFun() {

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Living Room", R.drawable.fl);
        file_maps.put("Bed Room 1", R.drawable.fll);
        file_maps.put("Bed Room 2", R.drawable.flll);
        file_maps.put("Bed Room 3", R.drawable.fllll);
        file_maps.put("BathRoom", R.drawable.flllll);
//        file_maps.put("part 6", R.drawable.desgin);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
//                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            slider.addSlider(textSliderView);
        }
        slider.setPresetTransformer(SliderLayout.Transformer.FlipHorizontal);
        slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        slider.setCustomAnimation(new DescriptionAnimation());
        slider.setDuration(4000);
//        slider.addOnPageChangeListener(this);
//        ListView l = (ListView)findViewById(R.id.transformers);
//        l.setAdapter(new TransformerAdapter(this));
//        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                mDemoSlider.setPresetTransformer(((TextView) view).getText().toString());
//                Toast.makeText(MainActivity.this, ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
//            }
//    });

    }

    private void Rabd(Context context) {
        RapidFloatingActionContentLabelList rfaContent = new RapidFloatingActionContentLabelList(context);
        rfaContent.setOnRapidFloatingActionContentLabelListListener(this);
        List<RFACLabelItem> items = new ArrayList<>();
        items.add(new RFACLabelItem<Integer>()
                .setLabel("Location")
                .setResId(R.mipmap.ic_loction)
                .setIconNormalColor(Color.WHITE)
                .setIconPressedColor(0xffbf360c)
                .setLabelColor(Color.RED)
                .setWrapper(0)

        );

        items.add(new RFACLabelItem<Integer>()
                .setLabel("Booking")
                .setResId(R.mipmap.ic_booking)
                .setIconNormalColor(Color.WHITE)
                .setIconPressedColor(0xff3e2723)
                .setLabelColor(0xFF00700D)
                .setLabelSizeSp(14)
                .setWrapper(1)
        );
        items.add(new RFACLabelItem<Integer>()
                .setLabel("maket")
                .setResId(R.mipmap.ic_buldingg)
                .setIconNormalColor(Color.WHITE)
                .setIconPressedColor(0xff1a237e)
                .setLabelColor(0xff000F5C)
                .setWrapper(2)
        );
        items.add(new RFACLabelItem<Integer>()
                .setLabel("Like")
                .setResId(R.mipmap.ic_heart)
                .setIconNormalColor(Color.WHITE)
                .setIconPressedColor(0xff0d5302)
                .setLabelColor(Color.RED)
                .setWrapper(3)
        );
        items.add(new RFACLabelItem<Integer>()
                .setLabel("3D")
                .setResId(R.mipmap.ic_threed)
                .setIconNormalColor(Color.WHITE)
                .setIconPressedColor(0xff0d5302)
                .setLabelColor(0xff000000)
                .setWrapper(4)
        );
        rfaContent
                .setItems(items)
                .setIconShadowColor(0xff888888)
        ;
        rfabHelper = new RapidFloatingActionHelper(
                context,
                rfaLayout,
                rfaBtn,
                rfaContent
        ).build();
    }


    @Override
    public void onRFACItemLabelClick(int position, RFACLabelItem item) {
        Toast.makeText(getApplicationContext(), "clicked label: " + position, Toast.LENGTH_SHORT).show();

        rfabHelper.toggleContent();
    }

    @Override
    public void onRFACItemIconClick(int position, RFACLabelItem item) {
        Toast.makeText(getApplicationContext(), "clicked icon: " + position, Toast.LENGTH_SHORT).show();
        if (position == 2) {
            Toast.makeText(this, "done!", Toast.LENGTH_SHORT).show();
        }
        rfabHelper.toggleContent();
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:

                dX = view.getX() - event.getRawX();
                dY = view.getY() - event.getRawY();
                break;

            case MotionEvent.ACTION_MOVE:

                view.animate()
                        .x(event.getRawX() + dX)
                        .y(event.getRawY() + dY)
                        .setDuration(0)
                        .start();
                break;
            default:
                view.animate().x(35).y(460).setDuration(950).start();
                return false;
        }
        return true;
    }


    public static void makeTextViewResizable(final TextView tv, final int maxLine, final String expandText, final boolean viewMore) {

        if (tv.getTag() == null) {
            tv.setTag(tv.getText());
        }
        ViewTreeObserver vto = tv.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @SuppressWarnings("deprecation")
            @Override
            public void onGlobalLayout() {
                String text;
                int lineEndIndex;
                ViewTreeObserver obs = tv.getViewTreeObserver();
                obs.removeGlobalOnLayoutListener(this);
                if (maxLine == 0) {
                    lineEndIndex = tv.getLayout().getLineEnd(0);
                    text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                } else if (maxLine > 0 && tv.getLineCount() >= maxLine) {
                    lineEndIndex = tv.getLayout().getLineEnd(maxLine - 1);
                    text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                } else {
                    lineEndIndex = tv.getLayout().getLineEnd(tv.getLayout().getLineCount() - 1);
                    text = tv.getText().subSequence(0, lineEndIndex) + " " + expandText;
                }
                tv.setText(text);
                tv.setMovementMethod(LinkMovementMethod.getInstance());
                tv.setText(
                        addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, lineEndIndex, expandText,
                                viewMore), TextView.BufferType.SPANNABLE);
            }
        });
    }
    private static SpannableStringBuilder addClickablePartTextViewResizable(final Spanned strSpanned, final TextView tv,
                                                                            final int maxLine, final String spanableText, final boolean viewMore) {
        String str = strSpanned.toString();
        SpannableStringBuilder ssb = new SpannableStringBuilder(strSpanned);

        if (str.contains(spanableText)) {


            ssb.setSpan(new MySpannable(false){
                @Override
                public void onClick(View widget) {
                    tv.setLayoutParams(tv.getLayoutParams());
                    tv.setText(tv.getTag().toString(), TextView.BufferType.SPANNABLE);
                    tv.invalidate();
                    if (viewMore) {
                        makeTextViewResizable(tv, -1, "View Less", false);
                    } else {
                        makeTextViewResizable(tv, 3, "View More", true);
                    }
                }
            }, str.indexOf(spanableText), str.indexOf(spanableText) + spanableText.length(), 0);

        }
        return ssb;

    }


}
