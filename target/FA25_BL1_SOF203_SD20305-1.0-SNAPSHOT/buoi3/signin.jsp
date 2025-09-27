<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 9/27/2025
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang Đăng Ký</title>
</head>
<body>
    <h1>FORM ĐĂNG KÝ</h1>
    <form action="/ket-qua-signin" method="post">
        <div>
            <label>Họ và tên </label>
            <input type="text" name="hoTen" placeholder="Nhập họ tên" required>
        </div>
        <div>
            <label>Ngày sinh: </label>
            <input type="date" name="ngaySinh">
        </div>
        <div>
            <label> Số điện thoại: </label>
            <input type="text" name="sdt" placeholder="Nhap sdt">
        </div>
        <div>
            <label>Giới tính: </label>
            <input type="radio" name="gioiTinh" value="Nam">
            <label>Nam</label>
            <input type="radio" name="gioiTinh" value="Nữ">
            <label>Nữ</label>
        </div>
        <div>
            <label>Địa chỉ: </label>
            <textarea name="diaChi" rows="5" cols="40"></textarea>
        </div>
        <%--Comment trong file jsp: Ctrl + Shift+ /
            COMBOBOX
        --%>
        <div>
            <label> Quốc gia: </label>
            <select name="quocGia">
                <option value="vietNam"> Việt Nam </option>
                <option value="lao"> Lào </option>
                <option value="campuchia"> Campuchia </option>
            </select>
        </div>
        <%--LIST BOX--%>
        <div>
            <label>Môn học: </label>
            <select name="monHoc" size="3" multiple>
                <option value="toan">Toán</option>
                <option value="van">Văn</option>
                <option value="anh">Anh</option>
            </select>
        </div>
        <%--CHECK BOX--%>
        <div>
            <label> Sở thích: </label> <br>
            <input type="checkbox" name="soThich" value="docSach">
            <label> Đọc sách</label> <br>
            <input type="checkbox" name="soThich" value="duLich">
            <label> Du lịch</label> <br>
            <input type="checkbox" name="soThich" value="ngheNhac">
            <label> Nghe nhạc</label>
        </div>
        <button type="submit"> ĐĂNG KÝ</button>
    </form>
</body>
</html>
