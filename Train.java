package Booking;
import java.util.Scanner;

interface details
{
  void display_train();
  boolean check_av_ac2(int t);
  boolean check_av_ac3(int t);
  boolean check_av_non(int t);
  void change_av_ac2(int t);
  void change_av_ac3(int t);
  void change_av_non(int t);
  int reserve_ac2(int t);
  public int reserve_non(int t);
  public int reserve_ac3(int t);
  public double calc_ac2(int t);
  public double calc_ac3(int t);
  public double calc_non(int t);
  public void print_ticket();
  public void payment();
}

public class Train implements details
{
int tno,seats_ac2,seats_ac3,seats_non;
String start,destination;
String ar_time,de_time;
double fare_ac2,fare_ac3,fare_non;
String train_name;
int num_s;

public Train(int t,int sac1,int sac2,int snon,String st,String dt,String art,String det,double fac2,double fac3,double fnon,String tname)
{
   tno=t;
   seats_ac2=sac1;
   seats_ac3=sac2;
   seats_non=snon;
   start=st;
   destination=dt;
   ar_time=art;
   de_time=det;
   fare_ac2= fac2;
   fare_ac3=fac3;
   fare_non=fnon;
   train_name=tname;

}

public void display_train()
{
  System.out.print("\n\nTRAIN NUMBER:"+tno);
  System.out.print("\t\tTRAIN NAME:" +train_name);
  System.out.print("\n\nSource:"+start);
  System.out.print("\t\t\tDestination:"+destination);
  System.out.print("\nArrival time:"+ar_time);
  System.out.print("\nDestination time:"+de_time);
	System.out.print("\n\nSEAT AVAILABILITY");
	System.out.print("\nAC 2-TIER:"+seats_ac2);
	System.out.print("\nAC 3-TIER:"+seats_ac3);
	System.out.print("\nNON AC:"+seats_non);
  System.out.print("\n\nFARE");
  System.out.print("\nAC 2-TIER:"+fare_ac2);
  System.out.print("\nAC 3-TIER:"+fare_ac3);
  System.out.print("\nNON AC:"+fare_non);
	System.out.println("\n\n");
 
}

public boolean check_av_ac2(int num_s)
{
  if(seats_ac2>num_s)
  {
     return true;
  }
  return false;
}

public boolean check_av_ac3(int num_s)
{ 
  if(seats_ac3>num_s)
  return true;
  return false;
}

public boolean check_av_non(int num_s)
{

   if(seats_non>num_s)
  return true;
  return false;
}

public void change_av_ac2(int num_s)
{
  seats_non=seats_non-num_s;
}

public void change_av_ac3(int num_s)
{
  seats_ac3 = seats_ac3 - num_s;
}

 public void change_av_non(int num_s)
{
  seats_non = seats_non - num_s;
}

public int reserve_ac2(int num_s)
{
   if(check_av_ac2(num_s))
   {
      change_av_ac2(num_s); 
      return 1; 
   }
  return 0;
  
}


public int reserve_ac3(int num_s)
{
   if(check_av_ac3(num_s)==true)
   {
     change_av_ac3(num_s);
     return 1;
   }
   return 0;
}

public int reserve_non(int num_s)
{
   if(check_av_non(num_s)==true)
   {
     change_av_non(num_s);
     return 1;
   }
   return 0;
}

public double calc_ac2(int num_s)
{
  return num_s * fare_ac2;
}

public double calc_ac3(int num_s)
{
  return num_s * fare_ac3;
}
public double calc_non(int num_s)
{
  return num_s * fare_non;
}


public void print_ticket(){
	System.out.print("\nTRAIN NUMBER:"+tno);
	System.out.print("\t\t\t\tTRAIN NAME:"+train_name);
	System.out.print("\n\nDESTINATION:"+destination);
	System.out.print("\t\t\tDESTINATION TIME:"+de_time);
}

public void payment()
{
    String choice;
    System.out.println("Enter the mode of payment:");
    Scanner sc=new Scanner(System.in);
    choice=sc.next();
    if(choice.equals("Netbanking"))
    {
        System.out.println("Enter the pin number: ");
        int p=sc.nextInt();
        System.out.println("Payment done successfully");
    }
    if(choice.equals("Cash"))
    {
      System.out.println("The payment can be done at the railway station before boarding");
    }
  }










}