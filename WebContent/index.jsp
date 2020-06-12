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
	if(list.size()==0||(list.get(list.size()-1).getId()!=999&&list.get(list.size()-1).getId()!=1000)){
%>
	<form id="actionform" action="/practice9/UserForm" method="get">
		投稿者名:<input type="text" id="name" name="name" value="ロボスレの住人"><br>
		メールアドレス:<input type="email" name="mail"><br>
		内容:<br>
		<textarea rows="6" cols="20" id="message" name="message"></textarea>

		<input type="submit" value="送信">
	</form>

	<%}

			for(int i = list.size()-1 ; i > -1 ; i--){
				BoardBean s = list.get(i);
				String name=util.XSS_Block.htmlEscape(s.getName());
				String message=util.XSS_Block.htmlEscape(s.getMessage());
			%>
	<p><%=s.getId()%>.<%=name %></p>
	<p style="color: gray">
		投稿日:<%=s.getCreateday() %>
		<%=s.getCreatetime()%>
		<%if(!s.getCreateday().equals(s.getUpdateday())||!s.getCreatetime().equals(s.getUpdatetime())){ %>
		編集日:<%=s.getUpdateday() %>
		<%=s.getUpdatetime() %>
		<%} %>
	</p>
	<pre style="font-size: 20px;"><%=message%></pre>
	<br>
	<%
				}
			%>
	<a href="/practice9/AdminForm">管理者画面へ</a>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script>
    $('#actionform').submit(function(){
        var name=document.getElementById("name").value;
        var message=document.getElementById("message").value;
        var mail=document.getElementById("mail").value;
       if(name===""||message===""||mail===""){
        	alert("空白のまま送信しないでください。");
            return false;
        }

    })

    </script>
</body>
</html>