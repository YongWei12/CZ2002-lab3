package lab3;

public class Plane {
private PlaneSeat[] seat;
private int numEmptySeat;
private PlaneSeat[] copy;

public Plane() {
	seat = new PlaneSeat[12];
	numEmptySeat =12;
	for(int i =0 ; i<seat.length ;i++) {
		seat[i] =new PlaneSeat(i+1); 
	}
};

public PlaneSeat[] sortSeats(){
	copy= new PlaneSeat[12] ;
	for (int i=0 ; i<seat.length ;i++) {
		copy[i] = seat[i];
	}
	
	PlaneSeat temp;
	
	for (int i = 1; i < copy.length; i++) {
		for (int j = i; j > 0; j--) {
			 if (copy[j].getCustomerID()< copy [j - 1].getCustomerID()) {
				 temp = copy[j];
				 copy[j]=copy[j-1];
				 copy[j-1]=temp;
			 }
		}
		
	}
	return copy;
	
}

public void showNumEmptySeats() {
	System.out.println("number of empty seats "+numEmptySeat);
}

public void showEmptySeats() {
	System.out.println("The following seats are empty: ");
	for(int i=0; i<seat.length ; i++) {
		if(seat[i].isOccupied() == false ) {
			System.out.println("SeatID " + seat[i].getSeatID());
		}
	}
}

public void showAssignedSeats(boolean bySeatId ) {
	if(bySeatId == true) {
		for(int i=0; i<seat.length ;i++) {
			if(seat[i].isOccupied() == true ) {
				System.out.println("SeatID "+ seat[i].getSeatID() +" assigned to CustomerID" + seat[i].getCustomerID() );
				
			}
		}
	}
	else {
		for(int i=0; i<copy.length; i++) {
			if(copy[i].isOccupied() == true ) {
				System.out.println("SeatID "+ copy[i].getSeatID() +" assigned to CustomerID" + copy[i].getCustomerID() );
				
			}
		}
	}
	
	
}

public void assignSeat(int seatId ,int cust_id ) {
	if(seat[seatId-1].isOccupied() == false) {
		seat[seatId-1].assign(cust_id);
		numEmptySeat--;
		System.out.println("assigned");
	}
	else {
		System.out.println("Seat already assigned to a customer. ");
	}
	
	
}

public void unAssignSeat(int seatId) {
	if(seat[seatId-1].isOccupied() == true) {
		seat[seatId-1].unAssign();
		numEmptySeat++;
		System.out.println("Seat Unassigned!");
	}
}


}
