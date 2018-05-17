package flowbank.daggertest.data;

import flowbank.daggertest.bean.AppInfo;
import flowbank.daggertest.bean.PageBean;
import flowbank.daggertest.http.ApiService;
import flowbank.daggertest.http.HttpManager;
import retrofit2.Callback;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/5/17.
 */
public class RecommendModel {


    public void getApps(Callback<PageBean<AppInfo>> callback){

        HttpManager manager = new HttpManager();

        ApiService apiService =  manager.getRetrofit(manager.getOKHttpClient()).create(ApiService.class);
        apiService.getApps("{'page':0}").enqueue(callback);

    }

}
