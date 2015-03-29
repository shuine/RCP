package com.crpapp.utils;

import android.content.Context;
import android.content.Intent;

public class TransferUtils {
	
	public TransferUtils() {
		// TODO Auto-generated constructor stub
	}
	
	private  static  TransferUtils transferUtils;
	
	public static TransferUtils getInstance(){
		if(transferUtils==null)
			transferUtils = new TransferUtils();
		return transferUtils;
	}
	
	public void transferActivity(Context context,Class cls){
		Intent intent = new Intent();
		intent.setClass(context, cls);
		context.startActivity(intent);
	}
}
