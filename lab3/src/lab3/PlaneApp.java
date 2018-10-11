package lab3;
import java.util.Scanner;

public class PlaneApp {
public static void main(String[] args) {
	System.out.println("1 Show number of empty seats");
	System.out.println("2 show the list of empty seats");
	System.out.println("3 show list of empty seats by seatID");
	System.out.println("4 show list of seats by customer ID");
	System.out.println("5 assign a customer to a seat");
	System.out.println("6 remove a seat assignment");
	System.out.println("7 exit");
	
	Scanner sc= new Scanner(System.in);
	System.out.print("Enter the number of your choice: ");
	int choice = sc.nextInt();
	
	Plane plane1 = new Plane();
	
	while(choice != 7) {
		switch(choice) {
		case 1:
			plane1.showNumEmptySeats();
			break;
	
		case 2:
			plane1.showEmptySeats();
			break;
			
		case 3:
			plane1.showAssignedSeats(true);
			System.out.println();
			break;
		case 4:
			plane1.sortSeats();
			plane1.showAssignedSeats(false);
			break;
		case 5:
			System.out.println("Assigning Seat .. ");
			System.out.println("Enter seat ID");
			int seatId = sc.nextInt();
			System.out.println("Enter customer ID");
			int customerId = sc.nextInt();
			plane1.assignSeat( seatId,  customerId);
			break;
		case 6:
			System.out.println("Enter seat ID");
			int seatId1 = sc.nextInt();
			plane1.unAssignSeat(seatId1);
			break;
			
		}
		System.out.println();
		System.out.print("Enter the number of your choice: ");
		choice = sc.nextInt();
		
	}
	System.out.println("exit...");
}

}
