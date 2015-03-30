package com.crp.app.fragment;

import com.crp.app.R;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class BaseFragment extends Fragment {
	
	private TextView titleTxt;
	private ImageButton backBtn;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initActionBar();
	}
	
	public void initActionBar(){
		ActionBar mActionBar = getActivity().getActionBar();
		mActionBar.setDisplayShowHomeEnabled(false);
		mActionBar.setDisplayShowTitleEnabled(false);
		
		LayoutInflater mInflater = LayoutInflater.from(getActivity());
		View costomView = mInflater.inflate(R.layout.action_customer_bar, null);
		titleTxt = (TextView)costomView.findViewById(R.id.action_bar_title_txt);
		backBtn = (ImageButton)costomView.findViewById(R.id.action_bar_back_imgbtn);
		mActionBar.setCustomView(costomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		mActionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_color));
		
		backBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getActivity().onBackPressed();
			}
		});
	}
	
	protected void setActionBarTitle(String str) {
		if(titleTxt!= null){
			titleTxt.setText(str);
		}
	}
	
//	protected void set() {
//		
//	}
}
