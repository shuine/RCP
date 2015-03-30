package com.crp.app.fragment;

import com.crp.app.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 用户备注界面
 * @author shihx1
 *
 */
public class UserRemarkFragment extends BaseFragment {
	
	View rootView;
	TextView emptyTxt;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.user_remark_frag_layout, container, false);
		emptyTxt = (TextView)rootView.findViewById(R.id.user_remark_empty_txt);
		emptyTxt.setVisibility(View.VISIBLE);
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
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
