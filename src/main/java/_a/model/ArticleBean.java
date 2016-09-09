package _a.model;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;

public class ArticleBean {
	
	private int a_id;
	private int m_id;
	private String a_block;
	private String a_title;
	private Timestamp a_createTime;
	private InputStream a_image;
		
	public ArticleBean() {
	}

	public ArticleBean(int m_id, String a_block, String a_title,
			InputStream a_image) {
		super();
		this.m_id = m_id;
		this.a_block = a_block;
		this.a_title = a_title;
		this.a_image = a_image;
	}
	
	
	public ArticleBean(int m_id, String a_block, String a_title,
			Timestamp a_createTime, InputStream a_image) {
		super();
		this.m_id = m_id;
		this.a_block = a_block;
		this.a_title = a_title;
		this.a_createTime = a_createTime;
		this.a_image = a_image;
	}

	public ArticleBean(int a_id, int m_id, String a_block, String a_title, Timestamp a_createTime, InputStream a_image) {
		super();
		this.a_id = a_id;
		this.m_id = m_id;
		this.a_block = a_block;
		this.a_title = a_title;
		this.a_createTime = a_createTime;
		this.a_image = a_image;
	}

	public int getA_id() {
		return a_id;
	}


	public void setA_id(int a_id) {
		this.a_id = a_id;
	}


	public int getM_id() {
		return m_id;
	}


	public void setM_id(int m_id) {
		this.m_id = m_id;
	}


	public String getA_block() {
		return a_block;
	}


	public void setA_block(String a_block) {
		this.a_block = a_block;
	}

	public String getA_title() {
		return a_title;
	}

	public void setA_title(String a_title) {
		this.a_title = a_title;
	}

	public Timestamp getA_createTime() {
		return a_createTime;
	}


	public void setA_createTime(Timestamp a_createTime) {
		this.a_createTime = a_createTime;
	}

	public InputStream getA_image() {
		return a_image;
	}

	public void setA_image(InputStream a_image) {
		this.a_image = a_image;
	}
}