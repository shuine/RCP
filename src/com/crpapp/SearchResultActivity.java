package com.crpapp;
import com.crpapp.fragment.SearchRecordFragment;
import com.crpapp.fragment.SearchResultFragment;
import com.crpapp.fragment.SendMessageFragment;
import com.crpapp.fragment.SettingFragment;
import com.crpapp.fragment.TagsManagerFragment;
import com.crpapp.fragment.impl.I_FragListener;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * 项目的主Activity，所有的Fragment都嵌入在这里。
 * 
 * @author leker
 */
public class SearchResultActivity extends FragmentActivity implements I_FragListener {

	/**
	 * 用于展示联系人的Fragment
	 */
	private SearchResultFragment searchFragment;


	
	//private TextView settingText;

	/**
	 * 用于对Fragment进行管理
	 */
	private FragmentManager fragmentManager;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.search_result_main);
		// 初始化布局元素
		//initViews();
		fragmentManager = getSupportFragmentManager();//FragmentManager();
		// 第一次启动时选中第0个tab
		setTabSelection(0);
	}
	

    private Handler mHandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub

			if(msg.what == 1){
				setTabSelection(4);
			}
			
		}
		
	};
	
	public Handler getHandler(){
		return mHandler;
	}

	/**
	 * 根据传入的index参数来设置选中的tab页。
	 * 
	 * @param index
	 *  每个tab页对应的下标。0表示查询，1表示查询记录，2标签管理
	 *  4. 查询结果
	 */
	private void setTabSelection(int index) {
		// 每次选中之前先清楚掉上次的选中状态
		// 开启一个Fragment事务
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		// 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
		hideFragments(transaction);
		switch (index) {
		case 0:
			// 当点击了联系人tab时，改变控件的图片和文字颜色
			if (searchFragment == null) {
				// 如果ContactsFragment为空，则创建一个并添加到界面上
				searchFragment = new SearchResultFragment(this);
				transaction.add(R.id.content, searchFragment);
			} else {
				// 如果ContactsFragment不为空，则直接将它显示出来
				transaction.show(searchFragment);
			}
			break;
		}
		transaction.commit();
	}

	/**
	 * 将所有的Fragment都置为隐藏状态。
	 * 
	 * @param transaction
	 *            用于对Fragment执行操作的事务
	 */
	private void hideFragments(FragmentTransaction transaction) {
		if (searchFragment != null) {
			transaction.hide(searchFragment);
		}
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		setTabSelection(4);
	}
	
}
