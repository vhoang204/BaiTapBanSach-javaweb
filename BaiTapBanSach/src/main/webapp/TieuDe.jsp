<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="p-3 bg-dark text-white rounded mb-3 shadow-sm">
    <div class="d-flex justify-content-between align-items-center">
        <h3 class="m-0 fw-bold"><i class="bi bi-book-half text-warning"></i> NHÀ SÁCH ONLINE</h3>
        <div>
            <% if (session.getAttribute("un") == null || session.getAttribute("un").equals("")) { %>
                <form class="d-flex gap-2" action="DangNhapServelet" method="post">
                    <input type="text" name="txtun" class="form-control form-control-sm" placeholder="Tên đăng nhập" required>
                    <input type="password" name="txtpass" class="form-control form-control-sm" placeholder="Mật khẩu" required>
                    <button type="submit" class="btn btn-primary btn-sm text-nowrap">Đăng nhập</button>
                </form>
                <% if ("".equals(session.getAttribute("un"))) { %>
                    <small class="text-danger d-block text-end">Đăng nhập sai!</small>
                <% } %>
            <% } else { %>
                <span class="me-3"><i class="bi bi-person-circle"></i> Xin chào, <b><%= session.getAttribute("un") %></b></span>
                <a href="DangNhapServelet?action=logout" class="btn btn-outline-light btn-sm">Đăng xuất</a>
            <% } %>
        </div>
    </div>
</div>