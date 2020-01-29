package App;
import java.io.FileNotFoundException;
import java.util.Scanner;
import ADT.*;
import FileIO.*;
import Media.*;
/**
 * 
 * @author Yusuf Alptuð AYDIN
 * @author Fatih YILMAZ
 */
public class Test{
	FileIO fio = new FileIO();
	ListADT<Item> al;
	
	public void test() throws FileNotFoundException {
		IList<Item> list = fio.readItems();
		BinaryST tree = new BinaryST();
		tree.setTree(list.getEntry(1));
		for(int i = 2; i<=list.getLength(); i++) 
			tree.add(list.getEntry(i));
		al = tree.toList();	
		
		 /**Demanding tasks to test manually are frozen**/
		  /*
		 	//minOrMaxPricedMedia("Sabahattin Ali","book","min");
			//minOrMaxPricedMedia("Sabahattin Ali","book","max");
			//minOrMaxPricedMedia("Chris Weitz","movie","max");
			//greater(30);
			//lessOrEqual(9);
			//ascendingAll();
			//descendingAll();
			//ascendingSpecific("book");
			//descendingSpecific("movie");
			*/
		//for(int i=0; i<tree.toArray().length;i++)
			//System.out.println(tree.toArray()[i]);
	
		
		System.out.println("Welcome to the Iztech Media Market...");
		String message = "->Enter 1 to see all media\n"+
		"->Enter 2 to see minimum priced book of a specific author\n"+
		"->Enter 3 to see maximum priced book of a specific author\n"+
		"->Enter 4 to see minimum priced movie of a specific director\n"+
		"->Enter 5 to see maximum priced movie of a specific director\n"+
		"->Enter 6 to see the products cheaper or equal than a specific amount\n"+
		"->Enter 7 to see the products expensive than a specific amount\n"+
		"->Enter 8 to see all products in descending order\n"+
		"->Enter 9 to see all products in ascending order\n"+
		"->Enter 10 to see books in descending order\n"+
		"->Enter 11 to see books in ascending order\n"+
		"->Enter 12 to see movies in descending order\n"+
		"->Enter 13 to see movies in ascending order\n"+
		"->Enter 14 to see options again"+
		"->Press q to leave...";
		System.out.println(message);
		
			String demand;
			String type;
			boolean flag = true;
			Scanner scanner = new Scanner(System.in);
			while(flag) {
				
				System.out.println("What is your wish: ");
				String response = scanner.nextLine();
				switch(response) {
				case "1":
					printAllMedia();
					break;
				case "2": 
					System.out.println("Enter his/her name: ");
					minOrMaxPricedMedia(scanner.nextLine(),"book","min");
				break;
				case "3": 
					System.out.println("Enter his/her name: ");
					minOrMaxPricedMedia(scanner.nextLine(),"book","max");
				break;
				case "4": 
					System.out.println("Enter his/her name: ");
					minOrMaxPricedMedia(scanner.nextLine(),"movie","min");
				break;
				case "5": 
					System.out.println("Enter his/her name: ");
					minOrMaxPricedMedia(scanner.nextLine(),"movie","max");
				break;
				case "6":
					System.out.println("Enter the amount: ");
					lessOrEqual(scanner.nextInt());
					break;
				case "7":
					System.out.println("Enter the amount: ");
					greater(scanner.nextInt());
					break;
				case "8":
					descendingAll();
					break;
				case "9":
					ascendingAll();
					break;
				case "10":
					descendingSpecific("book");
					break;
				case "11":
					ascendingSpecific("book");
					break;
				case "12":
					descendingSpecific("movie");
					break;
				case "13":
					ascendingSpecific("movie");
					break;
				case "14":
					System.out.println(message);
					break;
				case "q":
					flag = false;
					System.out.println("Goodbye..");
					break;
				
				default: 
					break;
					
					
				}				
			}
	}
	
	public void minOrMaxPricedMedia(String person,String type,String demand){
		Item result=null;
		boolean exists=false;
		if(person != null &&  type != null && demand != null) {
			for(int i = 1; i <= al.getLength();i++) {
				if(al.getEntry(i).getMedia().mediaType().equals(type))
				{
					if(al.getEntry(i).getMedia().person().equals(person)) {
						
						if(result == null) {
							exists = true;
							result = al.getEntry(i);
						}
							
						if(demand.equals("min") && 
								result.getPrice()>al.getEntry(i).getPrice()) {
							exists = true;
							result = al.getEntry(i);
						}
							
						if(demand.equals("max") &&
								result.getPrice()<al.getEntry(i).getPrice()) {
							exists = true;
							result = al.getEntry(i);
						}
										
						
					}
					
				}
				
				
			}
			if(exists == true)
				System.out.println(result.getMedia().mediaName());
			else
				System.out.println("No product exists of: " + person);	
		}
		else
			throw new IllegalArgumentException();
	}
	public void lessOrEqual(int amount) {
		if(amount>0) {
			for(int i=1; i<=al.getLength();i++) {
				if(al.getEntry(i).getMedia().mediaPrice() <= amount)
					System.out.println(al.getEntry(i).getMedia().mediaName());
			}
			System.out.println("There is no such an item..");
		}
		else
			throw new IllegalArgumentException();
	}
	public void greater(int amount) {
		if(amount>0) {
			for(int i=1; i<=al.getLength();i++) {
				if(al.getEntry(i).getMedia().mediaPrice() > amount)
					System.out.println(al.getEntry(i).getMedia().mediaName());
			}
			System.out.println("There is no such an item..");
		}
		else
			throw new IllegalArgumentException();
	}
	public void descendingAll() {
		for(int i = al.getLength(); i >=1;i--) 
			System.out.println(al.getEntry(i).getMedia().mediaName()
					+ ": "+al.getEntry(i).getMedia().mediaPrice());
	}
	public void ascendingAll() {
		for(int i = 1; i <=al.getLength();i++) 
			System.out.println(al.getEntry(i).getMedia().mediaName()
					+ ": "+al.getEntry(i).getMedia().mediaPrice());
	}
	public void descendingSpecific(String type) {
		if(type != null) {
			for(int i = al.getLength(); i >=1;i--) {
				if(al.getEntry(i).getMedia().mediaType().equals(type))
					System.out.println(al.getEntry(i).getMedia().mediaName()
							+ ": "+al.getEntry(i).getMedia().mediaPrice());
			}
		}
		else
			throw new IllegalArgumentException();
	}
	public void ascendingSpecific(String type) {
		if(type != null) {
			for(int i = 1; i <=al.getLength();i++) {
				if(al.getEntry(i).getMedia().mediaType().equals(type))
					System.out.println(al.getEntry(i).getMedia().mediaName()
							+ ": "+al.getEntry(i).getMedia().mediaPrice());
			}
		}
		else 
			throw new IllegalArgumentException();
	}
	public void printAllMedia() {
		for(int i=1;i<=al.getLength();i++)
			System.out.println(al.getEntry(i).getMedia().mediaName()+": "
					+al.getEntry(i).getMedia().mediaPrice());
	
	}
}
