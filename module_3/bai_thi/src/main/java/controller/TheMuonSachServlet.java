package controller;

import DTO.TheMuonSachDTO;
import models.Sach;
import models.TheMuonSach;
import service.impl.SachService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TheMuonSachServlet", value = "/theMuonSachs")
public class TheMuonSachServlet extends HttpServlet {
    SachService sachService =new SachService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {

            default:
                display(request, response);

        }
    }

    private void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TheMuonSachDTO> theMuonSach = sachService.getAllTheMuonSach();
        request.setAttribute("list", theMuonSach);
        request.getRequestDispatcher("listMuonSach.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
