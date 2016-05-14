package com.shareniu.dao.entity;


import java.math.BigDecimal;

/**
 * TGoodEntity BaseEntity
 * @author system
 */
public class GoodEntity {
	/**
     * 
     */
	private int id;
	/**
     * 
     */
	private String prodname;
	/**
     * 类别id
     */
	private byte[] description;	
	/**
     * 
     */
	private int cId;
	/**
     * 
     */
	private BigDecimal price;
	/**
     * 
     */
	private int socknum;
	/**
     * 
     */
	private String imgurl;
	/**
     * 
     */
	private int soldout;
    
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getProdname(){
		return prodname;
	}
	public void setProdname(String prodname){
		this.prodname = prodname;
	}
	public byte[] getDescription(){
		return description;
	}
	public void setDescription(byte[] description){
		this.description = description;
	}
	public int getCId(){
		return cId;
	}
	public void setCId(int cId){
		this.cId = cId;
	}
	public BigDecimal getPrice(){
		return price;
	}
	public void setPrice(BigDecimal price){
		this.price = price;
	}
	public int getSocknum(){
		return socknum;
	}
	public void setSocknum(int socknum){
		this.socknum = socknum;
	}
	public String getImgurl(){
		return imgurl;
	}
	public void setImgurl(String imgurl){
		this.imgurl = imgurl;
	}
	public int getSoldout(){
		return soldout;
	}
	public void setSoldout(int soldout){
		this.soldout = soldout;
	}
}