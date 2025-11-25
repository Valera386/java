<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Обращение #${cardId}</title>
    <style>
        body {font-family: Arial; margin: 40px; line-height: 1.6;}
        pre {background: #f4f4f4; padding: 15px; border-radius: 5px;}
    </style>
</head>
<body>
<h1>Обращение #${cardId}: ${card.topic}</h1>

<p><strong>Клиент:</strong> ${card.clientName}</p>
<p><strong>Сообщение:</strong><br>
    <pre>${card.message}</pre>
</p>

<c:if test="${card.numberOfAttachments > 0}">
    <p><strong>Прикреплённые файлы:</strong><br>
    <c:forEach var="attachment" items="${card.attachments}">
        <a href="<c:url value="/cards">
            <c:param name="action" value="download"/>
            <c:param name="cardId" value="${cardId}"/>
            <c:param name="attachment" value="${attachment.fileName}"/>
        </c:url>">
            ${attachment.fileName}
        </a><br>
    </c:forEach>
    </p>
</c:if>

<br>
<a href="<c:url value="/cards"/>">← Все обращения</a>
</body>
</html>