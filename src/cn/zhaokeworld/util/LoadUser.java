package cn.zhaokeworld.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cn.zhaokeworld.Model.Consumer;

public class LoadUser {

	public static void saveUser(Consumer consumer){
		try (
				FileOutputStream out0 = new FileOutputStream("config/"+consumer.getId()+".dat");
				ObjectOutputStream out = new ObjectOutputStream(out0);
				){
			out.writeObject(consumer);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Consumer loadUser(String id){
		File f = new File("config/"+id+".dat");
		if(!f.exists())
			return null;
		try(
				FileInputStream in0 = new FileInputStream(f);
				ObjectInputStream in = new ObjectInputStream(in0);
				) {
			Consumer consumer = (Consumer)in.readObject();
			return consumer;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
