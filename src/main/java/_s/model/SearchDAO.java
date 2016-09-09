package _s.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SearchDAO {

	private DataSource ds = null;

	public SearchDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/ipo");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insertSearch(SearchBean sb) {
		int result = -1;
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(
						"insert into s_detail (a_id, s_type, s_name, s_conn, s_time, s_location, s_desc, s_lat, s_lng, s_pet_type) values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");) {
			stmt.setInt(1, sb.getA_id());
			stmt.setString(2, sb.getS_type());
			stmt.setString(3, sb.getS_name());
			stmt.setString(4, sb.getS_conn());
			stmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			stmt.setString(6, sb.getS_location());
			stmt.setString(7, sb.getS_desc());
			stmt.setDouble(8, sb.getS_lat());
			stmt.setDouble(9, sb.getS_lng());
			stmt.setString(10, sb.getS_pet_type());

			result = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public SearchBean selectSerch(String a_id) {
		SearchBean temp = null;
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement("select * from s_detail where a_id = " + a_id);) {
			
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					temp = new SearchBean();
					temp.setS_id(rs.getInt(1));
					temp.setA_id(rs.getInt(2));
					temp.setS_type(rs.getString(3));
					temp.setS_name(rs.getString(4));
					temp.setS_conn(rs.getString(5));
					temp.setS_time(rs.getTimestamp(6));
					temp.setS_location(rs.getString(7));
					temp.setS_desc(rs.getString(8));
					temp.setS_lat(rs.getDouble(9));
					temp.setS_lng(rs.getDouble(10));
					temp.setS_pet_type(rs.getString(10));
					// temp.setS_lng(rs.getDouble(12));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

	public int updateSerch(SearchBean sb) {
		int result = -1;
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn
						.prepareStatement("update s_detail set s_type = ?, s_name = ?, s_conn = ?, s_time = ?,"
								+ " s_location = ?, s_desc = ?, s_lat = ?, s_lng = ?, s_img = ? "
								+ "where s_id = ?");) {
			stmt.setString(1, sb.getS_type());
			stmt.setString(2, sb.getS_name());
			stmt.setString(3, sb.getS_conn());
			stmt.setTimestamp(4, sb.getS_time());
			stmt.setString(5, sb.getS_location());
			stmt.setString(6, sb.getS_desc());
			stmt.setDouble(7, sb.getS_lat());
			stmt.setDouble(8, sb.getS_lng());
			// stmt.setString(9, sb.getS_img());
			stmt.setString(9, null);
			stmt.setInt(10, sb.getS_id());

			result = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<SearchBean> selectSearchAll() {
		SearchBean bean = null;
		ArrayList<SearchBean> list = new ArrayList<>();
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement("select * from s_detail");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				bean = new SearchBean();
				bean.setS_id(rs.getInt(1));
				bean.setA_id(rs.getInt(2));
				bean.setS_type(rs.getString(3));
				bean.setS_name(rs.getString(4));
				bean.setS_conn(rs.getString(5));
				bean.setS_time(rs.getTimestamp(6));
				bean.setS_location(rs.getString(7));
				bean.setS_desc(rs.getString(8));
				bean.setS_lat(rs.getDouble(9));
				bean.setS_lng(rs.getDouble(10));
				bean.setS_pet_type(rs.getString(11));

				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// public SearchBean selectSerch(SearchBean sb) {
	// SearchBean temp = null;
	// try (
	// Connection conn = ds.getConnection();
	// PreparedStatement stmt = conn.prepareStatement("select * from s_detail
	// where s_id = ?");
	// ) {
	// stmt.setInt(1, sb.getS_id());
	// try (ResultSet rs = stmt.executeQuery();) {
	// if (rs.next()) {
	// temp = new SearchBean();
	// temp.setS_id(rs.getInt(1));
	// temp.setA_id(rs.getInt(2));
	//

	public List<SearchBean> selectSearchAllType(String s_type, String s_pet_type) {
		SearchBean bean = null;
		ArrayList<SearchBean> list = new ArrayList<>();
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn
						.prepareStatement("select * from s_detail where s_type = ? and s_pet_type = ?");) {
			stmt.setString(1, s_type);
			stmt.setString(2, s_pet_type);

			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					bean = new SearchBean();
					bean.setS_id(rs.getInt(1));
					bean.setA_id(rs.getInt(2));
					bean.setS_type(rs.getString(3));
					bean.setS_name(rs.getString(4));
					bean.setS_conn(rs.getString(5));
					bean.setS_time(rs.getTimestamp(6));
					bean.setS_location(rs.getString(7));
					bean.setS_desc(rs.getString(8));
					bean.setS_lat(rs.getDouble(9));
					bean.setS_lng(rs.getDouble(10));
					bean.setS_pet_type(rs.getString(11));

					list.add(bean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
