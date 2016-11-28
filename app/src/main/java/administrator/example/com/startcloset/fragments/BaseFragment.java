package administrator.example.com.startcloset.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2016/11/28.
 */

public abstract class BaseFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public abstract String getFragmentTitle();
}
