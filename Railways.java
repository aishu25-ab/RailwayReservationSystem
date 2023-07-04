import PassengerRailways.Passenger;
import Booking.Train;
import Booking.Routes;
import java.util.Scanner;

class TrainNotFoundException extends Exception
{
	 String text;
	 public TrainNotFoundException(String t)
	 {
		 text=t;
	 }
}   

class PhoneNumberException extends Exception{
	String text;
	public PhoneNumberException(String t){
		text=t;
	}
}

class TrainDetails
{
   public void trains()
  {
    System.out.println("\nSL.NUM.\tTRAIN NUMBER\tFROM\tTO\n");
    System.out.println("1\t\t1240\t\tCHENNAI\t\tBANGALORE\n");
    System.out.println("2\t\t1242\t\tCHENNAI\t\tMUMBAI\n");
    System.out.println("3\t\t1243\t\tCHENNAI\t\tMADURAI\n");
    System.out.println("4\t\t1245\t\tCHENNAI\t\tHYDERABAD\n");
    System.out.println("5\t\t1247\t\tCHENNAI\t\tDELHI\n");
    System.out.println("6\t\t1249\t\tCHENNAI\t1\tCOIMBATORE\n");
  }
}

class Railways
{
  public static void main(String[] args)
  {
    int train_num;
    int num_seats;
    int op_choice, class_choice,cont;
    System.out.println("WELCOME TO E-RAILWAYS BOOKING SYSTEM\n");

		do{

			System.out.println("1.BOOKING\n2.TRAIN CHART\n");
      Scanner sc = new Scanner(System.in);
      op_choice = sc.nextInt();

    switch(op_choice)
    {
      case 1:
    
      System.out.println("You have choosed booking!\n\n");
		  System.out.println("------------------------------------------------------------");
			System.out.println("Enter passenger name: ");
			String name=sc.next();
			System.out.println("AGE: ");
			int age=sc.nextInt();
			System.out.println("Phone number: ");
			String number=sc.next();
			try{
				if(number.length()!=10){
					throw new PhoneNumberException("The length of the phone number should be 10");
				}
			}
			catch(PhoneNumberException e){
				System.out.println(e.text +"\n"+ e);
			}
			System.out.println("Address: ");
			String add=sc.next();
			System.out.println("Gender: ");
			String gen=sc.next();
			System.out.println("Enter your vaccination details (ONE,TWO,NIL): ");
			String vac=sc.next();
			Passenger passob=new Passenger(name,age,number,add,gen,vac);
      System.out.println("\n\n------------------------------------------------------------");
			
      TrainDetails obj = new TrainDetails();
      obj.trains(); 

      System.out.println("------------------------------------------------------------");

      
      System.out.println("ENTER TRAIN NUMBER: ");
      train_num = sc.nextInt();
			
			try{
				if(train_num!=1240 && train_num!=1242 && train_num!=1243 && train_num!=1245 && train_num!=1247 && train_num!=1249){
					throw new TrainNotFoundException("Train number not found");
				}
			}
			catch(TrainNotFoundException e){
				System.out.println(e.text+"\n"+ e);
			}


			
      switch(train_num)
      {
        case 1240:
              System.out.println("Enter the number  of seats you want to book: ");
               num_seats = sc.nextInt();
              Train t1=new Train(1240,100,90,110,"Chennai","Bangalore","17:00","21:00",780.50,670.25,500.00,"Shadabti Express" );
              System.out.println("------------------------------------------------------------");

				       t1.display_train();

               System.out.println("------------------------------------------------------------");
               System.out.println("Enter Class of the train:\n1.AC SECOND TIER\n2.AC THIRD TIER\n3.NON-AC");
               class_choice = sc.nextInt();
               switch(class_choice)
               {
                 case 1:
                 if(t1.reserve_ac2(num_seats) ==1)
                 {
                   System.out.println("\n\n");
                   t1.payment();
                   System.out.println("Your ticket has been booked successfully!");
                   System.out.println("\n\n------------------------------------------------------------");
                   System.out.println("\t\t\t\tETICKET - RAILWAYS");
                   passob.passenger_display();
                   t1.print_ticket();
									 System.out.println("\n");
                   System.out.println("......You have booked " +num_seats+ " seats......\n");
                   System.out.println("TICKET COST: " +t1.calc_ac2(num_seats));
                   System.out.println("\n------------------------------------------------------------");
                 }
                  else
                  {
                    System.out.println("SORRY! Unable to book your ticekts!");
                  }
                  break;
                  
                 case 2:
                   if(t1.reserve_ac3(num_seats) ==1)
                 {
                   System.out.println("\n\n");
                   t1.payment();
                   System.out.println("Your ticket has been booked successfully!");
                   System.out.println("\n\n------------------------------------------------------------");
                   System.out.println("\t\t\t\tETICKET - RAILWAYS");
                   passob.passenger_display();
                   t1.print_ticket();
									 System.out.println("\n");
                   System.out.println("......You have booked " +num_seats+ " seats......\n");
                   System.out.println("TICKET COST: " +t1.calc_ac3(num_seats));
                   System.out.println("\n--------------------------------------------------------------------------------------");
                }
                
                 else
                  {
                    System.out.println("SORRY! Unable to book your ticekts!");
                  }
                  break;

                 case 3:
                 if(t1.reserve_non(num_seats) ==1)
                 {
                   System.out.println("\n\n");
                   t1.payment();
                   System.out.println("Your ticket has been booked successfully!");
                   System.out.println("\n\n--------------------------------------------------------------------------------------");
                   System.out.println("\t\t\t\tETICKET - RAILWAYS");
                   passob.passenger_display();
                   t1.print_ticket();
									 System.out.println("\n");
                   System.out.println("......You have booked " +num_seats+ " seats......\n");
                   System.out.println("TICKET COST: " +t1.calc_non(num_seats));
                   System.out.println("\n--------------------------------------------------------------------------------------");
                 }
                 else
                  {
                    System.out.println("SORRY! Unable to book your ticekts!");
                  }
                  break;
               }
               break;
        
        
        
        case 1242:
              System.out.println("Enter the number  of seats you want to book: ");
              int seat_num = sc.nextInt();
					    Train t2=new Train(1242,150,70,80,"Chennai","Mumbai","8:00","14:00",1100.50,900,700,"Chennai Express");
              t2.display_train();
               System.out.println("Enter Class of the train:\n1.AC SECOND TIER\n2.AC THIRD TIER\n3.NON-AC");
               class_choice = sc.nextInt();
               switch(class_choice)
               {
                 case 1:
                 if(t2.reserve_ac2(seat_num) ==1)
                 {
                   System.out.println("\n\n");
                   t2.payment();
                   System.out.println("Your ticket has been booked successfully!");
                   System.out.println("\n\n--------------------------------------------------------------------------------------");
                   System.out.println("\t\t\t\tETICKET - RAILWAYS");
                   passob.passenger_display();
                   t2.print_ticket();
									 System.out.println("\n");
                   System.out.println("......You have booked " +seat_num+ " seats......\n");
                   System.out.println("TICKET COST: " +t2.calc_ac2(seat_num));
                   System.out.println("\n--------------------------------------------------------------------------------------");
                 }
                  else
                  {
                    System.out.println("SORRY! Unable to book your ticekts!");
                  }
                  break;
                  
                 case 2:
                   if(t2.reserve_ac3(seat_num) ==1)
                 {
                   System.out.println("\n\n");
                   t2.payment();
                   System.out.println("Your ticket has been booked successfully!");
                   System.out.println("\n\n--------------------------------------------------------------------------------------");
                   System.out.println("\t\t\t\tETICKET - RAILWAYS");
                   passob.passenger_display();
                   t2.print_ticket();
									 System.out.println("\n");
                   System.out.println("......You have booked " +seat_num+ " seats......\n");
                   System.out.println("TICKET COST: " +t2.calc_ac3(seat_num));
                   System.out.println("\n--------------------------------------------------------------------------------------");
                }
                
                 else
                  {
                    System.out.println("SORRY! Unable to book your ticekts!");
                  }
                  break;

                 case 3:
                 if(t2.reserve_non(seat_num) ==1)
                 {
                   System.out.println("\n\n");
                   t2.payment();
                   System.out.println("Your ticket has been booked successfully!");
                   System.out.println("\n\n--------------------------------------------------------------------------------------");
                   System.out.println("\t\t\t\tETICKET - RAILWAYS");
                   passob.passenger_display();
                   t2.print_ticket();
									 System.out.println("\n");
                   System.out.println("......You have booked " +seat_num+ " seats......\n");
                   System.out.println("TICKET COST: " +t2.calc_non(seat_num));
                   System.out.println("\n--------------------------------------------------------------------------------------");
                 }
                 else
                  {
                    System.out.println("SORRY! Unable to book your ticekts!");
                  }
                  break;
               }
               break;

               
        case 1243:
                System.out.println("Enter the number  of seats you want to book: ");
                int n_s = sc.nextInt();
                Train t3=new Train(1243,110,80,110,"Chennai","Madurai","6:00","13:45",850.25,690.50,500,"Super Express");
                t3.display_train();
               System.out.println("Enter Class of the train:\n1.AC SECOND TIER\n2.AC THIRD TIER\n3.NON-AC");
               class_choice = sc.nextInt();
               switch(class_choice)
               {
                 case 1:
                 if(t3.reserve_ac2(n_s) ==1)
                 {
                   System.out.println("\n\n");
                   t3.payment();
                   System.out.println("Your ticket has been booked successfully!");
                   System.out.println("\n\n--------------------------------------------------------------------------------------");
                   System.out.println("\t\t\t\tETICKET - RAILWAYS");
                   passob.passenger_display();
                   t3.print_ticket();
									 System.out.println("\n");
                   System.out.println("......You have booked " +n_s+ " seats......\n");
                   System.out.println("TICKET COST: " +t3.calc_ac2(n_s));
                   System.out.println("\n--------------------------------------------------------------------------------------");
                 }
                  else
                  {
                    System.out.println("SORRY! Unable to book your ticekts!");
                  }
                  break;
                  
                 case 2:
                   if(t3.reserve_ac3(n_s) ==1)
                 {
                   System.out.println("\n\n");
                   t3.payment();
                   System.out.println("Your ticket has been booked successfully!");
                   System.out.println("\n\n--------------------------------------------------------------------------------------");
                   System.out.println("\t\t\t\tETICKET - RAILWAYS");
                   passob.passenger_display();
                   t3.print_ticket();
									 System.out.println("\n");
                   System.out.println("......You have booked " +n_s+ " seats......\n");
                   System.out.println("TICKET COST: " +t3.calc_ac3(n_s));
                   System.out.println("\n--------------------------------------------------------------------------------------");
                }
                
                 else
                  {
                    System.out.println("SORRY! Unable to book your ticekts!");
                  }
                  break;

                 case 3:
                 if(t3.reserve_non(n_s) ==1)
                 {
                   System.out.println("\n\n");
                   t3.payment();
                   System.out.println("Your ticket has been booked successfully!");
                   System.out.println("\n\n--------------------------------------------------------------------------------------");
                   System.out.println("\t\t\t\tETICKET - RAILWAYS");
                   passob.passenger_display();
                   t3.print_ticket();
									 System.out.println("\n");
                   System.out.println("......You have booked " +n_s+ " seats......\n");
                   System.out.println("TICKET COST: " +t3.calc_non(n_s));
                   System.out.println("\n--------------------------------------------------------------------------------------");
                 }
                 else
                  {
                    System.out.println("SORRY! Unable to book your ticekts!");
                  }
                  break;
               }
               break;
                
        case 1245:
                System.out.println("Enter the number  of seats you want to book: ");
                int s_n = sc.nextInt();
				      	Train t4=new Train(1245,95,95,110,"Chennai","Hyderabad","13:00","8:00",1300.50,1100,800,"Raj Express");
                 t4.display_train();
                 System.out.println("Enter Class of the train:\n1.AC SECOND TIER\n2.AC THIRD TIER\n3.NON-AC");
               class_choice = sc.nextInt();
               switch(class_choice)
               {
                 case 1:
                 if(t4.reserve_ac2(s_n) ==1)
                 {
                   System.out.println("\n\n");
                   t4.payment();
                   System.out.println("Your ticket has been booked successfully!");
                   System.out.println("\n\n--------------------------------------------------------------------------------------");
                   System.out.println("\t\t\t\tETICKET - RAILWAYS");
                   passob.passenger_display();
                   t4.print_ticket();
									 System.out.println("\n");
                   System.out.println("......You have booked " +s_n+ " seats......\n");
                   System.out.println("TICKET COST: " +t4.calc_ac2(s_n));
                   System.out.println("\n--------------------------------------------------------------------------------------");
                 }
                  else
                  {
                    System.out.println("SORRY! Unable to book your ticekts!");
                  }
                  break;
                  
                 case 2:
                   if(t4.reserve_ac3(s_n) ==1)
                 {
                   System.out.println("\n\n");
                   t4.payment();
                   System.out.println("Your ticket has been booked successfully!");
                   System.out.println("\n\n--------------------------------------------------------------------------------------");
                   System.out.println("\t\t\t\tETICKET - RAILWAYS");
                   passob.passenger_display();
                   t4.print_ticket();
									 System.out.println("\n");
                   System.out.println("......You have booked " +s_n+ " seats......\n");
                   System.out.println("TICKET COST: " +t4.calc_ac3(s_n));
                   System.out.println("\n--------------------------------------------------------------------------------------");
                }
                
                 else
                  {
                    System.out.println("SORRY! Unable to book your ticekts!");
                  }
                  break;

                 case 3:
                 if(t4.reserve_non(s_n) ==1)
                 {
                   System.out.println("\n\n");
                   t4.payment();
                   System.out.println("Your ticket has been booked successfully!");
                   System.out.println("\n\n--------------------------------------------------------------------------------------");
                   System.out.println("\t\t\t\tETICKET - RAILWAYS");
                   passob.passenger_display();
                   t4.print_ticket();
									 System.out.println("\n");
                   System.out.println("......You have booked " +s_n+ " seats......\n");
                   System.out.println("TICKET COST: " +t4.calc_non(s_n));
                   System.out.println("\n--------------------------------------------------------------------------------------");
                 }
                 else
                  {
                    System.out.println("SORRY! Unable to book your ticekts!");
                  }
                  break;
               }
               break;
        
         case 1247:
                 System.out.println("Enter the number  of seats you want to book: ");
                 int ns = sc.nextInt();
                Train t5=new Train(1247,105,85,100,"Chennai","Delhi","21:00","10:00",1700,1400,1200,"Rajdhani Express" );
                t5.display_train();
                 System.out.println("Enter Class of the train:\n1.AC SECOND TIER\n2.AC THIRD TIER\n3.NON-AC");
               class_choice = sc.nextInt();
               switch(class_choice)
               {
                 case 1:
                 if(t5.reserve_ac2(ns) ==1)
                 {
                   System.out.println("\n\n");
                   t5.payment();
                   System.out.println("Your ticket has been booked successfully!");
                   System.out.println("\n\n--------------------------------------------------------------------------------------");
                   System.out.println("\t\t\t\tETICKET - RAILWAYS");
                   passob.passenger_display();
                   t5.print_ticket();
									 System.out.println("\n");
                   System.out.println("......You have booked " +ns+ " seats......\n");
                   System.out.println("TICKET COST: " +t5.calc_ac2(ns));
                   System.out.println("\n--------------------------------------------------------------------------------------");
                 }
                  else
                  {
                    System.out.println("SORRY! Unable to book your ticekts!");
                  }
                  break;
                  
                 case 2:
                   if(t5.reserve_ac3(ns) ==1)
                 {
                   System.out.println("\n\n");
                   t5.payment();
                   System.out.println("Your ticket has been booked successfully!");
                   System.out.println("\n\n--------------------------------------------------------------------------------------");
                   System.out.println("\t\t\t\tETICKET - RAILWAYS");
                   passob.passenger_display();
                   t5.print_ticket();
									 System.out.println("\n");
                   System.out.println("......You have booked " +ns+ " seats......\n");
                   System.out.println("TICKET COST: " +t5.calc_ac3(ns));
                   System.out.println("\n--------------------------------------------------------------------------------------");
                }
                
                 else
                  {
                    System.out.println("SORRY! Unable to book your ticekts!");
                  }
                  break;

                 case 3:
                 if(t5.reserve_non(ns) ==1)
                 {
                   System.out.println("\n\n");
                   t5.payment();
                   System.out.println("Your ticket has been booked successfully!");
                   System.out.println("\n\n--------------------------------------------------------------------------------------");
                   System.out.println("\t\t\t\tETICKET - RAILWAYS");
                   passob.passenger_display();
                   t5.print_ticket();
									 System.out.println("\n");
                   System.out.println("......You have booked " +ns+ " seats......\n");
                   System.out.println("TICKET COST: " +t5.calc_non(ns));
                   System.out.println("\n--------------------------------------------------------------------------------------");
                 }
                 else
                  {
                    System.out.println("SORRY! Unable to book your ticekts!");
                  }
                  break;
               }
               break;

        case 1249:
                System.out.println("Enter the number  of seats you want to book: ");
                int sn = sc.nextInt();
					      Train t6=new Train(1249,120,95,120,"Chennai","Coimbatore","14:00","21:00",900,800,700,"Double Decker Express");
				        t6.display_train();
                System.out.println("Enter Class of the train:\n1.AC SECOND TIER\n2.AC THIRD TIER\n3.NON-AC");
               class_choice = sc.nextInt();
               switch(class_choice)
               {
                 case 1:
                 if(t6.reserve_ac2(sn) ==1)
                 {
                   System.out.println("\n\n");
                   t6.payment();
                   System.out.println("Your ticket has been booked successfully!");
                   System.out.println("\n\n--------------------------------------------------------------------------------------");
                   System.out.println("\t\t\t\tETICKET - RAILWAYS");
                   passob.passenger_display();
                   t6.print_ticket();
									 System.out.println("\n");
                   System.out.println("......You have booked " +sn+ " seats......\n");
                   System.out.println("TICKET COST: " +t6.calc_ac2(sn));
                   System.out.println("\n--------------------------------------------------------------------------------------");
                 }
                  else
                  {
                    System.out.println("SORRY! Unable to book your ticekts!");
                  }
                  break;
                  
                 case 2:
                   if(t6.reserve_ac3(sn) ==1)
                 {
                   System.out.println("\n\n");
                   t6.payment();
                   System.out.println("Your ticket has been booked successfully!");
                   System.out.println("\n\n--------------------------------------------------------------------------------------");
                   System.out.println("\t\t\t\tETICKET - RAILWAYS");
                   passob.passenger_display();
                   t6.print_ticket();
									 System.out.println("\n");
                   System.out.println("......You have booked " +sn+ " seats......\n");
                   System.out.println("TICKET COST: " +t6.calc_ac3(sn));
                   System.out.println("\n--------------------------------------------------------------------------------------");
                }
                
                 else
                  {
                    System.out.println("SORRY! Unable to book your ticekts!");
                  }
                  break;

                 case 3:
                 if(t6.reserve_non(sn) ==1)
                 {
                   System.out.println("\n\n");
                   t6.payment();
                   System.out.println("Your ticket has been booked successfully!");
                   System.out.println("\n\n--------------------------------------------------------------------------------------");
                   System.out.println("\t\t\t\tETICKET - RAILWAYS");
                   passob.passenger_display();
                   t6.print_ticket();
									 System.out.println("\n");
                   System.out.println("......You have booked " +sn+ " seats......\n");
                   System.out.println("TICKET COST: " +t6.calc_non(sn));
                   System.out.println("\n--------------------------------------------------------------------------------------");
                 }
                 else
                  {
                    System.out.println("SORRY! Unable to book your ticekts!");
                  }
                  break;
               }
			}
      break;
			
			case 2:
				TrainDetails td = new TrainDetails();
        td.trains();
				System.out.println("\nEnter the train number:");
				int num=sc.nextInt();
				Routes route= new Routes(num);
        route.trainRoutes(num);
				break;

			/*case 3:
				TrainDetails ob=new TrainDetails();
				on.trains();
				System.out.println("\nEnter the train number:");
				int num=sc.nextInt();
				*/


  }

	System.out.println("\nDO YOU WANT TO BOOK AGAIN?\n\nPress 1 to continue or press 0 to terminate");
	cont=sc.nextInt();

	}while(cont==1);
 }
}

     
        
    
    