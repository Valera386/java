<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <title>Latest News</title>
    <meta charset="UTF-8">
</head>
<body>
    <h1>Latest News</h1>

    <c:choose>
        <c:when test="${fn:length(stories) == 0}">
            <b>There are no news today.</b>
        </c:when>
        <c:otherwise>
            <c:forEach items="${stories}" var="story">
                <div style="margin-bottom: 20px; padding: 10px; border: 1px solid #ccc;">
                    <b>
                        <c:out value="Title: ${story.title}"/> <br/>
                        <c:out value="Category: ${story.category}"/> <br/>
                        <c:out value="Date: ${story.dateStory}"/> <br/>
                    </b>
                    <c:out value="${story.content}"/> <br/>
                    <c:if test="${story.author != null}">
                        Author: <c:out value="${story.author}"/> <br/>
                    </c:if>
                    Date created: ${story.dateCreatedStory}
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</body>
</html>