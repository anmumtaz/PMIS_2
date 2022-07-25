package com.example.pmis_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ResourceFragmentPM extends Fragment {

    TextView PMTask1, PMTask2, PMTask3, PMTask4, PMTask5, PMPIC1, PMPIC2, PMPIC3, PMPIC4, PMPIC5, PMUr1, PMUr2, PMUr3, PMUr4, PMUr5, PMStat1, PMStat2, PMStat3, PMStat4, PMStat5, PMTL1, PMTL2, PMTL3, PMTL4, PMTL5;
    String key;
    ProjectListData projectListData;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_resource_p_m, container, false);
        PMTask1 = view.findViewById(R.id.PMtvTask1);
        PMTask2 = view.findViewById(R.id.PMtvTask2);
        PMTask3 = view.findViewById(R.id.PMtvTask3);
        PMTask4 = view.findViewById(R.id.PMtvTask4);
        PMTask5 = view.findViewById(R.id.PMtvTask5);
        PMPIC1 = view.findViewById(R.id.PMtvPIC1);
        PMPIC2 = view.findViewById(R.id.PMtvPIC2);
        PMPIC3 = view.findViewById(R.id.PMtvPIC3);
        PMPIC4 = view.findViewById(R.id.PMtvPIC4);
        PMPIC5 = view.findViewById(R.id.PMtvPIC5);
        PMUr1 = view.findViewById(R.id.PMtvUr1);
        PMUr2 = view.findViewById(R.id.PMtvUr2);
        PMUr3 = view.findViewById(R.id.PMtvUr3);
        PMUr4 = view.findViewById(R.id.PMtvUr4);
        PMUr5 = view.findViewById(R.id.PMtvUr5);
        PMStat1 = view.findViewById(R.id.PMtvStat1);
        PMStat2 = view.findViewById(R.id.PMtvStat2);
        PMStat3 = view.findViewById(R.id.PMtvStat3);
        PMStat4 = view.findViewById(R.id.PMtvStat4);
        PMStat5 = view.findViewById(R.id.PMtvStat5);
        PMTL1 = view.findViewById(R.id.PMtvTL1);
        PMTL2 = view.findViewById(R.id.PMtvTL2);
        PMTL3 = view.findViewById(R.id.PMtvTL3);
        PMTL4 = view.findViewById(R.id.PMtvTL4);
        PMTL5 = view.findViewById(R.id.PMtvTL5);

        key = getActivity().getIntent().getStringExtra("key");
        projectListData = getActivity().getIntent().getParcelableExtra("data");

        PMTask1.setText(projectListData.getTask1());
        PMTask2.setText(projectListData.getTask2());
        PMTask3.setText(projectListData.getTask3());
        PMTask4.setText(projectListData.getTask4());
        PMTask5.setText(projectListData.getTask5());
        PMPIC1.setText(projectListData.getPIC1());
        PMPIC2.setText(projectListData.getPIC2());
        PMPIC3.setText(projectListData.getPIC3());
        PMPIC4.setText(projectListData.getPIC4());
        PMPIC5.setText(projectListData.getPIC5());
        PMUr1.setText(projectListData.getUrg1());
        PMUr2.setText(projectListData.getUrg2());
        PMUr3.setText(projectListData.getUrg3());
        PMUr4.setText(projectListData.getUrg4());
        PMUr5.setText(projectListData.getUrg5());
        PMStat1.setText(projectListData.getStat1());
        PMStat2.setText(projectListData.getStat2());
        PMStat3.setText(projectListData.getStat3());
        PMStat4.setText(projectListData.getStat4());
        PMStat5.setText(projectListData.getStat5());
        PMTL1.setText(projectListData.getTL1());
        PMTL2.setText(projectListData.getTL2());
        PMTL3.setText(projectListData.getTL3());
        PMTL4.setText(projectListData.getTL4());
        PMTL5.setText(projectListData.getTL5());

        return view;
    }
}