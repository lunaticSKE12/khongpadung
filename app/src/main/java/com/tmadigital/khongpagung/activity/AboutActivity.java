package com.tmadigital.khongpagung.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.tmadigital.khongpagung.R;
import com.tmadigital.khongpagung.fragment.AboutFragment;
import com.tmadigital.khongpagung.fragment.MapFragment;
import com.tmadigital.khongpagung.method.SamplinkMethod;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class AboutActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    private SamplinkMethod samplinkMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        initInstances();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, AboutFragment.newInstance())
                    .commit();
        }
    }

    @Override  //------ Use In Activity For Change Default Font
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    private void initInstances() {

        samplinkMethod = new SamplinkMethod();

        //samplinkMethod.showLoading(this, "Please Wait", "Loading Data...");

        //---- Create Toolbar In First Step
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        actionBarDrawerToggle = new ActionBarDrawerToggle(
                AboutActivity.this,
                drawerLayout,
                R.string.open_drawer,
                R.string.close_drawer
        );

        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        TextView headerTopic = (TextView) findViewById(R.id.title_topic);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/Kanit-Light.ttf");
        headerTopic.setTypeface(custom_font);
        headerTopic.setTextSize(getResources().getDimension(R.dimen.header_topic_size));
        headerTopic.setText(getResources().getString(R.string.about_title));

        samplinkMethod.initMenuClickable(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//        builder.setTitle("ยืนยัน");
//        builder.setMessage("ต้องการออกจากระบบใช่หรือไม่ค่ะ ?");
//
//        builder.setPositiveButton("ออกจากระบบ", new DialogInterface.OnClickListener() {
//
//            public void onClick(DialogInterface dialog, int which) {
//                //  Exit Application
//                moveTaskToBack(true);
//                dialog.dismiss();
//            }
//        });
//
//        builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//                // Do nothing
//                dialog.dismiss();
//            }
//        });
//
//        AlertDialog alert = builder.create();
//        alert.show();
    }
}
