/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shipsProject;

/**
   Ship class
*/

public class Ship
{
   private String name;      // Ship name
   private int yearBuilt;    // 4 digit year built 
   private String nation;    // Nation of registry
   /**
      Constructor
      @param n The ship's name.
      @param y The year the ship was build.
   */
   public Ship(String n, int y, String na)
   {
      name = n;
      yearBuilt = y;
      nation = na;
   }

   /**
      setName method
      @param n The ship's name.
   */
   public void setName(String n)
   {
      name = n;
   }

   /**
      setYearBuilt method
      @param y The year the ship was built.
   */
   public void setYearBuilt(int y)
   {
      yearBuilt = y;
   }


   /**
      getName method
      @return The ship's name.
   */
   public String getName()
   {
      return name;
   }

   /**
      getYearBuilt method
      @return The year the ship was built.
   */
   public int getYearBuilt()
   {
      return yearBuilt;
   }

   /**
      toString method
      @return A string indicating the ship's name
              and the year it was built.
   */
   public String toString()
   {
      return "Name: " + name + "\t  Year built: " +
             yearBuilt + "\t  Nation registry: " +
             nation;
   }
}