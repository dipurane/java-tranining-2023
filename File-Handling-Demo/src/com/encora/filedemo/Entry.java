package com.encora.filedemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Entry {

	public static void main(String[] args)  {
		// new File("c:\\file-demo\data.txt")
		File f = new File("/Users/synerzip/Desktop/file-demo/data.txt");
		
	/*	if(f.exists()) {
			System.out.println("File is present I am going to delete it");
			//f.delete();
			System.out.println(f.getAbsolutePath());
			
		}else {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		
		try {
			FileOutputStream fos = new FileOutputStream(f);
			fos.write("This is my first content into the file \n".getBytes());
			fos.write("This is my Second content into the file".getBytes());
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis = new FileInputStream(f);
			int length = fis.read();
			byte b[] = new byte[length+1];
			fis.read(b);
			String s = new String(b);
			//System.out.println(s);
			FileReader reader = new FileReader(f);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = null;
			do {
				line = bufferedReader.readLine();
				if(line!=null)
				System.out.println(line);
			}while(line!=null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
