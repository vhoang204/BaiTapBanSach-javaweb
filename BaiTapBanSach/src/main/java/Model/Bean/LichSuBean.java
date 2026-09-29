package Model.Bean;

public class LichSuBean {
    private String hoten;
    private String tensach;
    private long soluong;
    private long gia;
    private long thanhtien;
    private boolean damua;

    public LichSuBean(String hoten, String tensach, long soluong, long gia, long thanhtien, boolean damua) {
        this.hoten = hoten;
        this.tensach = tensach;
        this.soluong = soluong;
        this.gia = gia;
        this.thanhtien = thanhtien;
        this.damua = damua;
    }

    public String getHoten() { return hoten; }
    public String getTensach() { return tensach; }
    public long getSoluong() { return soluong; }
    public long getGia() { return gia; }
    public long getThanhtien() { return thanhtien; }
    public boolean isDamua() { return damua; }
}