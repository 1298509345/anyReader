package com.example.code.demo;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;


public class settingFragment extends Fragment {
    private boolean btn_flag = true;
    private Switch button;


    public static settingFragment newInstance(String name) {

        Bundle args = new Bundle();
        args.putString("name", name);
        settingFragment fragment = new settingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        return view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button = view.findViewById(R.id.switch1);
        button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Resources resources = getActivity().getApplicationContext().getResources();
                    Drawable switchDrawable = resources.getDrawable(R.drawable.night);
                    getActivity().getWindow().setBackgroundDrawable(switchDrawable);
                    System.out.println("kai");
                }
                else {
                    Resources resources = getActivity().getApplicationContext().getResources();
                    getActivity().getWindow().setBackgroundDrawableResource(R.drawable.weathering);
                    System.out.println("guan");
                }

            }
        });
    }
}