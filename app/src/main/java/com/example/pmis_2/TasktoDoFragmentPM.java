package com.example.pmis_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;


public class TasktoDoFragmentPM extends Fragment {

    TextView PMtvPercentage;
    ProgressBar PMprogressBar;
    SeekBar PMseekBar;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_taskto_do_p_m, container, false);
        PMtvPercentage = view.findViewById(R.id.PMtvPercentage);
        PMprogressBar = view.findViewById(R.id.PMprogress);
        PMseekBar = view.findViewById(R.id.PMseekBar);

        PMseekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                PMprogressBar.setProgress(progress);
                PMtvPercentage.setText("" + progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return view;
    }
}