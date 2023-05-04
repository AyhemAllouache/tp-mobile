package com.example.tweeting;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;
import java.util.Locale;

public class fragment1 extends Fragment {
    TextToSpeech t1;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    private String mParam1;
    private String mParam2;
    private String mParam3;
    public fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment1, container, false);
        String user = getActivity().getIntent().getStringExtra("user");
        String content = getActivity().getIntent().getStringExtra("content");
        String date = getActivity().getIntent().getStringExtra("date");
        TextView user1 = v.findViewById(R.id.username);
        TextView content1=v.findViewById(R.id.content);
        TextView date1 =v.findViewById(R.id.pub_date);
        user1.setText(mParam1);
        content1.setText(mParam2);
        date1.setText(mParam3);

        t1 = new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR){
                    t1.setLanguage(Locale.ENGLISH);
                }
            }
        });

        Button btn = v.findViewById(R.id.voice);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.speak(content,TextToSpeech.QUEUE_FLUSH,null);
            }

        });
        return v;

    }
    public static fragment1 newInstance(String user, String note, String date) {
        fragment1 fragment = new fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, user);
        args.putString(ARG_PARAM2, note);
        args.putString(ARG_PARAM3, date);
        fragment.setArguments(args);
        return fragment;
    }
}