<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.btnsend{
  margin:0 auto;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户</title>
</head>
<body>
<table cellspacing="0" border="1" class="table1">
<thead>
<tr>
<input type="checkbox" />
<th width="300">姓名</th>
<th width="300">身份证号</th>
<th width="300">邮件</th>
</tr>
</thead>
<tbody>
<c:forEach var="u" items="${requestScope.userlist}">
<tr>
<input type="checkbox" id=${u.apply_id}/>
<td align="center">${u.applicant}</td>
<td align="center">${u.a_keshi}</td>
<td align="center">${u.p_keshi}</td>
</tr>
</c:forEach>
</tbody>
</table>
<input type="button" class="btnsend" value="发送通知" />
</body>
<script type="text/javascript" src="./js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="./js/jquery-1.10.2.min.js"></script>
</html>