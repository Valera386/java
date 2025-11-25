<%@ page session="false" import="java.util.Map" %>
<%@ page import="com.academy.Card" %>
<%
    @SuppressWarnings("unchecked")
    Map<Integer, Card> cardBase = (Map<Integer, Card>) request.getAttribute("cardBase");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Список обращений</title>
    <style>body{font-family: Arial; margin: 40px;}</style>
</head>
<body>
<h1>Обращения в службу поддержки</h1>

<a href="<c:url value="/cards"><c:param name="action" value="create"/></c:url>">
    + Новое обращение
</a>
<br><br>

<c:choose>
    <c:when test="<%= cardBase.isEmpty() %>">
        <b>Пока нет ни одного обращения.</b>
    </c:when>
    <c:otherwise>
        <c:forEach var="entry" items="<%= cardBase.entrySet() %>">
            <p>
                Обращение #${entry.key}:
                <a href="<c:url value="/cards">
                    <c:param name="action" value="view"/>
                    <c:param name="cardId" value="${entry.key}"/>
                </c:url>">
                    ${entry.value.topic}
                </a>
                (клиент: ${entry.value.clientName})
            </p>
        </c:forEach>
    </c:otherwise>
</c:choose>
</body>
</html>