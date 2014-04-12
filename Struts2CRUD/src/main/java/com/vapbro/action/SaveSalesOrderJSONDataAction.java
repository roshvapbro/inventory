package com.vapbro.action;

import java.lang.reflect.Type;
import java.sql.Date;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.Action;
import com.vapbro.model.SalesOrder;
import com.vapbro.service.SalesOrderDaoService;
import com.vapbro.service.SalesOrderService;

public class SaveSalesOrderJSONDataAction {

	// private String string1 = "A";
	// private String[] stringarray1 = {"A1","B1"};
	// private int number1 = 123456789;
	// private int[] numberarray1 = {1,2,3,4,5,6,7,8,9};
	private String data = new String();
	// private Map<String, String> maps = new HashMap<String, String>();

	// no getter method, will not include in the JSON
	private boolean success = true;
	private int total = 1;
	private static SalesOrderService salesOrderService = new SalesOrderDaoService();

	public SaveSalesOrderJSONDataAction() {

	}

	public String execute() {
		try {

			HttpServletRequest request = ServletActionContext.getRequest();
			System.out.println("in jsondataAction data1:"
					+ request.getParameterMap());
			System.out.println("in jsondataAction data2:"
					+ request.getParameterNames());
			System.out.println("in jsondataAction data3:"
					+ request.getParameter("data"));

			JSONObject jsonObject = null;
			String data = request.getParameter("data");
			if (data == null || data.trim() == "") {
				return Action.SUCCESS;
			}

			// boolean success = true;

			if (JSONSerializer.toJSON(data) instanceof JSONArray) {
				JSONArray jsonData = (JSONArray) JSONSerializer.toJSON(data);
				jsonObject = jsonData.getJSONObject(0);
			} else if (JSONSerializer.toJSON(data) instanceof JSONObject) {
				jsonObject = (JSONObject) JSONSerializer.toJSON(data);
			}
			System.out.println("jsonData:" + jsonObject);
			String name = jsonObject.getString("name");
			jsonObject.accumulate("success", true);
			System.out.println("name::" + name);

			// response.setContentType("application/json");
			// PrintWriter out = response.getWriter();
			// {"total":2,"data"

			// out.println("{\"total\":1,\"data\":"+data +
			// ",\"success\":true}");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Action.SUCCESS;
	}

	public String saveSalesOrder() {
		HttpServletRequest request = ServletActionContext.getRequest();

		System.out.println("in savesalesOrderAction data3:"
				+ request.getParameter("data"));
		data = request.getParameter("data");
		if (data != null && data.indexOf("[") != 0) {
			data = "[" + data + "]";
		}

		Type t = new TypeToken<List<Map<String, String>>>() {
		}.getType();
		Gson gson = new Gson();
		List<Map<String, String>> dataList = gson.fromJson(data, t);
		total = dataList.size();
		System.out.println("dataList::" + dataList);
		saveSalesOrderIntoDB(dataList);
		return Action.SUCCESS;

	}

	public void saveSalesOrderIntoDB(List<Map<String, String>> dataList) {

		for (int i = 0; i < dataList.size(); i++) {
			Map<String, String> map = dataList.get(i);
			SalesOrder so = new SalesOrder();
			for (Map.Entry<String, String> entry : map.entrySet()) {
				System.out.println("Key : " + entry.getKey() + " Value : "
						+ entry.getValue());

				if (entry.getKey().equalsIgnoreCase("price")) {
					so.setPrice(Double.parseDouble(entry.getValue()));
				} else if (entry.getKey().equalsIgnoreCase("date")) {
					so.setDate(getDate(entry.getValue()));
				} else if (entry.getKey().equalsIgnoreCase("productId")) {
					so.setProductId(Integer.parseInt(entry.getValue()));
				} else if (entry.getKey().equalsIgnoreCase("name")) {
					// set product Name
				}

			}
			// set some default values for sales order
			so.setStatus("Y");

			salesOrderService.insertSalesOrder(so);
			System.out.println("SalesOrderService insertSalesOrder called");

		}
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
		this.success = bool;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	// public void setServletRequest(HttpServletRequest request) {
	// this.request = request;
	// }
	//
	// public HttpServletRequest getServletRequest() {
	// return this.request;
	// }

	// @Override
	// public void setServletResponse(HttpServletResponse response) {
	// this.response=response;
	//
	// }

	// public Map<String, String> getMaps() {
	// return maps;
	// }
	//
	// public void setMaps(Map<String, String> maps) {
	// this.maps = maps;
	// }

	public Date getDate(String dateStr) {
		try {

			// java.util.Date date = formatter.parse(dateStr);
			Calendar cal = javax.xml.bind.DatatypeConverter
					.parseDateTime(dateStr);
			System.out.println("date:" + cal.getTime());
			java.util.Date date = cal.getTime();

			return new Date(date.getTime());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new Date(new java.util.Date().getTime());
	}

}