package com.example.cheng.mypage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ScrollViewListener{

    private ImageView img;
    private DampView dampView;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        setupView();
    }

    public void setupView() {
        tv_title = findViewById(R.id.tv_title);
        tv_title.getBackground().setAlpha(0);
        img = findViewById(R.id.img);
        dampView = findViewById(R.id.dampview);
        dampView.setScrollViewListener(this);
        dampView.setImageView(img);
    }

    @Override
    public void onScrollChanged(DampView scrollView, int x, int y, int oldx, int oldy) {
        double percent = (double) dampView.getScrollY() / (double) img.getHeight();
        int i = (int) (percent * 255);
        if (i < 5) {
            i = 0;
        } else if (i > 250) {
            i = 255;
        }
        tv_title.getBackground().setAlpha(i);
    }

}
