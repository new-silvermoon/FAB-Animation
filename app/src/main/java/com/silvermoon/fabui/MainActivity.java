package com.silvermoon.fabui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewAnimationUtils;
import android.widget.LinearLayout;

import com.silvermoon.fabui.animation.AnimFrag;

public class MainActivity extends AppCompatActivity implements AnimFrag.Callbacks{

    private LinearLayout llOld,llNew;
    float pixelDensity;
    private UpdatedViewFrag updatedViewFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        llOld = (LinearLayout)findViewById(R.id.llBottom);

        pixelDensity = getResources().getDisplayMetrics().density;

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        updatedViewFrag = UpdatedViewFrag.newInstance();
        updatedViewFrag.setParentFab(fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // revealView();
             //   llOld.setVisibility(View.GONE);
                updatedViewFrag.show(getSupportFragmentManager(), updatedViewFrag.getTag());
            }
        });
    }


    @Override
    public void onResult(Object result) {

        Log.d("k9res", "onResult: " + result.toString());
        if (result.toString().equalsIgnoreCase("swiped_down")) {
            //do something or nothing
        } else {
            //handle result
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (updatedViewFrag.isAdded()) {
            updatedViewFrag.dismiss();
            updatedViewFrag.show(getSupportFragmentManager(), updatedViewFrag.getTag());
        }

    }

    
    
}
