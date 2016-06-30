package cn.zhaokeworld.market;

import cn.zhaokeworld.Model.Car;

public interface IConsumerManager {

	/**
	 * 列出商品列表及库存表
	 */
	public boolean printGoodsList();
	
	/**
	 * 用户注册
	 * @param id 用户名
	 * @param passwd 密码
	 * @return 状态信息
	 */
	public String register(String id, String passwd);
	
	/**
	 * 用户登录
	 * @param id 用户名
	 * @param passwd 密码
	 */
	public boolean login(String id, String passwd);
	
	/**
	 * 结账
	 * @param car 用户的购物车
	 * @return 所有金额
	 */
	public float settle(Car car);
	
	/**
	 * 添加商品到购物车
	 * @param car 用户购物车
	 * @param id 商品编号
	 * @param count 商品数量
	 */
	public void addGood(Car car, int id, int count);
	
}
