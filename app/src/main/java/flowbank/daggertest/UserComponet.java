package flowbank.daggertest;

import dagger.Component;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/5/14.
 */
@Component(modules = {UserModule.class})
public interface UserComponet {

     void inject(MainActivity mainActivity);

}
