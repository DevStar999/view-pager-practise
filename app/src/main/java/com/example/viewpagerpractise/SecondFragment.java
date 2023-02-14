package com.example.viewpagerpractise;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SecondFragment extends Fragment {
    private OnSecondFragmentInteractionListener mListener;
    private AppCompatButton secondFragmentButton;

    public SecondFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void settingOnClickListeners() {
        secondFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onSecondFragmentButtonClicked();
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        secondFragmentButton = view.findViewById(R.id.second_fragment_button);

        settingOnClickListeners();

        return view;
    }

    public interface OnSecondFragmentInteractionListener {
        void onSecondFragmentButtonClicked();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSecondFragmentInteractionListener) {
            mListener = (OnSecondFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context + " must implement OnSecondFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}