<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary rounded mb-3 shadow-sm">
  <div class="container-fluid">
    <div class="collapse navbar-collapse">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item"><a class="nav-link active" href="SachServelet"><i class="bi bi-house-door-fill"></i> Trang chủ</a></li>
        <li class="nav-item"><a class="nav-link" href="htGioHang.jsp"><i class="bi bi-cart3"></i> Xem giỏ hàng</a></li>
        <% if (session.getAttribute("makh") != null) { %>
            <li class="nav-item"><a class="nav-link" href="LichSuServelet"><i class="bi bi-clock-history"></i> Lịch sử mua hàng</a></li>
        <% } %>
      </ul>
      <form class="d-flex" action="SachServelet" method="get">
        <input class="form-control me-2 form-control-sm" type="search" name="txttk" placeholder="Tìm tên sách..." aria-label="Search">
        <button class="btn btn-light btn-sm text-nowrap" type="submit"><i class="bi bi-search"></i> Tìm</button>
      </form>
    </div>
  </div>
</nav>