package flowbank.daggertest;

import android.app.Application;
import android.content.Context;

import flowbank.daggertest.di.component.AppComponent;
import flowbank.daggertest.di.component.DaggerAppComponent;
import flowbank.daggertest.di.module.AppModule;
import flowbank.daggertest.di.module.HttpModule;

/**
 * Created by jinhui on 2018/5/17.
 */

public class AppApplication extends Application {


    public AppComponent mAppComponent;

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static Application get(Context context){
        return (Application) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                // 官方说明有说明
//                .appModule(new AppModule(this))
                .httpModule(new HttpModule())
                .build();

    }


}
