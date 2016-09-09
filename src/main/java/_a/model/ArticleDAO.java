package _a.model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ArticleDAO {

	private DataSource ds = null;

	public ArticleDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/ipo");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insertArticle(ArticleBean bean) {
		int a_id = -1;
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn
						.prepareStatement(
								"insert into a_head (m_id, a_block, a_title, a_createTime, a_image) values( ?, ?, ?, ?, ? )",
								Statement.RETURN_GENERATED_KEYS);) {
			stmt.setInt(1, bean.getM_id());
			stmt.setString(2, bean.getA_block());
			stmt.setString(3, bean.getA_title());
			stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			stmt.setBinaryStream(5, bean.getA_image());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				a_id = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a_id;
	}
	
	public int deleteArticle(ArticleBean bean){
		int result = -1;
		try (
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement("delete from a_head where a_id = ?");
		){
			stmt.setInt(1, bean.getA_id());
			result = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateArticle(ArticleBean bean){
		int result = -1;
		try (
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement
					("update a_head set a_block = ?, a_title = ? where a_id = ?");
		){
			stmt.setString(1, bean.getA_block());
			stmt.setString(2, bean.getA_title());
			stmt.setInt(3, bean.getA_id());
			result = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<ArticleBean> selectArticleAll() {
		ArticleBean bean = null;
		ArrayList<ArticleBean> list = new ArrayList<>();
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn
						.prepareStatement("select * from a_head");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				bean = new ArticleBean();
				bean.setA_id(rs.getInt(1));
				bean.setM_id(rs.getInt(2));
				bean.setA_block(rs.getString(3));
				bean.setA_title(rs.getString(4));
				bean.setA_createTime(rs.getTimestamp(5));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ArticleBean> selectArticlesByM_id(int m_id) {
		List<ArticleBean> list = new ArrayList<ArticleBean>();
		ArticleBean bean = null;
		try (
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement("select * from a_head where m_id = ?");
		) {
			stmt.setInt(1, m_id);
			try (
				ResultSet rs = stmt.executeQuery();
			) {
				while (rs.next()) {
					bean = new ArticleBean();
					bean.setA_id(rs.getInt(1));
					bean.setM_id(rs.getInt(2));						
					bean.setA_block(rs.getString(3));
					bean.setA_title(rs.getString(4));
					bean.setA_createTime(rs.getTimestamp(5));
					list.add(bean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArticleBean selectArticleByA_id(int a_id) {
		ArticleBean userBean = null;
		try (
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement("select * from a_head where a_id = ?");
		) {
			stmt.setInt(1, a_id);
			try (
				ResultSet rs = stmt.executeQuery();
			) {
				if (rs.next()) {
					userBean = new ArticleBean();
					userBean.setA_id(rs.getInt(1));
					userBean.setM_id(rs.getInt(2));						
					userBean.setA_block(rs.getString(3));
					userBean.setA_title(rs.getString(4));
					userBean.setA_createTime(rs.getTimestamp(5));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userBean;
	}
	
	public List<ArticleBean> selectByBlock(String a_block) {
		ArrayList<ArticleBean> list = new ArrayList<>();
		ArticleBean articleBean = null;
		try (
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement("select * from a_head where a_block = ? order by a_id");
		) {
			stmt.setString(1, a_block);
			try (
				ResultSet rs = stmt.executeQuery();
			) {
				while (rs.next()) {
					articleBean = new ArticleBean();
					articleBean.setA_id(rs.getInt(1));
					articleBean.setM_id(rs.getInt(2));						
					articleBean.setA_block(rs.getString(3));
					articleBean.setA_title(rs.getString(4));
					articleBean.setA_createTime(rs.getTimestamp(5));
					list.add(articleBean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public InputStream selectImage(int a_id){
		InputStream is = null;
		try (
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select a_image from a_head where a_id=?");
		){
			pstmt.setInt(1, a_id);
			try(
				ResultSet rs = pstmt.executeQuery();
			){
				if (rs.next()){
					is = rs.getBinaryStream(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}
}
