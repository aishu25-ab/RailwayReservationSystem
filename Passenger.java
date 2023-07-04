package PassengerRailways;
public class Passenger{
    String name;
    int age;
    String phone_no;
    String address;
    String gender;
		String covid_vac;

    public Passenger(String name,int age,String phone_no,String address,String gender,String covid_vac){
        this.name=name;
        this.age=age;
        this.phone_no=phone_no;
        this.address=address;
        this.gender=gender;
				this.covid_vac=covid_vac;
    }

		public void passenger_display(){
			System.out.print("\nNAME:"+name);
			System.out.print("\t\t\t\t\tPHONE NUMBER:"+phone_no);
			System.out.print("\n\nADDRESS:"+address);
			System.out.print("\t\t\t\t\tGENDER:"+gender);
			System.out.print("\n\nCOVID VACCINATION DETAILS:"+covid_vac);
			System.out.println("\n\n");
		}
}



 