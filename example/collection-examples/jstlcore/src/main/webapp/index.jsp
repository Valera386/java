<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSTL Core — Все теги в одном месте (Tomcat 10/11)</title>
    <style>body {font-family: Arial; margin: 40px;} hr {margin: 30px 0;}</style>
</head>
<body>
    <h1>Все основные JSTL Core теги — РАБОТАЕТ!</h1>

    <!-- 1. c:out -->
    <h2>1. &lt;c:out&gt;</h2>
    <c:set var="xss" value="<script>alert('XSS')</script>" />
    Без c:out: ${xss}<br>
    С c:out: <c:out value="${xss}" />


    <hr>

    <!-- 2. c:set и c:remove -->
    <h2>2. &lt;c:set&gt; и &lt;c:remove&gt;</h2>
    <c:set var="name" value="Иван Иванов" />
    Привет, ${name}!<br>
    <c:remove var="name"/>
    После remove: ${name} (пусто)
    <hr>

    <!-- 3. c:if -->
    <h2>3. &lt;c:if&gt;</h2>
    <c:set var="age" value="25"/>
    <c:if test="${age >= 18}">
        Взрослый человек
    </c:if>
    <c:if test="${multiExpression}" var="isTrueExp" />
     ...
     <c:if test="${isTrueExp}">
        Run if true
     </c:if>
     ...
     <c:if test="${isTrueExp}">
        Run if true
     </c:if>

    <hr>

    <!-- 4. c:choose -->
    <h2>4. &lt;c:choose&gt;</h2>
    <c:set var="mark" value="85"/>
    <c:choose>
        <c:when test="${mark >= 90}">Отлично</c:when>
        <c:when test="${mark >= 70}">Хорошо</c:when>
        <c:otherwise>Можно лучше</c:otherwise>
    </c:choose>

     <c:choose>
        <c:when test="${condition}">
                "if"
        </c:when>
        <c:when test="${otherCondition}">
                "else if"
        </c:when>
        ...
        <c:otherwise>
                "else"
        </c:otherwise>
     </c:choose>

    <hr>

    <!-- 5. c:forEach -->
    <h2>5. &lt;c:forEach&gt;</h2>
    <c:forEach var="i" begin="1" end="6">
        Номер: ${i}<br>
    </c:forEach>


    <br>
    Фрукты:
    <c:set var="fruits" value="${['Яблоко','Банан','Груша']}"/>
    <c:forEach items="${fruits}" var="f" varStatus="s">
        ${s.count}. ${f}<br>
    </c:forEach>
    <hr>

     <c:forEach items="${clients}" var="client"
                                  varStatus="info">
        ${info.begin}
        ${info.end}
        ${info.step}
        ${info.count}
        ${info.current}
        ${info.index}
        ${info.first}
        ${info.last}
     </c:forEach>

      javax.servlet.jsp.jstl.core.LoopTagStatus


    <!-- 6. c:forTokens -->
    <h2>6. &lt;c:forTokens&gt;</h2>
    <c:forTokens items="один,два;три,четыре" delims=",;" var="word">
        ${word}<br>
    </c:forTokens>

    <hr>

    <!-- 7. c:url -->
    <h2>7. &lt;c:url&gt;</h2>
    <c:url value="/search" var="link">
        <c:param name="q" value="JSTL пример"/>
    </c:url>
    <a href="${link}">Поиск JSTL</a>


    <!-- 8. c:import -->
    <h2>8. &lt;c:import&gt;</h2>
    <c:import url="https://httpbin.org/html" var="page"/>
    Загружено символов: ${fn:length(page)}



</body>
</html>