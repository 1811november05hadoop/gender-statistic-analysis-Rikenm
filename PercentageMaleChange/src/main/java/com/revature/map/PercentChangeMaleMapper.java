package com.revature.map;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.hadoop.io.DoubleWritable;
//import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PercentChangeMaleMapper extends Mapper<LongWritable, Text, Text,DoubleWritable>{
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException  {
		
		
		
		
		String line = value.toString();
		
		//splits on any white space
		
		
		String[] words = line.split("\",");
		
		//from 2000 to 2015 
		boolean flag = false;
		if(line.matches("(.*)SL.EMP.TOTL.SP.MA.NE.ZS(.*)")){
			
				
				String initialData = words[44].replace("\"", "");
				String finalData = words[59].replace("\"", "");
				String country = words[0].replace("\"", "");
			    
				System.out.println(country+" "+initialData+ ".." +finalData);
				
				
				
				if(!initialData.equals("") && !finalData.equals("")){
				    
					
				
					
					context.write(new Text(country),new DoubleWritable((Float.parseFloat(finalData) - Float.parseFloat(initialData) )));
	
		}
		

		
	}
		
		
				
		}
		
		
		
		
		
	
}
