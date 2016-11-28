package administrator.example.com.startcloset.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import administrator.example.com.startcloset.fragments.BaseFragment;

/**
 * Created by Administrator on 2016/11/28.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> mList;
    private Context mContext;
    public MyFragmentAdapter(FragmentManager fm,List<BaseFragment> list) {
        super(fm);
        mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position).getFragmentTitle();
    }
}
