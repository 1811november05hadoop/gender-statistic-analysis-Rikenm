package com.revature.reduce;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import com.google.common.collect.Lists;

public class PercentChangeFemaleReducer extends Reducer<Text, DoubleWritable, Text, Text> {
	
	public void reduce(Text key, Iterable<DoubleWritable> values, Context context) 
			throws IOException, InterruptedException {
		
		
		
		String sb = new String();
		List list = Lists.newArrayList(values);
		
		
//		
//		Collections.sort(list, new Comparator<String>() {
//	        @Override
//	        public int compare(String o1, String o2) {
//	        	
////	        S
//	            return o1. - o2.getTime();
//	        }
//	    });
	
		for (DoubleWritable value : values ) {
			//need o unbox the int from the IntWritable
			
			

			sb += value.get()+" ";
			
				
		}
		
		

		context.write(key, new Text(sb));
	
	}

}