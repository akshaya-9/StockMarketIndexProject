package com.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
@Entity
public class BSE {
	
    @Id
	private java.util.Date date;
	private double open;
	private double high;
	private double low ;
	private double close;
	private double adjCLose;
	private double volume;
	public BSE(){
		
	}
	public BSE(Date date, double open, double high, double low, double close, double adjCLose,  double volume) {
		super();
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.adjCLose = adjCLose;
		this.volume = volume;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public double getAdjCLose() {
		return adjCLose;
	}
	public void setAdjCLose(double adjCLose) {
		this.adjCLose = adjCLose;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume( double volume) {
		this.volume = volume;
	}

}

