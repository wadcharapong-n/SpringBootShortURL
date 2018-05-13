<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>First Web Application</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="../css/listmgnt.css">
<link rel="stylesheet"  href="../css/menu.css" >
</head>

<body>
	<jsp:include page="menu.jsp"/>
	<div class="table-title">
		<h3></h3>
	</div>
	<table class="table-fill">
		<thead>
			<tr>
				<th class="text-left">Link</th>
				<th class="text-left">count</th>
			</tr>
		</thead>
		<tbody class="table-hover">
			<c:forEach var="item" items="${urls }">
				<tr>
					<td class="text-left"><c:out value="${item.orginalUrl }"></c:out></td>
					<td class="text-left"><c:out value="${item.clickCount }"></c:out></td>
				</tr>
				
			</c:forEach>
		</tbody>
	</table>

<%-- 	<c:forEach var="item" items="55"> --%>
<!-- 		<p> -->
<%-- 			<c:out value="${item }"></c:out> --%>
<!-- 		</p> -->
<%-- 	</c:forEach> --%>
</body>

</html>