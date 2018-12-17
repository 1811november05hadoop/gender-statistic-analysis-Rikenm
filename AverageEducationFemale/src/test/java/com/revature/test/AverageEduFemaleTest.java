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

import com.revature.map.AverageEduFemaleMapper;
import com.revature.reduce.AverageEduFemaleReducer;


public class AverageEduFemaleTest {
	
	private MapDriver<LongWritable, Text, Text,DoubleWritable> mapDriver;
	private ReduceDriver<Text, DoubleWritable, Text, DoubleWritable> reduceDriver; 
	private MapReduceDriver<LongWritable,Text, Text,DoubleWritable,Text, DoubleWritable> mapReduceDriver;

	@Before
	public void setup(){
		AverageEduFemaleMapper mapper = new AverageEduFemaleMapper();
		
		mapDriver = new MapDriver<>();
		mapDriver.setMapper(mapper);
		
		
		
		AverageEduFemaleReducer reducer = new AverageEduFemaleReducer();
		reduceDriver = new ReduceDriver<>();
		reduceDriver.setReducer(reducer);
		
		mapReduceDriver = new MapReduceDriver<>();
		mapReduceDriver.setMapper(mapper);
		mapReduceDriver.setReducer(reducer);
		
		
	}
	
	
	
	@Test 
	public void testMapper(){
		//mock input 
		mapDriver.withInput(new LongWritable(1), new Text("\"United States\",\"USA\",\"Gross graduation ratio, tertiary, female (%)\",\"SE.TER.CMPL.FE.ZS\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"35.85857\",\"37.8298\",\"37.43131\",\"38.22037\",\"39.18913\",\"39.84185\",\"40.23865\",\"41.26198\",\"42.00725\",\"42.78946\",\"43.68347\",\"\",\"46.37914\",\"47.68032\",\"\",\"\",\"\",\"\","));
		
		//expected output 
		//mapDriver.withOutput(new Text("United States"), new DoubleWritable(37.8298 - 35.85857));
		mapDriver.withOutput(new Text("United States"),new DoubleWritable(-0.39849090576171875));
		mapDriver.withOutput(new Text("United States"),new DoubleWritable(0.7890625) );
		mapDriver.withOutput(new Text("United States"),new DoubleWritable(0.9687576293945312) );
		mapDriver.withOutput(new Text("United States"),new DoubleWritable( 0.6527214050292969) );
		mapDriver.withOutput(new Text("United States"),new DoubleWritable(0.3968009948730469) );
		mapDriver.withOutput(new Text("United States"),new DoubleWritable(1.0233268737792969) );
		mapDriver.withOutput(new Text("United States"),new DoubleWritable(0.7452735900878906) );
		mapDriver.withOutput(new Text("United States"),new DoubleWritable(0.7822074890136719) );
		mapDriver.withOutput(new Text("United States"),new DoubleWritable(0.894012451171875) );
		mapDriver.withOutput(new Text("United States"),new DoubleWritable(1.3478336334228516) );
		mapDriver.withOutput(new Text("United States"),new DoubleWritable(1.3011817932128906) );
		
		
		
		mapDriver.runTest();
		
		
	}
	
	
	@Test
	public void testReducer(){
		
		List<DoubleWritable> values = new ArrayList<>();
		values.add(new DoubleWritable(-0.39849090576171875));
		values.add(new DoubleWritable(0.7890625));
		values.add(new DoubleWritable(0.9687576293945312));
		values.add(new DoubleWritable( 0.6527214050292969));
		values.add(new DoubleWritable(0.3968009948730469));
		values.add(new DoubleWritable(1.0233268737792969));
		values.add(new DoubleWritable(0.7452735900878906));
		values.add(new DoubleWritable(0.7822074890136719));
		values.add(new DoubleWritable(0.894012451171875));
		values.add(new DoubleWritable(1.3478336334228516));
		values.add(new DoubleWritable(1.3011817932128906));
		
		reduceDriver.withInput(new Text("United States"), values);
		reduceDriver.withOutput(new Text("United States"),new DoubleWritable(0.772971586747603));
		
		reduceDriver.runTest();
	}
	
	
	@Test
	public void testMapReduce(){
		//mock input 
		mapReduceDriver.withInput(new LongWritable(1), new Text("\"United States\",\"USA\",\"Gross graduation ratio, tertiary, female (%)\",\"SE.TER.CMPL.FE.ZS\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"35.85857\",\"37.8298\",\"37.43131\",\"38.22037\",\"39.18913\",\"39.84185\",\"40.23865\",\"41.26198\",\"42.00725\",\"42.78946\",\"43.68347\",\"\",\"46.37914\",\"47.68032\",\"\",\"\",\"\",\"\","));
		
		//Expected Final Output
		mapReduceDriver.withOutput(new Text("United States"),new DoubleWritable(0.772971586747603));
		
		
		
		
		mapReduceDriver.runTest();
	}
	
	
}
