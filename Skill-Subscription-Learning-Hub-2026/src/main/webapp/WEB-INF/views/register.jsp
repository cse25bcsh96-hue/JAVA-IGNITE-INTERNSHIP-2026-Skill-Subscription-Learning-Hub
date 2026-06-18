<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="/css/style.css">
</head>

<body>

<div class="header">
    <img src="/images/logo.png" alt="Logo">
    <h2>Skill Subscription Hub</h2>
</div>

<div class="container">

    <h3>Register</h3>

    <form action="/register" method="post">

        <!-- Enter name -->
        <input type="text" name="name" placeholder="Name" required>

        <!-- Enter email -->
        <input type="email" name="email" placeholder="Email" required>

        <!-- Enter password -->
        <input type="password" name="password" placeholder="Password" required>

        <button type="submit">Register</button>

    </form>

</div>

</body>
</html>
