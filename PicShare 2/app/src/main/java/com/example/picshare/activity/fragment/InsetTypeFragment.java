package com.example.picshare.activity.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.picshare.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InsetTypeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsetTypeFragment extends Fragment {
    private String title;

    public InsetTypeFragment() {
        // Required empty public constructor
    }


    public static InsetTypeFragment newInstance(String title) {
        InsetTypeFragment fragment = new InsetTypeFragment();
        fragment.title = title;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_inset_type, container, false);
        TextView tv = v.findViewById(R.id.title);
        tv.setText(title);
        return v;
    }
}