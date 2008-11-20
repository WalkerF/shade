package com.shade.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class Config {

	private Properties props = new Properties();
	
	public Config(String file)
	{
		try {
			props.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//not necessary if public
	public  void Initialize(String file)
	{
		try {
			props.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Load the new properties, and put them all in props
	 * Not necessary if single file for everything
	 */
	public void AddPropertiesFile(String file)
	{
		Properties newprops = new Properties();
		try {
			newprops.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<Object> s = newprops.keySet();
		Iterator<Object> i = s.iterator();
		String key,value;
		while(i.hasNext())
		{
			key = i.next().toString();
			value = newprops.getProperty(key);
		   if(props.containsKey(key))
		      props.setProperty(key, value);
		   else
			  props.put(key, value);
		}
	}
	
	public int GetInt(String name)
	{
	   if(props.containsKey(name))
		   return Integer.parseInt(props.getProperty(name));
	   else return 0;
	}
	public double GetDouble(String name)
	{
		if(props.containsKey(name))
			return Double.parseDouble(props.getProperty(name));
		return 0;
	}
	public String GetString(String name)
	{
	   if(props.containsKey(name))
		   return props.getProperty(name);
	   else return null;
	}
	public float GetFloat(String name)
	{
	   if(props.containsKey(name))
		   return Float.parseFloat(props.getProperty(name));
	   return 0;
	}
	public String[] GetStringArray(String name)
	{
		if(props.containsKey(name))
			return props.getProperty(name).split(",");
		return null;
	}
	public Object[] GetObjectArray(String name)
	{
		if(props.containsKey(name))
		{
			String[] temp = props.getProperty(name).split(",");
			Object[] toReturn = new Object[temp.length];
			for(int i=0;i<toReturn.length;i++)
			{
				toReturn[i] = temp[i];
			}
			return toReturn;
		}
		return null;
	}

		
}
