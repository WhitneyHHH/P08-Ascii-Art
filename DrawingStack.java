//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           DrawingStack (models the DrawingStack data type)
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
import java.util.Iterator;

/**
 * This class models the DrawingStack data type.
 * 
 * @author Wenfei Huang
 *
 */
public class DrawingStack implements StackADT<DrawingChange>, Iterable<DrawingChange>{
  private LinkedNode<DrawingChange> top;
  private int size;

  /**
   * Return a DrawingStackIterator with the top set as head.
   */
  @Override
  public Iterator iterator() {
    return new DrawingStackIterator(top);
  }

  /**
   * Add an element to this stack.
   * 
   * @param element: an element to be added
   * @throws jIllegalArgumentException: if the input element is null
   */
  @Override
  public void push(DrawingChange element) {
    if (element == null) {
      throw new IllegalArgumentException("no element!");
    }
    top = new LinkedNode<DrawingChange>(((DrawingChange)element), top);  
    size++;
  }

  /**
   * Remove the element on the top of this stack and return it.
   * 
   * @return the element removed from the top of the stack
   * @throws EmptyStackException if the stack is empty
   */
  @Override
  public DrawingChange pop() {
    if (top == null) {
      throw new EmptyStackException();
    }
    DrawingChange changes = top.getData();
    top = top.getNext();
    size--;
    return changes;
  }

  /**
   * Get the element on the top of this stack.
   * 
   * @return the element on the stack top
   * @throws EmptyStackException if the stack is empty
   */
  @Override
  public DrawingChange peek() {
    if (top == null) {
      throw new EmptyStackException();
    }
    return top.getData();
  }

  /**
   * Check whether this stack is empty or not.
   * 
   * @return true if this stack contains no elements, otherwise false
   */
  @Override
  public boolean isEmpty() {
    if (top == null) {
      return true;
    }
    return false;
  }

  /**
   * Get the number of elements in this stack.
   * 
   * @return the size of the stack
   */
  @Override
  public int size() {
    return size;
  }

}
