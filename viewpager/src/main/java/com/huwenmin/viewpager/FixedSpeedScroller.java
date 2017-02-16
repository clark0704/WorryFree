package com.huwenmin.viewpager;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class FixedSpeedScroller extends Scroller {

    private int mDuration = 1500;

    public FixedSpeedScroller(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public FixedSpeedScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        // TODO Auto-generated method stub
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        // TODO Auto-generated method stub
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

    public void setmDuration(int time) {
        mDuration = time;
    }

    public int getmDuration() {
        return mDuration;
    }

}
