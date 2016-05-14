package com.shareniu.dao.entity;



/**
 * TUserEntity BaseEntity
 * @author system
 */
public class UserEntity{
	/**
     * 
     */
	private int id;
	/**
     * 
     */
	private String username;
	/**
     * 
     */
	private String password;
	/**
     * 
     */
	private String mobileno;
	/**
     * 
     */
	private String email;
	/**
     * 状态
     */
	private int satatus;	
	/**
     * 
     */
	private String usertype;
	/**
     * 
     */
	private String salt;
    
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getMobileno(){
		return mobileno;
	}
	public void setMobileno(String mobileno){
		this.mobileno = mobileno;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public int getSatatus(){
		return satatus;
	}
	public void setSatatus(int satatus){
		this.satatus = satatus;
	}
	public String getUsertype(){
		return usertype;
	}
	public void setUsertype(String usertype){
		this.usertype = usertype;
	}
	public String getSalt(){
		return salt;
	}
	public void setSalt(String salt){
		this.salt = salt;
	}
}