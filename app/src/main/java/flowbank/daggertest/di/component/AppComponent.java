package flowbank.daggertest.di.component;

import javax.inject.Singleton;

import dagger.Component;
import flowbank.daggertest.data.http.ApiService;
import flowbank.daggertest.di.module.AppModule;
import flowbank.daggertest.di.module.HttpModule;

/**
 * Created by jinhui on 2018/5/17.
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    public ApiService getApiService();

}
