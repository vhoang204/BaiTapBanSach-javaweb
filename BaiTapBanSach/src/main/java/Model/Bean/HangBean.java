package Model.Bean;
public class HangBean {
private String mahang;
private String tenhang;
private long gia;
private long soluong;
private long thanhtien;
public String getMahang() {
return mahang;

}
public void setMahang(String mahang) {
this.mahang = mahang;
}
public String getTenhang() {
return tenhang;
}
public void setTenhang(String tenhang) {
this.tenhang = tenhang;
}
public long getGia() {
return gia;
}
public void setGia(long gia) {
this.gia = gia;
}
public long getSoluong() {
return soluong;
}
public void setSoluong(long soluong) {
this.soluong = soluong;
}
public long getThanhtien() {
return thanhtien;
}
public void setThanhtien(long thanhtien) {
this.thanhtien = thanhtien;
}
public HangBean(String mahang, String tenhang, long gia,
long soluong) {
super();
this.mahang = mahang;
this.tenhang = tenhang;
this.gia = gia;
this.soluong = soluong;
this.thanhtien=soluong*gia;
}

}