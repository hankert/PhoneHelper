package flowbank.daggertest.ui.bean;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/5/16.
 */
public class FragmentInfo {

    private String title;
    private Class mFragment;


    public FragmentInfo(String title, Class fragment) {
        this.title = title;
        mFragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public Class getFragment() {
        return mFragment;
    }



    public void setTitle(String title) {

        this.title = title;
    }

    public void setFragment(Class fragment) {
        mFragment = fragment;
    }
}
