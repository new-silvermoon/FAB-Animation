package com.silvermoon.fabui;

import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.silvermoon.fabui.animation.AnimFrag;

public class UpdatedViewFrag extends AnimFrag {

    Button btn_close;

    public static UpdatedViewFrag newInstance() {
        UpdatedViewFrag f = new UpdatedViewFrag();
        return f;
    }


    @Override

    public void setupDialog(Dialog dialog, int style) {
        View contentView = View.inflate(getContext(), R.layout.set_alarm_view, null);

        RelativeLayout rl_content = (RelativeLayout) contentView.findViewById(R.id.rl_content);
        LinearLayout ll_buttons = (LinearLayout) contentView.findViewById(R.id.ll_buttons);
        contentView.findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeFilter("closed");
            }
        });

        //params to set
        setAnimationDuration(600); //optional; default 500ms
        setPeekHeight(300); // optional; default 400dp
        setCallbacks((Callbacks) getActivity()); //optional; to get back result
        setViewgroupStatic(ll_buttons); // optional; layout to stick at bottom on slide
//        setViewPager(vp_types); //optional; if you use viewpager that has scrollview
        setViewMain(rl_content); //necessary; main bottomsheet view
        setMainContentView(contentView); // necessary; call at end before super
        super.setupDialog(dialog, style); //call super at last
    }


}
