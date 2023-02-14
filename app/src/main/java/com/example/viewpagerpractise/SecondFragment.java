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
    private AppCompatButton swipeLeftButton;
    private AppCompatButton swipeRightButton;


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
        swipeLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onSecondFragmentSwipeLeftButtonClicked();
                }
            }
        });
        swipeRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onSecondFragmentSwipeRightButtonClicked();
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        secondFragmentButton = view.findViewById(R.id.second_fragment_button);
        swipeLeftButton = view.findViewById(R.id.swipe_left_second_fragment_button);
        swipeRightButton = view.findViewById(R.id.swipe_right_second_fragment_button);

        settingOnClickListeners();

        return view;
    }

    public interface OnSecondFragmentInteractionListener {
        void onSecondFragmentButtonClicked();
        void onSecondFragmentSwipeLeftButtonClicked();
        void onSecondFragmentSwipeRightButtonClicked();
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