//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           AsciiTester (tests the functionality of data type)
// Files:           DrawingChange.java, DrawingStack.java, DrawingStackIterator.java,
//                  Canvas.java, LinkedNode.java, StackADT.java, AsciiArtDriver.java,
//                  AsciiArtTester.java
// Course:          CS 300, Fall, 2019
//
// Author:          Wenfei Huang
// Email:           whuang258@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    None
// Partner Email:   None
// Partner Lecturer's Name: None
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X_ Write-up states that pair programming is allowed for this assignment.
//   _X_ We have both read and understand the course Pair Programming Policy.
//   _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         CS Learning Center
// Online Sources:  None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * This class tests multiple methods inside the DrawingChange class and DrawingStack class.
 * Testing methods include constructors, accessor and mutator methods. 
 * 
 * @author Wenfei Huang
 *
 */
public class AsciiArtTester {

  /**
   * Print out the result of runAsciiArtTestSuite method.
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(runAsciiArtTestSuite());
  }
  
  /**
   * Checks for the correctness of DrawingStack.push() and DrawingStack.peek() methods
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testStackPushPeek(){ 
    boolean pass = true;
    DrawingChange test1 = new DrawingChange (6, 21, 'm', 'a');
    DrawingChange test2 = new DrawingChange (19, 96, 'm', 'c');    
    DrawingStack testA = new DrawingStack();
    if (!testA.isEmpty()) {
      pass = false;
    }
    // Calling peek on an empty stack should throw an exception
    try {
      testA.peek();
      pass = false;
    } catch (EmptyStackException e) {
      // ignore
    }
    // Test whether the peek works well
    testA.push(test1);
    if (!testA.peek().equals(test1)) {
      pass = false;
    }
    testA.push(test2);
    if (!testA.peek().equals(test2)) {
      pass = false;
    }
    return pass;
  }
  
  /**
   * Checks for the correctness of Canvas.Draw()
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testCanvasDraw(){
    boolean pass = false;
    Canvas canvas = new Canvas(6, 1);
    canvas.draw(0, 0, 'm');
    canvas.draw(0, 2, 'm');
    canvas.draw(0, 4, 'c');
    // Test whether draw method works well
    if (canvas.toString().equals("m m c \n")) {
      pass = true;
    }
    return pass;
  }
  
  /**
   * checks for the correctness of DrawingStack.pop(). It calls DrawingStack.push() and 
   * DrawingStack.peek() methods
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testStackPop() {
    boolean pass = true;
    DrawingStack testB = new DrawingStack();
    DrawingChange test1 = new DrawingChange (6, 21, 'm', 'a');
    testB.push(test1);
    // Test whether pop method changes the size of the stack and returns correctly
    if (testB.size()!=1 || !testB.pop().equals(test1) || testB.size()!=0) {
      pass = false;
    }
    return pass;
  }
  
  /**
   * checks for the correctness of DrawingStackIterator.hasNext() and DrawingStackIterator.next() 
   * methods
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testDrawingStackIterator(){
    boolean pass = false;
    DrawingChange test1 = new DrawingChange (6, 21, 'm', 'a');
    DrawingChange test3 = new DrawingChange (7, 30, 'h', 'a');
    LinkedNode<DrawingChange> tail = new LinkedNode<>(test3);
    LinkedNode<DrawingChange> top = new LinkedNode<>(test1, tail);
    DrawingStackIterator iterator = new DrawingStackIterator(top);
    // Test the methods of iterator
    if (iterator.hasNext()==true && iterator.next().equals(top.getData())
        && iterator.next().equals(tail.getData())) {
      pass = true;
    }
    try {
      iterator.next();
      pass = false;
    } catch (NoSuchElementException e) {
      // ignore
    }
    return pass;
  } 
  
  /**
   * Checks for the correctness of the Canvas.undo() method
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testCanvasUndo(){
    boolean pass = false;
    Canvas canvas = new Canvas(6, 1);
    canvas.draw(0, 0, 'm');
    canvas.draw(0, 2, 'm');
    canvas.draw(0, 4, 'c');
    canvas.undo();
    // Test whether the undo method functions and returns correctly
    if (canvas.undo() && canvas.undo() && !canvas.undo()) {
      pass = true;
    }
    return pass;
  } 
  
  /**
   * Checks for the correctness of the Canvas.redo() method
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testCanvasRedo(){
    boolean pass = false;
    Canvas canvas = new Canvas(6, 1);
    canvas.draw(0, 0, 'm');
    canvas.draw(0, 2, 'm');
    canvas.draw(0, 4, 'c');
    canvas.undo();
    canvas.undo();
    canvas.undo();
    // Test whether the redo method functions and returns correctly
    if (canvas.redo() && canvas.redo() && canvas.redo() && !canvas.redo()) {
      pass = true;
    }
    return pass;
  } 
  
  /**
   * Checks for the correctness of all the other methods
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean runAsciiArtTestSuite() { 
    if (testStackPushPeek() && testCanvasDraw() && testStackPop()
        && testDrawingStackIterator() && testCanvasUndo() && testCanvasRedo()) {
      return true;
    }
    return false;
      
  }

}
