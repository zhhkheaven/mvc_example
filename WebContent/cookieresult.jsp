<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This is cookieresult</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;
		String CookieName = null;
		String CookieValue = null;
		if (cookies.length > 0) {
			for (int j = 0; j < cookies.length; j++) {
				CookieName = cookies[j].getName();
				CookieValue = cookies[j].getValue();
				out.println("<br>CookieName:<strong>"+CookieName+"</strong>");
				out.println("<br>CookieValue:<strong>"+CookieValue+"</strong>");
			}
		}
		
		for (int i = 0; i < cookies.length; i++) {
			cookie = cookies[i];
			if (cookie.getName().equals("username")) {
				String name = cookie.getValue();
				out.println("<br><strong>" + name + "</strong>");
				break;
			}
		}
	%>

</body>
</html>