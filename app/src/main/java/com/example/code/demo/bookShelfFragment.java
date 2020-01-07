package com.example.code.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class bookShelfFragment extends Fragment {
    private TextView tv3, tv4, tv5, tv6;
    private ImageView imgV3,imgV4,imgV5,imgV6;

    public static bookShelfFragment newInstance(String name) {

        Bundle args = new Bundle();
        args.putString("name", name);
        bookShelfFragment fragment = new bookShelfFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookshelf, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv3 = view.findViewById(R.id.bookName3);
        tv4 = view.findViewById(R.id.bookName4);
        tv5 = view.findViewById(R.id.bookName5);
        tv6 = view.findViewById(R.id.bookName6);
        imgV3 = view.findViewById(R.id.imageView3);
        imgV4 = view.findViewById(R.id.imageView4);
        imgV5 = view.findViewById(R.id.imageView5);
        imgV6 = view.findViewById(R.id.imageView6);
        Bundle bundle = getArguments();
        if (bundle != null) {
            tv3.setText("书籍3");
            tv4.setText("书籍4");
            tv5.setText("书籍5");
            tv6.setText("书籍6");
        }
        if (imgV3 != null) {
            imgV3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), ReadingActivity.class);
                    intent.putExtra("bookName","1");
                    startActivity(intent);
                }
            });
        }
        if (imgV4 != null) {
            imgV4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), ReadingActivity.class);
                    intent.putExtra("bookName","2");
                    startActivity(intent);
                }
            });
        }
        if (imgV5 != null) {
            imgV5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), ReadingActivity.class);
                    intent.putExtra("bookName","3");
                    startActivity(intent);
                }
            });
        }
        if (imgV6 != null) {
            imgV6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), ReadingActivity.class);
                    intent.putExtra("bookName","4");
                    startActivity(intent);
                }
            });
        }
    }
}
