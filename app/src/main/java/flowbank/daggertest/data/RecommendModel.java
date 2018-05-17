package flowbank.daggertest.data;

import flowbank.daggertest.bean.AppInfo;
import flowbank.daggertest.bean.PageBean;
import flowbank.daggertest.data.http.ApiService;
import flowbank.daggertest.data.http.HttpManager;
import retrofit2.Callback;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/5/17.
 */
public class RecommendModel {


    private ApiService mApiService;

    public RecommendModel(ApiService apiService) {
        mApiService = apiService;
    }

    public void getApps(Callback<PageBean<AppInfo>> callback){

//        HttpManager manager = new HttpManager();
//
//        ApiService apiService =  manager.getRetrofit(manager.getOKHttpClient()).create(ApiService.class);
        mApiService.getApps("{'page':0}").enqueue(callback);

    }

}
