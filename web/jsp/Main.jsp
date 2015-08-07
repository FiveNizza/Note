<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Main</title>
</head>
<body>

    <form name="User" method="post" action="controller">
        <h3>${ user } ${ id }</h3>
    </form>
    <br/>
    <hr/>
    <%--<form name="MainPage" method="post" action="controller">--%>
        <%--&lt;%&ndash;<input type="hidden" name="command" value="main"/>&ndash;%&gt;--%>
    <%--</form>--%>
    <form name="Page" method="post" action="controller">
        <input type="submit" name="command" value="add"/>
    </form>
    <table>
    <hr/>
    <form name="List" method="post" action="controller">
    <c:forEach var="elem" items="${ list }" varStatus="status" >
        <c:set var="count" value="10"/>
        <c:if test="${count >= status.count}">
        <tr>
            Заметка № <c:out value="${ elem.id }"/>
            <br/>
            <input type="text" value="${ elem.nameNote }">
            <br>
            <textarea name="note" rows="10" cols="20" >
                    ${ elem.textNote }
            </textarea>
            <br/>
            <%--<input type="submit" name="command" value="Edit${status.count}"/>--%>
            <input type="submit" name="command" value="Delete${status.count}"/>
            <br/>
            <br/>
            <br/>
        </tr>
        </c:if>
    </c:forEach>
    </form>
    <hr/>
    </table>
    <form name="aHref" method="post" action="controller">
        <a href="controller?command=Logout">Logout</a>
    </form>
</body>
</html>
