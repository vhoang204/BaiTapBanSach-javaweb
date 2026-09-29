package Model.Bean;
public class SachBean {
private String masach;
private String tensach;
private String tacgia;
private long gia;
private String anh;
public String getMasach() {
return masach;
}
public void setMasach(String masach) {
this.masach = masach;
}

public String getTensach() {
return tensach;
}
public void setTensach(String tensach) {
this.tensach = tensach;
}
public String getTacgia() {
return tacgia;
}
public void setTacgia(String tacgia) {
this.tacgia = tacgia;
}
public long getGia() {
return gia;
}
public void setGia(long gia) {
this.gia = gia;
}
public String getAnh() {
return anh;
}
public void setAnh(String anh) {
this.anh = anh;
}
public SachBean(String masach, String tensach,
String tacgia, long gia, String anh) {
super();
this.masach = masach;
this.tensach = tensach;
this.tacgia = tacgia;
this.gia = gia;
this.anh = anh;
}
}