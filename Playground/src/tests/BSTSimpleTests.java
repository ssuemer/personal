package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ds.BST;

class BSTSimpleTests {
	
	private class LexigographicObject implements Comparable<LexigographicObject>{
		
		int a;
		int b;
	
		public LexigographicObject(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(LexigographicObject o) {
			// TODO Auto-generated method stub
			if (a > o.a) {
				return 1;
			} else if (a == o.a) {
				if (b > o.b){
					return 1;
				} else if (b == o.b) {
					return 0;
				} else {
					return -1;
				}
			} else {
				return -1;
			}
		}
		
		@Override
		public String toString() {
			return "(" + a + "," + b + ")";
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof LexigographicObject && a == ((LexigographicObject) obj).a && b == ((LexigographicObject) obj).b) {
				return true;
			} else {
				return false;
			}
		}
		
	}
	
	@Test
	void testRootIntInsertion() {
		BST<Integer> bst = new BST<>();
		for (int i = -20; i < 20; i++) {
			bst.insert(i);
			assertEquals(Integer.toString(i),bst.inOrder());
			bst.clear();
		}
	}
	
	@Test
	void testRootLOInsertion() {
		BST<LexigographicObject> bst = new BST<>();
		for (int i = -20; i < 20; i++) {
			bst.insert(new LexigographicObject(i,i + 1));
			assertEquals("(" + i + "," + (i + 1) + ")",bst.inOrder());
			bst.clear();
		}
		bst.insert(new LexigographicObject(4, 3));
		bst.insert(new LexigographicObject(4, 3));
		assertEquals("(4,3)",bst.inOrder());
		
	}
	
	@Test
	void IntInsertion() {
		BST<Integer> bst = new BST<>();
		bst.insert(6);
		bst.insert(5);
		bst.insert(7);
		bst.insert(4);
		bst.insert(8);
		bst.insert(10);
		bst.insert(9);
		bst.insert(6);
		bst.insert(9);
		assertEquals("4 5 6 7 8 9 10",bst.inOrder());
		BST<Integer> bst2 = new BST<>();
		bst2.insert(7);
		bst2.insert(4);
		bst2.insert(8);
		bst2.insert(10);
		bst2.insert(6);
		bst2.insert(5);
		bst2.insert(9);
		bst2.insert(9);
		assertEquals(bst.inOrder(),bst2.inOrder());
	}
	
	
	
	

}
