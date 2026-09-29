package Model.BO;
import java.util.ArrayList;
import Model.Bean.LoaiBean;
import Model.DAO.LoaiDAO;
public class LoaiBO {
LoaiDAO s= new LoaiDAO();
 public ArrayList<LoaiBean> getLoai() throws Exception{
 return s.getLoai();
 }
}