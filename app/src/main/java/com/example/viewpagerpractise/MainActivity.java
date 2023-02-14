package com.example.viewpagerpractise;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFirstFragmentInteractionListener,
        SecondFragment.OnSecondFragmentInteractionListener,
        ThirdFragment.OnThirdFragmentInteractionListener {
    private ViewPager2 viewPager2;
    private FragmentStateAdapter pagerAdapter;

    private void initialise() {
        viewPager2 = findViewById(R.id.view_pager);
        pagerAdapter = new ViewPagerAdapter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialise();

        viewPager2.setAdapter(pagerAdapter);
        viewPager2.setPageTransformer(new ZoomOutPageTransformer());
    }

    @Override
    public void onFirstFragmentButtonClicked() {
        Toast.makeText(this, "First Fragment Button Clicked", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSecondFragmentButtonClicked() {
        Toast.makeText(this, "Second Fragment Button Clicked", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onThirdFragmentButtonClicked() {
        Toast.makeText(this, "Third Fragment Button Clicked", Toast.LENGTH_LONG).show();
    }
}