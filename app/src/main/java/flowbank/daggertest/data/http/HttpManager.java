package flowbank.daggertest.data.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/5/17.
 */
public class HttpManager {

    public OkHttpClient getOKHttpClient(){

        // 使用拦截器
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        //开发模式记录整个body  否则只记录基本信息返回200 http协议版本
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // 如果使用到https 我们需要创建 SSLSocketFactory 并设置到client

        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                // 连接超时设置
                .connectTimeout(10, TimeUnit.SECONDS)
                // 读取超时设置
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    public Retrofit getRetrofit(OkHttpClient client){

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client);

        return builder.build();


    }

}
