package cn.zhaokeworld.market;

import java.util.Scanner;

public class AdminProxy {

	private static IGoodsManager handler = Market.getMarketInstance();
	
	public static boolean login(){
		System.out.println("请输入管理员密码：");
		Scanner sc = new Scanner(System.in);
		if(handler.login("admin", sc.next())){
			System.out.println("登录成功");
			return true;
		}else{
			System.out.println("登录失败，您输入的密码错误");
			return false;
		}
	}

	public static void printMenu() {
		// TODO Auto-generated method stub
		while(true){
			System.out.println("1、新增商品");
			System.out.println("2、增加商品库存");
			System.out.println("3、显示商品列表");
			System.out.println("4、退出");
			Scanner sc = new Scanner(System.in);
			switch (sc.nextInt()) {
				case 1:
					handler.createNewGood();
					break;
				case 2:
					alertStock();
					break;
				case 3:
					handler.printGoodsList();
					break;
				case 4:
					Market.getMarketInstance().destory();
					break;
				default:
					break;
			}
		}
	}

	private static void alertStock() {
		// TODO Auto-generated method stub
		System.out.println("请输入您要增加库存的商品编号及数量，空格隔开");
		Scanner sc = new Scanner(System.in);
		handler.alertStock(sc.nextInt(), sc.nextInt(), true);
	}

}
