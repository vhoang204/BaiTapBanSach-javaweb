package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DungChung.CDungChung; // Lưu ý kiểm tra lại đúng tên package và class CDungChung
import Model.Bean.LoaiBean;

public class LoaiDAO {
    Connection cn;

    public void KetNoi() throws Exception {
        // Nạp database driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        // Mở kết nối
        cn = DriverManager.getConnection(CDungChung.url, CDungChung.un, CDungChung.pass);
    }

    public ArrayList<LoaiBean> getLoai() throws Exception {
        // Kết nối
        KetNoi();
        
        String sql = "select * from loai";
        PreparedStatement cmd = cn.prepareStatement(sql);
        ResultSet r = cmd.executeQuery();
        
        ArrayList<LoaiBean> ds = new ArrayList<LoaiBean>();
        
        // Đã thêm () vào r.next() và mở ngoặc nhọn {
        while (r.next()) {
            String maloai = r.getString("maloai");
            String tenloai = r.getString("tenloai");
            LoaiBean l = new LoaiBean(maloai, tenloai);
            ds.add(l);
        }
        
        r.close();
        return ds;
    }
}