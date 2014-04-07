package com.vapbro.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;

public class SaveSalesOrderJSONDataAction implements ServletRequestAware,ServletResponseAware {

	// private String string1 = "A";
	// private String[] stringarray1 = {"A1","B1"};
	// private int number1 = 123456789;
	// private int[] numberarray1 = {1,2,3,4,5,6,7,8,9};
	private String data = new String();
	// private Map<String, String> maps = new HashMap<String, String>();

	// no getter method, will not include in the JSON
	private boolean success = true;
	private int total = 1;

	private HttpServletRequest request;
	private HttpServletResponse response;

	public SaveSalesOrderJSONDataAction() {

	}

	public String execute() {
		try {
			System.out.println("in jsondataAction data1:"
					+ request.getParameterMap());
			System.out.println("in jsondataAction data2:"
					+ request.getParameterNames());
			System.out.println("in jsondataAction data3:"
					+ request.getParameter("data"));

			JSONObject jsonObject=null;
			String data = request.getParameter("data");
			if(data==null || data.trim()==""){
				return Action.SUCCESS;
			}
			
			//boolean success = true;
			
			if (JSONSerializer.toJSON(data) instanceof JSONArray) {
				JSONArray jsonData = (JSONArray) JSONSerializer.toJSON(data);
				jsonObject = jsonData.getJSONObject(0);
			}else if (JSONSerializer.toJSON(data) instanceof JSONObject) {
				 jsonObject = (JSONObject) JSONSerializer.toJSON(data);
			}
			System.out.println("jsonData:" + jsonObject);
			String name = jsonObject.getString("name");
			jsonObject.accumulate("success", true);
			System.out.println("name::" + name);
			
			//response.setContentType("application/json"); 
			//PrintWriter out = response.getWriter();
			//{"total":2,"data"
			
			//out.println("{\"total\":1,\"data\":"+data + ",\"success\":true}");
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Action.SUCCESS;
	}
	
	
	public String saveSalesOrder(){
		System.out.println("in savesalesOrderAction data3:"
				+ request.getParameter("data"));
		data=request.getParameter("data");
		
		response.setContentType("application/json"); 
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("{\"total\":1,\"data\":"+data + ",\"success\":true}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//{"total":2,"data"
		
		
	
		
		
		
		
		return Action.SUCCESS;
		
	}
	
	

	// public String getString1() {
	// return string1;
	// }
	//
	// public void setString1(String string1) {
	// this.string1 = string1;
	// }
	//
	// public String[] getStringarray1() {
	// return stringarray1;
	// }
	//
	// public void setStringarray1(String[] stringarray1) {
	// this.stringarray1 = stringarray1;
	// }
	//
	// public int getNumber1() {
	// return number1;
	// }
	//
	// public void setNumber1(int number1) {
	// this.number1 = number1;
	// }
	//
	// public int[] getNumberarray1() {
	// return numberarray1;
	// }
	//
	// public void setNumberarray1(int[] numberarray1) {
	// this.numberarray1 = numberarray1;
	// }

	public String getData() {
		return data;
	}

	public void setData(String lists) {
		this.data = lists;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean bool) {
		this.success= bool;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return this.request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}

	// public Map<String, String> getMaps() {
	// return maps;
	// }
	//
	// public void setMaps(Map<String, String> maps) {
	// this.maps = maps;
	// }

}