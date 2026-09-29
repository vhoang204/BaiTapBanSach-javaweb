<%@page import="Model.Bean.LoaiBean"%>
<%@page import="Model.Bean.SachBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Trang Chủ - Bán Sách</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container my-3">
    <%@include file='TieuDe.jsp' %>
    <%@include file='Menu.jsp' %>
    
    <% if ("Chuadangnhap".equals(request.getParameter("msg"))) { %>
        <div class="alert alert-warning alert-dismissible fade show" role="alert">
            <strong>Thông báo:</strong> Bạn cần đăng nhập tài khoản trước khi thực hiện thanh toán!
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    <% } %>

    <div class="row">
        <!-- Danh mục Loại Sách (Cột Trái) -->
        <div class="col-md-3">
            <div class="list-group mb-3 shadow-sm">
                <div class="list-group-item bg-secondary text-white fw-bold"><i class="bi bi-list-task"></i> LOẠI SÁCH</div>
                <%
                    ArrayList<LoaiBean> dsloai = (ArrayList<LoaiBean>) request.getAttribute("lstLoai");
                    if (dsloai != null) {
                        for (LoaiBean l : dsloai) {
                %>
                    <a href="SachServelet?ml=<%=l.getMaloai()%>" class="list-group-item list-group-item-action">
                        <%=l.getTenloai()%>
                    </a>
                <%      }
                    } 
                %>
            </div>
        </div>

        <!-- Danh sách Sách (Cột Phải) -->
        <div class="col-md-9">
            <div class="row row-cols-1 row-cols-md-3 g-3">
                <%
                    List<SachBean> dssach = (List<SachBean>) request.getAttribute("lstSach");
                    if (dssach != null && !dssach.isEmpty()) {
                        for (SachBean s : dssach) {
                %>
                    <div class="col">
                        <div class="card h-100 shadow-sm border-0">
                            <img src="<%=s.getAnh()%>" class="card-img-top p-2" alt="<%=s.getTensach()%>" style="height: 200px; object-fit: contain;">
                            <div class="card-body d-flex flex-column">
                                <h6 class="card-title text-truncate" title="<%=s.getTensach()%>"><%=s.getTensach()%></h6>
                                <p class="card-text text-muted small mb-1">Tác giả: <%=s.getTacgia()%></p>
                                <p class="card-text text-danger fw-bold mb-3"><%=s.getGia()%> VNĐ</p>
                                <a href="GioHangServelet?ms=<%=s.getMasach()%>&ts=<%=s.getTensach()%>&gia=<%=s.getGia()%>" 
                                   class="btn btn-outline-primary btn-sm mt-auto w-100">
                                   <i class="bi bi-cart-plus"></i> Đặt mua
                                </a>
                            </div>
                        </div>
                    </div>
                <%      }
                    } else { 
                %>
                    <div class="col-12"><div class="alert alert-info">Không tìm thấy sách nào!</div></div>
                <%  } %>
            </div>

            <!-- PHẦN PHÂN TRANG -->
            <%
                Integer currentPage = (Integer) request.getAttribute("currentPage");
                Integer totalPages = (Integer) request.getAttribute("totalPages");
                String ml = (String) request.getAttribute("maloai");
                String tk = (String) request.getAttribute("txttk");
                
                String query = "";
                if (ml != null) query += "&ml=" + ml;
                if (tk != null) query += "&txttk=" + tk;

                if (totalPages != null && totalPages > 1) {
            %>
                <nav class="mt-4">
                  <ul class="pagination justify-content-center">
                    <% for (int p = 1; p <= totalPages; p++) { %>
                        <li class="page-item <%= (currentPage != null && currentPage == p) ? "active" : "" %>">
                            <a class="page-link" href="SachServelet?page=<%=p%><%=query%>"><%=p%></a>
                        </li>
                    <% } %>
                  </ul>
                </nav>
            <% } %>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/bootstrap.bundle.min.js"></script>
</body>
</html>