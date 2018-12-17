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

import com.revature.map.PercentChangeMaleMapper;


public class PercentChangeMaleTest {
	
	private MapDriver<LongWritable, Text, Text, DoubleWritable> mapDriver;
	
	
	@Before
	public void setup(){
		PercentChangeMaleMapper mapper = new PercentChangeMaleMapper();
		
		mapDriver = new MapDriver<>();
		mapDriver.setMapper(mapper);
		
	
		
	}
	
	
	
	@Test 
	public void testMapper(){
		//mock input 
		
		mapDriver.withInput(new LongWritable(1), new Text("\"Australia\",\"AUS\",\"Employment to population ratio, 15+, male (%) (national estimate)\",\"SL.EMP.TOTL.SP.MA.NE.ZS\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"74.3899993896484\",\"74.370002746582\",\"74.2900009155273\",\"72.5100021362305\",\"69.2600021362305\",\"69.629997253418\",\"69.7399978637695\",\"70.0400009155273\",\"69.4899978637695\",\"70.1500015258789\",\"71.1399993896484\",\"70.5\",\"67.2600021362305\",\"65.75\",\"65.0800018310547\",\"66.2600021362305\",\"67.3600006103516\",\"67.1699981689453\",\"66.7399978637695\",\"66.9300003051758\",\"67.1600036621094\",\"67.4400024414063\",\"66.8499984741211\",\"67.0999984741211\",\"67.3300018310547\",\"67.7300033569336\",\"68.5699996948242\",\"68.870002746582\",\"69.5800018310547\",\"69.75\",\"68.1900024414063\",\"68.6900024414063\",\"68.6399993896484\",\"68.0299987792969\",\"67.3000030517578\",\"66.6800003051758\",\"66.7600021362305\",\"66.5500030517578\","));
		
		//expected output 
		mapDriver.withOutput(new Text("Australia"), new DoubleWritable(-0.6800003051757812));
		
		
		mapDriver.runTest();
		
	}
	
	
	
}
