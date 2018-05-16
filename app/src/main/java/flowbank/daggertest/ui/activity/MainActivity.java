package flowbank.daggertest.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import flowbank.daggertest.R;
import flowbank.daggertest.ui.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {



    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private View headerView;


//    @Inject
//    ApiService mApiService;
//    @Inject
//    UserManger mUserManger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        DaggerUserComponet.create().inject(this);
//
//        mUserManger.register();
//        mApiService.register();
//        DaggerUserComponet.builder().userModule(new UserModule()).build().inject(this);

//        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
//            @Override
//            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
//                Log.d(TAG, "onDrawerSlide: ");
//
//            }
//
//            @Override
//            public void onDrawerOpened(@NonNull View drawerView) {
//                Log.d(TAG, "onDrawerOpened: ");
//            }
//
//            @Override
//            public void onDrawerClosed(@NonNull View drawerView) {
//                Log.d(TAG, "onDrawerClosed: ");
//            }
//
//            @Override
//            public void onDrawerStateChanged(int newState) {
//                Log.d(TAG, "onDrawerStateChanged: ");
//            }
//        });

        initDrawerLayout();

        initTabLayout();

    }

    private void initTabLayout() {
        PagerAdapter  adapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    private void initDrawerLayout() {
        headerView = mNavigationView.getHeaderView(0);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "headerView clicked", Toast.LENGTH_SHORT).show();
            }
        });

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_app_update:
                        Toast.makeText(MainActivity.this, "menu_app_update clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_message:
                        Toast.makeText(MainActivity.this, "menu_message clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_setting:
                        Toast.makeText(MainActivity.this, "menu_setting clicked", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }

                return false;
            }
        });

        mToolBar.inflateMenu(R.menu.toolbar_menu);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.open, R.string.close);
        drawerToggle.syncState();
        mDrawerLayout.addDrawerListener(drawerToggle);
    }
}
