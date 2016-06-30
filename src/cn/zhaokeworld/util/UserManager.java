package cn.zhaokeworld.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class UserManager {

	private static Properties properties = new Properties();
	static{
		File f = new File("config/user.properties");
		FileInputStream in;
		try {
			if(!f.exists())
				f.createNewFile();
			in = new FileInputStream(f);
			properties.load(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean checkUser(String id, String passwd){
		if(properties.getProperty(id)!=null&&properties.getProperty(id).equals(passwd))
			return true;
		else
			return false;
	}
	
	public static boolean register(String id, String passwd){
		if(properties.getProperty(id)!=null)
			return false;
		properties.setProperty(id, passwd);
		return true;
	}
	
	public static void saveProperties(){
		FileOutputStream out;
		try {
			out = new FileOutputStream("config/user.properties");
			properties.store(out, null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
