package administrator.example.com.startcloset.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import administrator.example.com.startcloset.model.Banner;
import it.sephiroth.android.library.picasso.Picasso;
import retrofit2.http.HEAD;

/**
 * Created by Administrator on 2016/11/28.
 */

public class HeadPagerAdapter extends PagerAdapter {
    private List<Banner.DataBean.ItemsBean> mList;
    private Context mContext;
    public HeadPagerAdapter(List<Banner.DataBean.ItemsBean> list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return 3000;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View ret=null;
        if (mList.size()!=0) {
            ImageView imageView = new ImageView(mContext);
            Banner.DataBean.ItemsBean itemsBean = mList.get(position % mList.size());
            Picasso.with(mContext)
                    .load(itemsBean.getComponent().getPicUrl())
                    .config(Bitmap.Config.RGB_565)
                    .into(imageView);
            container.addView(imageView);
            ret = imageView;
        }
        return ret;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(((View) object));
    }
}
