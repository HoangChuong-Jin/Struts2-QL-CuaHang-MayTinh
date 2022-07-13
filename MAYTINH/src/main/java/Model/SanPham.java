package Model;

public class SanPham {
	int id;
	String tensanpham;
	String mota;
	float giagoc;
	float giaban;
	int soluongton;
	String hinhanh;
	String danhmuc;
	String thuonghieu;
	int luotxem;
	int luotmua;
	public SanPham(int id, String tensanpham, String mota, float giagoc, float giaban, int soluongton, String hinhanh,
			String danhmuc, String thuonghieu, int luotxem, int luotmua) {
		super();
		this.id = id;
		this.tensanpham = tensanpham;
		this.mota = mota;
		this.giagoc = giagoc;
		this.giaban = giaban;
		this.soluongton = soluongton;
		this.hinhanh = hinhanh;
		this.danhmuc = danhmuc;
		this.thuonghieu = thuonghieu;
		this.luotxem = luotxem;
		this.luotmua = luotmua;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTensanpham() {
		return tensanpham;
	}
	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public float getGiagoc() {
		return giagoc;
	}
	public void setGiagoc(float giagoc) {
		this.giagoc = giagoc;
	}
	public float getGiaban() {
		return giaban;
	}
	public void setGiaban(float giaban) {
		this.giaban = giaban;
	}
	public int getSoluongton() {
		return soluongton;
	}
	public void setSoluongton(int soluongton) {
		this.soluongton = soluongton;
	}
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	public String getDanhmuc() {
		return danhmuc;
	}
	public void setDanhmuc(String danhmuc) {
		this.danhmuc = danhmuc;
	}
	public String getThuonghieu() {
		return thuonghieu;
	}
	public void setThuonghieu(String thuonghieu) {
		this.thuonghieu = thuonghieu;
	}
	public int getLuotxem() {
		return luotxem;
	}
	public void setLuotxem(int luotxem) {
		this.luotxem = luotxem;
	}
	public int getLuotmua() {
		return luotmua;
	}
	public void setLuotmua(int luotmua) {
		this.luotmua = luotmua;
	}
	
	
	
}