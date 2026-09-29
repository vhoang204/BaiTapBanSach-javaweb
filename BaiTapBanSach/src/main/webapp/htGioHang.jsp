<%@page import="Model.BO.GioHangBO"%>
<%@page import="Model.Bean.HangBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Giỏ Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container my-3">
    <%@include file='TieuDe.jsp' %>
    <%@include file='Menu.jsp' %>

    <div class="card shadow-sm border-0">
        <div class="card-header bg-dark text-white">
            <h5 class="mb-0"><i class="bi bi-cart3"></i> Giỏ Hàng Của Bạn</h5>
        </div>
        <div class="card-body">
            <%
                GioHangBO gh = (GioHangBO) session.getAttribute("gh");
                if (gh != null && !gh.ds.isEmpty()) {
            %>
                <div class="table-responsive">
                    <table class="table table-hover align-middle">
                        <thead class="table-light">
                            <tr>
                                <th>Mã sách</th>
                                <th>Tên sách</th>
                                <th>Giá</th>
                                <th width="180">Số lượng</th>
                                <th>Thành tiền</th>
                                <th>Thao tác</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (HangBean h : gh.ds) { %>
                                <tr>
                                    <td><%=h.getMahang()%></td>
                                    <td><%=h.getTenhang()%></td>
                                    <td><%=h.getGia()%> VNĐ</td>
                                    <td>
                                        <form action="GioHangServelet" method="post" class="d-flex gap-1">
                                            <input type="hidden" name="action" value="sua">
                                            <input type="hidden" name="id" value="<%=h.getMahang()%>">
                                            <input type="number" name="txtsl" value="<%=h.getSoluong()%>" min="1" class="form-control form-control-sm" style="width: 70px;">
                                            <button type="submit" class="btn btn-sm btn-outline-secondary">Lưu</button>
                                        </form>
                                    </td>
                                    <td class="fw-bold text-danger"><%=h.getThanhtien()%> VNĐ</td>
                                    <td>
                                        <a href="GioHangServelet?action=xoa&id=<%=h.getMahang()%>" class="btn btn-sm btn-outline-danger" onclick="return confirm('Xóa sách này khỏi giỏ?');">
                                            <i class="bi bi-trash"></i> Xóa
                                        </a>
                                    </td>
                                </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>

                <div class="d-flex justify-content-between align-items-center mt-3 pt-3 border-top">
                    <a href="SachServelet" class="btn btn-outline-primary"><i class="bi bi-arrow-left"></i> Tiếp tục mua sách</a>
                    <div class="text-end">
                        <h4 class="mb-2">Tổng tiền: <span class="text-danger"><%=gh.Tongtien()%> VNĐ</span></h4>
                        <a href="ThanhToanServelet" class="btn btn-success btn-lg">
                            <i class="bi bi-credit-card"></i> Thanh Toán
                        </a>
                    </div>
                </div>
            <% } else { %>
                <div class="alert alert-info text-center mb-0">Giỏ hàng của bạn đang trống!</div>
            <% } %>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/bootstrap.bundle.min.js"></script>
</body>
</html>