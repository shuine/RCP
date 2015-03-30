package com.crp.app.fragment;

import com.crp.app.R;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TabWidget;
import android.widget.TextView;

public class TagsManagerFragment extends BaseFragment {
	
	private View mRootView;
	private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private TabWidget mTabWidget;
    private String[] addresses = { "1", "2", "3" };
    private TextView[] mTextTabs = new TextView[addresses.length];
    private Context mContext;
    private int currentIndicatorLeft = 0;
    private ImageView iv_nav_indicator;
    private int indicatorWidth=0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mContext = getActivity();
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mRootView = inflater.inflate(R.layout.tabwidget_viewpager_layout, container, false);
		mContext = getActivity();
		return mRootView;
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initViews();
	}
	
	private void initViews(){
		iv_nav_indicator = (ImageView)mRootView.findViewById(R.id.tab_pager_nav_indicator);
    	DisplayMetrics dm = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
		indicatorWidth = dm.widthPixels /3;
		
		LayoutParams cursor_Params = iv_nav_indicator.getLayoutParams();
		//Toast.makeText(getActivity(), "indicatorWidth is:"+indicatorWidth, 1).show();
		cursor_Params.width = indicatorWidth;
		iv_nav_indicator.setLayoutParams(cursor_Params);
		addresses = getResources().getStringArray(R.array.tags_info_tab_menu);
		Log.i("viewpager", "addresses.length is:"+addresses.length);
    	mTabWidget = (TabWidget) mRootView.findViewById(R.id.tabWidget1);
        mTabWidget.setStripEnabled(false);
        mTextTabs[0] = new TextView(mContext);
        mTextTabs[0].setFocusable(true);
        mTextTabs[0].setText(addresses[0]);
        mTextTabs[0].setTextSize(20);
        mTextTabs[0].setGravity(Gravity.CENTER);
        mTextTabs[0].setTextColor(getResources().getColorStateList(R.drawable.search_rb_blue_bg));
        mTabWidget.addView(mTextTabs[0]);
        /* 
         * Listener必须在mTabWidget.addView()之后再加入，用于覆盖默认的Listener，
         * mTabWidget.addView()中默认的Listener没有NullPointer检测。
         */
        mTextTabs[0].setOnClickListener(mTabClickListener);
        mTextTabs[1] = new TextView(mContext);
        mTextTabs[1].setFocusable(true);
        mTextTabs[1].setText(addresses[1]);
        mTextTabs[1].setTextSize(20);
        mTextTabs[1].setGravity(Gravity.CENTER);
        mTextTabs[1].setTextColor(getResources().getColorStateList(R.drawable.search_rb_blue_bg));
        mTabWidget.addView(mTextTabs[1]);
        mTextTabs[1].setOnClickListener(mTabClickListener);
        mTextTabs[2] = new TextView(mContext);
        mTextTabs[2].setFocusable(true);
        mTextTabs[2].setText(addresses[2]);
        mTextTabs[2].setTextSize(20);
        mTextTabs[2].setGravity(Gravity.CENTER);
        mTextTabs[2].setTextColor(getResources().getColorStateList(R.drawable.search_rb_blue_bg));
        mTabWidget.addView(mTextTabs[2]);
        mTextTabs[2].setOnClickListener(mTabClickListener);

        mViewPager = (ViewPager) mRootView.findViewById(R.id.viewPager1);
        mPagerAdapter = new MyPagerAdapter(getActivity().getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOnPageChangeListener(mPageChangeListener);
        //mViewPager.setOffscreenPageLimit(2);

        mTabWidget.setCurrentTab(0);
	}
	
	private void startAniation(View v){
		TranslateAnimation animation = new TranslateAnimation(
				currentIndicatorLeft, v.getLeft(), 0f, 0f);
		animation.setInterpolator(new LinearInterpolator());
		animation.setDuration(100);
		animation.setFillAfter(true);
		iv_nav_indicator.setAnimation(animation);
		iv_nav_indicator.startAnimation(animation);
		currentIndicatorLeft = v.getLeft();
		/*animation.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				Log.i(TAG, "enter onAnimationStart");
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				Log.i(TAG, "enter onAnimationEnd");
			}
		});*/
    }
    
    private OnClickListener mTabClickListener = new OnClickListener() {
        @Override
        public void onClick(View v)
        {
            if (v == mTextTabs[0])
            {
                mViewPager.setCurrentItem(0);
            } else if (v == mTextTabs[1])
            {
                mViewPager.setCurrentItem(1);
            } else if (v == mTextTabs[2])
            {
                mViewPager.setCurrentItem(2);
            }
            v.setSelected(true);
            startAniation(v);
        }
    };

    private OnPageChangeListener mPageChangeListener = new OnPageChangeListener() {

        @Override
        public void onPageSelected(int arg0)
        {
        	//mode = arg0;
        	//mChangeActionModeListener.changeActionMode(arg0);
            mTabWidget.setCurrentTab(arg0);
        	//isUser = false;
        	//mTabWidget.getChildAt(arg0).performClick();
        	View v = mTabWidget.getChildAt(arg0);
        	startAniation(v);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2)
        {

        }

        @Override
        public void onPageScrollStateChanged(int arg0)
        {
        	
        }
    };
    BaseFragment ft = null;
    private class MyPagerAdapter extends FragmentStatePagerAdapter
    {
        public MyPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }
        @Override
        public Fragment getItem(int position)
        {
        	//Fragment ft = null;
			switch (position) {
			case 0:
				ft = new ChildTagNormalFragment();
				Bundle args = new Bundle();
				//args.putString(Constant.ARGUMENTS_NAME, mTextTabs[position].getText().toString());
				ft.setArguments(args);
				break;
			case 1:
				ft = new ChildTagDiyFragment();
				break;
			case 2:
				ft = new ChildTagSystemFragment();
				break;
			default:
				break;
			}
			return ft;
        }
        @Override
        public int getCount()
        {
            return addresses.length;
        }
    }
	
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
}
