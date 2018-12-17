package com.revature;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.revature.map.PercentChangeFemaleMapper;
import com.revature.reduce.PercentChangeFemaleReducer;

public class PercentChangeFemaleDriver {
	
	public static void main(String[] args) throws Exception {
		
		if(args.length != 2) {
			System.out.println("Usage: WordCount <input_dir> <output_dir>");
			System.exit(-1);
		}
		
		else {
			//The MMpReduce object 
			Job job = new Job();
			
			//The class that contains the main() method
			job.setJarByClass(PercentChangeFemaleDriver.class);
			
			job.setJobName("percent-change-fe");
			
			//Set input and output paths
			FileInputFormat.setInputPaths(job, new Path(args[0]));
			FileOutputFormat.setOutputPath(job, new Path(args[1]));
			
			//Specify mapper and reducer class
			job.setMapperClass(PercentChangeFemaleMapper.class);
			//job.setReducerClass(PercentChangeFemaleReducer.class);
			
			//specify 
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(DoubleWritable.class);
		
			
			//run and check 
			boolean jobComplete = job.waitForCompletion(true);
			System.exit(jobComplete ? 0 : 1);
		}
	}
}
