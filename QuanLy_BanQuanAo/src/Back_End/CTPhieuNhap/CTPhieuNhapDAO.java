/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.CTPhieuNhap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.connec;
import Dao.DAOInterface;

/**
 *
 * @author NGOC THUC
 */
public class CTPhieuNhapDAO implements DAOInterface<CTPhieuNhap> {
	public static CTPhieuNhapDAO getInstance()
	{
		return new CTPhieuNhapDAO();
	}
	@Override
	public int insert(CTPhieuNhap t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "INSERT INTO CHITIETPHIEUNHAP(CTPN_MAPN, CTPN_MASP, CTSP_GIASP, CTSP_SOLUONGSP) " +
			             " VALUES(?,?,?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaPN());
			pst.setString(2, t.getMaSP());
			pst.setFloat(3, t.getDonGia());
			pst.setInt(4, t.getSoLuong());
			
			ketQua = pst.executeUpdate();
			
			System.out.println("Bạn đã thực thi " + sql);
			System.out.println("Có " + ketQua + " bị thay đổi");
			
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(CTPhieuNhap t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "DELETE FROM CHITIETPHIEUNHAP " +
			             " WHERE CTPN_MAPN=? AND CTPN_MASP=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaPN());
			pst.setString(2, t.getMaSP());
			
			ketQua = pst.executeUpdate();
			
			System.out.println("Bạn đã thực thi " + sql);
			System.out.println("Có " + ketQua + " bị thay đổi");
			
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(CTPhieuNhap t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "UPDATE CHITIETPHIEUNHAP(CTPN_MAPN, CTPN_MASP, CTSP_GIASP, CTSP_SOLUONGSP) " +
			             " SET CTPN_MASP=?" +
					     ", CTSP_GIASP=?" +
			             ", CTSP_SOLUONGSP=?" +
					     " WHERE CTPN_MAPN=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaSP());
			pst.setFloat(2, t.getDonGia());
			pst.setInt(3, t.getSoLuong());
			pst.setString(4, t.getMaPN());
			
			ketQua = pst.executeUpdate();
			
			System.out.println("Bạn đã thực thi " + sql);
			System.out.println("Có " + ketQua + " bị thay đổi");
			
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<CTPhieuNhap> selectAll() {
		ArrayList<CTPhieuNhap> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM CHITIETPHIEUNHAP";
			PreparedStatement pst = c.prepareStatement(sql); 
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maPN = rs.getString("CTPN_MAPN");
				String maSP = rs.getString("CTPN_MASP");
				Float donGia = rs.getFloat("CTSP_DONGIA");
			    int soLuong = rs.getInt("CTSP_SOLUONGSP");
			    
			    CTPhieuNhap a = new CTPhieuNhap(maPN, maSP, donGia, soLuong);
			    ketQua.add(a);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public CTPhieuNhap selectById(CTPhieuNhap t) {
		CTPhieuNhap ketQua = null;
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM CHITIETPHIEUNHAP WHERE CTPN_MAPN=?";
			PreparedStatement pst = c.prepareStatement(sql); 
			pst.setString(1, t.getMaPN());
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maPN = rs.getString("CTPN_MAPN");
				String maSP = rs.getString("CTPN_MASP");
				Float donGia = rs.getFloat("CTSP_DONGIA");
			    int soLuong = rs.getInt("CTSP_SOLUONGSP");
			    
			    ketQua = new CTPhieuNhap(maPN, maSP, donGia, soLuong);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<CTPhieuNhap> selectByCondition(String condition) {
		ArrayList<CTPhieuNhap> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM CHITIETPHIEUNHAP WHERE " + condition;
			PreparedStatement pst = c.prepareStatement(sql); 
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maPN = rs.getString("CTPN_MAPN");
				String maSP = rs.getString("CTPN_MASP");
				Float donGia = rs.getFloat("CTSP_DONGIA");
			    int soLuong = rs.getInt("CTSP_SOLUONGSP");
			    
			    CTPhieuNhap a = new CTPhieuNhap(maPN, maSP, donGia, soLuong);
			    ketQua.add(a);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}
    
}
