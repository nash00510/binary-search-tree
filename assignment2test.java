/*Author: Nash Smith
  ID: 1277758
*/

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class assignment2test {
   @Test
	
   public void testInsert() {
   	BSTlex tree = new BSTlex();
   	System.out.println("-- Insert Test --");
   	tree.insert("The");
   	tree.insert("umpire");
   	tree.insert("Dog");
   	tree.insert("took");
   	tree.insert("Anything");
   	tree.insert("quick");
   	
   	assertEquals("The tree has 6 values", "anything\ndog\nquick\nthe\ntook\numpire\n", tree.toString());
   }
   
   @Test
   public void testInsert2() {
   	
   	BSTlex tree2 = new BSTlex();
   	System.out.println("-- Insert Test 2 --");
   	assertEquals("The tree is empty","", tree2.toString());
   }
   
   @Test
   public void testInsert3() {
   	
   	BSTlex tree = new BSTlex();
   	System.out.println("-- Insert Test 3 --");
   	tree.insert("The");
   	tree.insert("umpire");
   	tree.insert("Dog");
   	tree.insert("took");
   	tree.insert("Anything");
   	tree.insert("quick");
   	
   	tree.insert("dog");
   	
   	
   	assertEquals("Tree has 5 items, dog should not be in tree","anything\nquick\nthe\ntook\numpire\n", tree.toString());
   }
   
   @Test
   public void testDelete() {
   	BSTlex tree = new BSTlex();
   	System.out.println("-- Delete Test --");
   	tree.insert("The");
   	tree.insert("umpire");
   	tree.insert("Dog");
   	tree.insert("took");
   	tree.insert("Anything");
   	tree.insert("quick");
   	
   	//delete leaf with two children
   	tree.delete("dog");
   	
   	assertEquals("dog should be deleted", "anything\nquick\nthe\ntook\numpire\n", tree.toString());
   	
   	//BSTlex tree2 = new BSTlex();
   	
   	//assertEquals("", tree2.toString());
   }
   
   @Test
   public void testDelete2() {
   	BSTlex tree2 = new BSTlex();
   	System.out.println("-- Delete Test 2 --");
   	tree2.delete("word");
   	
   	assertEquals("", tree2.toString());
   }
   
   @Test
   public void testFind() {
   	BSTlex tree = new BSTlex();
   	System.out.println("-- Find Test --");
   	tree.insert("The");
   	tree.insert("umpire");
   	tree.insert("Dog");
   	tree.insert("took");
   	tree.insert("Anything");
   	tree.insert("quick");
   	
   	//delete leaf with two children
   	boolean found = tree.find("took");
   	System.out.println(found);
   	
   	assertEquals("took is in the tree, should be found", true, found);
   	
   	//BSTlex tree2 = new BSTlex();
   	
   	//assertEquals("", tree2.toString());
   }
   
   @Test
   public void testFind2() {
   	BSTlex tree = new BSTlex();
   	System.out.println("-- Find Test 2 --");
   	tree.insert("The");
   	tree.insert("umpire");
   	tree.insert("Dog");
   	tree.insert("took");
   	tree.insert("Anything");
   	tree.insert("quick");
   	
   	//try find the word nope
   	boolean found = tree.find("nope");
   	System.out.println(found);
   	
   	assertEquals("not isn't in the tree, shouldn't be found", false, found);
   	
   	//BSTlex tree2 = new BSTlex();
   	
   	//assertEquals("", tree2.toString());
   }
   
   @Test
   public void testFind3() {
   	BSTlex tree = new BSTlex();
   	System.out.println("-- Find Test 3 --");
   	
   	//try find nope in the empty tree
   	boolean found = tree.find("nope");
   	System.out.println(found);
   	
   	assertEquals("tree is empty", false, found);
   	
   }
   
}
