package administrator.example.com.startcloset.fragments;


import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.List;

import administrator.example.com.startcloset.R;
import administrator.example.com.startcloset.adapter.HeadPagerAdapter;
import administrator.example.com.startcloset.client.NetService;
import administrator.example.com.startcloset.model.Banner;
import administrator.example.com.startcloset.model.Recommend;
import butterknife.BindView;
import butterknife.ButterKnife;
import it.sephiroth.android.library.picasso.Picasso;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class Bbs_RecommendFragment extends BaseFragment implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.bbs_fragment_recommend_headpager)
    ViewPager mBbsFragmentRecommendHeadpager;
    @BindView(R.id.bbs_fragment_pageRadioGroup)
    RadioGroup mBbsFragmentPageRadioGroup;
    @BindView(R.id.bbs_fragment_swiprefrshlayout)
    SwipeRefreshLayout mBbsFragmentSwiprefrshlayout;
    private boolean running;
    private View mRet;
    private HeadPagerAdapter mHeadPagerAdapter;
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 998:
                    int currentItem = mBbsFragmentRecommendHeadpager.getCurrentItem();
                    mBbsFragmentRecommendHeadpager.setCurrentItem((currentItem + 1) % 3);
                    break;
            }
            return true;
        }
    });
    private List<Banner.DataBean.ItemsBean> mItems;
    private NetService mNetService;

    public Bbs_RecommendFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRet = inflater.inflate(R.layout.fragment_bbs__recommend, container, false);
        ButterKnife.bind(this, mRet);
        //设置下拉刷新
        mBbsFragmentSwiprefrshlayout.setColorSchemeColors(Color.BLACK,Color.YELLOW,Color.RED,Color.BLUE);
        mBbsFragmentSwiprefrshlayout.setOnRefreshListener(this);
        //动态设置RadioButton个数
        for (int i = 0; i < 3; i++) {
            View rb = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bbs_radiobutton, null);
            rb.setId(i);
            mBbsFragmentPageRadioGroup.addView(rb, i);
        }
        mBbsFragmentPageRadioGroup.setOnCheckedChangeListener(this);
        mBbsFragmentRecommendHeadpager.setOnPageChangeListener(this);
        mBbsFragmentPageRadioGroup.check(0);
        //Retrofit进行网络访问 获取Banner
        Retrofit retrofit = getRetrofit();
        mNetService = retrofit.create(NetService.class);
        getNetBanner(mNetService);
        //Retrofit进行网络访问 获取Recommend
        getNetRecommend(mNetService);
        //开启线程发送消息轮滑Viewpager
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                running = true;
                while (running) {
                    mHandler.sendEmptyMessage(998);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
        thread.start();


        return mRet;
    }

    private void getNetRecommend(NetService netService) {
        Call<Recommend> recommend = netService.getRecommend();
        recommend.enqueue(new Callback<Recommend>() {
            @Override
            public void onResponse(Call<Recommend> call, Response<Recommend> response) {
                List<Recommend.ResponseBean.DataBean.ItemsBean> items = response.body().getResponse().getData().getItems();
                for (int i = 0; i < 6; i++) {
                    ImageView imgview = (ImageView) getView("bbs_fragment_imageview" + i);
                    Picasso.with(getContext()).load(items.get(i).getComponent().getPicUrl())
                            .config(Bitmap.Config.RGB_565)
                            .resize(220, 120)
                            .into(imgview);
                    TextView textView = (TextView) getView("bbs_fragment_textview" + i);
                    textView.setText(items.get(i).getComponent().getTitle());
                }
                mBbsFragmentSwiprefrshlayout.setRefreshing(false);

            }

            @Override
            public void onFailure(Call<Recommend> call, Throwable t) {

            }
        });
    }

    private void getNetBanner(NetService netService) {
        Call<Banner> bannerList = netService.getBannerList();
        bannerList.enqueue(new Callback<Banner>() {
            @Override
            public void onResponse(Call<Banner> call, Response<Banner> response) {
                Banner banner = response.body();
                mItems = banner.getData().getItems();
                mHeadPagerAdapter = new HeadPagerAdapter(mItems, getContext());
                mBbsFragmentRecommendHeadpager.setAdapter(mHeadPagerAdapter);
            }

            @Override
            public void onFailure(Call<Banner> call, Throwable t) {

            }
        });
    }

    @Override
    public void onDestroy() {
        running = false;
        super.onDestroy();
    }

    public static Retrofit getRetrofit() {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("http://api-v2.mall.hichao.com/");
        builder.addConverterFactory(ScalarsConverterFactory.create());
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit build = builder.build();
        return build;
    }

    public View getView(String id) {
        View ret = null;
        if (id != null) {
            Class<R.id> idClass = R.id.class;
            try {
                Field field = idClass.getDeclaredField(id);
                field.isAccessible();
                int anInt = field.getInt(idClass);
                ret = mRet.findViewById(anInt);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    @Override
    public String getFragmentTitle() {
        return "推荐";
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mBbsFragmentPageRadioGroup.check(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        mBbsFragmentRecommendHeadpager.setCurrentItem(i);
    }

    @Override
    public void onRefresh() {
        getNetBanner(mNetService);
        getNetRecommend(mNetService);
    }
}
