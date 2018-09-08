package com.zc.interfacecallback;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.zc.interfacecallback.adapter.MyAdapter;
import com.zc.interfacecallback.callback.DataCallBack;
import com.zc.interfacecallback.util.InitDataUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements DataCallBack {

    @Bind(R.id.rv)
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRV();
    }

    public void initRV() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyAdapter(InitDataUtil.getFData(), this));
    }

    @Override
    public void dataCallBack(Object obj) {
        if (obj instanceof String) {
            String data = (String) obj;
            Toast.makeText(MainActivity.this, "我是回调数据：" + data, Toast.LENGTH_SHORT).show();
        }
    }
}
