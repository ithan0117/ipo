package _m.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	private DataSource ds = null;
	public MemberDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/ipo");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int insertMemeber(MemberBean mb){
		int result = -1;
		try (
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement("insert into m_member (m_account, m_password, m_nickname, m_createTime) values( ? , ? , ? , ?)");
		){
			stmt.setString(1, mb.getM_account());
			stmt.setString(2, mb.getM_password());
			stmt.setString(3, mb.getM_nickname());
			stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			result = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteMember(MemberBean mb){
		int result = -1;
		try (
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement("delete from m_member where m_id = ?");
		){
			stmt.setInt(1, mb.getM_id());
			result = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateMember(MemberBean mb){
		int result = -1;
		try (
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement
					("update m_member set m_password = ?, m_nickname = ?, m_pass = ? where m_account = ?");
		){
			stmt.setString(1, mb.getM_password());
			stmt.setString(2, mb.getM_nickname());
			if(mb.getM_pass()){
				stmt.setInt(3, 1);
			} else {
				stmt.setInt(3, 0);
			}
			stmt.setString(4, mb.getM_account());
			result = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public MemberBean selectMember(MemberBean mb){
		MemberBean temp = null;
		try (
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement
					("select * from m_member where m_account = ?");
		){
			stmt.setString(1, mb.getM_account());
			try (
				ResultSet rs = stmt.executeQuery();
			){
				if(rs.next()){
					temp = new MemberBean();
					temp.setM_id(rs.getInt(1));
					temp.setM_account(rs.getString(2));
					temp.setM_password(rs.getString(3));
					temp.setM_nickname(rs.getString(4));
					temp.setM_createTime(rs.getTimestamp(5));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public List<MemberBean> selectMembers(){
		List<MemberBean> list = new ArrayList<>();
		MemberBean mb = null;
		try (
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement
					("select * from m_member");
			ResultSet rs = stmt.executeQuery();
		){
				while(rs.next()){
					mb = new MemberBean();
					mb.setM_id(rs.getInt(1));
					mb.setM_account(rs.getString(2));
					mb.setM_password(rs.getString(3));
					mb.setM_nickname(rs.getString(4));
					mb.setM_createTime(rs.getTimestamp(5));
					list.add(mb);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return list;
	}
}
