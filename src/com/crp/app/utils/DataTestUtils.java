package com.crp.app.utils;

import java.util.ArrayList;
import java.util.List;

import com.crp.app.bean.TAGModel;

/**
 * 数据测试类
 * @author shihx1
 *
 */
public class DataTestUtils {
	
	private static DataTestUtils dateTestUtils;
	DataTestUtils(){}
	
	public static DataTestUtils getInstance(){
		if(dateTestUtils==null)
			dateTestUtils = new DataTestUtils();
		return dateTestUtils;
	}
	
	
	public static List<TAGModel> getTags(){
		List<TAGModel> list = new ArrayList<TAGModel>();
		TAGModel model = new TAGModel();
		model.setName("垂直行业");
		model.setNum("");
		model.setHasChild(true);
		
		TAGModel model1 = new TAGModel();
		model1.setName("影音娱乐");
		model1.setHasChild(true);
		
		TAGModel model2 = new TAGModel();
		model2.setName("电子商务");
		model2.setHasChild(true);
		
		TAGModel model3 = new TAGModel();
		model3.setName("女性时尚");
		TAGModel model4 = new TAGModel();
		model4.setName("小说");
		TAGModel model5 = new TAGModel();
		model5.setName("地产");
		
		list.add(model);
		list.add(model1);
		list.add(model2);
		list.add(model3);
		list.add(model4);
		list.add(model5);
		
		return list;
	}
}
