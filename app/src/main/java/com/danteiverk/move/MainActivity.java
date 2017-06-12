package com.danteiverk.move;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;

public class MainActivity extends TabActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private Context mContext;
    private TabHost tabHost;
    private RadioGroup radioGroup;
    private RadioButton rb_jd;
    private RadioButton rb_tz;
    private RadioButton rb_move;
    private RadioButton rb_jl;
    private RadioButton rb_sz;
    private int mColorTheme;
    private int mColorGray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        tabHost = this.getTabHost();
        tabHost.setup();
        // 添加选项卡 
        tabHost.addTab(tabHost.newTabSpec("ONE").setIndicator("one")
                .setContent(new Intent(this, JdAct.class)));

        tabHost.addTab(tabHost.newTabSpec("TWO").setIndicator("two")
                .setContent(new Intent(this, TzAct.class)));

        tabHost.addTab(tabHost.newTabSpec("THREE").setIndicator("three")
                .setContent(new Intent(this, MoveAct.class)));

        tabHost.addTab(tabHost.newTabSpec("FOUR").setIndicator("four")
                .setContent(new Intent(this, JlAct.class)));

        tabHost.addTab(tabHost.newTabSpec("FIVE").setIndicator("five")
                .setContent(new Intent(this, SzAct.class)));

        radioGroup = (RadioGroup) findViewById(R.id.main_radio);
        radioGroup.setOnCheckedChangeListener(this);

        // 初始化控件
        init();
    }

    private void init() {
        rb_jd = (RadioButton) findViewById(R.id.rb_jd);
        rb_tz = (RadioButton) findViewById(R.id.rb_tz);
        rb_move = (RadioButton) findViewById(R.id.rb_move);
        rb_jl = (RadioButton) findViewById(R.id.rb_jl);
        rb_sz = (RadioButton) findViewById(R.id.rb_sz);

        mColorTheme = Color.parseColor("#4c4c4c");
        mColorGray = Color.parseColor("#a6a6a6");

        rb_jd.setOnClickListener(this);
        rb_tz.setOnClickListener(this);
        rb_move.setOnClickListener(this);
        rb_jl.setOnClickListener(this);
        rb_sz.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // TODO Auto-generated method stub
        switch (checkedId) {
            case R.id.rb_jd:
                tabHost.setCurrentTabByTag("ONE");
                break;
            case R.id.rb_tz:
                tabHost.setCurrentTabByTag("TWO");
                break;
            case R.id.rb_move:
                tabHost.setCurrentTabByTag("THREE");
                break;
            case R.id.rb_jl:
                tabHost.setCurrentTabByTag("FOUR");
                break;
            case R.id.rb_sz:
                tabHost.setCurrentTabByTag("FIVE");
                break;
        }
    }
    @Override
    public void onClick(View view) {
        hideColor();
        switch (view.getId()) {
            case R.id.rb_jd:
                rb_jd.setTextColor(mColorTheme);
                break;
            case R.id.rb_tz:
                rb_tz.setTextColor(mColorTheme);
                break;
            case R.id.rb_move:
                rb_move.setTextColor(mColorTheme);
                break;
            case R.id.rb_jl:
                rb_jl.setTextColor(mColorTheme);
                break;
            case R.id.rb_sz:
                rb_sz.setTextColor(mColorTheme);
                break;
            default:
                break;
        }
    }

    private void choiceFrg(int num) {
        hideColor();
        switch (num) {
            case 0:
                rb_jd.setChecked(true);
                rb_jd.setTextColor(mColorTheme);
                break;
            case 1:
                rb_tz.setChecked(true);
                rb_tz.setTextColor(mColorTheme);
                break;
            case 2:
                rb_move.setChecked(true);
                rb_move.setTextColor(mColorTheme);
                break;
            case 3:
                rb_jl.setChecked(true);
                rb_jl.setTextColor(mColorTheme);
                break;
            case 4:
                rb_sz.setChecked(true);
                rb_sz.setTextColor(mColorTheme);
                break;
        }
    }

    private void hideColor() {
        rb_jd.setTextColor(mColorGray);
        rb_tz.setTextColor(mColorGray);
        rb_move.setTextColor(mColorGray);
        rb_jl.setTextColor(mColorGray);
        rb_sz.setTextColor(mColorGray);
    }

    public static SelectorView sv;
    public interface SelectorView {
        int selected();
    }

    /**
     * 设置显示那个模块
     *
     * @param position
     */
    public static void setView(final int position) {
        sv = new SelectorView() {
            @Override
            public int selected() {
                return position;
            }
        };
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        if (sv != null) {
            tabHost.setCurrentTab(sv.selected());
            rb_jd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tabHost.setCurrentTab(0);
                    choiceFrg(0);
                    sv = null;
                }
            });
            rb_tz.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    tabHost.setCurrentTab(1);
                    choiceFrg(1);
                    sv = null;
                }
            });
            rb_move.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tabHost.setCurrentTab(2);
                    choiceFrg(2);
                    sv = null;
                }
            });
            rb_jl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tabHost.setCurrentTab(3);
                    choiceFrg(3);
                    sv = null;
                }
            });
            rb_sz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tabHost.setCurrentTab(4);
                    choiceFrg(4);
                    sv = null;
                }
            });
            choiceFrg(sv.selected());

        }
    }
}
