package flowbank.daggertest;

import android.util.Log;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/5/14.
 */
public class UserManger {

    private ApiService mApiService;
    public UserManger(ApiService apiService){
        mApiService = apiService;
    }


    public void register(){
        Log.d("UserManger", "register: ");
        mApiService.register();
    }


}
