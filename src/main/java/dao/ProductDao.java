package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Product;

public class ProductDao {

	public static void addProduct(Product p) {

		try {

			Connection conn = DBConnection.createConnection();
			String sql = "insert into product(pname,pcategory,pmodel,pprice,pdesc,image) values(?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, p.getPname());
			pst.setString(2, p.getPcategory());
			pst.setString(3, p.getPmodel());
			pst.setLong(4, p.getPprice());
			pst.setString(5, p.getPdesc());
			pst.setString(6, p.getImage());
			pst.executeUpdate();
			System.out.println("Product Added . . . ");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Product> viewProduct() {
		List<Product> list = new ArrayList<Product>();

		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from product";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Product p = new Product();
				p.setPid(rs.getInt("pid"));
				p.setPname(rs.getString("pname"));
				p.setPcategory(rs.getString("pcategory"));
				p.setPmodel(rs.getString("pmodel"));
				p.setPprice(rs.getLong("pprice"));
				p.setPdesc(rs.getString("pdesc"));
				p.setImage(rs.getString("image"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void deleteProduct(int id) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "delete from product where pid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("Product deleted Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateProduct(Product p) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "update product set pname=?,pcategory=?,pmodel=?,pprice=?,pdesc=? where pid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, p.getPname());
			pst.setString(2, p.getPcategory());
			pst.setString(3, p.getPmodel());
			pst.setLong(4, p.getPprice());
			pst.setString(5, p.getPdesc());
			pst.setInt(6, p.getPid());
			pst.executeUpdate();
			System.out.println("Product Updated");
		} catch (Exception 	e) {
			e.printStackTrace();
		}
	}
	
	public static Product getProductByPid(int id) {
		Product p = null;
		
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from product where pid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				p = new Product();
				p.setPid(rs.getInt("pid"));
				p.setPname(rs.getString("pname"));
				p.setPcategory(rs.getString("pcategory"));
				p.setPmodel(rs.getString("pmodel"));
				p.setPprice(rs.getLong("pprice"));
				p.setPdesc(rs.getString("pdesc"));
				p.setImage(rs.getString("image"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
}
