package flowbank.daggertest.presenter;

import flowbank.daggertest.bean.AppInfo;
import flowbank.daggertest.bean.PageBean;
import flowbank.daggertest.data.RecommendModel;
import flowbank.daggertest.presenter.contract.RecommendContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @auther jh
 * @des 负责 和模型  view交互
 * Created by J.H on 2018/5/17.
 */
public class RecommendPresenter implements RecommendContract.Presenter {

    private RecommendContract.View mView;
    private RecommendModel mModel;

//    @Inject
    public RecommendPresenter(RecommendContract.View view, RecommendModel model) {
        mView = view;
        this.mModel = model;
    }


    @Override
    public void requestDatas() {

        mView.showLoading();
        mModel.getApps(new Callback<PageBean<AppInfo>>() {
            @Override
            public void onResponse(Call<PageBean<AppInfo>> call, Response<PageBean<AppInfo>> response) {
                if (response != null){
                    mView.showResult(response.body().getDatas());
                }else {
                    mView.showNodata();
                }
                mView.dimissLoading();
            }

            @Override
            public void onFailure(Call<PageBean<AppInfo>> call, Throwable t) {
                mView.dimissLoading();
                mView.showError(t.getMessage());
            }
        });
    }
}
