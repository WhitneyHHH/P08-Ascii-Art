//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Canvas (models the Canvas data type)
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
 * This class models the Canvas data type.
 * @author Wenfei Huang
 *
 */
public class Canvas {
  private final int width; // width of the canvas
  private final int height; // height of the canvas
  private char [][] drawingArray; // 2D character array to store the drawing
  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo
  
  /**
   * Creates a new canvas which is initially blank.
   * @param width: canvas width
   * @param height: canvas height
   */
  public Canvas(int width, int height) {
    if (width<=0 || height<=0) {
      throw new IllegalArgumentException("invalid width or height!");
    }
    this.width = width;
    this.height = height;
    this.undoStack = new DrawingStack();
    this.redoStack = new DrawingStack();
    this.drawingArray = new char[height][width];
  }
  
  /**
   * Draw a character at the given position drawingArray[row][col]
   * @param row: the row to draw on
   * @param col: the col to draw on
   * @param c: the character to draw
   */
  public void draw(int row, int col, char c) {
    if (row>(drawingArray.length-1) || col>(drawingArray[row].length-1)) {
      throw new IllegalArgumentException("drawing outside the canvas!");
    }
    undoStack.push(new DrawingChange(row, col, drawingArray[row][col], c));
    drawingArray[row][col] = c;
    // Clear the redoStack by popping until size is zero
    while (redoStack.size()!=0) {
      redoStack.pop();
    }
  }
  
  /**
   * Undo the most recent drawing change.
   * @return true if undo is successful. False otherwise.
   */
  public boolean undo() {
    if (undoStack.isEmpty()) {
      return false;
    }
    // Pop the undoStack and add it to redoStack
    DrawingChange undone = undoStack.pop();
    redoStack.push(undone);
    drawingArray[undone.row][undone.col] = undone.prevChar;
    return true;
 }
  
  /**
   * Redo the most recent undone drawing change.
   * @return true if redo is successful. False otherwise.
   */
  public boolean redo() {
    if (redoStack.isEmpty()) {
      return false;
    }
 // Pop the redoStack and add it back to undoStack
    DrawingChange redone = redoStack.pop();
    undoStack.push(redone);
    drawingArray[redone.row][redone.col] = redone.newChar;
    return true;
 }
  
  /**
   * Return a printable string version of the Canvas.
   * @return String representing the canvas
   */
  public String toString() {
    String printed = "";
    // Iterate through the array
    for (int i=0; i<drawingArray.length; i++) {
      for (int j=0; j<drawingArray[i].length; j++) {
        // If the character at that position is character default value, then add a space to the 
        // returned string. Else, concate that character to the string.
        if (drawingArray[i][j]=='\u0000') {
          printed = printed + " ";
        } else {
          printed = printed + drawingArray[i][j];
        }
        // If it is end of a row and not the last row of the drawingArray, then add the characters 
        // to the next line.
        if (j==drawingArray[i].length-1) {
          printed = printed + System.lineSeparator();
        }
      }
    }
    return printed;
  }
  
  /**
   * Prints the Canvas’s string representation to System.out.
   */
  public void printDrawing() {
    System.out.print(this);
  }

  /**
   * Prints a record of the changes that are stored on the undoStack
   */
  public void printHistory() {
    int step = undoStack.size();
    // Use an enhanced for loop to iterate through undoStack and print the content according to
    // specific format.
    for (DrawingChange changes: undoStack) {
      System.out.println(step + ". draw '" + changes.newChar + "' on (" + changes.row +
          ", " + changes.col + ")");
      step--;
    }
    
  }

}
