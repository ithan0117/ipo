package _m.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class MemberBean implements Serializable{
	private static final long serserialVersionUID = 1L;
	
	private int m_id;
	private String m_account;
	private String m_password;
	private String m_nickname;
	private Timestamp m_createTime;
	private boolean m_pass;
	
	public MemberBean(){
		super();
	}

	public MemberBean(String m_account, String m_password, String m_nickname) {
		super();
		this.m_account = m_account;
		this.m_password = m_password;
		this.m_nickname = m_nickname;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public String getM_account() {
		return m_account;
	}

	public void setM_account(String m_account) {
		this.m_account = m_account;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public String getM_nickname() {
		return m_nickname;
	}

	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}

	public Timestamp getM_createTime() {
		return m_createTime;
	}

	public void setM_createTime(Timestamp m_createTime) {
		this.m_createTime = m_createTime;
	}

	public boolean getM_pass() {
		return m_pass;
	}

	public void setM_pass(boolean m_pass) {
		this.m_pass = m_pass;
	}

	public static long getSerserialversionuid() {
		return serserialVersionUID;
	}
	
}
