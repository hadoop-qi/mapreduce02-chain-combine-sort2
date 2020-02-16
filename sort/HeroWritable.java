package com.zhiyou100.sort;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class HeroWritable implements WritableComparable<HeroWritable> {

	private String name;
	private double rate;
	
	public HeroWritable() {
		super();
	}
	
	
	public HeroWritable(String name, double rate) {
		super();
		this.name = name;
		this.rate = rate;
	}
	
	@Override
	public void write(DataOutput out) throws IOException {
		
		out.writeUTF(name);
		out.writeDouble(rate);
	}


	@Override
	public void readFields(DataInput in) throws IOException {

		name = in.readUTF();
		rate = in.readDouble();
	}


	@Override
	public int compareTo(HeroWritable o) {
		
		if (rate > o.getRate()) {
			
			return 1;
		}else if (rate == o.getRate()) {
			
			return 0;
		}else {
			
			return -1;
		}
	}

	@Override
	public String toString() {
		return name + "===========" + rate;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
}
