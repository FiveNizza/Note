<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    Request from ${ pageContext.errorData.requestURI } is failed
    <br/>
    Servlet name or type: ${ pageContext.errorData.servletName }
    <br/>
    Status code: ${ pageContext.errorData.statusCode }
    <bt/>
    Exception: ${ pageContext.errorData.throwable }

</body>
</html>
