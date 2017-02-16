package com.huwenmin.viewpager;

import android.app.Activity;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengxiaozheng on 15/6/16.
 *
 * 首页Banner样式
 */
public class BannerVRView extends LinearLayout{
    Activity mContext;

    static final int    TIME                = 5000;//5秒钟

    Runnable mViewpagerRunnable;
    Handler mHandler;

    List<ImageView> mImageViews;
    List<AssetItem> mAssetItems;

    BannerAdapter       mAdapter;

    ViewPager mViewPager;
    RelativeLayout mGroupLayout;
    TextView mAssert_title;
    TextView mAssert_desc;

    TextView mAssert_page;
    TextView mAssert_total_page;



    public BannerVRView(Activity context) {
        super(context);


        initView(context);

        initData();

        initListener();

        initRunnable();
    }

    private void initData(){
        mImageViews     = new ArrayList<ImageView>();
        mAssetItems     = new ArrayList<AssetItem>();

        AssetItem item = new AssetItem();
        item.pic = R.mipmap.pic;
        item.title = "《寒战2》首映礼";
        item.desc = "发哥与群星首映礼玩自拍";
        mAssetItems.add(item);

        AssetItem item1 = new AssetItem();
        item1.pic = R.mipmap.pic1;
        item1.title = "《寒战2》首映礼1";
        item1.desc = "发哥与群星首映礼玩自拍";
        mAssetItems.add(item1);

        AssetItem item2 = new AssetItem();
        item2.pic = R.mipmap.pic2;
        item2.title = "《寒战2》首映礼2";
        item2.desc = "发哥与群星首映礼玩自拍";
        mAssetItems.add(item2);

        AssetItem item3 = new AssetItem();
        item3.pic = R.mipmap.pic3;
        item3.title = "《寒战2》首映礼3";
        item3.desc = "发哥与群星首映礼玩自拍";
        mAssetItems.add(item3);



        for (int i = 0;i< mAssetItems.size();i++){
            addImageView(mAssetItems.get(i),i);
        }

        mAssert_total_page.setText(mImageViews.size() + "");
        mAdapter = new BannerAdapter();
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem((mImageViews.size()) * 100);

        mHandler = new Handler();

        setTitleAndDesc(0);
    }



    private void initView(Activity context) {
        mContext        = context;

        View view       = LayoutInflater.from(mContext).inflate(R.layout.view_vr_banner_pager, this, true);

        mGroupLayout    = (RelativeLayout) view.findViewById(R.id.viewGroup);

        mViewPager      = (ViewPager)view.findViewById(R.id.viewPager);

        android.view.ViewGroup.LayoutParams lp = mViewPager.getLayoutParams();
        lp.height       = getResources().getDisplayMetrics().widthPixels * 20 / 36;
        mViewPager.setLayoutParams(lp);


        try {
            Field mScroller;
            mScroller   = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            FixedSpeedScroller scroller = new FixedSpeedScroller(mViewPager.getContext(), new LinearInterpolator());
            scroller.setmDuration(300);
            mScroller.set(mViewPager, scroller);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        mAssert_title   = (TextView) view.findViewById(R.id.assert_title);
        mAssert_desc    = (TextView) view.findViewById(R.id.assert_desc);


        mAssert_page    = (TextView) view.findViewById(R.id.assert_page);
        mAssert_total_page   = (TextView) view.findViewById(R.id.assert_total_page);


    }



    public class BannerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mImageViews.size();
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
            ((ViewPager)container).removeView((View) object);

        }


        @Override
        public Object instantiateItem(View container, int position) {
            ((ViewPager)container).addView(mImageViews.get(position));
            return mImageViews.get(position);
        }
    }

    /**
     * 添加事件监听
     */
    private void initListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            boolean isScrolled = false;

            @Override
            public void onPageScrollStateChanged(int status) {
                switch (status) {
                    case 1:// 手势滑动
                        isScrolled = false;
                        break;
                    case 2:// 界面切换
                        isScrolled = true;
                        break;
                    case 0:// 滑动结束
                        // 当前为最后一张，此时从右向左滑，则切换到第一张
                        if (mViewPager.getCurrentItem() == mViewPager.getAdapter()
                                .getCount() - 1 && !isScrolled) {
                            mViewPager.setCurrentItem(0);
                        }
                        // 当前为第一张，此时从左向右滑，则切换到最后一张
                        else if (mViewPager.getCurrentItem() == 0 && !isScrolled) {
                            mViewPager.setCurrentItem(mViewPager.getAdapter()
                                    .getCount() - 1);
                        }
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageSelected(int index) {
                int i = index % mImageViews.size();
                //设置显示点
                //设置标题
                setTitleAndDesc(i);
            }
        });
    }

    /**
     * 定时切换
     */
    private void initRunnable() {
        mViewpagerRunnable = new Runnable() {

            @Override
            public void run() {
                int nowIndex = mViewPager.getCurrentItem();
                int count = mViewPager.getAdapter().getCount();

                // 如果下一张的索引大于最后一张，则切换到第一张
                if (nowIndex + 1 >= count) {
                    mViewPager.setCurrentItem(0);
                } else {
                    mViewPager.setCurrentItem(nowIndex + 1);
                }
                if(mHandler != null)
                    mHandler.postDelayed(mViewpagerRunnable, TIME);
            }
        };
        mViewPager.postDelayed(mViewpagerRunnable, TIME);
    }

    /**
     * 设置标题及描述
     * @param index
     */
    private void setTitleAndDesc(int index){
        AssetItem item = mAssetItems.get(index);
        mAssert_title.setText(item.title);
        mAssert_desc.setText(item.desc);
        index=index+1;
        mAssert_page.setText(index+"");
    }

    public void resumeHandler(){
        if (mHandler != null) {
            mHandler.removeCallbacks(mViewpagerRunnable);
            mViewPager.postDelayed(mViewpagerRunnable, TIME);
        }
    }

    public void stopHandler(){
        if (mHandler != null) {
            mHandler.removeCallbacks(mViewpagerRunnable);
        }
    }

    /**
     * 清空定时器
     */
    public void removeHandler() {
        if (mHandler != null) {
            mHandler.removeCallbacks(mViewpagerRunnable);
            mHandler = null;
        }
    }

    private void addImageView(AssetItem item, int i){


        try {
            ImageView imageView = new ImageView(mContext);
            imageView.setImageResource(item.pic);
            mImageViews.add(i, imageView);
        }catch (NullPointerException nex){

        }catch (Exception ex){

        }
    }
}
