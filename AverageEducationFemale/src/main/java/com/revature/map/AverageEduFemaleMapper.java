package com.revature.map;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.hadoop.io.DoubleWritable;
//import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AverageEduFemaleMapper extends Mapper<LongWritable, Text, Text,DoubleWritable>{
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException  {
		
		
		
		
		String line = value.toString();
		
		//splits on any white space
		

		
		
		int innerCount = 0; 
		float previous = 0;
		int outerCount = 1;
		boolean flag = false;
		String[] words = line.split("\",");
		
	
		
		if(line.matches("(.*)SE.TER.CMPL.FE.ZS(.*)")){
			//System.out.println(line);
			
			for (int i = 44 ; i < words.length; i++) {
				
								String word = words[i];
								String country = words[0].replace("\"", "");
							
								if(!word.equals("\"") && country.equals("United States")){
								    
									System.out.println(country+" "+word);
									String valueWithoutQuotes = word.replace("\"", "");
									if(innerCount >= 1){

										context.write(new Text(country),new DoubleWritable((Float.parseFloat(valueWithoutQuotes) - previous)/outerCount));
										
									}
									previous = Float.parseFloat(valueWithoutQuotes);
									
									outerCount = 1;
									innerCount++;
									
								}else{
									
									outerCount++;
									
								}
								
			}
				
		}
		
		
		
		
		
		
	}
}
