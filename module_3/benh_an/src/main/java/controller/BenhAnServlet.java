package controller;

import models.BenhAn;
import models.BenhNhan;
import service.IBenhAnService;
import service.iml.BenhAnService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BenhANServlet", value = "/benhan")
public class BenhAnServlet extends HttpServlet {
    IBenhAnService benhAnService = new BenhAnService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                suaBenhAn(request, response);
                break;
            default:
                danhSachBenhAn(request, response);
                break;
        }

    }

    private void suaBenhAn(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        BenhAn benhAn = benhAnService.timBenhAn(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("suaBenhAn.jsp");
        request.setAttribute("benhAn", benhAn);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void danhSachBenhAn(HttpServletRequest request, HttpServletResponse response) {
        List<BenhAn> danhSachBenhAn = benhAnService.danhSachBenhAn();
        request.setAttribute("danhSachBenhAn", danhSachBenhAn);
        try {
            request.getRequestDispatcher("benhAn.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                chinhSuaBenhAn(request, response);
                break;
            case "delete":
                xoaBenhAn(request, response);

                break;
        }
    }

    private void xoaBenhAn(HttpServletRequest request, HttpServletResponse response) {
        String id =request.getParameter("idDelete");
        benhAnService.xoaBenhAnTheoId(id);
        try {
            List<BenhAn> benhAnList = benhAnService.danhSachBenhAn();
            request.setAttribute("danhSachBenhAn", benhAnList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("benhAn.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }


    private void chinhSuaBenhAn(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String maBenhAn = request.getParameter("maBenhAn");
        BenhNhan benhNhan = new BenhNhan(request.getParameter("maBenhNhan"), request.getParameter("hoTen"));
//        String maBenhNhan = request.getParameter("maBenhNhan");
//        String hoTen = request.getParameter("hoTen");
        String ngayNhapVien = request.getParameter("ngayNhapVien");
        String ngayRaVien = request.getParameter("ngayRaVien");
        String lyDo = request.getParameter("lyDo");
        BenhAn benhAn = new BenhAn(maBenhAn, benhNhan, ngayNhapVien, ngayRaVien, lyDo);
        benhAnService.capNhapBenhAn(benhAn);


    }
}
