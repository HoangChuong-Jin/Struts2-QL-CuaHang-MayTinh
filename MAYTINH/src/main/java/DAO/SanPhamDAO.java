package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.SanPham;
import Model.User;
public class SanPhamDAO {
	public List<SanPham> getList(){
		List<SanPham> list=new ArrayList<SanPham>();
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT *	from sanpham");
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{
					list.add( new SanPham(rs.getInt("id"),
					rs.getString("tensanpham"),
					rs.getString("mota"),
					rs.getFloat("giagoc"),
					rs.getFloat("giaban"),
					rs.getInt("soluongton"),
					rs.getString("hinhanh"),
					rs.getString("danhmuc"),
					rs.getString("thuonghieu"),
					rs.getInt("luotxem"),
					rs.getInt("luotmua")));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<SanPham> getList2(){
		List<SanPham> list=new ArrayList<SanPham>();
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT * from sanpham WHERE danhmuc = 'Laptop'");
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{
					list.add( new SanPham(rs.getInt("id"),
					rs.getString("tensanpham"),
					rs.getString("mota"),
					rs.getFloat("giagoc"),
					rs.getFloat("giaban"),
					rs.getInt("soluongton"),
					rs.getString("hinhanh"),
					rs.getString("danhmuc"),
					rs.getString("thuonghieu"),
					rs.getInt("luotxem"),
					rs.getInt("luotmua")));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<SanPham> getList3(){
		List<SanPham> list=new ArrayList<SanPham>();
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT * from sanpham WHERE danhmuc = 'Máy bàn'");
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{
					list.add( new SanPham(rs.getInt("id"),
					rs.getString("tensanpham"),
					rs.getString("mota"),
					rs.getFloat("giagoc"),
					rs.getFloat("giaban"),
					rs.getInt("soluongton"),
					rs.getString("hinhanh"),
					rs.getString("danhmuc"),
					rs.getString("thuonghieu"),
					rs.getInt("luotxem"),
					rs.getInt("luotmua")));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<SanPham> getList4(){
		List<SanPham> list=new ArrayList<SanPham>();
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT * from sanpham WHERE danhmuc = 'khác'");
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{
					list.add( new SanPham(rs.getInt("id"),
					rs.getString("tensanpham"),
					rs.getString("mota"),
					rs.getFloat("giagoc"),
					rs.getFloat("giaban"),
					rs.getInt("soluongton"),
					rs.getString("hinhanh"),
					rs.getString("danhmuc"),
					rs.getString("thuonghieu"),
					rs.getInt("luotxem"),
					rs.getInt("luotmua")));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<SanPham> getList5(){
		List<SanPham> list=new ArrayList<SanPham>();
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT * from sanpham WHERE soluongton = 0");
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{
					list.add( new SanPham(rs.getInt("id"),
					rs.getString("tensanpham"),
					rs.getString("mota"),
					rs.getFloat("giagoc"),
					rs.getFloat("giaban"),
					rs.getInt("soluongton"),
					rs.getString("hinhanh"),
					rs.getString("danhmuc"),
					rs.getString("thuonghieu"),
					rs.getInt("luotxem"),
					rs.getInt("luotmua")));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public SanPham getSanPhamByID(int id)
	{
		SanPham sanpham=null;
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT * from sanpham WHERE id = ? ");
			statement.setInt(1, id);
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{					
					sanpham=new SanPham(rs.getInt("id"),
							rs.getString("tensanpham"),
							rs.getString("mota"),
							rs.getFloat("giagoc"),
							rs.getFloat("giaban"),
							rs.getInt("soluongton"),
							rs.getString("hinhanh"),
							rs.getString("danhmuc"),
							rs.getString("thuonghieu"),
							rs.getInt("luotxem"),
							rs.getInt("luotmua"));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return sanpham;
	}

	public void Order(int nguoidung_id,int sanpham_id, int soluong, float giaban, float tongtien)
	{
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("INSERT INTO	donhang (nguoidung_id,sanpham_id,soluong,giaban,tongtien) values(?,?,?,?,?)");
			statement.setInt(1, nguoidung_id);
			statement.setInt(2, sanpham_id);
			statement.setInt(3, soluong);
			statement.setFloat(4, giaban);
			statement.setFloat(5, tongtien);
			db.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void store(String tensanpham, String mota, float giagoc, float giaban, int soluongton, String hinhanh, String danhmuc, String thuonghieu)
	{
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("INSERT INTO	sanpham (tensanpham,mota,giagoc,giaban,soluongton,hinhanh,danhmuc,thuonghieu) values(?,?,?,?,?,?,?,?)");
			statement.setString(1, tensanpham);
			statement.setString(2, mota);
			statement.setFloat(3, giagoc);
			statement.setFloat(4, giaban);
			statement.setFloat(5, soluongton);
			statement.setString(6, hinhanh);
			statement.setString(7, danhmuc);
			statement.setString(8, thuonghieu);
			db.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(int id, String tensanpham,String mota, float giagoc, float giaban, int soluongton, String hinhanh, String danhmuc, String thuonghieu) {
		// TODO Auto-generated method stub
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("UPDATE sanpham SET tensanpham=?, mota=?, giagoc=?, giaban=?, soluongton=?,hinhanh=?, danhmuc=?, thuonghieu=? where id=?");
			statement.setString(1, tensanpham);
			statement.setString(2, mota);
			statement.setFloat(3, giagoc);
			statement.setFloat(4, giaban);
			statement.setFloat(5, soluongton);
			statement.setString(6, hinhanh);
			statement.setString(7, danhmuc);
			statement.setString(8, thuonghieu);
			statement.setInt(9, id);	
			db.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("DELETE FROM sanpham  where id=?");
			statement.setInt(1, id);	
			db.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<SanPham> timkiemsptheoten(String tukhoa){
		List<SanPham> list=new ArrayList<SanPham>();
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT *	from sanpham WHERE tensanpham like ?");
			statement.setString(1, "%"+tukhoa+"%");
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{
					list.add( new SanPham(rs.getInt("id"),
							rs.getString("tensanpham"),
							rs.getString("mota"),
							rs.getFloat("giagoc"),
							rs.getFloat("giaban"),
							rs.getInt("soluongton"),
							rs.getString("hinhanh"),
							rs.getString("danhmuc"),
							rs.getString("thuonghieu"),
							rs.getInt("luotxem"),
							rs.getInt("luotmua")));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}