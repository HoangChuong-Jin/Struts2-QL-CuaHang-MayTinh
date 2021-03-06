package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.NguoiDung;
import Model.SanPham;
import Model.User;
public class NguoiDungDAO {
	public List<NguoiDung> getList(){
		List<NguoiDung> list=new ArrayList<NguoiDung>();
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT *	from nguoidung");
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{
					list.add( new NguoiDung(rs.getInt("id"),
					rs.getString("hoten"),
					rs.getString("sodienthoai"),
					rs.getString("tendangnhap"),
					rs.getString("matkhau"),
					rs.getString("loaiquyen"),
					rs.getString("hinhanh")));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<NguoiDung> getList2(){
		List<NguoiDung> list=new ArrayList<NguoiDung>();
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT * FROM `nguoidung` WHERE loaiquyen = 'KHACH'");
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{
					list.add( new NguoiDung(rs.getInt("id"),
					rs.getString("hoten"),
					rs.getString("sodienthoai"),
					rs.getString("tendangnhap"),
					rs.getString("matkhau"),
					rs.getString("loaiquyen"),
					rs.getString("hinhanh")));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public NguoiDung getNguoiDungByID(int id)
	{
		NguoiDung nguoidung=null;
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT * from nguoidung WHERE id = ? ");
			statement.setInt(1, id);
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{					
					nguoidung=new NguoiDung(rs.getInt("id"),
							rs.getString("hoten"),
							rs.getString("sodienthoai"),
							rs.getString("tendangnhap"),
							rs.getString("matkhau"),
							rs.getString("loaiquyen"),
							rs.getString("hinhanh"));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return nguoidung;
	}
/*
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
*/
	public void store(String hoten, String sodienthoai, String tendangnhap, String matkhau, String loaiquyen, String hinhanh)
	{
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("INSERT INTO	nguoidung (hoten,sodienthoai,tendangnhap,matkhau,loaiquyen,hinhanh) values(?,?,?,?,?,?)");
			statement.setString(1, hoten);
			statement.setString(2, sodienthoai);
			statement.setString(3, tendangnhap);
			statement.setString(4, MD5.getMd5(matkhau));
			statement.setString(5, loaiquyen);
			statement.setString(6, hinhanh);
			db.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(int id,String hoten, String sodienthoai, String tendangnhap, String loaiquyen, String hinhanh) {
		// TODO Auto-generated method stub
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("UPDATE nguoidung SET hoten=?, sodienthoai=?, tendangnhap=?, loaiquyen=?,hinhanh=? where id=?");
			statement.setString(1, hoten);
			statement.setString(2, sodienthoai);
			statement.setString(3, tendangnhap);
			statement.setString(4, loaiquyen);
			statement.setString(5, hinhanh);
			statement.setInt(6, id);	
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
			statement = db.getConn().prepareStatement("DELETE FROM nguoidung  where id=?");
			statement.setInt(1, id);	
			db.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}