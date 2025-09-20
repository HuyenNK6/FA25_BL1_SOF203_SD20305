<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 9/20/2025
  Time: 12:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang Đăng Nhập</title>
</head>
<%--    Form Control
        @action: địa chỉ URL nhận dữ liệu form khi nhấp nút submit
        @method: hình thức gửi dữ liệu form, có 2 giá trị
             -   GET: Tạo chuỗi truy vấn và đính kèm URL của @action
             -   POST: Mở kênh truyền thông ngầm gửi dữ liệu lên server
    --%>
<body>
    <h1>${name}</h1>
    <form action="/ket-qua" method="post">
        <label>Username </label>
        <input type="text" name="username" placeholder="Enter username" required> <br>
        <label>Password </label>
        <input type="password" name="password" placeholder="Enter password" required>
        <button type="submit">LOGIN</button>
    </form>
</body>
</html>
