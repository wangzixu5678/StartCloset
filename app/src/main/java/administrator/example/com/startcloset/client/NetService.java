package administrator.example.com.startcloset.client;

import administrator.example.com.startcloset.model.Banner;

import administrator.example.com.startcloset.model.Recommend;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2016/11/28.
 */

public interface NetService {
    @GET("/forum/banner")
    Call<Banner> getBannerList();
    @GET("forum/tag-recommend")
    Call<Recommend> getRecommend();
}
