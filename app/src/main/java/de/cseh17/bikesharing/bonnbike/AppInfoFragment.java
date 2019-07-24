package de.cseh17.bikesharing.bonnbike;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Objects;

public class AppInfoFragment extends Fragment {

    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.about_fragment, container, false);
        TextView datenschutzButtonTv = view.findViewById(R.id.datenschutz_button);

        datenschutzButtonTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatenschutzFragment datenschutzFragment = new DatenschutzFragment();
                FragmentManager fm = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                ft.add(R.id.main_layout,datenschutzFragment).addToBackStack(null).commit();
            }
        });

        datenschutzButtonTv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN: {
                        view.setAlpha(0.5f);
                        break;
                    }
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL: {
                        view.setAlpha(1.0f);
                        break;
                    }
                }
                return false;
            }
        });

        return view;
    }
}
