package flowbank.daggertest.ui.activity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.context.IconicsLayoutInflater2;
import com.mikepenz.ionicons_typeface_library.Ionicons;

import flowbank.daggertest.R;

public class IconActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        LayoutInflaterCompat.setFactory2(getLayoutInflater(), new IconicsLayoutInflater2(getDelegate()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon);

        Drawable drawable =  new IconicsDrawable(this)
                .icon(Ionicons.Icon.ion_ios_alarm)
                .color(Color.RED)
                .sizeDp(24);

        ((ImageView)this.findViewById(R.id.img)).setImageDrawable(drawable);
    }
}
