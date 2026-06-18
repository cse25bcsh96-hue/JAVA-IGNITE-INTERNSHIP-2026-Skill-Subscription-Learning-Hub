<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Skill Packs</title>
    <link rel="stylesheet" href="/css/style.css">
</head>

<body>

<div class="header">
    <img src="/images/logo.png" alt="Logo">
    <h2>Available Skill Packs</h2>
</div>

<div class="container">

    <h3>All Courses</h3>

    <!-- Loop through skill packs -->
    <c:forEach var="pack" items="${packs}">

        <div class="card">

            <!-- Show title -->
            <h4>${pack.title}</h4>

            <!-- Show description -->
            <p>${pack.description}</p>

            <!-- Show price -->
            <b>₹ ${pack.price}</b>

            <br><br>

            <!-- Subscribe action -->
            <a href="/subscribe?userId=1&packId=${pack.id}">
                Subscribe
            </a>

        </div>

    </c:forEach>

</div>

</body>
</html>
