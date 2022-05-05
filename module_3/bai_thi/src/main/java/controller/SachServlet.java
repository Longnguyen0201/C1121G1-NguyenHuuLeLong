package controller;

import models.HocSinh;
import models.Sach;
import models.TheMuonSach;
import service.impl.SachService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SachServlet", value = "/sachs")
public class SachServlet extends HttpServlet {
    service.SachService sachService = new SachService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "muon":
                formMuonSach(request, response);
                break;
            default:
                display(request, response);

        }

    }

    private void formMuonSach(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Sach sach = sachService.selectById(id);
        request.setAttribute("sach", sach);
        List<HocSinh> hocsinh = sachService.getAllHocSinh();
        request.setAttribute("hocsinhList", hocsinh);
        List<Sach> sachList = sachService.getAll();
        request.setAttribute("list", sachList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Sach> sachList = sachService.getAll();
        request.setAttribute("list", sachList);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "muon":
                MuonSach(request, response);
                break;

        }
    }

    private void MuonSach(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        String maSach = request.getParameter("maSach");
        String maHocSinh = request.getParameter("hocsinh");
        Integer trangThai = 1;
        String ngayMuon = request.getParameter("ngayMuon");
        String ngayTra = request.getParameter("ngayTra");
        TheMuonSach theMuonSach = new TheMuonSach(code,maSach,maHocSinh,trangThai,ngayMuon,ngayTra);
        sachService.muonSach(theMuonSach);
        try {
            request.getRequestDispatcher("list.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
