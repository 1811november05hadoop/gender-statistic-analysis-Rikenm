package com.revature.test;


import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

import com.revature.map.PercentChangeFemaleMapper;



public class PercentChangeFemaleTest {
	
	private MapDriver<LongWritable, Text, Text,DoubleWritable> mapDriver;
	
	
	@Before
	public void setup(){
		PercentChangeFemaleMapper mapper = new PercentChangeFemaleMapper();
		
		mapDriver = new MapDriver<>();
		mapDriver.setMapper(mapper);
		

		
		
	}
	
	
	
	@Test 
	public void testMapper(){
		//mock input 
		mapDriver.withInput(new LongWritable(1), new Text("\"Australia\",\"AUS\",\"Employment to population ratio, 15+, female (%) (national estimate)\",\"SL.EMP.TOTL.SP.FE.NE.ZS\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"40.0099983215332\",\"41.25\",\"41.4199981689453\",\"40.8400001525879\",\"40.0299987792969\",\"41.0099983215332\",\"42.2200012207031\",\"44.0900001525879\",\"44.7200012207031\",\"45.9199981689453\",\"47.7200012207031\",\"48.4900016784668\",\"47.2200012207031\",\"46.7799987792969\",\"46.5299987792969\",\"47.6699981689453\",\"49.2599983215332\",\"49.3600006103516\",\"49.2599983215332\",\"49.7099990844727\",\"50.060001373291\",\"51.2000007629395\",\"51.5\",\"51.8400001525879\",\"52.5699996948242\",\"52.5999984741211\",\"54\",\"54.689998626709\",\"55.2900009155273\",\"55.8699989318848\",\"55.5699996948242\",\"55.4599990844727\",\"55.7400016784668\",\"55.6199989318848\",\"55.3499984741211\",\"54.9700012207031\",\"55.4300003051758\",\"55.7799987792969\","));
		
		//expected output 
		mapDriver.withOutput(new Text("Australia"), new DoubleWritable(4.229999542236328));
		
		
		mapDriver.runTest();
		
		
	}
	
	
	
	
}
