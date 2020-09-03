package com.test.photogallery.vp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.test.photogallery.R;

/**参考:
 * https://blog.csdn.net/m0_37796683/article/details/82427474
 */
public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private LinearLayout ll_layout;

    //向导界面的图片
    private int[] mPics = new int[]{R.mipmap.icon_1, R.mipmap.icon_2,
            R.mipmap.icon_3, R.mipmap.icon_4, R.mipmap.icon_5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp);
        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        ll_layout = (LinearLayout) findViewById(R.id.ll_layout);

        //设置适配器
        mViewPager.setAdapter(new MyAdapter(this, mPics));
        mViewPager.setPageMargin(20);
        mViewPager.setOffscreenPageLimit(mPics.length);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());//3D画廊模式

        //左右都有图
        mViewPager.setCurrentItem(1);

        //viewPager左右两边滑动无效的处理
        ll_layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return mViewPager.dispatchTouchEvent(motionEvent);
            }
        });
    }

}
