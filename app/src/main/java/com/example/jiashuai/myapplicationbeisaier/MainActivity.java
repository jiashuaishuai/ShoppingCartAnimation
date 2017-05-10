package com.example.jiashuai.myapplicationbeisaier;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jiashuai.myapplicationbeisaier.myadapter.MyListAdapter;
import com.example.jiashuai.myapplicationbeisaier.myview.MyLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView myListview;
    private TextView myTv, xxv;
    private List<String> data = new ArrayList<>();
    private int[] p = new int[2];
    private int[] iconP = new int[2];
    private PathMeasure mPathMeasure;
    private float[] mCurrentPosition = new float[2];
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xxv = (TextView) findViewById(R.id.xxv);
        myListview = (ListView) findViewById(R.id.mylistview);
        myTv = (TextView) findViewById(R.id.mytv);


        for (int i = 0; i < 50; i++) {
            data.add("商品" + i);
        }
        myListview.setAdapter(new MyListAdapter(this, data, p));
        myListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView item_icon = (ImageView) view.findViewById(R.id.icon_img);
                TextView tv = (TextView) view.findViewById(R.id.name_tv);
                tv.setText("点击次条目" + position);
                myTv.getLocationInWindow(p);
                item_icon.getLocationInWindow(iconP);
                startAnm();
            }
        });
    }

    private void startAnm() {
        int startx = iconP[0];
        int starty = iconP[1];
        int endx = p[0];
        int endy = p[1];
        int asx, asy;

        asx = (startx + endx) / 2;
        asy = starty - 300;

        Path path = new Path();
        path.moveTo(startx, starty);
        path.quadTo(asx, asy, endx, endy);

        mPathMeasure = new PathMeasure(path, false);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, mPathMeasure.getLength());
        valueAnimator.setDuration(300);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        xxv.setVisibility(View.VISIBLE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (Float) animation.getAnimatedValue();
// 获取当前点坐标封装到mCurrentPosition
                mPathMeasure.getPosTan(value, mCurrentPosition, null);
                xxv.setX(mCurrentPosition[0]);
                xxv.setY(mCurrentPosition[1]);

            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                index++;
                myTv.setText(index + "");
//                xxv.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        valueAnimator.start();
    }

}



