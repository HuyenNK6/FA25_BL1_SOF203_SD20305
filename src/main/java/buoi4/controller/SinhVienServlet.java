package buoi4.controller;

import buoi4.entity.SinhVien;
import buoi4.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "sinhvien-servlet", value = {
        "/sinh-vien/get-all",//GET
        "/sinh-vien/search",//GET
        "/sinh-vien/remove",//GET
        "/sinh-vien/detail",//GET
        "/sinh-vien/view-update",//GET
        "/sinh-vien/view-add",//GET
        "/sinh-vien/update",//POST
        "/sinh-vien/add"//POST
})
public class SinhVienServlet extends HttpServlet {
    SinhVienService service =  new SinhVienService();
    List<SinhVien> lstSV= new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
            http:/localhost:8080/sinh-vien/get-all?mssv=PH123
        req.getRequestURL() => http:/localhost:8080/sinh-vien/get-all
        req.getRequestURI() => /sinh-vien/get-all
        - contextPath, servletPath, queryString ??
         */
        String uri = req.getRequestURI();
        if(uri.contains("get-all")){
            this.getAll(req, resp); //gọi đến phần get All -> chuyển trang home
        }else if(uri.contains("search")){
            //search
        }else if(uri.contains("remove")){
            //remove
        }else if(uri.contains("detail")){
            //detail
        }else if(uri.contains("view-update")){
            //view-update
        }else if(uri.contains("view-add")){
            this.viewAdd(req,resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri= req.getRequestURI();
        if(uri.contains("add")){
            this.addSV(req, resp); //gọi chức năng add
        }

    }

    private void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        lstSV= service.getAllSV();
        req.setAttribute("lstSV",lstSV);
        req.getRequestDispatcher("/buoi4/home-sinh-vien.jsp").forward(req,resp);
    }
    private void viewAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/buoi4/view-add.jsp").forward(req,resp);
    }
    private void addSV(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //1. lấy thông tin từ view-add.jsp gửi đi
        String mssv= req.getParameter("mssv");
        String ten= req.getParameter("ten");
        String tuoi= req.getParameter("tuoi");
        String gioiTinh= req.getParameter("gioiTinh");
        String diaChi= req.getParameter("diaChi");

        //2. tạo đối tượng SV mới từ thông tin trên
        //sử dụng constructor
        //sử dụng Builder
        SinhVien sv= new SinhVien(
                mssv,
                ten,
                Integer.parseInt(tuoi),
                Boolean.parseBoolean(gioiTinh),
                diaChi
        );
        //3. thêm đối tượng vào danh sách
        service.addSV(sv);
        //4. load lại bảng- get all
        this.getAll(req, resp);
    }

}
