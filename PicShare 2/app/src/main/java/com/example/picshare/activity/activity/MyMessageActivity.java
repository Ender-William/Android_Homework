package com.example.picshare.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.example.picshare.R;


public class MyMessageActivity extends BaseActivity {
    private String[] names = {"张三","李四","王五"};
    private String[] details = {"010-12345678","012-12345678","0951-12345678"};
    private int[] icon = {R.drawable.logo,R.drawable.logo,R.drawable.logo};


    @Override
    protected int initLayout() {
        return R.layout.activity_my_message;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        //强制使用竖屏
        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        super.onResume();

        ListView lv = findViewById(R.id.MyMesgListView);
        MyAdapter adapter = new MyAdapter();
        lv.setAdapter(adapter);


    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            View newview = View.inflate(MyMessageActivity.this,R.layout.my_msg_item,null);
            TextView name = newview.findViewById(R.id.MyMesgLVUserName);
            TextView mesg = newview.findViewById(R.id.MyMesgLVShowMesg);
            ImageView iv = newview.findViewById(R.id.MyMesgLVImg);

            name.setText(names[position]);
            mesg.setText(details[position]);
            iv.setBackgroundResource(icon[position]);

            return newview;
        }
    }

}