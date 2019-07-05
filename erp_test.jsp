<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.landray.kmss.component.dbop.ds.DataSet"%>    
 <%@page import="java.sql.ResultSet"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ERP测试</title>
</head>
<body>


<%
DataSet dsSet = null;
ResultSet rs0 = null;
String fd_date = "";
try{
dsSet = new DataSet("ERPZSQ");
rs0=dsSet.executeQuery("   select * from ima_file  where IMA01 = '1102-000821'");
while(rs0.next()){
	 fd_date = rs0.getString(1);
	
}
}catch(SQLException sqlException){
	System.out.println(sqlException);
}finally{
	if(rs0!=null){
		rs0.close();
	}
	if(dsSet!=null){
		dsSet.close();
	}
}




%>
<h1><%= fd_date %></h1>


</body>
</html>