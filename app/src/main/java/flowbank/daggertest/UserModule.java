package flowbank.daggertest;

import dagger.Module;
import dagger.Provides;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/5/14.
 */
@Module
public class UserModule {

//    @Provides
//    public ApiService provideApiService(){
//        return  new ApiService();
//    }
    @Provides
    public UserManger provideUserManager(ApiService apiService){
        return  new UserManger(apiService);
    }
}
