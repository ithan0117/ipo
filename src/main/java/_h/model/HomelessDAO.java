package _h.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import _a.model.ArticleBean;
import _a.model.ArticleDAO;
import _a.model.JoinBean;

public class HomelessDAO {

	private DataSource ds = null;

	public HomelessDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/ipo");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<HomelessBean> selectHomelessAll() {
		HomelessBean bean = null;
		ArrayList<HomelessBean> list = new ArrayList<>();
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn
						.prepareStatement("SELECT * FROM h_detail order by a_id");
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				bean = new HomelessBean();
				bean.setH_id(rs.getInt(1));
				bean.setA_id(rs.getInt(2));
				bean.setH_area(rs.getString(3));
				bean.setH_pet_type(rs.getString(4));
				bean.setH_age(rs.getString(5));
				bean.setH_pet_color(rs.getString(6));
				bean.setH_name(rs.getString(7));
				bean.setH_time(rs.getTimestamp(8));
				bean.setH_desc(rs.getString(9));
				bean.setH_lat(rs.getDouble(10));
				bean.setH_lng(rs.getDouble(11));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int insertHomeless(HomelessBean hb) {
		int result = -1;
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn
						.prepareStatement("insert into h_detail (a_id, h_area, h_pet_type, h_age, h_pet_color, h_name, h_time, h_desc, h_lat, h_lng) values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");) {
			pstmt.setInt(1, hb.getA_id());
			pstmt.setString(2, hb.getH_area());
			pstmt.setString(3, hb.getH_pet_type());
			pstmt.setString(4, hb.getH_age());
			pstmt.setString(5, hb.getH_pet_color());
			pstmt.setString(6, hb.getH_name());
			pstmt.setTimestamp(7, hb.getH_time());
			pstmt.setString(8, hb.getH_desc());
			pstmt.setDouble(9, hb.getH_lat());
			pstmt.setDouble(10, hb.getH_lng());
			result = pstmt.executeUpdate();
			System.out.println("成功寫入資料庫HHHHH");
		} catch (SQLException e) {
			try (
				Connection connn = ds.getConnection();
				PreparedStatement stmt = connn.prepareStatement("DELETE FROM a_head WHERE a_id = ?")
			) {
				stmt.setInt(1, hb.getA_id());
				stmt.executeUpdate();
				System.out.println("成功刪除資料庫AAAAA");
			} catch (SQLException e1) {
				System.out.println("AAAAA資料庫刪除有誤");
				e1.printStackTrace();
			}
			System.out.println("HHHHH資料庫寫入有誤");
			e.printStackTrace();
		}
		return result;
	}

	public HomelessBean selectHomelessDetail(int a_id) {
		HomelessBean bean = null;
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn
						.prepareStatement("select * from h_detail where a_id = ?");) {
			stmt.setInt(1, a_id);
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					bean = new HomelessBean();
					bean.setH_id(rs.getInt(1));
					bean.setA_id(rs.getInt(2));
					bean.setH_area(rs.getString(3));
					bean.setH_pet_type(rs.getString(4));
					bean.setH_age(rs.getString(5));
					bean.setH_pet_color(rs.getString(6));
					bean.setH_name(rs.getString(7));
					bean.setH_time(rs.getTimestamp(8));
					bean.setH_desc(rs.getString(9));
					bean.setH_lat(rs.getDouble(10));
					bean.setH_lng(rs.getDouble(11));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	
//	public List<JoinBean> selectHomelessHeadAndDetail() {
//		List<JoinBean> list = new ArrayList<JoinBean>();
//		
//		List<ArticleBean> aList = new ArticleDAO().selectByBlock("H");
//		List<HomelessBean> hList = selectHomelessAll();
//		JoinBean bean = null;
//		for (int i = 0; i < aList.size() ; i++) {
//			bean = new JoinBean(aList.get(i), hList.get(i));
//			list.add(bean);
//		}
//		return list;
//	}
	

	public List<JoinBean> selectHomelessHeadAndDetail() {
		List<JoinBean> list = new ArrayList<JoinBean>();
		JoinBean bean = null;
		ArticleBean aBean = null;
		HomelessBean hBean = null;
		try (
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement("select * from a_head left join h_detail on a_head.a_id=h_detail.a_id where a_block ='H'");
			ResultSet rs = stmt.executeQuery();
		) {
			while (rs.next()) {
				aBean = new ArticleBean();
				aBean.setA_id(rs.getInt(1));
				aBean.setM_id(rs.getInt(2));
				aBean.setA_block(rs.getString(3));
				aBean.setA_title(rs.getString(4));
				aBean.setA_createTime(rs.getTimestamp(5));
				aBean.setA_image(rs.getBinaryStream(6));
				
				hBean = new HomelessBean();
				hBean.setH_id(rs.getInt(7));
				hBean.setA_id(rs.getInt(8));
				hBean.setH_area(rs.getString(9));
				hBean.setH_pet_type(rs.getString(10));
				hBean.setH_age(rs.getString(11));
				hBean.setH_pet_color(rs.getString(12));
				hBean.setH_name(rs.getString(13));
				hBean.setH_time(rs.getTimestamp(14));
				hBean.setH_desc(rs.getString(15));
				hBean.setH_lat(rs.getDouble(16));
				hBean.setH_lng(rs.getDouble(17));
				bean = new JoinBean(aBean, hBean);
				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
