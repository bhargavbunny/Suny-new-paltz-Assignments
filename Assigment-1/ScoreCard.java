/* NAME - BHARGAV REDDY KONAPALLI
 * STUDENT_ID - N03857206
 * ---------------------------------------------------------------------------------------
 *  Write a program
 *
 *  (1) to read a list of exam scores (integers in the range 0..100) and
 *  (2) to compute the total number of grades and the number of grades in each
 *  letter-grade category:
 *
 *  A: 90-100
 *  B: 80-89
 *  C: 70-79
 *  D: 60-69
 *  F: 0-59
 *
 *  The end of the input is indicated by a negative integer as a sentinel value.
 *
 *  For example, if the input is
 *  75 63 87 84 71 81 50 78 76 74 85 72 66 98 43 -1
 *
 *  the output would be:
 *
 *  Total number of grades = 15
 *  Number of A's = 1
 *  Number of B's = 4
 *  Number of C's = 6
 *  Number of D's = 2
 *  Number of F's = 2
 * -----------------------------------------------------------------------------------------
 */

import java.util.*;

public class ScoreCard
{

public static void main(String[] args)

{

	int numberscore=0, Agrade=0, Bgrade=0, Cgrade=0, Dgrade=0, Fail=0; // Initializing Variables
	Scanner s = new Scanner(System.in);                                // Invoke of Scanner function
	System.out.println("Enter Scores");
	for(;;)                                                            // Infinte loop
	{
	int score = s.nextInt();
	int a[]  = new int[256];                                           // Integer array with 256 size
	a[numberscore] = score;
	if(a[numberscore] >= 90 && a[numberscore]<= 100)                   // Condition to check for the score and assign Grades
	{
		Agrade ++;
	}
	else if(a[numberscore]>=80 && a[numberscore]<=89)
	{
	
		Bgrade ++;
	}
	else if(a[numberscore]>=70 && a[numberscore]<=79)
	{
		Cgrade ++;
	}
	else if(a[numberscore]>=60 && a[numberscore]<=69)
	{
		Dgrade ++;
	}
	else if(a[numberscore]>0 && a[numberscore]<=59)
	{
		Fail ++;
	}	
	else if(a[numberscore] == -1)
	{
		break ;
	}
	else                                                              // Check if the score is non-integer or greater than 100
	{
	
		System.out.println("Enter valued is not in range (1-100).....!!!!!!");
		continue;
	}
	}
	int TotalGrades = Agrade + Bgrade + Cgrade + Dgrade + Fail;
	System.out.println("----------------------------------------------------------------");
	System.out.println("Report.....!!!!!!");
	System.out.println("The total number of Grades is  "+ TotalGrades);
	System.out.println("The count for A grade is       "+ Agrade);
	System.out.println("The count for B grade is       "+ Bgrade);
	System.out.println("The count for C grade is       "+ Cgrade);
	System.out.println("the count for D grade is       "+ Dgrade);
	System.out.println("The count for Fail grade is    "+ Fail);
}



}
