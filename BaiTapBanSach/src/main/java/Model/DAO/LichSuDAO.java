package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DungChung.CDungChung;
import Model.Bean.LichSuBean;

public class LichSuDAO {
    Connection cn;

    public void KetNoi() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        cn = DriverManager.getConnection(CDungChung.url, CDungChung.un, CDungChung.pass);
    }

    public ArrayList<LichSuBean> getLichSu(long makh) throws Exception {
        KetNoi();
        String sql = "SELECT kh.hoten, s.tensach, ct.SoLuongMua, s.gia, (ct.SoLuongMua * s.gia) AS thanhtien, ct.damua " +
                     "FROM KhachHang kh " +
                     "JOIN HOADON hd ON kh.makh = hd.makh " +
                     "JOIN CHITIETHOADON ct ON hd.mahd = ct.MaHoaDon " +
                     "JOIN sach s ON ct.MaSach = s.masach " +
                     "WHERE kh.makh = ?";
        PreparedStatement cmd = cn.prepareStatement(sql);
        cmd.setLong(1, makh);
        ResultSet r = cmd.executeQuery();
        
        ArrayList<LichSuBean> ds = new ArrayList<>();
        while (r.next()) {
            ds.add(new LichSuBean(
                r.getString("hoten"),
                r.getString("tensach"),
                r.getLong("SoLuongMua"),
                r.getLong("gia"),
                r.getLong("thanhtien"),
                r.getBoolean("damua")
            ));
        }
        r.close();
        cn.close();
        return ds;
    }
}