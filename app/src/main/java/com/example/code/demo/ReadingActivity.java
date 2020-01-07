package com.example.code.demo;

import android.app.Activity;

import java.io.IOException;
import java.io.InputStream;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class ReadingActivity extends Activity implements ScrollViewListener {
    private ObservableScrollView mScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_reading);

        mScrollView = findViewById(R.id.scroll);
        mScrollView.setScrollViewListener(this);
        TextView tv = findViewById(R.id.tv);
        // 拿到文件的输入流
        Intent intent = getIntent();
        InputStream in = null;
        if (intent.getStringExtra("bookName").equals("1"))
            in = getResources().openRawResource(R.raw.note1);
        else if (intent.getStringExtra("bookName").equals("2"))
            in = getResources().openRawResource(R.raw.note2);
        else if (intent.getStringExtra("bookName").equals("3"))
            in = getResources().openRawResource(R.raw.note3);
        else if (intent.getStringExtra("bookName").equals("4"))
            in = getResources().openRawResource(R.raw.note4);
        try {
            readFile(in, tv);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public void readFile(InputStream in, TextView tv) throws IOException {

        // 获得内容的长度in.available()
        byte[] buffer = new byte[in.available()];
        // 把内存从inputStream内读取到数组上
        in.read(buffer);


        // 把内容复制给String
        String content = new String(buffer, "UTF-8");
        tv.setText(content);

        // 初始化设计滑动距离只能这样写
        // mScrollView.smoothScrollTo()或mScrollView.mScrollView.scrollTo()均无效!
        // 根据记录的y来回到上次离开的地方
        mScrollView.post(new Runnable() {
            @Override
            public void run() {
                // 500为模拟值,实际上可以从轻量级数据库orSQLite获取上次记录的值
                mScrollView.smoothScrollTo(0, 500);
            }
        });
    }

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
        // 每次滑动记录y
        // 使用SharedPreferences或者SQLITE
    }
}
