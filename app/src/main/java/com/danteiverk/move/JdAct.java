package com.danteiverk.move;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.flyco.tablayout.SegmentTabLayout;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/24.
 */

public class JdAct extends FragmentActivity {

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private FragTargetProgress fragTargetProgress;
    private FragTarget fragTarget;
    private String[] mTitles = {"目标进度", "目标"};
    private View mDecorView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_jd);

        fragTargetProgress = new FragTargetProgress();
        fragTarget = new FragTarget();
        mFragments.add(fragTargetProgress);
        mFragments.add(fragTarget);
        mDecorView = getWindow().getDecorView();
        SegmentTabLayout tabLayout_4 = ViewFindUtils.find(mDecorView, R.id.tl_4);
        tabLayout_4.setTabData(mTitles, this, R.id.fl_change, mFragments);
    }
}
