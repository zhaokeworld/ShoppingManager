package cn.zhaokeworld.Model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.zhaokeworld.market.Good;

public class Car implements Serializable{

	private static final long serialVersionUID = 1376642335684457906L;
	private Map<Integer, Good> goodsList  = new HashMap<Integer, Good>(); //商品列表
	private Map<Integer, Integer> goodCount = new HashMap<Integer, Integer>();//商品数量
	
	public Map<Integer, Good> getGoodsList() {
		return goodsList;
	}
	public Map<Integer, Integer> getGoodCount() {
		return goodCount;
	}
	
	public void printCar(){
		if(goodsList.size()!=0){
			System.out.println("商品编号\t商品名称\t单价\t库存量");
			float sum = 0;
			for(int i : goodsList.keySet()){
				System.out.println(goodsList.get(i).getId()+"\t"+goodsList.get(i).getName()+"\t"+goodsList.get(i).getPrice()+"\t"+this.goodCount.get(i));
				sum += goodsList.get(i).getPrice() * goodCount.get(i);
			}
			System.out.println("总价："+sum);
		}else
			System.out.println("您的购物车空空如也");
	}
	public void clear() {
		// TODO Auto-generated method stub
		goodsList.clear();
		goodCount.clear();
	}
}
