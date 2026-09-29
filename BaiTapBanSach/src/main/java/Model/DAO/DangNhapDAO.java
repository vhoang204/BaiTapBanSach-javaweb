package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DungChung.CDungChung;
import Model.Bean.KhachHangBean;

public class DangNhapDAO {
    Connection cn;

    public void KetNoi() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        cn = DriverManager.getConnection(CDungChung.url, CDungChung.un, CDungChung.pass);
    }

    public KhachHangBean KtDangNhap(String un, String pass) throws Exception {
        KetNoi();
        String sql = "SELECT * FROM KhachHang WHERE Tendn=? AND Pass=?";
        PreparedStatement cmd = cn.prepareStatement(sql);
        cmd.setString(1, un);
        cmd.setString(2, pass);
        ResultSet r = cmd.executeQuery();
        
        KhachHangBean kh = null;
        if (r.next()) {
            kh = new KhachHangBean(
                r.getLong("makh"),
                r.getString("hoten"),
                r.getString("diachi"),
                r.getString("sodt"),
                r.getString("email"),
                un, pass
            );
        }
        r.close();
        cn.close();
        return kh;
    }
}