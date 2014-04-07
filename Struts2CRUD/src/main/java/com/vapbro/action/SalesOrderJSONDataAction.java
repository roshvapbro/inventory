package com.vapbro.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;

public class SalesOrderJSONDataAction{

	//private String string1 = "A";
	//private String[] stringarray1 = {"A1","B1"};
	//private int number1 = 123456789;
	//private int[] numberarray1 = {1,2,3,4,5,6,7,8,9};
	private List<Map<String,String>> data = new ArrayList<Map<String,String>>();
	//private Map<String, String> maps = new HashMap<String, String>();
	
	//no getter method, will not include in the JSON
	private String string2 = "B";
	private int total=2;
	
	public SalesOrderJSONDataAction(){
		Map<String,String> temp = new HashMap<String,String>();
		temp.put("birthday", "01/01/2000");
		temp.put("email", "murugan@gmail.com");
		temp.put("id", "idval");
		temp.put("name", "kumar");
		temp.put("phone", "(000) 000-0000");
		data.add(temp);
		
		Map<String,String> temp2 = new HashMap<String,String>();
		temp2.put("birthday", "01/01/2001");
		temp2.put("email", "murugan2@gmail.com");
		temp2.put("id", "idval3");
		temp2.put("name", "kumar4");
		temp2.put("phone", "(000) 000-0005");
		data.add(temp2);
	}

	public String execute() {
        return Action.SUCCESS;
    }
	
//	public String getString1() {
//		return string1;
//	}
//
//	public void setString1(String string1) {
//		this.string1 = string1;
//	}
//
//	public String[] getStringarray1() {
//		return stringarray1;
//	}
//
//	public void setStringarray1(String[] stringarray1) {
//		this.stringarray1 = stringarray1;
//	}
//
//	public int getNumber1() {
//		return number1;
//	}
//
//	public void setNumber1(int number1) {
//		this.number1 = number1;
//	}
//
//	public int[] getNumberarray1() {
//		return numberarray1;
//	}
//
//	public void setNumberarray1(int[] numberarray1) {
//		this.numberarray1 = numberarray1;
//	}

	public List<Map<String,String>> getData() {
		return data;
	}

	public void setData(List<Map<String,String>> lists) {
		this.data = lists;
	}
	
	public String getString2() {
		return string2;
	}

	public void setString2(String string2) {
		this.string2 = string2;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}


//	public Map<String, String> getMaps() {
//		return maps;
//	}
//
//	public void setMaps(Map<String, String> maps) {
//		this.maps = maps;
//	}
	
}