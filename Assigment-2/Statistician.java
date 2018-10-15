// File: Statistician.java
// This is an assignment for students to complete after reading Chapter 2 of
// "Data Structures and Other Objects Using Java" by Michael Main.

// Check with your instructor to see whether you should put this class in
// a package. At the moment, it is declared as part of edu.colorado.homework:
//package edu.colorado.homework;

/******************************************************************************
* This class is a homework assignment;									       
* A <CODE>Statistician</CODE> keeps track of statistics about a sequence of
* double numbers.
*
* <b>Note:</b>
*   This file contains only blank implementations ("stubs")
*   because this is a Programming Project for my students.
*
* <b>Outline of Java Source Code for this class:</b>
*   <A HREF="../../../../edu/colorado/homework/Statistician.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/homework/Statistician.java
*   </A>
*
* @version Feb 10, 2016
******************************************************************************/
public class Statistician
{   
   private int count;
   private double sum,max,min;

   public Statistician( )
   {
      count = 0;  
   }        


   /**
   * Add the numbers of another Statistician to this Statistician.
   * @param addend
   *   a Statistician whose numbers will be added to this Statistician
   * <b>Precondition:</b>
   *   The parameter, <CODE>addend</CODE>, is not null. 
   * <b>Postcondition:</b>
   *   The numbers from <CODE>addend</CODE> have been added to this
   *   Statistician. After the operation, this Statistician acts as if
   *   if was given all of its numbers and also given all of the numbers
   *   from the addend.
   * @exception NullPointerException
   *   Indicates that <CODE>addend</CODE> is null. 
   **/
   public void addAll(Statistician addend)
   {
      if (addend.count !=0)
      {
      	if (count == 0)
	{
	  count = addend.count;
	  sum = addend.sum;
	  max = addend.max;
	  min = addend.min;
	}
	else
	{
	  count += addend.count;
	  sum += addend.sum;
	  	if (addend.max > max) max = addend.max;
		if (addend.min < min) min = addend.min;
	}
      }
   }   
   
   
   /**
   * Clear this Statistician. 
   * <b>Postcondition:</b>
   *   This Statistician is reinitialized as if it has never been given any 
   *   numbers.
   **/
   public void clear( )
   {
      count = 0;
   }


   /**
   * Compare this <CODE>Statistician</CODE> to another object for equality.
   * @param obj
   *   an object with which this <CODE>Statistician</CODE> will be compared
   * @return
   *   A return value of <CODE>true</CODE> indicates that 
   *   <CODE>obj</CODE> refers to a 
   *   <CODE>Statistican</CODE> object with the same length, sum, mean,
   *   minimum and maximum as this 
   *   <CODE>Statistician</CODE>. Otherwise the return value is 
   *   <CODE>false</CODE>.
   * <b>Note:</b>
   *   If <CODE>obj</CODE> is null or does not refer to a 
   *   <CODE>Statistician</CODE> object, then the answer is 
   *   <CODE>false</CODE>.
   **/   
   public boolean equals(Object obj)
   {
      if (obj instanceof Statistician)
      {
      	Statistician newStat = (Statistician) obj ; 
	return (newStat.count == count && newStat.sum == sum && newStat.max == max &&newStat.min == min);
      }
      return false;
   } 
   
   
   /**
   * Determine how many numbers have been given to this Statistician.
   * @return
   *   the count of how many numbers have been given to this Statistician
   *   since it was initialized or reinitialized.
   * <b>Note:</b>
   *   Giving a Statistician more than
   *   <CODE>Integer.MAX_VALUE</CODE> numbers, will
   *   cause failure with an arithmetic overflow.
   **/ 
   public int length( )
   {
      return count;
   }


   /**
   * Determine the largest number that has been given 
   * to this Statistician.
   * @return
   *   the largest number that has been given to this 
   *   Statistician
   *   since it was initialized or reinitialized.
   * <b>Note:</b>
   *   If <CODE>length()</CODE> is zero, then the answer from this method
   *   is <CODE>Double.NaN</CODE>.
   **/ 
   public double maximum( )
   {
      if(count == 0) return Double.NaN;
      return max;
   }


   /**
   * Determine the arithmetic average of all the numbers that have been given 
   * to this Statistician.
   * @return
   *   the arithmetic mean of all the number that have been given to this 
   *   Statistician
   *   since it was initialized or reinitialized.
   * <b>Note:</b>
   *   If this Statistician has been given more than
   *   <CODE>Integer.MAX_VALUE</CODE> numbers, then this method fails
   *   because of arithmetic overflow.
   *   If <CODE>length()</CODE> is zero, then the answer from this method
   *   is <CODE>Double.NaN</CODE>.
   *   If <CODE>sum()</CODE> exceeds the bounds of double numbers, then the 
   *   answer from this method may be 
   *   <CODE>Double.POSITIVE_INFINITY</CODE> or
   *   <CODE>Double.NEGATIVE_INFINITY</CODE>.
   **/ 
   public double mean( )
   {
      if(count == 0) return Double.NaN;
      return (sum/count);
   }


   /**
   * Determine the smallest number that has been given 
   * to this Statistician.
   * @return
   *   the smallest number that has been given to this 
   *   Statistician
   *   since it was initialized or reinitialized.
   * <b>Note:</b>
   *   If <CODE>length()</CODE> is zero, then the answer from this method
   *   is <CODE>Double.NaN</CODE>.
   **/ 
   public double minimum( )
   {
      if ( count == 0 ) return Double.NaN;
      return min;
   }


   /**
   * Give a new number to this Statistician. 
   * @param number
   *   the new number that is being given the this Statistician
   * <b>Postcondition:</b>
   *   The specified number has been given to this Statistician and
   *   it will be included in any subsequent statistics.
   **/
   public void next(double number)
   {
     if (count == 0)
     {
     	sum = number;
	max = number;
	min = number;
     }
     else
     {
     	sum += number;
	if(number > max) max = number;
	if(number < min) min = number;
     }
     count ++;   }


   /**
   * Determine the sum of all the numbers that have been given to this 
   * Statistician.
   * @return
   *   the sum of all the number that have been given to this 
   *   Statistician
   *   since it was initialized or reinitialized.
   * <b>Note:</b>
   *   If the sum exceeds the bounds of double numbers, then the answer
   *   from this method may be 
   *   <CODE>Double.POSITIVE_INFINITY</CODE> or
   *   <CODE>Double.NEGATIVE_INFINITY</CODE>.
   **/ 
   public double sum( )
   {
      if (count == 0) return 0;
      return sum;
   }


   /**
   * Create a new Statistician that behaves as if it was given all the
   * numbers from two other bags.
   * @param s1
   *   the first of two Statisticians
   * @param s2
   *   the second of two Statisticians
   * <b>Precondition:</b>
   *   Neither s1 nor s2 is null.
   * @return
   *   a new Statistician that acts as if it was given all the numbers from
   *   s1 and s2.
   * @exception NullPointerException
   *   Indicates that one of the arguments is null.
   **/   
   public static Statistician union(Statistician s1, Statistician s2)
   {
      if(s1 == null || s2 == null)
      {
      	throw new RuntimeException("union: null pointer exception");
      }
      Statistician sumStat = new Statistician();
      sumStat.addAll(s1);
      sumStat.addAll(s2);
      return sumStat;
   }
      
}
           
