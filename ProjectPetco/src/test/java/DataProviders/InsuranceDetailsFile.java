package DataProviders;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class InsuranceDetailsFile {
	private Properties prop;
	private String propertyPath = "configs//Details.properties";
	
	public void ConfigFileReader() {
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
		public String getPetName() {
			final String petName=prop.getProperty("petname");
			//System.out.prntln(petName);
			if (petName!= null ) return petName;
			else throw new RuntimeException("petName property Not found");
			
			}
		public String getZipCode() {
			String zipCode=prop.getProperty("zipCode");
			if (zipCode!= null ) return zipCode;
			else throw new RuntimeException("zipCode property Not found");
			
			}
	
	
	}
}


		
