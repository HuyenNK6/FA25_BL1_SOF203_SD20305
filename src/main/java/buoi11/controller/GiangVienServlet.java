package buoi11.controller;

import buoi11.entity.GiangVien;
import buoi11.repository.GiangVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name= "giang-vien-servlet", value = {
        "/giang-vien/hien-thi-tat-ca",
        "/giang-vien/detail"
})
public class GiangVienServlet extends HttpServlet {
    GiangVienRepository repo= new GiangVienRepository();
    List<GiangVien> listGVs= new ArrayList<>();
    GiangVien gv= new GiangVien();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri= req.getRequestURI();
        if(uri.contains("hien-thi-tat-ca")){
            this.getAll(req, resp);
        }else if(uri.contains("detail")){
            this.detail(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
    protected void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listGVs= repo.getAll();
        req.setAttribute("listGVs",listGVs);
        req.getRequestDispatcher("/buoi11/giang-vien.jsp").forward(req,resp);
    }
    protected void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lấy id của đối tượng cần xem chi tiết
        String id = req.getParameter("id");
        //tìm thông tin đối tượng đó
        gv = repo.findById(Integer.parseInt(id));
        //gửi sang jsp -> để load lên form
        req.setAttribute("gv",gv);
        listGVs= repo.getAll();
        req.setAttribute("listGVs",listGVs);
        req.getRequestDispatcher("/buoi11/giang-vien.jsp").forward(req,resp);
    }
}
