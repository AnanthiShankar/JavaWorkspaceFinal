package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Deserialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rectangle dsr1=(rectangle) deSerializefromFileToObject("rectserialized");
		
		System.out.println(dsr1.area());
		System.out.println(dsr1.perimeter());
		
		

	}
	public static Object deSerializefromFileToObject(String fileName)  {
		try {
			FileInputStream fis=new FileInputStream(new File(fileName));
			ObjectInputStream ois=new ObjectInputStream(fis);
			Object dso=ois.readObject();
			//dso.writeObject(dso);
			ois.close();
			fis.close();
			return dso;
			
		}catch(FileNotFoundException e){
			
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
		
	}

