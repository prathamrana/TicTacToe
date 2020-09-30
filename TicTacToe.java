//TicTacToe
//Preetham Anumapuram & Pratham Rana

import java.util.Scanner;
public class TicTacToe
{
   public static Scanner input = new Scanner(System.in);
   public static String coordinate = "1,1";
   public static int[][] gameBoard = new int[3][3];
   public static boolean isX = false;
   
   public static void makeSquare(){
      for (int j = 0; j < 3; j++){ 
         for (int i = 0; i < 3; i++){
            System.out.print(" ---");
         }
         System.out.println();
         for (int i = 0; i < 3; i++){
            System.out.print("| ");
            if ((gameBoard[j][i] == 0 || gameBoard[j][i] == 1) || (getRow() == j && getCol() == i && (gameBoard[j][i] == 0 || gameBoard[j][i] == 1))){
               if (gameBoard[j][i] == 0){
                  System.out.print("O");
               }
               else{
                  System.out.print("X");
               }
            }
            else{
               System.out.print(" ");
            }
            System.out.print(" "); 
         }
         System.out.println("|");
      }
      for (int i = 0; i < 3; i++){
         System.out.print(" ---");
      } 
      System.out.println();
   }
   
   public static int getRow(){
      int r = Integer.parseInt(coordinate.substring(0,1)) - 1;
      if (r == 0){
         return 2;
      }
      else if (r == 2){
         return 0;
      }
      else{
         return r;
      }
   }
   
   public static int getCol(){
      return Integer.parseInt(coordinate.substring(2)) - 1;
   }
   
   public static boolean isWinner(){
      if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2])
         return true;
      if (gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0])
         return true;
      for (int i = 0; i < gameBoard.length; i++){
         if (gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2])
            return true;
         if (gameBoard[0][i] == gameBoard[1][i] && gameBoard[1][i] == gameBoard[2][i])
            return true;
      }
      return false;
   }
   
   public static boolean isEmpty(){
      int row = 0;
      int col = 0;
      for (int i = 2; i <= 10; i++){
         if (i == gameBoard[row][col]){
            return true;
         }
         if (col == 2){
            row++;
            col = 0;
         }
         else{
            col++;
         }
      }
      return false;
   }
   
   public static boolean isInvalid(){
      return (gameBoard[getRow()][getCol()] == 0 || gameBoard[getRow()][getCol()] == 1);
   } 
   
   public static void setMark(){
      isX = !isX;
      if (isX){
         gameBoard[getRow()][getCol()] = 1;
      }
      else{
         gameBoard[getRow()][getCol()] = 0;
      }
   }
     
   public static void playGame(){
      int gameBoardHolder = 2;
      for (int j = 0; j < 3; j++){
         for (int k = 0; k < 3; k++){
            gameBoard[j][k] = gameBoardHolder;
            gameBoardHolder++;
         }
      }
      System.out.println("Directions on how to play java Tic-Tac-Toe: ");
      System.out.println("Get either three X's or O's in a row, column, or diagonal to win.");
      System.out.println("To place X or O, type in a coordinate by following that the bottom row is 1 and the right column is 3 ex.(row,col)");
      
      makeSquare();
      System.out.print("Type in the coordinate: ");
      coordinate = input.nextLine();
      setMark();
      
      while(isEmpty()){
         makeSquare();
         System.out.print("Type in the coordinate: ");
         coordinate = input.nextLine();
         
         if (!isInvalid()){
            setMark();
         }
         else{
            System.out.println("Cannot place marker with existing marker in place!!");
         }
      
         if (isWinner()){
            if (isX){
               makeSquare();
               System.out.println("X Won!");
            }
            else{
               makeSquare();
               System.out.println("O Won!");
            }
            break;
         } 
      }
      
      if (!isEmpty() && !isWinner()){
         makeSquare();
         System.out.println("No Winner, it's a tie");
      }
   }
      
   public static void main(String[] args){
      playGame();
   }
}