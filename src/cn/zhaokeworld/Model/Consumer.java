package cn.zhaokeworld.Model;

import java.io.Serializable;

public class Consumer implements Serializable {

	private static final long serialVersionUID = -5484114413708190636L;
	private String id;
	private Car car = new Car();
	public Consumer(String id){
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public Car getCar() {
		return car;
	}
}
