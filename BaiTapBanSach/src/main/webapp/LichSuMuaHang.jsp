<%@page import="Model.Bean.LichSuBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lịch Sử Mua Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container my-3">
    <%@include file='TieuDe.jsp' %>
    <%@include file='Menu.jsp' %>

    <div class="card shadow-sm border-0">
        <div class="card-header bg-success text-white">
            <h5 class="mb-0"><i class="bi bi-check-circle me-2"></i> Lịch Sử Đơn Hàng Của Khách Hàng</h5>
        </div>
        <div class="card-body">
            <%
                ArrayList<LichSuBean> dsLichSu = (ArrayList<LichSuBean>) request.getAttribute("dsLichSu");
                if (dsLichSu != null && !dsLichSu.isEmpty()) {
            %>
                <div class="table-responsive">
                    <table class="table table-bordered table-hover align-middle">
                        <thead class="table-light text-center">
                            <tr>
                                <th>STT</th>
                                <th>Họ Tên Khách Hàng</th>
                                <th>Tên Sách</th>
                                <th>Số Lượng Mua</th>
                                <th>Giá</th>
                                <th>Thành Tiền</th>
                                <th>Trạng Thái (DaMua)</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% 
                                int stt = 1;
                                for (LichSuBean ls : dsLichSu) { 
                            %>
                                <tr>
                                    <td class="text-center"><%=stt++%></td>
                                    <td><b><%=ls.getHoten()%></b></td>
                                    <td><%=ls.getTensach()%></td>
                                    <td class="text-center"><%=ls.getSoluong()%></td>
                                    <td class="text-end"><%=ls.getGia()%> VNĐ</td>
                                    <td class="text-end fw-bold text-danger"><%=ls.getThanhtien()%> VNĐ</td>
                                    <td class="text-center">
                                        <% if (ls.isDamua()) { %>
                                            <span class="badge bg-success">Đã duyệt (True)</span>
                                        <% } else { %>
                                            <span class="badge bg-warning text-dark">Chờ duyệt (False)</span>
                                        <% } %>
                                    </td>
                                </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
            <% } else { %>
                <div class="alert alert-info text-center mb-0">Bạn chưa có lịch sử mua hàng nào!</div>
            <% } %>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/bootstrap.bundle.min.js"></script>
</body>
</html>