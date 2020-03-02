package cn.tjuscs.st;

import java.util.*;

public class Patchwork {
	private Map<Integer,Integer> map;
	public Patchwork(Map m) {
		this.map = m;
	}
//	输入给定金额，输出bool，是否可以拼凑出
	public boolean take_out(int mn){
		int temp = 0;
		//当拼出的钱数还不足，并且口袋中有钱时
		for (Integer key : map.keySet()) {
			int c = map.get(key);
			while(temp+key <= mn && c > 0) {
				temp += key;
				c--;
			}
			if(temp == mn) {
				return true;
			}
//			System.out.println(key);
		}
		return false;
	}
}

