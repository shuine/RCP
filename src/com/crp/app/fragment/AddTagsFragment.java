package com.crp.app.fragment;

import java.util.List;

import com.crp.app.R;
import com.crp.app.bean.TAGModel;
import com.crp.app.fragment.impl.I_TAGImpl;
import com.crp.app.utils.DataTestUtils;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 添加标签的fragment
 * @author leker
 *
 */
public class AddTagsFragment extends BaseFragment implements OnItemClickListener{
	
	private View rootView;
	List<TAGModel> list;// = new ArrayList<TAGModel>();
	ListView add_tag_frag_list;
	private ListDataAdapter listDataAdapter;
	I_TAGImpl tagImpl;
	
	public AddTagsFragment(I_TAGImpl impl) {
		// TODO Auto-generated constructor stub
		tagImpl = impl;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.add_tags_frag_layout, container, false);
		add_tag_frag_list = (ListView)rootView.findViewById(R.id.add_tag_frag_list);
		return rootView;//super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initData();
	}
	
	private void initData(){
		listDataAdapter = new ListDataAdapter(getActivity());
		listDataAdapter.setDataList(DataTestUtils.getTags());
		add_tag_frag_list.setAdapter(listDataAdapter);
		add_tag_frag_list.setOnItemClickListener(this);
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
	
	class ListDataAdapter extends BaseAdapter{
		List<TAGModel> list;
		LayoutInflater inflater;
		
		public ListDataAdapter(Context context) {
			// TODO Auto-generated constructor stub
			inflater = LayoutInflater.from(context);
		}
		
		public void setDataList(List<TAGModel> mlist){
			list = mlist;
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			if(list!=null)
				return list.size();
			return 0;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			if(list!=null)
				return list.get(position);
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			TAGModel model = list.get(position);
			ViewHolder holder;
			if(convertView==null){
				holder = new ViewHolder();
				convertView = inflater.inflate(R.layout.add_tag_item, null);
				holder.imageView = (ImageView)convertView.findViewById(R.id.add_tag_item_img);
				holder.name = (TextView)convertView.findViewById(R.id.add_tag_item_name);
				convertView.setTag(holder);
			}else{
				holder = (ViewHolder)convertView.getTag();
			}
			holder.name.setText(model.getName());
			holder.imageView.setVisibility(model.isHasChild() == true ? View.VISIBLE : View.GONE);
			return convertView;
		}
		
	}
	
	class ViewHolder{
		TextView name;
		ImageView imageView;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		final TAGModel model = (TAGModel)parent.getItemAtPosition(position);
		tagImpl.goToDetail(model);
	}
}
