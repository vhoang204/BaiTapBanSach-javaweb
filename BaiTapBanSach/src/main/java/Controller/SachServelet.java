package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Bean.LoaiBean;
import Model.Bean.SachBean;
import Model.BO.LoaiBO;
import Model.BO.SachBO;

@WebServlet("/SachServelet")
public class SachServelet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            
            LoaiBO l = new LoaiBO();
            ArrayList<LoaiBean> dsloai = l.getLoai();
            request.setAttribute("lstLoai", dsloai);

            String maloai = request.getParameter("ml");
            String ten = request.getParameter("txttk");
            SachBO s = new SachBO();
            
            ArrayList<SachBean> dssach = new ArrayList<>();
            if (maloai != null) {
                dssach = s.TimSachTheoMa(maloai);
            } else if (ten != null) {
                dssach = s.TimSachTheoTen(ten);
            } else {
                dssach = s.getSach();
            }

            // --- XỬ LÝ PHÂN TRANG ---
            int page = 1;
            String pageParam = request.getParameter("page");
            if (pageParam != null) {
                page = Integer.parseInt(pageParam);
            }
            
            int pageSize = 6; 
            int totalBooks = dssach.size();
            int totalPages = (int) Math.ceil((double) totalBooks / pageSize);
            
            int start = (page - 1) * pageSize;
            int end = Math.min(start + pageSize, totalBooks);
            
            List<SachBean> listPage = (start < totalBooks) ? dssach.subList(start, end) : new ArrayList<>();

            request.setAttribute("lstSach", listPage);
            request.setAttribute("currentPage", page);
            request.setAttribute("totalPages", totalPages);
            request.setAttribute("maloai", maloai);
            request.setAttribute("txttk", ten);

            RequestDispatcher rd = request.getRequestDispatcher("htSach.jsp");
            rd.forward(request, response);
            
        } catch (Exception tt) {
            response.getWriter().println(tt.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}