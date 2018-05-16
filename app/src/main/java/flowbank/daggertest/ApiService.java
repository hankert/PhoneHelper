package flowbank.daggertest;

import android.util.Log;

import javax.inject.Inject;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/5/14.
 */
public class ApiService {

    @Inject
    public ApiService(){
        Log.d("ApiService", "register: 构造");
    }

    public void register(){
        Log.d("ApiService", "register: ");
    }

}
