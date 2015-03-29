package com.crpapp.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.crpapp.R;
import com.crpapp.SearchResultActivity;
import com.crpapp.bean.Person;
import com.crpapp.fragment.SearchResultAllFragment.MyListAdapter;
import com.crpapp.fragment.SearchResultAllFragment.ViewHolder;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 标签组查询
 * @author leker
 *
 */
public class SearchResultContactedFragment extends BaseFragment {
	
	private View rootView;
	private ListView mListView;
	private Context mContext;
	private MyListAdapter adapter;
	private List<Person> persons = new ArrayList<Person>();  
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.search_result_contacted_layout, null);
		return rootView;//super.onCreateView(inflater, container, savedInstanceState);
	}
	
  @Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		mContext = getActivity();
		initPersonData();
		mListView = (ListView) getView().findViewById(R.id.lv_contacted_person);
		adapter = new MyListAdapter(persons);  
		mListView.setAdapter(adapter);  
	  
	}

	/**  
     * 模拟数据  
     */  
    private void initPersonData(){  
        Person mPerson;  
        for(int i=1;i<=12;i++){  
            mPerson = new Person();  
            mPerson.setName("Jay"+i);  
            persons.add(mPerson);  
        }  
    }  
	
 
	  //自定义ListView适配器  
    class MyListAdapter extends BaseAdapter{  
        List<Boolean> mChecked;  
        List<Person> listPerson;  
        HashMap<Integer,View> map = new HashMap<Integer,View>();   
        Boolean mIsCheckAll = false;
          
        public MyListAdapter(List<Person> list){  
            listPerson = new ArrayList<Person>();  
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
              
            if(position % 2 ==1){
            	view.setBackgroundColor(Color.alpha(0xE0FFFF));
            }else{
            	view.setBackgroundColor(0xE0FFFF);
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
      
}
