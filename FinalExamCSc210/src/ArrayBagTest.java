import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

	public class ArrayBagTest {

		  @Test

		  void testAddLastAndIterator() {

		    ArrayBag<String> strs = new ArrayBag<>();

		    strs.add("Aa");

		    strs.add("bB");

		    strs.add("Cc");

		   

		    Iterator<String> itr = strs.iterator();

		    String result = "";

		    while( itr.hasNext() ) {

		      String current = itr.next();

		      result += current.toLowerCase() + current.toUpperCase() + "_";

		    }  

		    assertEquals("aaAA_bbBB_ccCC_", result);

		  }

		}
