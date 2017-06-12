package com.danteiverk.move;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/5/24.
 */

public class FragTargetProgress extends Fragment {
    private View view;
    private ArcProgressBar apb;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_tp, container, false);
        initView();
        return view;
    }

    private void initView() {
        apb = (ArcProgressBar) view.findViewById(R.id.apb);
        apb.setProgress(50);
    }
}
