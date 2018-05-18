package flowbank.daggertest.di.component;

import dagger.Component;
import flowbank.daggertest.di.FragmentScope;
import flowbank.daggertest.di.module.RecommendModule;
import flowbank.daggertest.ui.fragment.RecommendFragment;

/**
 * Created by jinhui on 2018/5/17.
 */
@FragmentScope
@Component(modules = RecommendModule.class, dependencies = AppComponent.class)
public interface RecommendComponent {

    void inject(RecommendFragment fragment);

}
