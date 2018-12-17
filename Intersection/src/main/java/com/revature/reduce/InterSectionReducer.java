package com.revature.reduce;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class InterSectionReducer extends Reducer<Text, DoubleWritable, Text, Text> {
	
	public void reduce(Text key, Iterable<DoubleWritable> values, Context context) 
			throws IOException, InterruptedException {
		
		
		int count = 0; 
		
		
		for (DoubleWritable value : values ) {
			//need o unbox the int from the IntWritable
			
			count++;
			System.out.println(count);
	
		}
		
		if(count==2){
			context.write(key, new Text(""));
			
		}
		
		
		
	}
	


}
