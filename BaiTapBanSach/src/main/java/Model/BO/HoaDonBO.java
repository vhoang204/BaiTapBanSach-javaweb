package Model.BO;

import Model.Bean.HangBean;
import Model.DAO.HoaDonDAO;

public class HoaDonBO {
    HoaDonDAO hdDao = new HoaDonDAO();

    public void ThanhToan(long makh, GioHangBO gh) throws Exception {
        if (gh == null || gh.ds.isEmpty()) return;
        
        long mahd = hdDao.ThemHoaDon(makh);
        for (HangBean h : gh.ds) {
            hdDao.ThemChiTiet(h.getMahang(), h.getSoluong(), mahd);
        }
    }
}