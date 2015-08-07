<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
    <body>
        <form name="RegisterForm" method="post" action="controller">
            <input type="hidden" name="command" value="doRegister"/>
            Login:<br/>
            <input type="text" name="login" value=""/>
            <br/>Password:<br/>
            <input type="password" name="password" value=""/>
            <br/>Repeat Password:<br/>
            <input type="password" name="repeatPassword" value=""/>
            <br/>
            ${ passwordMismatch }
            <br/>
            ${ loginIsOccupied }
            <br/>
            ${ errorLoginPassMessage }
            <br/>
            ${ wrongAction }
            <br/>
            <input type="submit" value="Ok"/>
            <a href="controller?command=Logout">Вернуться на страницу входа</a>
        </form>
    </body>
</html>
