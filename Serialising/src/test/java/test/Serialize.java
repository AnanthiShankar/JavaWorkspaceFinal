package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rectangle rect=new rectangle(5,4);
		System.out.println(rect.area());
		System.out.println(rect.perimeter());
		serializeToFile(rect,"rectserialized");
		

	}
	public static void serializeToFile(Object classObject,String fileName)  {
		try {
			FileOutputStream file1=new FileOutputStream(fileName);
			ObjectOutputStream os=new ObjectOutputStream(file1);
			os.writeObject(classObject);
			os.close();
			file1.close();
			
		}catch(FileNotFoundException e){
			
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
