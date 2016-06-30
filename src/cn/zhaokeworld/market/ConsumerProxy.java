package cn.zhaokeworld.market;

import java.util.Scanner;

import cn.zhaokeworld.Model.Consumer;
import cn.zhaokeworld.util.LoadUser;

public class ConsumerProxy {

	private static Consumer consumer = null;
	private static IConsumerManager handler = Market.getMarketInstance();
	
	@SuppressWarnings("resource")
	public static void register(){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String id = sc.next();
		System.out.println("请输入密码：");
		String passwd = sc.next();
		System.out.println(handler.register(id, passwd));
	}
	
	@SuppressWarnings("resource")
	public static boolean login(){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String id = sc.next();
		System.out.println("请输入密码：");
		String passwd = sc.next();
		if(!handler.login(id, passwd)){
			System.out.println("用户名或密码错误，请重新登录");
			return false;
		}
		else{
			consumer = LoadUser.loadUser(id);
			if(consumer==null)
				consumer = new Consumer(id);
			System.out.println("登录成功");
			return true;
		}
	}

	@SuppressWarnings("resource")
	public static void printMenu() {
		// TODO Auto-generated method stub
		while(true){
			System.out.println("1、选购商品");
			System.out.println("2、查看购物车");
			System.out.println("3、结账");
			System.out.println("4、退出");
			Scanner sc = new Scanner(System.in);
			switch (sc.nextInt()) {
				case 1:
					buyshopping();
					break;
				case 2:
					showCar();
					break;
				case 3:
					settle();
					break;
				case 4:
					exit();
					break;
				default:
					break;
			}
		}
	}

	private static void exit() {
		// TODO Auto-generated method stub
		LoadUser.saveUser(consumer);
		Market.getMarketInstance().destory();
	}

	private static void settle() {
		// TODO Auto-generated method stub
		Market.getMarketInstance().settle(consumer.getCar());
	}

	private static void showCar() {
		// TODO Auto-generated method stub
		consumer.getCar().printCar();
	}

	private static void buyshopping() {
		// TODO Auto-generated method stub
		if(!handler.printGoodsList())
			return;
		System.out.println("请输入您要购买的商品编号以及数量，空格隔开：");
		Scanner sc = new Scanner(System.in);
		handler.addGood(consumer.getCar(), sc.nextInt(), sc.nextInt());
	}

//	public static void setConsumer(Consumer consumer) {
//		ConsumerProxy.consumer = consumer;
//	}
}
