package com.example.sin5.aboutfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sin5 on 2016/5/24.
 */
public class AnotherFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("create");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("pause");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("destroy");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println("createview");
        View root =  inflater.inflate(R.layout.fragment_another, container, false);

        root.findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        return root;
    }
}
