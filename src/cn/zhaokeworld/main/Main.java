package cn.zhaokeworld.main;

import java.util.Scanner;

import cn.zhaokeworld.market.AdminProxy;
import cn.zhaokeworld.market.ConsumerProxy;
import cn.zhaokeworld.market.Market;
import cn.zhaokeworld.util.LoadGoods;

public class Main {

	public static void main(String[] args){
//		Market market = Market.getMarketInstance();
		
		printMainMenu();
//		printConsuserMenu();
//		market.getGoodsList().put(123, new SmallFood(123, "卫龙", 0.5f));
//		market.getGoodStock().put(123, 12);
//		market.printGoodsList();
//		LoadGoods.saveGoodsList();
//		LoadGoods.saveGoodStock();
		
		
		Market.getMarketInstance().destory();
	}

	@SuppressWarnings("resource")
	public static void printMainMenu(){
		System.out.println("1、用户入口");
		System.out.println("2、管理员入口");
		Scanner sc = new Scanner(System.in);
		switch(sc.nextInt()){
			case 1:
				printConsuserMenu();
				break;
			case 2:
				if(!AdminProxy.login())
					printMainMenu();
				else
					AdminProxy.printMenu();
				break;
			default:
				break;
		}
	}

	@SuppressWarnings("resource")
	private static void printConsuserMenu() {
		// TODO Auto-generated method stub
		System.out.println("1、注册新用户");
		System.out.println("2、登录");
		System.out.println("3、退出");
		Scanner sc = new Scanner(System.in);
		switch(sc.nextInt()){
			case 1:
				ConsumerProxy.register();
				printConsuserMenu();
				break;
			case 2:
				if(!ConsumerProxy.login())
					printConsuserMenu();
				else
					ConsumerProxy.printMenu();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				break;
		}
	}
	
}
