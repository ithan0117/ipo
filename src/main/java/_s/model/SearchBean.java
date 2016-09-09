package _s.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class SearchBean implements Serializable{
	private static final long serserialVersionUID = 1L;
	
	private int s_id;				//尋覓文章自動編碼
	private int a_id;				//文章識別
	private String s_type;			//頁面識別(l,f)
	private String s_name;			//聯絡人
	private String s_conn;			//電話/信箱
	private Timestamp s_time;		//發生時間
	private String s_location;		//地點
	private String s_desc;			//描述	
	private double s_lat;			//緯度
	private double s_lng;			//經度
	private String s_pet_type;		//寵物種類(c,d,o)
			
	public SearchBean() {
		super();
	}
	
	public SearchBean(int s_id, int a_id, String s_type, String s_name, String s_conn, Timestamp s_time,
			String s_location, String s_desc, double s_lat, double s_lng, String s_pet_type) {
		super();
		this.s_id = s_id;
		this.a_id = a_id;
		this.s_type = s_type;
		this.s_name = s_name;
		this.s_conn = s_conn;
		this.s_time = s_time;
		this.s_location = s_location;
		this.s_desc = s_desc;
		this.s_lat = s_lat;
		this.s_lng = s_lng;
		this.s_pet_type = s_pet_type;
	}

	public SearchBean(int a_id, String s_type, String s_name, String s_conn, Timestamp s_time, String s_location,
			String s_desc, double s_lat, double s_lng, String s_pet_type) {
		super();
		this.a_id = a_id;
		this.s_type = s_type;
		this.s_name = s_name;
		this.s_conn = s_conn;
		this.s_time = s_time;
		this.s_location = s_location;
		this.s_desc = s_desc;
		this.s_lat = s_lat;
		this.s_lng = s_lng;
		this.s_pet_type = s_pet_type;
	}

	public SearchBean(int a_id, String s_name, String s_conn, Timestamp s_time, String s_location, String s_desc) {
		super();
		this.a_id = a_id;
		this.s_name = s_name;
		this.s_conn = s_conn;
		this.s_time = s_time;
		this.s_location = s_location;
		this.s_desc = s_desc;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public String getS_type() {
		return s_type;
	}

	public void setS_type(String s_type) {
		this.s_type = s_type;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_conn() {
		return s_conn;
	}

	public void setS_conn(String s_conn) {
		this.s_conn = s_conn;
	}

	public Timestamp getS_time() {
		return s_time;
	}

	public void setS_time(Timestamp s_time) {
		this.s_time = s_time;
	}

	public String getS_location() {
		return s_location;
	}

	public void setS_location(String s_location) {
		this.s_location = s_location;
	}

	public String getS_desc() {
		return s_desc;
	}

	public void setS_desc(String s_desc) {
		this.s_desc = s_desc;
	}

	public double getS_lat() {
		return s_lat;
	}

	public void setS_lat(double s_lat) {
		this.s_lat = s_lat;
	}

	public double getS_lng() {
		return s_lng;
	}

	public void setS_lng(double s_lng) {
		this.s_lng = s_lng;
	}

	public String getS_pet_type() {
		return s_pet_type;
	}

	public void setS_pet_type(String s_pet_type) {
		this.s_pet_type = s_pet_type;
	}
}
