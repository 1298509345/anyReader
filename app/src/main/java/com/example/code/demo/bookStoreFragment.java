package com.example.code.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class bookStoreFragment extends Fragment {
    private TextView tv;
    private TextView tv2;
    public static bookStoreFragment newInstance(String name) {

        Bundle args = new Bundle();
        args.putString("name", name);
        bookStoreFragment fragment = new bookStoreFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv = view.findViewById(R.id.textView);
        tv2 = view.findViewById(R.id.textView2);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String name = bundle.get("name").toString();
            tv.setText("书籍1");
            tv2.setText("书籍2");
        }

    }
}
