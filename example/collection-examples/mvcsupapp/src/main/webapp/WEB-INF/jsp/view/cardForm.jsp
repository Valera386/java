<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Новое обращение</title>
    <style>
        body {font-family: Arial; margin: 40px; line-height: 1.6;}
        input, textarea {width: 100%; padding: 8px; margin: 8px 0;}
        input[type=submit] {width: auto; padding: 10px 20px; font-size: 16px;}
    </style>
</head>
<body>
<h1>Новое обращение в службу поддержки</h1>

<form method="POST" action="cards" enctype="multipart/form-data">
    <input type="hidden" name="action" value="create"/>

    <p><strong>Имя клиента:</strong><br>
        <input type="text" name="clientName" required/></p>

    <p><strong>Тема:</strong><br>
        <input type="text" name="topic" required/></p>

    <p><strong>Сообщение:</strong><br>
        <textarea name="message" rows="8" required></textarea></p>

    <p><strong>Прикрепить файл:</strong><br>
        <input type="file" name="file1"/></p>

    <p><input type="submit" value="Отправить обращение"/></p>
</form>

<br>
<a href="<c:url value="/cards"/>">← Все обращения</a>
</body>
</html>