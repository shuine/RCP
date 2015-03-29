package com.crpapp.fragment;

import com.crpapp.R;
import com.crpapp.SearchResultActivity;
import com.crpapp.fragment.impl.I_FragListener;
import com.crpapp.utils.TransferUtils;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * 关键字查询
 * @author leker
 *
 */
public class TagKeyFragment extends BaseFragment implements OnClickListener{
	private View rootView;
	private I_FragListener fragListener;
	private Button tag_key_search_btn;
	
	public TagKeyFragment(I_FragListener i_frag) {
		// TODO Auto-generated constructor stub
		fragListener = i_frag;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.tag_key_frag_layout, null);
		tag_key_search_btn = (Button)rootView.findViewById(R.id.tag_key_search_btn);
		
		tag_key_search_btn.setOnClickListener(this);
		return rootView;//super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==tag_key_search_btn){
			//fragListener.jump();
			TransferUtils.getInstance().transferActivity(getActivity(), SearchResultActivity.class);
		}
	}
}
