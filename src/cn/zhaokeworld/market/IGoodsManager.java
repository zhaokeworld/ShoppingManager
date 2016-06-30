package cn.zhaokeworld.market;

public interface IGoodsManager {

	/**
	 * 新增商品
	 */
	public void createNewGood();
	
	/**
	 * 列出商品列表及库存表
	 */
	public boolean printGoodsList();
	
	/**
	 * 修改商品数量
	 * @param isadd 增减标识，true为增
	 * @param count 偏移量
	 */
	public void alertStock(int id, int count, boolean isadd);
	
	/**
	 * 用户登录
	 * @param id 用户名
	 * @param passwd 密码
	 */
	public boolean login(String id, String passwd);
	
}
