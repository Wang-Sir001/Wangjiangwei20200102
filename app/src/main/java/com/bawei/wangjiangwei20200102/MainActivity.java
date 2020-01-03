package com.bawei.wangjiangwei20200102;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.bawei.wangjiangwei20200102.model.adapter.HomeAdapter;
import com.bawei.wangjiangwei20200102.model.entity.HomeEntity;
import com.bawei.wangjiangwei20200102.utils.OkhttpUtils;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView = findViewById(R.id.recy);

        OkhttpUtils.getInstance().doGet("http://172.17.8.100/small/commodity/v1/bannerShow", new OkhttpUtils.OkHttpCallback() {
            @Override
            public void success(String data) {
                Log.i("xxx",data);
                HomeEntity homeEntity = new Gson().fromJson(data, HomeEntity.class);
                recyclerView.setAdapter(new HomeAdapter(MainActivity.this,homeEntity.result));
            }

            @Override
            public void error(Throwable throwable) {

            }
        });

    }
}
