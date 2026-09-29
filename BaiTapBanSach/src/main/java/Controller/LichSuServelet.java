package Controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Bean.LichSuBean;
import Model.BO.LichSuBO;

@WebServlet("/LichSuServelet")
public class LichSuServelet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Long makh = (Long) session.getAttribute("makh");
        
        if (makh != null) {
            try {
                LichSuBO lsBo = new LichSuBO();
                ArrayList<LichSuBean> dsLichSu = lsBo.getLichSu(makh);
                request.setAttribute("dsLichSu", dsLichSu);
                
                RequestDispatcher rd = request.getRequestDispatcher("LichSuMuaHang.jsp");
                rd.forward(request, response);
            } catch (Exception e) {
                response.getWriter().println(e.getMessage());
            }
        } else {
            response.sendRedirect("SachServelet");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}