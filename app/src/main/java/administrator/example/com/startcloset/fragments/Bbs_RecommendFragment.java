package administrator.example.com.startcloset.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import administrator.example.com.startcloset.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Bbs_RecommendFragment extends BaseFragment {


    public Bbs_RecommendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bbs__recommend, container, false);
    }

    @Override
    public String getFragmentTitle() {
        return "推荐";
    }
}
