package flowbank.daggertest.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import flowbank.daggertest.ui.bean.FragmentInfo;
import flowbank.daggertest.ui.fragment.CategotyFragment;
import flowbank.daggertest.ui.fragment.GamesFragment;
import flowbank.daggertest.ui.fragment.RankingFragment;
import flowbank.daggertest.ui.fragment.RecommendFragment;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/5/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter{

    private List<FragmentInfo> mFragments = new ArrayList<>(4);

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragments();
    }

    private void initFragments(){
        mFragments.add(new FragmentInfo("推荐",RecommendFragment.class));
        mFragments.add(new FragmentInfo("排行",RankingFragment.class));
        mFragments.add(new FragmentInfo("游戏",GamesFragment.class));
        mFragments.add(new FragmentInfo("分类",CategotyFragment.class));
    }


    @Override
    public Fragment getItem(int position) {
        try {
            return (Fragment) mFragments.get(position).getFragment().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
/*
switch (position){
case 0:
fragment = new CategotyFragment();
break;
case 1:
fragment = new GamesFragment();
break;
case 2:
fragment = new RecommendFragment();
break;
case 3:
fragment = new RankingFragment();
break;
default:
break;
}
*/
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getTitle();
    }
}
