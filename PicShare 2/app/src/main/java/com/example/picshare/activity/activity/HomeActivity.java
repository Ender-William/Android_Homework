package com.example.picshare.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.picshare.R;
import com.example.picshare.activity.adapter.MyPagerAdapter;
import com.example.picshare.activity.entity.TabEntity;
import com.example.picshare.activity.fragment.CartoonFragment;
import com.example.picshare.activity.fragment.InsetFragment;
import com.example.picshare.activity.fragment.NovelFragment;
import com.example.picshare.activity.fragment.PersonalFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity {

    private String[] mTitles = {"插画", "漫画", "小说", "个人"};
    private int[] mIconUnselectIds = {
            R.mipmap.inset_unselect, R.mipmap.cartoon_unselect,
            R.mipmap.novel_unselect, R.mipmap.personal_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.inset_select, R.mipmap.cartoon_select,
            R.mipmap.novel_select, R.mipmap.personal_select};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private ViewPager viewPager;
    private CommonTabLayout commonTabLayout;

    @Override
    protected int initLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        viewPager = findViewById(R.id.viewpager);
        commonTabLayout = findViewById(R.id.commonTabLayout);
    }

    @Override
    protected void initData() {
        mFragments.add(InsetFragment.newInstance());
        mFragments.add(CartoonFragment.newInstance());
        mFragments.add(NovelFragment.newInstance());
        mFragments.add(PersonalFragment.newInstance());
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        commonTabLayout.setTabData(mTabEntities);
        commonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });

        viewPager.setOffscreenPageLimit(mFragments.size());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                commonTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),mTitles,mFragments));
    }
}