//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           DrawingStackIterator (models the DrawingStackIterator data type)
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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class models the DrawingStackIterator data type.
 * 
 * @author Wenfei Huang
 *
 */
public class DrawingStackIterator implements Iterator<DrawingChange>{
  private LinkedNode<DrawingChange> next;
  
  /**
   * Initializes a new DrawingStackIterator with parameter top set as next.
   * @param top: to be set as next node
   */
  public DrawingStackIterator(LinkedNode<DrawingChange> top) {
    next = top;
  }

  /**
   * Return true when there are more DrawingChange left for it to return, and false otherwise.
   */
  @Override
  public boolean hasNext() {
    if (next == null) {
      return false;
    }
    return true;
  }

  /**
   * Return the DrawingChange node.
   * @throws NoSuchElementException if there is no DrawingChange left to be returned by an iterator
   */
  @Override
  public DrawingChange next() {
    if (next==null) {
      throw new NoSuchElementException("The stack is exhausted!");
    }
    DrawingChange data = next.getData();
    next = next.getNext();
    return data;
  }

}
