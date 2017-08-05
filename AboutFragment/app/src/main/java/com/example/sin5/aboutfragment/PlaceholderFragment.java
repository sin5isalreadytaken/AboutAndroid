package com.example.sin5.aboutfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sin5 on 2016/5/24.
 */
public class PlaceholderFragment extends Fragment {
    public PlaceholderFragment(){

    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("a pause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("a destroy");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        rootView.findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container, new AnotherFragment()).commit();
            }
        });

        rootView.findViewById(R.id.startsa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SliderActivity.class));
            }
        });

        rootView.findViewById(R.id.startTab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Tabs.class));
            }
        });

        return rootView;
    }
}
