package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Bean.KhachHangBean;
import Model.BO.DangNhapBO;

@WebServlet("/DangNhapServelet")
public class DangNhapServelet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        
        if ("logout".equals(action)) {
            session.removeAttribute("un");
            session.removeAttribute("makh");
            session.removeAttribute("kh");
            response.sendRedirect("SachServelet");
            return;
        }

        String un = request.getParameter("txtun");
        String pass = request.getParameter("txtpass");
        
        DangNhapBO dn = new DangNhapBO();
        try {
            KhachHangBean kh = dn.KtDangNhap(un, pass);
            if (kh != null) {
                session.setAttribute("un", kh.getHoten());
                session.setAttribute("makh", kh.getMakh()); // Tạo Session lưu mã khách hàng
                session.setAttribute("kh", kh);
            } else {
                session.setAttribute("un", "");
                session.removeAttribute("makh");
            }
            response.sendRedirect("SachServelet");
        } catch (Exception tt) {
            response.getWriter().println(tt.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}