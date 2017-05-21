package com.bestbuy.automation.testing.singleton;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

	private static Properties dataProps;
	
	private static Properties elementProps;
	
	private PropertyLoader(){
		
	}
	
	public static Properties getDataProps(){
		if(dataProps == null){
			FileInputStream stream;
			try {
				stream = new FileInputStream("data.properties");
				dataProps = new Properties();
				dataProps.load(stream);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return dataProps;
	}
	
	public static Properties getElementsProps(){
		if(elementProps == null){
			FileInputStream stream;
			try {
				stream = new FileInputStream("elements.properties");
				elementProps = new Properties();
				elementProps.load(stream);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return elementProps;
	}
}
