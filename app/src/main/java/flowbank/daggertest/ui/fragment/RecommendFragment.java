package flowbank.daggertest.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import flowbank.daggertest.R;
import flowbank.daggertest.bean.AppInfo;
import flowbank.daggertest.presenter.RecommendPresenter;
import flowbank.daggertest.presenter.contract.RecommendContract;
import flowbank.daggertest.ui.adapter.RecomendAppAdatper;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/5/16.
 */
public class RecommendFragment extends Fragment implements RecommendContract.View{


    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private RecomendAppAdatper mRecomendAppAdatper;

    private RecommendContract.Presenter mPresenter;
    private ProgressDialog mProgressDialog;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);

        ButterKnife.bind(this, view);
        mProgressDialog = new ProgressDialog(getActivity());
        mPresenter = new RecommendPresenter(this);
        initData();
        return view;
    }

    private void initData(){
        mPresenter.requestDatas();
    }

    private void initRecyclerView(List<AppInfo> datas){
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecomendAppAdatper = new RecomendAppAdatper(getActivity(), datas);

        mRecyclerView.setAdapter(mRecomendAppAdatper);
    }

    @Override
    public void showResult(List<AppInfo> datas) {
        initRecyclerView(datas);
    }

    @Override
    public void showNodata() {
        Toast.makeText(getActivity(), "暂时没数据，请吃饭再来", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getActivity(), "服务器开小差了"+msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        mProgressDialog.show();
    }

    @Override
    public void dimissLoading() {
        if (mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }
}
