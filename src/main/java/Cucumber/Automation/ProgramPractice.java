package Cucumber.Automation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ProgramPractice {

	public static void main(String[] args) {
		
		int a[]= {2,3,4,2,3,4,4,4,45,4,4,4,4,4};
		System.out.println("Majority of elements= "+majorityElementsinArray(a, a.length));
		
		Integer m[]= {9,1,3,6,8,0};
		missingnumberintheArray(m);

	}

	static int majorityElementsinArray(int a[], int size) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : a) {
			Integer val = map.get(i);
			if (val == null) {
				map.put(i, 1);
			} else {
				map.put(i, val + 1);
			}

			for (Map.Entry<Integer, Integer> m : map.entrySet()) {
				if (m.getValue() > size / 2) {
					return m.getKey();
				}
			}
		}
		return -1;
	}
	
	public static void missingnumberintheArray(Integer a[]) {
		HashSet<Integer> hashset= new HashSet<Integer>();
				
		for(int i:a) {
			hashset.add(i);
		}
		int n=a.length+1;
		for(int i=0;i<n;i++) {
			if(!hashset.contains(i)) {
				System.out.println(i);
			}
		}
	}

}
