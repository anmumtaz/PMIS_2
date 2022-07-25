package com.example.pmis_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ResourceFragment extends Fragment {

    TextView MemTask1, MemTask2, MemTask3, MemTask4, MemTask5, MemPIC1, MemPIC2, MemPIC3, MemPIC4, MemPIC5, MemUr1, MemUr2, MemUr3, MemUr4, MemUr5, MemStat1, MemStat2, MemStat3, MemStat4, MemStat5, MemTL1, MemTL2, MemTL3, MemTL4, MemTL5;
    String key;
    ProjectListData projectListData;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_resource, container, false);
        MemTask1 = view.findViewById(R.id.MemtvTask1);
        MemTask2 = view.findViewById(R.id.MemtvTask2);
        MemTask3 = view.findViewById(R.id.MemtvTask3);
        MemTask4 = view.findViewById(R.id.MemtvTask4);
        MemTask5 = view.findViewById(R.id.MemtvTask5);
        MemPIC1 = view.findViewById(R.id.MemtvPIC1);
        MemPIC2 = view.findViewById(R.id.MemtvPIC2);
        MemPIC3 = view.findViewById(R.id.MemtvPIC3);
        MemPIC4 = view.findViewById(R.id.MemtvPIC4);
        MemPIC5 = view.findViewById(R.id.MemtvPIC5);
        MemUr1 = view.findViewById(R.id.MemtvUr1);
        MemUr2 = view.findViewById(R.id.MemtvUr2);
        MemUr3 = view.findViewById(R.id.MemtvUr3);
        MemUr4 = view.findViewById(R.id.MemtvUr4);
        MemUr5 = view.findViewById(R.id.MemtvUr5);

        key = getActivity().getIntent().getStringExtra("key");
        projectListData = getActivity().getIntent().getParcelableExtra("data");

        MemTask1.setText(projectListData.getTask1());
        MemTask2.setText(projectListData.getTask2());
        MemTask3.setText(projectListData.getTask3());
        MemTask4.setText(projectListData.getTask4());
        MemTask5.setText(projectListData.getTask5());
        MemPIC1.setText(projectListData.getPIC1());
        MemPIC2.setText(projectListData.getPIC2());
        MemPIC3.setText(projectListData.getPIC3());
        MemPIC4.setText(projectListData.getPIC4());
        MemPIC5.setText(projectListData.getPIC5());
        MemUr1.setText(projectListData.getUrg1());
        MemUr2.setText(projectListData.getUrg2());
        MemUr3.setText(projectListData.getUrg3());
        MemUr4.setText(projectListData.getUrg4());
        MemUr5.setText(projectListData.getUrg5());
        MemStat1.setText(projectListData.getStat1());
        MemStat2.setText(projectListData.getStat2());
        MemStat3.setText(projectListData.getStat3());
        MemStat4.setText(projectListData.getStat4());
        MemStat5.setText(projectListData.getStat5());
        MemTL1.setText(projectListData.getTL1());
        MemTL2.setText(projectListData.getTL2());
        MemTL3.setText(projectListData.getTL3());
        MemTL4.setText(projectListData.getTL4());
        MemTL5.setText(projectListData.getTL5());

        return view;
    }
}