package administrator.example.com.startcloset;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import administrator.example.com.startcloset.fragments.BbsFragment;
import administrator.example.com.startcloset.fragments.ClassFragment;
import administrator.example.com.startcloset.fragments.HomeFragment;
import administrator.example.com.startcloset.fragments.LikeFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.main_radiogroup)
    RadioGroup mMainRadiogroup;
    @BindView(R.id.main_home)
    RadioButton mMainHome;
    @BindView(R.id.main_class)
    RadioButton mMainClass;
    @BindView(R.id.main_bbs)
    RadioButton mMainBbs;
    @BindView(R.id.main_message)
    RadioButton mMainMessage;
    @BindView(R.id.main_like)
    RadioButton mMainLike;
    private Drawable mDrawable_home_on;
    private Drawable mDrawable_class_on;
    private Drawable mDrawable_bbs_on;
    private Drawable mDrawable_message_on;
    private Drawable mDrawable_like_on;
    private Drawable mDrawable_home;
    private Drawable mDrawable_class;
    private Drawable mDrawable_bbs;
    private Drawable mDrawable_message;
    private Drawable mDrawable_like;
    private BbsFragment mBbsFragment;
    private ClassFragment mClassFragment;
    private HomeFragment mHomeFragment;
    private LikeFragment mLikeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initDrawable();
        initFragment();
        mMainRadiogroup.setOnCheckedChangeListener(this);
        mMainRadiogroup.check(R.id.main_bbs);
    }

    private void initFragment() {
        mBbsFragment = new BbsFragment();
        mClassFragment = new ClassFragment();
        mHomeFragment = new HomeFragment();
        mLikeFragment = new LikeFragment();
    }

    private void initDrawable() {
        mDrawable_home_on = this.getResources().getDrawable(R.drawable.bottom_home_icon_on);
        mDrawable_class_on = this.getResources().getDrawable(R.drawable.buttom_class_on);
        mDrawable_bbs_on = this.getResources().getDrawable(R.drawable.buttom_bbs_on);
        mDrawable_message_on = this.getResources().getDrawable(R.drawable.buttom_massage_on);
        mDrawable_like_on = this.getResources().getDrawable(R.drawable.bottom_like_icon_on);
        mDrawable_home = this.getResources().getDrawable(R.drawable.bottom_home_icon);
        mDrawable_class = this.getResources().getDrawable(R.drawable.buttom_class);
        mDrawable_bbs = this.getResources().getDrawable(R.drawable.buttom_bbs);
        mDrawable_message = this.getResources().getDrawable(R.drawable.buttom_massage);
        mDrawable_like = this.getResources().getDrawable(R.drawable.bottom_like_icon);
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        //初始化Fragment管理器
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = manager.beginTransaction();
        //初始化GroupButton
        mMainHome.setCompoundDrawablesRelativeWithIntrinsicBounds(null,mDrawable_home,null,null);
        mMainClass.setCompoundDrawablesRelativeWithIntrinsicBounds(null,mDrawable_class,null,null);
        mMainBbs.setCompoundDrawablesRelativeWithIntrinsicBounds(null,mDrawable_bbs,null,null);
        mMainMessage.setCompoundDrawablesRelativeWithIntrinsicBounds(null,mDrawable_message,null,null);
        mMainLike.setCompoundDrawablesRelativeWithIntrinsicBounds(null,mDrawable_like,null,null);
        switch (i) {
            case R.id.main_home:
                mMainHome.setCompoundDrawablesRelativeWithIntrinsicBounds(null,mDrawable_home_on,null,null);
                beginTransaction.replace(R.id.main_container,mHomeFragment);
                break;
            case R.id.main_class:
                mMainClass.setCompoundDrawablesRelativeWithIntrinsicBounds(null,mDrawable_class_on,null,null);
                beginTransaction.replace(R.id.main_container,mClassFragment);
                break;
            case R.id.main_bbs:
                mMainBbs.setCompoundDrawablesRelativeWithIntrinsicBounds(null,mDrawable_bbs_on,null,null);
                beginTransaction.replace(R.id.main_container,mBbsFragment);
                break;
            case R.id.main_message:
                mMainMessage.setCompoundDrawablesRelativeWithIntrinsicBounds(null,mDrawable_message_on,null,null);
                break;
            case R.id.main_like:
                mMainLike.setCompoundDrawablesRelativeWithIntrinsicBounds(null,mDrawable_like_on,null,null);
                beginTransaction.replace(R.id.main_container,mLikeFragment);
                break;
        }
        beginTransaction.commit();
    }
}
