package flowbank.daggertest.http;

import flowbank.daggertest.bean.AppInfo;
import flowbank.daggertest.bean.PageBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/5/17.
 */
public interface ApiService {

//    public final String BASE_URL = "http://192.168.2.8/RestServer/api/";
    public final String BASE_URL = "http://112.124.22.238:8081/course_api/cniaoplay/";

    @GET("featured")
    public Call<PageBean<AppInfo>> getApps(@Query("p") String jsonParam);

}
