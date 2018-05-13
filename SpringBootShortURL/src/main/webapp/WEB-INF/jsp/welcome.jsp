<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>First Web Application</title>
<link rel="stylesheet" href="../css/login.css">
<link rel="stylesheet" href="../css/menu.css">
<script type="text/javascript">
function copyfunction(){
	var copyText = document.getElementById("shortLink");
	var text = copyText.value;
	copyText.select();
	document.execCommand("Copy");
	
	document.getElementById("shortLink").value = text;
}
</script>
</head>

<body>
	<jsp:include page="menu.jsp" />
	<center><font color="red">${errorMessage}</font></center>
	<form method="post" class="login-form" action="/web/shortLink">
		<div class="login-page" style="max-width: 1080px">
			<div class="form" style="max-width: 1080px">
				<input type="text" placeholder="url" name="url" value="${url}"/>

				<button>get Short link</button>

			</div>
		</div>		
	</form>
	<div class="login-page" style="max-width: 1080px">
			<div class="form" style="max-width: 1080px">
				<input id="shortLink" type="text" value="${shortLink}" name="shortLink"
					readonly="readonly" />

				<button onclick="copyfunction();">copy link</button>

			</div>
		</div>
</body>

</html>