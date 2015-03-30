package com.crp.app;

import com.crp.app.bean.TAGModel;
import com.crp.app.fragment.AddTagsDetailFragment;
import com.crp.app.fragment.AddTagsFragment;
import com.crp.app.fragment.impl.I_TAGImpl;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * 标签管理
 * @author leker
 *
 */
public class AddTagsActivity extends FragmentActivity implements I_TAGImpl{
	
	private FragmentManager fragmentManager;
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.fragment_main);
		
		fragmentManager = getSupportFragmentManager();
		FragmentTransaction ft = fragmentManager.beginTransaction();
		ft.replace(R.id.content, new AddTagsFragment(this));
		ft.commitAllowingStateLoss();
	}
	
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}



	@Override
	public void goToDetail(Object object) {
		// TODO Auto-generated method stub
		TAGModel model = (TAGModel)object;
		if(model.isHasChild()){
			addChildDetailFragment();
		}
	}
	
	private void addChildDetailFragment(){
		FragmentTransaction ft = fragmentManager.beginTransaction();
		ft.replace(R.id.content, new AddTagsDetailFragment());
		ft.addToBackStack(null);
		ft.commitAllowingStateLoss();
	}
}
