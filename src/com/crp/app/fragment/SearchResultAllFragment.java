package com.crp.app.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.crp.app.R;
import com.crp.app.SearchResultActivity;
import com.crp.app.UserInfoActivity;
import com.crp.app.bean.PersonModel;
import com.crp.app.fragment.impl.I_FragListener;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 标签组查询
 * @author leker
 *
 */
public class SearchResultAllFragment extends BaseFragment implements OnItemClickListener{
	
	private View rootView;
	ListView lv;  
    List<PersonModel> persons = new ArrayList<PersonModel>();  
    Context mContext;  
    MyListAdapter adapter;  
    List<Integer> listItemID = new ArrayList<Integer>();  
    private CheckBox mCheckBoxAll;
    private Button mBtnSend;
    private Handler handler;
    
    private String TAG = "SearchResultAllFragment";
    I_FragListener listener;
    
    public SearchResultAllFragment(I_FragListener fragListener) {
		// TODO Auto-generated constructor stub
    	listener = fragListener;
	}
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setActionBarTitle("查询结果");
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.search_result_all_layout, null);
		return rootView;//super.onCreateView(inflater, container, savedInstanceState);
	}
	
	
	  @Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		mContext = getActivity();
		handler = ((SearchResultActivity)mContext).getHandler();
		initPersonData();
		lv = (ListView) getView().findViewById(R.id.lv_person);
		adapter = new MyListAdapter(persons);  
	    lv.setAdapter(adapter);  
	    lv.setOnItemClickListener(this);
	    mCheckBoxAll = (CheckBox) getView().findViewById(R.id.checkbox_select_all);
	    mBtnSend = (Button) getView().findViewById(R.id.btn_send_message);
	    mCheckBoxAll.setOnClickListener(clickListener);
	    mBtnSend.setOnClickListener(clickListener);
	}

	/**  
     * 模拟数据  
     */  
    private void initPersonData(){  
        PersonModel mPerson;  
        for(int i=1;i<=12;i++){  
            mPerson = new PersonModel();  
            mPerson.setName("All"+i);  
            persons.add(mPerson);  
        }  
    }  
	
    private OnClickListener clickListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.checkbox_select_all:
				Log.d(TAG, "click listener checkbox"+mCheckBoxAll.isChecked());
				if(mCheckBoxAll.isChecked()){
					for(int i = 0; i < adapter.mChecked.size();i++){
						adapter.mChecked.set(i, true);
					}
					adapter.notifyDataSetChanged();
				}else{
					adapter.mIsCheckAll = false;
					for(int i = 0; i < adapter.mChecked.size();i++){
						adapter.mChecked.set(i, false);
					}
					adapter.notifyDataSetChanged();
				}
				break;
			case R.id.btn_send_message:
				int num = 0;
				for(int i = 0; i < adapter.mChecked.size();i++){
				  num+=adapter.mChecked.get(i)?1:0;
				}
				if(num < 1){
					Toast.makeText(mContext, "请选择客户", 1000).show();
					return;
				}
				/*if(num == 1){
					if(handler != null){
						handler.sendEmptyMessage(1);
					}
				}else{
					if(handler != null){
						handler.sendEmptyMessage(2);
					}
				}*/
				listener.jump();
				
				break;
			}
		}
    	
    };
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
                Log.e(TAG,"position1 = "+position);  
                  
                LayoutInflater mInflater = LayoutInflater.from(mContext);
                view = mInflater.inflate(R.layout.listview_contact_item_checkbox, null);  
                holder = new ViewHolder();  
                holder.selected = (CheckBox)view.findViewById(R.id.cb_contact_select);  
                holder.name = (TextView)view.findViewById(R.id.tv_contact_name);  
                holder.simPercent = (TextView)view.findViewById(R.id.tv_contact_simpercent);  
                final int p = position;  
                map.put(position, view);  
                holder.selected.setOnClickListener(new View.OnClickListener() {  
                      
                    @Override  
                    public void onClick(View v) {  
                        CheckBox cb = (CheckBox)v;  
                        mChecked.set(p, cb.isChecked());  
                    }  
                });  
                view.setTag(holder);  
            }else{  
                Log.e(TAG,"position2 = "+position);  
                view = map.get(position);  
                holder = (ViewHolder)view.getTag();  
            }  
              
            if(position % 2 ==1){
            	view.setBackgroundColor(getResources().getColor(R.color.list_item_bg1));
            }else{
            	view.setBackgroundColor(getResources().getColor(R.color.list_item_bg2));
            }
            holder.selected.setChecked(mChecked.get(position));  
            holder.name.setText(listPerson.get(position).getName());  
            holder.simPercent.setText("80%");  
              
            return view;  
        }  
          
    }  
    
    static class ViewHolder{
    	CheckBox selected;
    	TextView name;
    	TextView simPercent;
    }

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), "position is:"+position, 1).show();
		Intent intent = new Intent();
		intent.setClass(getActivity(), UserInfoActivity.class);
		startActivity(intent);
	}
      
}
