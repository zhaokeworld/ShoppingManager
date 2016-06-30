package cn.zhaokeworld.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import cn.zhaokeworld.market.Good;
import cn.zhaokeworld.market.Market;

/**
 * 加载保存商品列表和商品库存的工具
 * @author zhaoke
 *
 */
public class LoadGoods {

	/**
	 * 加载商品列表
	 * @return 商品列表
	 */
	public static Map<Integer, Good> getGoodsList(){
		
		Map<Integer, Good> goodsList = null;
		File f = new File("config/goodsList.dat");
		if(!f.exists())
			return new HashMap<Integer, Good>();
		try(
				FileInputStream in0 = new FileInputStream("config/goodsList.dat");
				ObjectInputStream in = new ObjectInputStream(in0);	
				){
			Object o = in.readObject();
			if(o instanceof Map)
				goodsList = (Map<Integer, Good>)o;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goodsList;
	}
	
	/**
	 * 加载库存列表
	 * @return 库存列表
	 */
	public static Map<Integer, Integer> getGoodStock(){
		
		Map<Integer, Integer> goodStock = null;
		File f = new File("config/goodStock.dat");
		if(!f.exists())
			return new HashMap<Integer, Integer>();
		try(
				FileInputStream in0 = new FileInputStream(f);
				ObjectInputStream in = new ObjectInputStream(in0);	
				){
			Object o = in.readObject();
			if(o instanceof Map)
				goodStock = (Map<Integer, Integer>)o;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goodStock;
	}
	
	/**
	 * 保存现有的商品列表
	 */
	public static void saveGoodsList(){
		try(
				FileOutputStream out0 = new FileOutputStream("config/goodsList.dat");
				ObjectOutputStream out = new ObjectOutputStream(out0);
				){
			out.writeObject(Market.getMarketInstance().getGoodsList());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 保存现有的库存表
	 */
	public static void saveGoodStock(){
		try(
				FileOutputStream out0 = new FileOutputStream("config/goodStock.dat");
				ObjectOutputStream out = new ObjectOutputStream(out0);
				){
			out.writeObject(Market.getMarketInstance().getGoodStock());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
