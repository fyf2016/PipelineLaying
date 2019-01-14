package com.dao.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import com.dao.OutputDataDAO;

public class OutputDataDAOImpl implements OutputDataDAO {

	@Override
	public void exportData(String[] Result) {
		OutputStream fos;
		try {
			fos = new FileOutputStream("D:\\finalPlan.txt");
			Writer os;
			try {
				os = new OutputStreamWriter(fos,"utf-8");
				PrintWriter pw = new PrintWriter(os);
				for(String s:Result)
				{
					pw.println(s);
				}
				
				pw.close();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
		

	}

}
