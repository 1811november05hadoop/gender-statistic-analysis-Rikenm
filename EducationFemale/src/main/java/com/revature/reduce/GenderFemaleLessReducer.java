package com.revature.reduce;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class GenderFemaleLessReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
	
	public void reduce(Text key, Iterable<DoubleWritable> values, Context context) 
			throws IOException, InterruptedException {
		
		double total = 0;
		int count = 0; 
		for (DoubleWritable value : values ) {
			//need o unbox the int from the IntWritable
			total += value.get();
			count++;
			
			
			
		}
		
		double percentage = total/count ;
		
		if(percentage <= 30){
			context.write(key, new DoubleWritable(percentage));
		}
		
		
	}

}
