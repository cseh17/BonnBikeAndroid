package de.cseh17.bikesharing.bonnbike;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DatenschutzFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.datenschutz_fragment, container, false);

        // Check for Android version, and set accordingly the html into the TextView in order to be displayed.
        final TextView datenschutzTv = view.findViewById(R.id.dsgvo_text_view);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            datenschutzTv.setText(Html.fromHtml(getString(R.string.dsgvo_html), Html.FROM_HTML_MODE_COMPACT));
        } else {
            datenschutzTv.setText(Html.fromHtml(getString(R.string.dsgvo_html)));
        }
        return view;
    }
}
