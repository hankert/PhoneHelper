package flowbank.daggertest.di.module;

import android.app.ProgressDialog;

import dagger.Module;
import dagger.Provides;
import flowbank.daggertest.data.RecommendModel;
import flowbank.daggertest.data.http.ApiService;
import flowbank.daggertest.presenter.RecommendPresenter;
import flowbank.daggertest.presenter.contract.RecommendContract;
import flowbank.daggertest.ui.fragment.RecommendFragment;

/**
 * Created by jinhui on 2018/5/17.
 */
@Module
public class RecommendModule {

    private RecommendContract.View mView;

    public RecommendModule(RecommendContract.View view) {
        mView = view;
    }

    @Provides
    public RecommendContract.Presenter providePresenter(RecommendContract.View view, RecommendModel model){

        return new RecommendPresenter(view, model);

    }

    @Provides
    public RecommendContract.View provideView(){
        return mView;
    }

    @Provides
    public RecommendModel provideModel(ApiService apiService){
        return new RecommendModel(apiService);
    }

    @Provides
    public ProgressDialog provideDialog(RecommendContract.View view){
            return new ProgressDialog(((RecommendFragment)view).getActivity());
    }

}
