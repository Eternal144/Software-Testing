package cn.tjuscs.st;
import java.lang.reflect.Array;
import java.util.*;
//
/*
 * Author WZ@tju
 */
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestPara {
	Patchwork patch = null;
	private int input;
	private boolean expected;
	
	public TestPara(int input, boolean expected) {
		this.input = input;
		this.expected = expected;
	}
	@Before
	public void setUp(){
		Map<Integer,Integer> m = new LinkedHashMap<Integer,Integer>();
		m.put(50, 1);
		m.put(20, 1);
		m.put(10, 1);
		m.put(5, 2);
		m.put(1, 3);
		patch = new Patchwork(m);
	}
	@Parameters
	public static Collection<Object[]> getData(){
		return Arrays.asList(new Object[][]{
			{50,true},
			{62,true},
			{44,false},
			{32,true},
			{32,true},
			{29,false},
			{0,true},
			{20,true},
			{2,true},
			{100,false},
			});
	}
//	public static void main(String[] args) {
//		Patchwork patch;
//		Map<Integer,Integer> m = new LinkedHashMap<Integer,Integer>();
//		m.put(50, 1);
//		m.put(20, 1);
//		m.put(10, 1);
//		m.put(5, 2);
//		m.put(1, 3);
//		patch = new Patchwork(m);
//		patch.take_out(20);
//	}
	
	@Test
	public void testTakeOut(){
//		boolean result = patch.take_out(50);
		assertEquals( this.expected,patch.take_out(this.input));
	}
	
	

}
