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
import android.widget.TextView;

/**
 * 标签组查询
 * @author leker
 *
 */
public class TagGroupFragment extends BaseFragment implements OnClickListener{
	private View rootView;
	TextView tag_group_frag_txt1;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.tag_group_frag_layout, null);
		tag_group_frag_txt1 = (TextView)rootView.findViewById(R.id.tag_group_frag_txt1);
		return rootView;//super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}
	
	private void initListener(){
		
	}
	
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==tag_group_frag_txt1){
			TransferUtils.getInstance().transferActivity(getActivity(), SearchResultActivity.class);
		}
	}
}
