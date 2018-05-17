package flowbank.daggertest.presenter.contract;

import java.util.List;

import flowbank.daggertest.bean.AppInfo;
import flowbank.daggertest.presenter.BasePresenter;
import flowbank.daggertest.ui.BaseView;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/5/17.
 */
public interface RecommendContract {

    interface View extends BaseView{

        void showResult(List<AppInfo> datas);
        void showNodata();
        void showError(String msg);
    }

    interface Presenter extends BasePresenter{
        public void requestDatas();
    }

}
