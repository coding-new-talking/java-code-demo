package org.cnt.java.classfile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>西兰花
 * @author lixinjie
 * @since 2019-07-09
 */
public class Broccoli extends Vegetable implements Organic {
	
	private double price;
	private double weight;
	protected List<String> history = new ArrayList<>();
	public Map<Integer, Double> perDay = new HashMap<>(); 
	protected Double rate;
	
	@Override
	public String getCertification() {
		return "china";
	}
	
	@Override
	public void grow() {
		System.out.println("grow");
	}

	public double bloom() {
		return 0.2;
	}
	
	public String fruit() {
		return "perfect";
	}

	public double getPrice() {
		return price;
	}

	public double getWeight() {
		return weight;
	}
	
	
	public String str(String sss, Integer iii) {
		return sss + iii;
	}
}
