package com.example.dell.myvideoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.easefun.polyvsdk.sub.vlms.entity.PolyvCoursesInfo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String IS_VLMS_ONLINE = "isVlmsOnline";
    private Button mBtnPlay;
    private PolyvCoursesInfo.Course course = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnPlay = (Button) findViewById(R.id.btn_play);

        mBtnPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_play:
                Intent intent = new Intent(MainActivity.this, PolyvPlayerActivity.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean(MainActivity.IS_VLMS_ONLINE, true);
                bundle.putParcelable("course", course);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
    }
}
