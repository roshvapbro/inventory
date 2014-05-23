package com.vapbro.action.Finance;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class DetailAction extends ActionSupport {
private String lst;
private List lstList = null;
private List lstList2 = null;
Integer id;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String execute() throws Exception {
	
	System.out.println("Id"+getId());


if (getLst() != null && !getLst().equals("")) {
	
	System.out.println("Name"+getLst());
populateDetail(getLst());
return SUCCESS;
} else {
return SUCCESS;
}
}

private void populateDetail(String id) {
lstList = new ArrayList();
if (id.equalsIgnoreCase("Fruits")) {
lstList.add("Apple");
lstList.add("PineApple");
lstList.add("Mango");
lstList.add("Banana");
lstList.add("Grapes");
} else if (id.equalsIgnoreCase("Places")) {
lstList.add("New York");
lstList.add("Sydney");
lstList.add("California");
lstList.add("Switzerland");
lstList.add("Paris");
} else {
lstList.add("Other 1");
lstList.add("Other 2");
lstList.add("Other 3");
lstList.add("Other 4");
lstList.add("Other 5");
}
}

public List getLstList() {
return lstList;
}

public void setLstList(List lstList) {
this.lstList = lstList;
}

public String getLst() {
return lst;
}

public void setLst(String lst) {
this.lst= lst;
}
}
