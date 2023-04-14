/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mavenproject7;
import java.time.LocalDate;
import static java.time.LocalDate.now;
/**
 *
 * @author Mega Store
 */
public class Mavenproject7 {

    public static void main(String[] args) {
        Acount a=new Acount(1414,5000);
        System.out.println("the id="+a.getid());
        System.out.println("the balance now="+a.getbalance());
        a.withdraw(500);
         System.out.println("the balance now="+a.getbalance());
       a.deposit(1200);
        System.out.println("the balance now="+a.getbalance());
        a.setannualinterestrate(500);
         System.out.println("the monthly interestrate="+a.getmonthlyinterestrate());
          System.out.println("the monthly interest="+a.getmonthlyinterest());
    }
}
class Acount {
    private int id=0;
    private double balance=0;
    private double annualinterestrate=0;
    private LocalDate datecreated;
    
   
    Acount(){
        id=1;
        balance=1;
        annualinterestrate=1;
        datecreated=now();
    }
    Acount(int id,double balance){
   this.id=id;
   this.balance=balance;
}
    public void setid(int id){
        this.id=id;
    }
    public void setbalance(double balance){
        this.balance=balance;
    }
    public void setannualinterestrate(double x){
        this.annualinterestrate=x;
    }
 
      public double getbalance(){
          return balance;
         
      }
       public int getid(){
          return id;
         
      }
       public LocalDate getdatecreated(){
           return datecreated;
       }
        public double getinterestrate(){
          return annualinterestrate;
         
      }
       
    public double getmonthlyinterestrate(){
      return this.annualinterestrate*10;
    }
     public double getmonthlyinterest(){
           return  this.annualinterestrate*10 /12;
    }
     public double withdraw(double amount){
       return this.balance=balance-amount;
    
     
     }
    
     public double deposit(double amount){
        
        return this. balance=balance+amount;
      
     }
    
    
    
}

