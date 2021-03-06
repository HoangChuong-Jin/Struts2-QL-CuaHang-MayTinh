package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.DonHang;
import Model.SanPham;
import Model.User;
public class DonHangDAO {
	public List<DonHang> getList(){
		List<DonHang> list=new ArrayList<DonHang>();
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT *	from donhang");
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{
					list.add( new DonHang(rs.getInt("id"),
					rs.getInt("nguoidung_id"),
					rs.getInt("sanpham_id"),
					rs.getInt("soluong"),
					rs.getFloat("giaban"),
					rs.getDate("ngay"),
					rs.getFloat("tongtien"),
					rs.getString("ghichu"),
					rs.getString("trangthai")));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<DonHang> getList2(){
		List<DonHang> list=new ArrayList<DonHang>();
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT * from donhang WHERE trangthai = 'Đang xử lí'");
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{
					list.add( new DonHang(rs.getInt("id"),
					rs.getInt("nguoidung_id"),
					rs.getInt("sanpham_id"),
					rs.getInt("soluong"),
					rs.getFloat("giaban"),
					rs.getDate("ngay"),
					rs.getFloat("tongtien"),
					rs.getString("ghichu"),
					rs.getString("trangthai")));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public DonHang getDonHangByID(int id)
	{
		DonHang donhang=null;
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT * from donhang WHERE id = ? ");
			statement.setInt(1, id);
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{					
					donhang=new DonHang(rs.getInt("id"),
							rs.getInt("nguoidung_id"),
							rs.getInt("sanpham_id"),
							rs.getInt("soluong"),
							rs.getFloat("giaban"),
							rs.getDate("ngay"),
							rs.getFloat("tongtien"),
							rs.getString("ghichu"),
							rs.getString("trangthai"));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return donhang;
	}

	public void update(int id, String trangthai) {
		// TODO Auto-generated method stub
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("UPDATE donhang SET trangthai=? where id=?");
			statement.setString(1, trangthai);
			statement.setInt(2, id);	
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
			statement = db.getConn().prepareStatement("DELETE FROM donhang  where id=?");
			statement.setInt(1, id);	
			db.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}