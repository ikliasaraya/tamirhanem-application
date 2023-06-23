package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import helper.DbConnection;

public class Customer {
	
	private int customerId;
	private int customerUserIdFk;
	private int customerUserTypeIfFk;
	private String customerName;
	private String customerSurname;
	private String customerPhone;
	private Date customerRegisterDate;
	private int customerCityIdFk;
	private int customerDistrictIdFk;
	
	public int addDbCustomer() throws SQLException {
		Connection conn = DbConnection.getConnection();
		String sql = "INSERT INTO tamirhanemdb.customer (customer_useridfk, customer_usertypeidfk, customer_name, customer_surname, customer_phone, customer_cityidfk, customer_districtidfk) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, this.customerUserIdFk);
		st.setInt(2, this.customerUserTypeIfFk);
		st.setString(3, this.customerName);
		st.setString(4, this.customerSurname);
		st.setString(5, this.customerPhone);
		st.setInt(6, this.customerCityIdFk);
		st.setInt(7,  this.customerDistrictIdFk);
		int query = st.executeUpdate();
		conn.close();
		if(query > 0) {
			System.out.println("customer olustu");
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCustomerUserIdFk() {
		return customerUserIdFk;
	}
	public void setCustomerUserIdFk(int customerUserIdFk) {
		this.customerUserIdFk = customerUserIdFk;
	}
	public int getCustomerUserTypeIfFk() {
		return customerUserTypeIfFk;
	}
	public void setCustomerUserTypeIfFk(int customerUserTypeIfFk) {
		this.customerUserTypeIfFk = customerUserTypeIfFk;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerSurname() {
		return customerSurname;
	}
	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public Date getCustomerRegisterDate() {
		return customerRegisterDate;
	}
	public void setCustomerRegisterDate(Date customerRegisterDate) {
		this.customerRegisterDate = customerRegisterDate;
	}
	public int getCustomerCityIdFk() {
		return customerCityIdFk;
	}
	public void setCustomerCityIdFk(int customerCityIdFk) {
		this.customerCityIdFk = customerCityIdFk;
	}
	public int getCustomerDistrictIdFk() {
		return customerDistrictIdFk;
	}
	public void setCustomerDistrictIdFk(int customerDistrictIdFk) {
		this.customerDistrictIdFk = customerDistrictIdFk;
	}
}
