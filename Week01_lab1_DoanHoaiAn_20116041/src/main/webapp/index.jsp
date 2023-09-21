<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<div class="wrapper">
    <form action="admin" method="post">
        <div class="mb-3">
            <label for="account_id" class="form-label">AccountID</label>
            <input id="account_id" name="account_id" class="form-control" aria-describedby="emailHelp">
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input id="password" name="password" type="password" class="form-control">
        </div>

        <button name="action" value="login" type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>