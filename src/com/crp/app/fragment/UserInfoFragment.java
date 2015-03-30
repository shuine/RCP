package com.crp.app.fragment;

import com.crp.app.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 用户信息界面
 * @author shihx1
 *
 */
public class UserInfoFragment extends BaseFragment implements OnClickListener{
	
	View rootView;
	private Button user_send_msg_btn,user_call_phone_btn;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.user_info_frag_layout, container, false);
		initViewAndListener();
		return rootView;//super.onCreateView(inflater, container, savedInstanceState);
	}
	
	private void initViewAndListener(){
		user_send_msg_btn = (Button)rootView.findViewById(R.id.user_send_msg_btn);
		user_send_msg_btn.setOnClickListener(this);
		user_call_phone_btn = (Button)rootView.findViewById(R.id.user_call_phone_btn);
		user_call_phone_btn.setOnClickListener(this);
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.user_send_msg_btn:
			break;
		case R.id.user_call_phone_btn:
			break;
		}
	}
}
