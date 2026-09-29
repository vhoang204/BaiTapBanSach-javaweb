package Model.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DungChung.CDungChung;
import Model.Bean.SachBean;
public class SachDAO {
 Connection cn;
 public void KetNoi() throws Exception{
 //Nạp database driver
 Class.forName(
"com.microsoft.sqlserver.jdbc.SQLServerDriver");
 cn=DriverManager.getConnection(CDungChung.url,
 CDungChung.un,CDungChung.pass);
 }
public ArrayList<SachBean> getSach() throws Exception{
//Ket Noi
KetNoi();
String sql="select * from sach";
PreparedStatement cmd= cn.prepareStatement(sql);
ResultSet r= cmd.executeQuery();
ArrayList<SachBean> ds= new ArrayList<SachBean>();
while(r.next()){//Duyet qua cac sach trong bang Sach(csdl)
String masach=r.getString("masach");//lay ra masach
String tensach=r.getString("tensach");
String tacgia=r.getString("tacgia");
long gia=r.getLong("gia");
String anh=r.getString("anh");
SachBean s= new SachBean(masach, tensach,
tacgia, gia, anh);//Tao ra lop SachBean
ds.add(s);//Them Sach vao ds
}
r.close();
return ds;
}
public ArrayList<SachBean> TimSachTheoMa(String maloai) throws
Exception{
//Ket Noi
KetNoi();
String sql="select * from sach where maloai='"+ maloai+"'";
PreparedStatement cmd= cn.prepareStatement(sql);
ResultSet r= cmd.executeQuery();
ArrayList<SachBean> ds= new ArrayList<SachBean>();
while(r.next()){//Duyet qua cac sach trong bang Sach(csdl)
String masach=r.getString("masach");//lay ra masach
String tensach=r.getString("tensach");
String tacgia=r.getString("tacgia");
long gia=r.getLong("gia");
String anh=r.getString("anh");
SachBean s= new SachBean(masach, tensach,
tacgia, gia, anh);//Tao ra lop SachBean
ds.add(s);//Them Sach vao ds
}
r.close();
return ds;
}
public ArrayList<SachBean> TimSachTheoTen(String ten) throws
Exception{
//Ket Noi
KetNoi();
String sql="select * from sach where tensach like N'%"+
ten+"%'";
PreparedStatement cmd= cn.prepareStatement(sql);
ResultSet r= cmd.executeQuery();
ArrayList<SachBean> ds= new ArrayList<SachBean>();
while(r.next()){//Duyet qua cac sach trong bang Sach(csdl)
String masach=r.getString("masach");//lay ra masach
String tensach=r.getString("tensach");
String tacgia=r.getString("tacgia");
long gia=r.getLong("gia");
String anh=r.getString("anh");
SachBean s= new SachBean(masach, tensach,
tacgia, gia, anh);//Tao ra lop SachBean
ds.add(s);//Them Sach vao ds
}
r.close();
return ds;
}
}