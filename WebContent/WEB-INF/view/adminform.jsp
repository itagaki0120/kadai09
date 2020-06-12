<%@page import="bean.BoardBean"%>
<%@page import="dao.BoardDao"%>
<%@page import="util.XSS_Block"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
				ArrayList<BoardBean> list = BoardDao.selectAll();
			for(int i = list.size()-1 ; i > -1 ; i--){
				BoardBean s = list.get(i);
				String name=s.getName();
				String message=s.getMessage();
			%>

	<form id="updateform" action="/practice9/UpdateAdmin" method="get">
		<input type="hidden" name="id" value="<%=s.getId()%>"> 投稿者名:<input
			type="text" id="name" name="name" value=<%=name %>><br> 内容:
		<textarea id="message" name="message"><%=message %></textarea><br>
		<input type="submit" value="更新">
	</form>
	<form action="/practice9/DeleteAdmin" method="get">
		<input type="hidden" name="id" value="<%=s.getId()%>"> <input
			type="submit" value="削除">
	</form>
	<br>
	<%
				}
			%>
	<a href="/practice9/UserForm">投稿画面へ</a>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script>
    $('#updateform').submit(function(){
        var name=document.getElementById("name").value;
        var message=document.getElementById("message").value;
       if(name===""||message===""){
        	alert("空白のまま更新しないでください。");
            return false;
        }

    })

    </script>
</body>
</html>