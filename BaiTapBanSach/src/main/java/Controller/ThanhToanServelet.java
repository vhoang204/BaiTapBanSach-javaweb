package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BO.GioHangBO;
import Model.BO.HoaDonBO;

@WebServlet("/ThanhToanServelet")
public class ThanhToanServelet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Long makh = (Long) session.getAttribute("makh");
        
        // Yêu cầu đăng nhập mới được thanh toán
        if (makh == null) {
            response.sendRedirect("SachServelet?msg=Chuadangnhap");
            return;
        }

        GioHangBO gh = (GioHangBO) session.getAttribute("gh");
        if (gh != null && !gh.ds.isEmpty()) {
            try {
                HoaDonBO hdBo = new HoaDonBO();
                hdBo.ThanhToan(makh, gh);
                session.removeAttribute("gh"); // Xóa giỏ hàng sau khi thanh toán thành công
                response.sendRedirect("LichSuServelet");
            } catch (Exception e) {
                response.getWriter().println(e.getMessage());
            }
        } else {
            response.sendRedirect("htGioHang.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}