package com.example.viewpagerpractise;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ThirdFragment extends Fragment {
    private OnThirdFragmentInteractionListener mListener;
    private AppCompatButton thirdFragmentButton;

    public ThirdFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void settingOnClickListeners() {
        thirdFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onThirdFragmentButtonClicked();
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);

        thirdFragmentButton = view.findViewById(R.id.third_fragment_button);

        settingOnClickListeners();

        return view;
    }

    public interface OnThirdFragmentInteractionListener {
        void onThirdFragmentButtonClicked();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnThirdFragmentInteractionListener) {
            mListener = (OnThirdFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context + " must implement OnThirdFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}