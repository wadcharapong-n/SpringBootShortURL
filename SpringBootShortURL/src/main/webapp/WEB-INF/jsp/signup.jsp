<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>First Web Application</title>
<link rel="stylesheet" href="../css/login.css">
<link rel="stylesheet"  href="../css/menu.css" >
</head>

<body>
	<jsp:include page="menu.jsp"/>
	<font color="red">${errorMessage}</font>
	<form method="post" class="login-form" action="/web/signup">
		<div class="login-page">
			<div class="form">
				<input type="text" placeholder="username" name="name" /> 
				<input type="password" placeholder="password" name="password" />
				<input type="password" placeholder="confirm password" name="cpassword" />
				<input type="text" placeholder="email" name="email" /> 
				<button>Sign Up</button>
				
			</div>
		</div>
	</form>
</body>

</html>