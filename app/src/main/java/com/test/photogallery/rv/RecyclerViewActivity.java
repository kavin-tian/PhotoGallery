package com.test.photogallery.rv;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.test.photogallery.R;

/**参考:
 * https://blog.csdn.net/m0_37796683/article/details/82497003
 */
public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private CardScaleHelper mCardScaleHelper;

    private int[] mPics = new int[]{R.mipmap.icon_1, R.mipmap.icon_2, R.mipmap.icon_3, R.mipmap.icon_4,
            R.mipmap.icon_5,R.mipmap.icon_1, R.mipmap.icon_2, R.mipmap.icon_3, R.mipmap.icon_4, R.mipmap.icon_5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(new MyAdapter(this, mPics));

        // mRecyclerView绑定scale效果
        mCardScaleHelper = new CardScaleHelper();
        mCardScaleHelper.setCurrentItemPos(1);

        mCardScaleHelper.attachToRecyclerView(mRecyclerView);
    }
}
