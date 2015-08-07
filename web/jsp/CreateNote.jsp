<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create note</title>
</head>
<body>
    <form name="User" method="post" action="controller">
        <h3>Welcome <input type="" name="login" value="${ user }" disabled></h3>
    </form>
    <form name="CreateForm" method="post" action="controller">
        <div style="text-align: center;">
            <input type="text" name="note_name" value=""/>
        </div>
        <hr/>
        <div style="text-align: center;">
            <textarea name="note" rows="20" cols="10">
                ${ textNote }
            </textarea>
        </div>
        <div style="text-align: center">
            <input type="submit" name="command" value="Create">
        </div>
        <hr/>
    <a href="controller?command=goMain">Return to main menu</a>
</form>
</body>
</html>
