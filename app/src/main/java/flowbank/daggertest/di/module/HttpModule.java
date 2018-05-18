package flowbank.daggertest.di.module;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import flowbank.daggertest.data.http.ApiService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jinhui on 2018/5/17.
 */
@Module
public class HttpModule {

    @Provides
    @Singleton
    public OkHttpClient provideOKHttpClient(){

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

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client){

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client);

        return builder.build();


    }

    @Provides
    @Singleton
    public ApiService provideApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

}
