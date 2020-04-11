
import static org.junit.Assert.*;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class BackPackTest {
	int[][] res;
	int[] w;
	int[] p;
	int[][] wrong;
	
	@Before
	public void setUp() {
		res = new int[][]{{0,0,4,4,4,4,4,4,4,4},{0,0,4,5,5,5,9,9,9,9},{0,0,4,5,6,6,9,10,11,11}};
		w = new int[]{3, 4, 5};
		p = new int[]{4, 5, 6};
		wrong = new int[][]{{0,0,4,4,4,4,3,4,5,5},{0,0,4,5,5,5,7,8,9,9},{0,0,4,5,6,6,9,10,11,11}};
	}
	
	@Test
	public void test() {
		assertTrue(BackPack.isEqual(10, 3, res, BackPack.BackPack_Solution(10, 3, w, p)));
	}

}
