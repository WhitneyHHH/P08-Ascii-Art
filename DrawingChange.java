//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           DrawingChange (models the DrawingChange data type)
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

/**
 * This class models the DrawingChange data type.
 * 
 * @author Wenfei Huang
 *
 */
public class DrawingChange {
  public final int row; // row (y-coordinate) for this DrawingChange
  public final int col; // col (x-coordinate) for this DrawingChange
  public final char prevChar; // previous character in the (row,col) position 
  public final char newChar; // new character in the (row,col) position
  
  /**
   * Initializes a new DrawingChange with the parameter row, col, previous character, and new
   * character set to variables in this class.
   * @param row: y coordinate of the change
   * @param col: x coordinate of the change
   * @param prevChar: character previously at this position
   * @param newChar: character to change to
   */
  public DrawingChange(int row, int col, char prevChar, char newChar) {
    this.row = row;
    this.col = col;
    this.prevChar = prevChar;
    this.newChar = newChar;
  }

}
