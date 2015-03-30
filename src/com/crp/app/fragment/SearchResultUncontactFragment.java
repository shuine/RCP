package com.crp.app.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.crp.app.R;
import com.crp.app.SearchResultActivity;
import com.crp.app.UserInfoActivity;
import com.crp.app.bean.PersonModel;
import com.crp.app.fragment.SearchResultContactedFragment.MyListAdapter;
import com.crp.app.fragment.SearchResultContactedFragment.ViewHolder;
import com.crp.app.utils.TransferUtils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 标签组查询
 * @author leker
 *
 */
public class SearchResultUncontactFragment extends BaseFragment implements OnItemClickListener{
	
	private View rootView;
	private ListView mListView;
	private Context mContext;
	private MyListAdapter adapter;
	private List<PersonModel> persons = new ArrayList<PersonModel>();  
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.search_result_uncontacted_layout, null);
		return rootView;//super.onCreateView(inflater, container, savedInstanceState);
	}
	
	 @Override
		public void onActivityCreated(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onActivityCreated(savedInstanceState);
			mContext = getActivity();
			initPersonData();
			mListView = (ListView) getView().findViewById(R.id.lv_uncontacted_person);
			adapter = new MyListAdapter(persons);  
			mListView.setAdapter(adapter);  
			mListView.setOnItemClickListener(this);
		}

		/**  
	     * 模拟数据  
	     */  
	    private void initPersonData(){  
	        PersonModel mPerson;  
	        for(int i=1;i<=6;i++){  
	            mPerson = new PersonModel();  
	            mPerson.setName("未联系"+i);  
	            persons.add(mPerson);  
	        }  
	    }  
		
	 
		  //自定义ListView适配器  
	    class MyListAdapter extends BaseAdapter{  
	        List<Boolean> mChecked;  
	        List<PersonModel> listPerson;  
	        HashMap<Integer,View> map = new HashMap<Integer,View>();   
	        Boolean mIsCheckAll = false;
	          
	        public MyListAdapter(List<PersonModel> list){  
	            listPerson = new ArrayList<PersonModel>();  
	            listPerson = list;  
	              
	            mChecked = new ArrayList<Boolean>();  
	            for(int i=0;i<list.size();i++){  
	                mChecked.add(false);  
	            }  
	        }  
	  
	        @Override  
	        public int getCount() {  
	            return listPerson.size();  
	        }  
	  
	        @Override  
	        public Object getItem(int position) {  
	            return listPerson.get(position);  
	        }  
	  
	        @Override  
	        public long getItemId(int position) {  
	            return position;  
	        }  
	  
	        @Override  
	        public View getView(int position, View convertView, ViewGroup parent) {  
	            View view;  
	            ViewHolder holder = null;  
	              
	            if (map.get(position) == null) {  
	                LayoutInflater mInflater = LayoutInflater.from(mContext);
	                view = mInflater.inflate(R.layout.listview_contact_item, null);  
	                holder = new ViewHolder();  
	                holder.name = (TextView)view.findViewById(R.id.tv_contact_name);  
	                holder.simPercent = (TextView)view.findViewById(R.id.tv_contact_simpercent);  
	                final int p = position;  
	                map.put(position, view);  
	               
	                view.setTag(holder);  
	            }else{  
	                view = map.get(position);  
	                holder = (ViewHolder)view.getTag();  
	            }  
	              
	            /*if(position % 2 ==1){
	            	view.setBackgroundColor(Color.alpha(0xE0FFFF));
	            }else{
	            	view.setBackgroundColor(0xE0FFFF);
	            }*/
	            if(position % 2 ==1){
	            	view.setBackgroundColor(getResources().getColor(R.color.list_item_bg1));
	            }else{
	            	view.setBackgroundColor(getResources().getColor(R.color.list_item_bg2));
	            }
	            holder.name.setText(listPerson.get(position).getName());  
	            holder.simPercent.setText("80%");  
	            return view;  
	        }  
	          
	    }  
	    
	    static class ViewHolder{
	    	TextView name;
	    	TextView simPercent;
	    }

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			Toast.makeText(mContext, "uncontact position is:"+position, 1).show();
			Intent intent = new Intent();
			intent.setClass(getActivity(), UserInfoActivity.class);
			startActivity(intent);
			//TransferUtils.getInstance().transferActivity(getActivity(), SearchResultActivity.class);
		}
	      
}
