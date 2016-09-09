package _h.model;

import java.sql.Timestamp;

public class HomelessBean {

	private int h_id;
	private int a_id;
	private String h_area;
	private String h_pet_type;
	private String h_age;
	private String h_pet_color;
	private String h_name;
	private Timestamp h_time;
	private String h_desc;
	private double h_lat;
	private double h_lng;
	
	public HomelessBean() {
		
	}

	public HomelessBean(int a_id, String h_area, String h_pet_type, String h_age,
			String h_pet_color, String h_name, Timestamp h_time, String h_desc,
			double h_lat, double h_lng) {
		super();
		this.a_id = a_id;
		this.h_area = h_area;
		this.h_pet_type = h_pet_type;
		this.h_age = h_age;
		this.h_pet_color = h_pet_color;
		this.h_name = h_name;
		this.h_time = h_time;
		this.h_desc = h_desc;
		this.h_lat = h_lat;
		this.h_lng = h_lng;
	}

	public int getH_id() {
		return h_id;
	}

	public void setH_id(int h_id) {
		this.h_id = h_id;
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public String getH_area() {
		return h_area;
	}

	public void setH_area(String h_area) {
		this.h_area = h_area;
	}

	public String getH_pet_type() {
		return h_pet_type;
	}

	public void setH_pet_type(String h_pet_type) {
		this.h_pet_type = h_pet_type;
	}

	public String getH_age() {
		return h_age;
	}

	public void setH_age(String h_age) {
		this.h_age = h_age;
	}

	public String getH_pet_color() {
		return h_pet_color;
	}

	public void setH_pet_color(String h_pet_color) {
		this.h_pet_color = h_pet_color;
	}

	public String getH_name() {
		return h_name;
	}

	public void setH_name(String h_name) {
		this.h_name = h_name;
	}

	public Timestamp getH_time() {
		return h_time;
	}

	public void setH_time(Timestamp h_time) {
		this.h_time = h_time;
	}

	public String getH_desc() {
		return h_desc;
	}

	public void setH_desc(String h_desc) {
		this.h_desc = h_desc;
	}

	public double getH_lat() {
		return h_lat;
	}

	public void setH_lat(double h_lat) {
		this.h_lat = h_lat;
	}

	public double getH_lng() {
		return h_lng;
	}

	public void setH_lng(double h_lng) {
		this.h_lng = h_lng;
	}
	
	
}
