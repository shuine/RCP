package com.crpapp.fragment;

import com.crpapp.R;
import com.crpapp.SearchResultActivity;
import com.crpapp.utils.TransferUtils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 标签查询
 * @author leker
 *
 */
public class TagSeachFragment extends BaseFragment implements OnClickListener{
	
	private View rootView;
	private Button tag_search_add_btn;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.tag_search_frag_layout, null);
		tag_search_add_btn = (Button)rootView.findViewById(R.id.tag_search_add_btn);
		return rootView;
		//return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initListener();
	}
	
	private void initListener(){
		tag_search_add_btn.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==tag_search_add_btn){
			TransferUtils.getInstance().transferActivity(getActivity(), SearchResultActivity.class);
		}
	}
}
