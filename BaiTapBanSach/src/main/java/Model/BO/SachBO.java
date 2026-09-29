package Model.BO;
import java.util.ArrayList;
import java.util.List;
import Model.Bean.SachBean;
import Model.DAO.SachDAO;
public class SachBO {
SachDAO s= new SachDAO();
 public ArrayList<SachBean> getSach() throws Exception{
 return s.getSach();
 }
 public ArrayList<SachBean> TimSachTheoMa(String maloai) throws
Exception{
 return s.TimSachTheoMa(maloai);
 }
 public ArrayList<SachBean> TimSachTheoTen(String ten) throws
Exception{
 return s.TimSachTheoTen(ten);
}
}