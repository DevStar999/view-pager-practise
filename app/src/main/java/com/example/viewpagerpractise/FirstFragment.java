package com.example.viewpagerpractise;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FirstFragment extends Fragment {
    private OnFirstFragmentInteractionListener mListener;
    private AppCompatButton firstFragmentButton;

    public FirstFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void settingOnClickListeners() {
        firstFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onFirstFragmentButtonClicked();
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        firstFragmentButton = view.findViewById(R.id.first_fragment_button);

        settingOnClickListeners();

        return view;
    }

    public interface OnFirstFragmentInteractionListener {
        void onFirstFragmentButtonClicked();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFirstFragmentInteractionListener) {
            mListener = (OnFirstFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context + " must implement OnFirstFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}