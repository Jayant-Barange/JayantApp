package com.truyum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="Menu_Item")
public class MenuItem {
	
	@Id
	@Column(name="item_id")
	private int itemid;
	@Column(name="item_type",length=20)
	private String itemtype;
	@Column(name="item_name",length=20)
	private String itemname;
	@Column(name="item_price")
	private int itemprice;
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getItemtype() {
		return itemtype;
	}
	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getItemprice() {
		return itemprice;
	}
	public void setItemprice(int itemprice) {
		this.itemprice = itemprice;
	}
	public MenuItem(int itemid, String itemtype, String itemname, int itemprice) {
		super();
		this.itemid = itemid;
		this.itemtype = itemtype;
		this.itemname = itemname;
		this.itemprice = itemprice;
	}
	public MenuItem() {
		super();
	}
	

}
