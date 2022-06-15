package com.example.picshare.activity.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.picshare.R;
import com.example.picshare.activity.adapter.InsetAdapter;
import com.example.picshare.activity.entity.TabEntity;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InsetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsetFragment extends Fragment {
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles = {
            "热门", "鬼灭之刃", "刀剑神域", "赛马娘",
            "辉夜", "犬夜叉", "蜡笔小新", "天空之城",
            "约会大作战", "冰菓", "理科生", "名侦探柯南",

    };
    private ViewPager viewPager;
    private SlidingTabLayout slidingTabLayout;



    public InsetFragment() {
        // Required empty public constructor
    }

    public static InsetFragment newInstance() {
        InsetFragment fragment = new InsetFragment();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_inset, container, false);
        viewPager = v.findViewById(R.id.InsetfixViewPager);
        slidingTabLayout = v.findViewById(R.id.InsetSlidingTabLayout);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        for (String title : mTitles) {
            mFragments.add(InsetTypeFragment.newInstance(title));
        }
        viewPager.setOffscreenPageLimit(mFragments.size());
        viewPager.setAdapter(new InsetAdapter(getFragmentManager(),mTitles,mFragments));
        slidingTabLayout.setViewPager(viewPager);
    }
}