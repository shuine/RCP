package com.crp.app;
import com.crp.app.fragment.SearchFragment;
import com.crp.app.fragment.SearchRecordFragment;
import com.crp.app.fragment.SearchResultFragment;
import com.crp.app.fragment.SettingFragment;
import com.crp.app.fragment.TagsManagerFragment;
import com.crp.app.fragment.impl.I_FragListener;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Color;

/**
 * 项目的主Activity，所有的Fragment都嵌入在这里。
 * 
 * @author leker
 */
public class MainActivity extends FragmentActivity implements OnClickListener,I_FragListener {

	/**
	 * 用于展示消息的Fragment
	 */
	private TagsManagerFragment messageFragment;

	/**
	 * 用于展示联系人的Fragment
	 */
	private SearchFragment searchFragment;

	/**
	 * 用于展示动态的Fragment
	 */
	private SearchRecordFragment newsFragment;

	/**
	 * 用于展示的Fragment
	 */
	private SettingFragment settingFragment;

	/**
	 * 用来展示搜索的结果
	 */
	private SearchResultFragment searchResultFragment;
	
	/**
	 * 消息界面布局
	 */
	private View messageLayout;

	/**
	 * 联系人界面布局
	 */
	private View contactsLayout;

	/**
	 * 动态界面布局
	 */
	private View newsLayout;

	/**
	 * 设置界面布局
	 */
	//private View settingLayout;

	/**
	 * 在Tab布局上显示消息图标的控件
	 */
	private ImageView messageImage;

	/**
	 * 在Tab布局上显示联系人图标的控件
	 */
	private ImageView contactsImage;

	/**
	 * 在Tab布局上显示动态图标的控件
	 */
	private ImageView newsImage;

	/**
	 * 在Tab布局上显示设置图标的控件
	 */
	//private ImageView settingImage;

	/**
	 * 在Tab布局上显示查询的控件
	 */
	private TextView searchText;

	/**
	 * 在Tab布局上显示查询记录标题的控件
	 */
	private TextView searchRecordText;

	/**
	 * 在Tab布局上显示标签管理的控件
	 */
	private TextView tagmanagerText;

	/**
	 * 在Tab布局上显示设置标题的控件
	 */
	//private TextView settingText;

	/**
	 * 用于对Fragment进行管理
	 */
	private FragmentManager fragmentManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		// 初始化布局元素
		initViews();
		fragmentManager = getSupportFragmentManager();//FragmentManager();
		// 第一次启动时选中第0个tab
		setTabSelection(0);
	}
	
	/**
	 * 在这里获取到每个需要用到的控件的实例，并给它们设置好必要的点击事件。
	 */
	private void initViews() {
		messageLayout = findViewById(R.id.message_layout);
		contactsLayout = findViewById(R.id.contacts_layout);
		newsLayout = findViewById(R.id.news_layout);
		//settingLayout = findViewById(R.id.setting_layout);
		messageImage = (ImageView) findViewById(R.id.message_image);
		contactsImage = (ImageView) findViewById(R.id.contacts_image);
		newsImage = (ImageView) findViewById(R.id.news_image);
		//settingImage = (ImageView) findViewById(R.id.setting_image);
		searchText = (TextView) findViewById(R.id.message_text);
		searchRecordText = (TextView) findViewById(R.id.contacts_text);
		tagmanagerText = (TextView) findViewById(R.id.news_text);
		//settingText = (TextView) findViewById(R.id.setting_text);
		messageLayout.setOnClickListener(this);
		contactsLayout.setOnClickListener(this);
		newsLayout.setOnClickListener(this);
		//settingLayout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.message_layout:
			// 当点击了消息tab时，选中第1个tab
			setTabSelection(0);
			break;
		case R.id.contacts_layout:
			// 当点击了联系人tab时，选中第2个tab
			setTabSelection(1);
			break;
		case R.id.news_layout:
			// 当点击了动态tab时，选中第3个tab
			setTabSelection(2);
			break;
		case R.id.setting_layout:
			// 当点击了设置tab时，选中第4个tab
			setTabSelection(3);
			break;
		default:
			break;
		}
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
		clearSelection();
		// 开启一个Fragment事务
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		// 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
		hideFragments(transaction);
		switch (index) {
		case 0:
			// 当点击了联系人tab时，改变控件的图片和文字颜色
			contactsImage.setImageResource(R.drawable.contacts_selected);
			searchText.setTextColor(Color.WHITE);
			if (searchFragment == null) {
				// 如果ContactsFragment为空，则创建一个并添加到界面上
				searchFragment = new SearchFragment(this);
				transaction.add(R.id.content, searchFragment);
			} else {
				// 如果ContactsFragment不为空，则直接将它显示出来
				transaction.show(searchFragment);
			}
			break;
		case 1:
			// 当点击了消息tab时，改变控件的图片和文字颜色
			messageImage.setImageResource(R.drawable.message_selected);
			searchRecordText.setTextColor(Color.WHITE);
			if (newsFragment == null) {
				// 如果NewsFragment为空，则创建一个并添加到界面上
				newsFragment = new SearchRecordFragment();
				transaction.add(R.id.content, newsFragment);
			} else {
				// 如果NewsFragment不为空，则直接将它显示出来
				transaction.show(newsFragment);
			}
			break;
		case 2:
			// 当点击了动态tab时，改变控件的图片和文字颜色
			newsImage.setImageResource(R.drawable.news_selected);
			tagmanagerText.setTextColor(Color.WHITE);
			if (messageFragment == null) {
				// 如果MessageFragment为空，则创建一个并添加到界面上
				messageFragment = new TagsManagerFragment();
				transaction.add(R.id.content, messageFragment);
			} else {
				// 如果MessageFragment不为空，则直接将它显示出来
				transaction.show(messageFragment);
			}
			break;
		/*case 3:
		default:
			// 当点击了设置tab时，改变控件的图片和文字颜色
			//settingImage.setImageResource(R.drawable.setting_selected);
			//settingText.setTextColor(Color.WHITE);
			if (settingFragment == null) {
				// 如果SettingFragment为空，则创建一个并添加到界面上
				settingFragment = new SettingFragment();
				transaction.add(R.id.content, settingFragment);
			} else {
				// 如果SettingFragment不为空，则直接将它显示出来
				transaction.show(settingFragment);
			}
			break;*/
			case 4:
				/*if(searchResultFragment==null){
					searchResultFragment = new SearchResultFragment();
					transaction.add(R.id.content, searchResultFragment);
					transaction.addToBackStack(null);
				}else{
					transaction.show(searchResultFragment);
				}*/
			break;
		}
		transaction.commit();
	}

	/**
	 * 清除掉所有的选中状态。
	 */
	private void clearSelection() {
		messageImage.setImageResource(R.drawable.message_unselected);
		searchText.setTextColor(Color.parseColor("#82858b"));
		contactsImage.setImageResource(R.drawable.contacts_unselected);
		searchRecordText.setTextColor(Color.parseColor("#82858b"));
		newsImage.setImageResource(R.drawable.news_unselected);
		tagmanagerText.setTextColor(Color.parseColor("#82858b"));
		//settingImage.setImageResource(R.drawable.setting_unselected);
		//settingText.setTextColor(Color.parseColor("#82858b"));
	}

	/**
	 * 将所有的Fragment都置为隐藏状态。
	 * 
	 * @param transaction
	 *            用于对Fragment执行操作的事务
	 */
	private void hideFragments(FragmentTransaction transaction) {
		if (messageFragment != null) {
			transaction.hide(messageFragment);
		}
		if (searchFragment != null) {
			transaction.hide(searchFragment);
		}
		if (newsFragment != null) {
			transaction.hide(newsFragment);
		}
		if (settingFragment != null) {
			transaction.hide(settingFragment);
		}
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		setTabSelection(4);
	}
}
