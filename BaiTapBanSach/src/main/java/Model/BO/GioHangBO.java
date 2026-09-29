package Model.BO;

import java.util.ArrayList;
import java.util.List;
import Model.Bean.HangBean;

public class GioHangBO {
    public List<HangBean> ds = new ArrayList<HangBean>();

    public void Them(String mahang, String tenhang, long gia, long soluong) {
        for (HangBean h : ds) {
            if (h.getMahang().equalsIgnoreCase(mahang)) {
                long slmoi = h.getSoluong() + soluong;
                h.setSoluong(slmoi);
                h.setThanhtien(slmoi * gia);
                return;
            }
        }
        ds.add(new HangBean(mahang, tenhang, gia, soluong));
    }

    public void Xoa(String mahang) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getMahang().equalsIgnoreCase(mahang)) {
                ds.remove(i);
                return;
            }
        }
    }

    public void Sua(String mahang, long soluongMoi) {
        for (HangBean h : ds) {
            if (h.getMahang().equalsIgnoreCase(mahang)) {
                h.setSoluong(soluongMoi);
                h.setThanhtien(soluongMoi * h.getGia());
                return;
            }
        }
    }

    public long Tongtien() {
        long sum = 0;
        for (HangBean h : ds) {
            sum += h.getThanhtien();
        }
        return sum;
    }
}