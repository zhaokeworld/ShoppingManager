package cn.zhaokeworld.market;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import cn.zhaokeworld.Model.Car;
import cn.zhaokeworld.util.LoadGoods;
import cn.zhaokeworld.util.UserManager;
/**
 * 商场类，描述了一个完整的商场系统
 * @author zhaoke
 *
 */
public class Market implements IGoodsManager, IConsumerManager {

	private Map<Integer, Good> goodsList  = null; //商品列表
	private Map<Integer, Integer> goodStock = null;//库存列表

	private static Market instance = new Market();
	
	private Market(){};
	
	static{
		instance.init();
	}
	public static Market getMarketInstance(){
		return instance;
	}
	
	public Map<Integer, Good> getGoodsList() {
		return goodsList;
	}
	
	public Map<Integer, Integer> getGoodStock() {
		return goodStock;
	}
	
	/**
	 * 初始化商品列表和库存表
	 */
	public void init(){
		goodsList = LoadGoods.getGoodsList();
		goodStock = LoadGoods.getGoodStock();
	}
	
	/**
	 * 打印商品列表及库存
	 */
	@Override
	public boolean printGoodsList(){
		if(goodsList.size()==0){
			System.out.println("目前还没有商品");
			return false;
		}
		System.out.println("商品编号\t商品名称\t单价\t库存量");
		for(int i : goodsList.keySet())
			System.out.println(goodsList.get(i).getId()+"\t"+goodsList.get(i).getName()+"\t"+goodsList.get(i).getPrice()+"\t"+this.goodStock.get(i));
		return true;
	}
	
	private void createNewGood0(Good good, int count){
		goodsList.put(good.getId(), good);
		goodStock.put(good.getId(), count);
	}
	
	/**
	 * 新增商品
	 */
	@SuppressWarnings("resource")
	@Override
	public void createNewGood() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入商品编号、商品名称、单价、库存量，空格隔开");
		Good good = new SmallFood(sc.nextInt(), sc.next(), sc.nextFloat());
		createNewGood0(good, sc.nextInt());
		
	}
	
	/**
	 * 修改商品数量
	 * @param id 商品编号
	 * @param count 偏移量
	 * @param isadd 增减标识，true为增
	 */
	@Override
	public void alertStock(int id, int count, boolean isadd) {
		int sum = goodStock.get(id);
		if(isadd)
			sum += count;
		else
			sum -= count;
		goodStock.put(id, sum);
	}
	
	/**
	 * 用户注册
	 * @param id 用户名
	 * @param passwd 密码
	 */
	@Override
	public String register(String id, String passwd) {
		// TODO Auto-generated method stub
		if(UserManager.register(id, passwd))
			return "注册成功";
		else
			return "重复的用户名，请重新输入";
	}
	
	/**
	 * 用户登录
	 * @param id 用户名
	 * @param passwd 密码
	 */
	@Override
	public boolean login(String id, String passwd) {
		// TODO Auto-generated method stub
		return UserManager.checkUser(id, passwd);
	}
		
	/**
	 * 结账
	 * @param car 用户的购物车
	 * @return 所有金额
	 */
	@Override
	public float settle(Car car) {
		// TODO Auto-generated method stub
		float sum = 0;
		Map<Integer, Good> goodsList0 = car.getGoodsList();
		Map<Integer, Integer> goodCount0 = car.getGoodCount();
		car.getGoodCount();
		for(int i : goodsList0.keySet()){
			sum += goodsList0.get(i).getPrice() * goodCount0.get(i);
			alertStock(i, goodCount0.get(i), false);
		}
		car.clear();
		return sum;
	}
	
	/**
	 * 添加商品到购物车
	 * @param car 用户购物车
	 * @param id 商品编号
	 * @param count 商品数量
	 */
	@Override
	public void addGood(Car car, int id, int count) {
		// TODO Auto-generated method stub
		if(goodsList.get(id)==null){
			System.out.println("您输入的商品编号不存在，请重新输入");
			return;
		}
		if(car.getGoodsList().get(id)!=null){
			car.getGoodCount().put(id, (count+car.getGoodCount().get(id)));
		}else{
			car.getGoodsList().put(id, this.goodsList.get(id));
			car.getGoodCount().put(id, count);
		}
	}
	
	public void destory(){
		LoadGoods.saveGoodsList();
		LoadGoods.saveGoodStock();
		UserManager.saveProperties();
		System.exit(0);
	}
	
}
