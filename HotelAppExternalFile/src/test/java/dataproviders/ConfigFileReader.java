package dataproviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties prop;
	private String propertyPath = "configs//Configurations.properties";
	
	public ConfigFileReader() {
		BufferedReader reader;
		try{
			reader=new BufferedReader(new FileReader(propertyPath));
			prop=new Properties();
			try {
				prop.load(reader);
				reader.close();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
			throw new RuntimeException("Properties File Not Found");
		}
	}
		
		public String getDriverPath() {
			String driverPath=prop.getProperty("driverPath");
			if (driverPath!= null ) return driverPath;
			else throw new RuntimeException("Driver Path Not found");
			}
		
		public String getAppUrl() {
				String appUrl=prop.getProperty("url");
				
				if (appUrl!= null ) return appUrl;
				else throw new RuntimeException("url property Not found");
			}
		
		
		public String getUsername() {
				String userName=prop.getProperty("username");
				System.out.println(userName);
				if (userName!= null ) return userName;
				else throw new RuntimeException("userName property Not found");
				
			}
		public String getPassword() {
				String passWord=prop.getProperty("password");
				if (passWord!= null ) return passWord;
				else throw new RuntimeException("passWord property Not found");
				
			}
		
	}
	


