package com.revature.reduce;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text, DoubleWritable, Text, Text> {
	
	public void reduce(Text key, Iterable<DoubleWritable> values, Context context) 
			throws IOException, InterruptedException {
		
		
		
		String sb = new String();
	
		for (DoubleWritable value : values ) {
			//need o unbox the int from the IntWritable
			
			

			sb += value.get()+" ";
			
				
		}
		
		

		context.write(key, new Text(sb));
	
	}

}
