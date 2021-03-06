package com.crp.app.fragment;

import com.crp.app.R;
import com.crp.app.fragment.impl.I_FragListener;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SendMessageFragment extends BaseFragment {

	private I_FragListener fragListener;
	private Button mImageView;
	private EditText mEditText;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View newsLayout = inflater.inflate(R.layout.send_message_layout, container,
				false);
		return newsLayout;
	}
	
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		mImageView = (Button) getView().findViewById(R.id.imageview_send_message);
		mEditText = (EditText) getView().findViewById(R.id.edittext_message);
		mImageView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String message = mEditText.getText().toString();
				if(message == null || message.length() <1){
					Toast.makeText(getActivity(), "请输入内容", 1000).show();
				}else{
					new AlertDialog.Builder(getActivity())   
					.setTitle("确认发送")  
					.setMessage("message")  
					.setPositiveButton("是", null)  
					.setNegativeButton("否", null)  
					.show(); 
					onDestroy();
				}
			}
			
		});
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}


	public SendMessageFragment(I_FragListener listener){
		this.fragListener = listener;
	}

}
