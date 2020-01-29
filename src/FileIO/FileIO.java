package FileIO;

import java.io.*;
import java.util.Scanner;

import ADT.*;
import Media.*;

public class FileIO {

	
	
	public IList<Item> readItems() throws FileNotFoundException {
		
		Scanner scanner = new Scanner(new FileReader(new File("Media.txt")));
		IMedia product = null;
		IList<IMedia> list = new ListADT<IMedia>();
		IList<Item> itemList = new ListADT<Item>();
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] array = line.split(",");	
			if(array[0].equals("Book")) 
				product = new Book(array[1],Integer.parseInt(array[2]),
						Integer.parseInt(array[3]),array[4]);
			else if(array[0].equals("Movie")) {
				if(array.length==7)
					product = new Movie(array[1],Integer.parseInt(array[2]),
						Integer.parseInt(array[3]),array[4],array[5],array[6]);
				else 
					product = new Movie(array[1],Integer.parseInt(array[2]),
						Integer.parseInt(array[3]),array[4],array[5],null);
			}
				
			else break;
			
			list.add(product);
			Item item = new Item(product);
			itemList.add(item);
		}
	//	for(int i=0; i<list.getLength();i++)
	//		System.out.println(list.getEntry(i+1).mediaName());
	
	//	return list;
		return itemList;
	}
	
}
