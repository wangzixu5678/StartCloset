package administrator.example.com.startcloset.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import administrator.example.com.startcloset.R;
import administrator.example.com.startcloset.adapter.MyFragmentAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BbsFragment extends Fragment{


    @BindView(R.id.bbs_fragment_toolbar)
    Toolbar mBbsFragmentToolbar;
    @BindView(R.id.bbs_fragment_tablayout)
    TabLayout mBbsFragmentTablayout;
    @BindView(R.id.bbs_fragment_viewpager)
    ViewPager mBbsFragmentViewpager;

    public BbsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ret = null;
        ret = inflater.inflate(R.layout.fragment_bbs, container, false);
        ButterKnife.bind(this, ret);
        //设置ActionBar
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(mBbsFragmentToolbar);
        ArrayList<BaseFragment> list = new ArrayList<>();
        list.add(new Bbs_FocusFragment());
        list.add(new Bbs_RecommendFragment());
        list.add(new Bbs_NewFragment());
        mBbsFragmentViewpager.setAdapter(new MyFragmentAdapter(getChildFragmentManager(),list));
        mBbsFragmentTablayout.setupWithViewPager(mBbsFragmentViewpager);
        return ret;
    }

}
