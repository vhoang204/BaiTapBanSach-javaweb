package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DungChung.CDungChung;

public class HoaDonDAO {
    Connection cn;

    public void KetNoi() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        cn = DriverManager.getConnection(CDungChung.url, CDungChung.un, CDungChung.pass);
    }

    public long getMaxMaHD() throws Exception {
        KetNoi();
        String sql = "SELECT ISNULL(MAX(mahd), 0) FROM HOADON";
        PreparedStatement cmd = cn.prepareStatement(sql);
        ResultSet r = cmd.executeQuery();
        long max = 0;
        if (r.next()) max = r.getLong(1);
        r.close();
        cn.close();
        return max + 1;
    }

    public long getMaxMaChiTiet() throws Exception {
        KetNoi();
        String sql = "SELECT ISNULL(MAX(machitiethoadon), 0) FROM CHITIETHOADON";
        PreparedStatement cmd = cn.prepareStatement(sql);
        ResultSet r = cmd.executeQuery();
        long max = 0;
        if (r.next()) max = r.getLong(1);
        r.close();
        cn.close();
        return max + 1;
    }

    public long ThemHoaDon(long makh) throws Exception {
        long mahd = getMaxMaHD();
        KetNoi();
        String sql = "INSERT INTO HOADON(mahd, makh, NgayMua, damua) VALUES(?, ?, GETDATE(), 0)";
        PreparedStatement cmd = cn.prepareStatement(sql);
        cmd.setLong(1, mahd);
        cmd.setLong(2, makh);
        cmd.executeUpdate();
        cn.close();
        return mahd;
    }

    public void ThemChiTiet(String masach, long soluong, long mahd) throws Exception {
        long mact = getMaxMaChiTiet();
        KetNoi();
        String sql = "INSERT INTO CHITIETHOADON(machitiethoadon, MaSach, SoLuongMua, MaHoaDon, damua) VALUES(?, ?, ?, ?, 0)";
        PreparedStatement cmd = cn.prepareStatement(sql);
        cmd.setLong(1, mact);
        cmd.setString(2, masach);
        cmd.setLong(3, soluong);
        cmd.setLong(4, mahd);
        cmd.executeUpdate();
        cn.close();
    }
}