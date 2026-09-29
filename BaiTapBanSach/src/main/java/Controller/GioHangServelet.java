package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.BO.GioHangBO;

@WebServlet("/GioHangServelet")
public class GioHangServelet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        GioHangBO gh = (GioHangBO) session.getAttribute("gh");
        if (gh == null) {
            gh = new GioHangBO();
            session.setAttribute("gh", gh);
        }

        String ms = request.getParameter("ms");
        String ts = request.getParameter("ts");
        String gia = request.getParameter("gia");
        String action = request.getParameter("action");

        if (ms != null && ts != null && gia != null) {
            gh.Them(ms, ts, Long.parseLong(gia), 1);
        } else if (action != null) {
            if (action.equals("xoa")) {
                gh.Xoa(request.getParameter("id"));
            } else if (action.equals("sua")) {
                String id = request.getParameter("id");
                long sl = Long.parseLong(request.getParameter("txtsl"));
                gh.Sua(id, sl);
            }
        }
        
        response.sendRedirect("htGioHang.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}