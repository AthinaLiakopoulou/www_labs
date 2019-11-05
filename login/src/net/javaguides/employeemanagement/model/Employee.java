package net.javaguides.employeemanagement.model;

import java.io.Serializable;

/**
 * JavaBean class used in jsp action tags.
 * @author Ramesh Fadatare
 */
public class Employee implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

