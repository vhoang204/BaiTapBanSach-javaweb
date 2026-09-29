package Model.BO;

import Model.Bean.KhachHangBean;
import Model.DAO.DangNhapDAO;

public class DangNhapBO {
    DangNhapDAO dn = new DangNhapDAO();
    
    public KhachHangBean KtDangNhap(String un, String pass) throws Exception {
        return dn.KtDangNhap(un, pass);
    }
}