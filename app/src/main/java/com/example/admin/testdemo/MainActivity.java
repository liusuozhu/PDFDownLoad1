package com.example.admin.testdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private EditText et;
    private SearchListPopUp searchListPopUp;
    private static List<String> supplyKeyWords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et= (EditText) findViewById(R.id.et);
        supplyKeyWords=new ArrayList<>();
        supplyKeyWords.add("43434");
        supplyKeyWords.add("3434");
        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initSearchPop();
            }
        });

    }
    public void initSearchPop(){
        searchListPopUp = new SearchListPopUp(MainActivity.this);
        searchListPopUp.mPopupWindow.setBackgroundDrawable(null);
        searchListPopUp.mPopupWindow.setOutsideTouchable(true);
        searchListPopUp.showPopupWindowAsDropDown(et);

    }


    public class SearchListPopUp extends BasePopupWindow {
        private Activity mActivity;

        public SearchListPopUp(Activity context) {
            super(context, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            mActivity = context;
        }

        @Override
        protected Animation getShowAnimation() {
            return null;
        }

        @Override
        protected View getClickToDismissView() {
            return null;
        }

        @Override
        public View getPopupView() {
            View view = getPopupViewById(R.layout.viewpaper_search);
            final LinearLayout llKeyWords=(LinearLayout)view.findViewById(R.id.llKeyWords);
            final List<String> keyWordsList=supplyKeyWords;
            if(keyWordsList!=null&&keyWordsList.size()>0) {
                llKeyWords.removeAllViews();
                for (int len = keyWordsList.size(), i = len - 1; i >= 0; i--) {
                    final View view1  = LayoutInflater.from(MainActivity.this).inflate(R.layout.viewpaper_search_item, null);
                    final TextView tvKeyWords = (TextView) view1.findViewById(R.id.tvKeyWords);
                    tvKeyWords.setText(keyWordsList.get(i));

                    llKeyWords.addView(view1);

                }


            }

            return view;
        }

        @Override
        public View getAnimaView() {
            return null;
        }
    }

}
