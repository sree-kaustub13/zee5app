package com.zee.zee5app;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main3 {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,9,8,8,7,7,6,4);
		list.forEach(e->System.out.println(e));
		list.forEach(System.out::println);
		
		System.out.println("Sorted one");
		//Collections.sort(list);
		Collections.sort(null, null);
		list.forEach(System.out::println);
	}
}
