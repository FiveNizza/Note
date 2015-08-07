<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form name="LoginForm" method="post" action="controller">
        Login:<br/>
        <input type="text" name="login" value=""/>
        <br/>Password:<br/>
        <input type="password" name="password" value=""/>
            <br/>
        ${ registerIsOk }
            <br/>
        ${ errorLoginPassMessage }
            <br/>
        ${ wrongAction }
            <br/>
        ${ nullPage }
            <br/>
        <input type="submit" name="command" value="Login"/>
        <input type="submit" name="command" value="Register"/>
    </form>
</body>
</html>
