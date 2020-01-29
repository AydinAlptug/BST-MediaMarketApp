package Media;

public class Book implements IMedia{
	private String name;
	private int price;
	private int year;
	private String authorName;
	private String type = "book";
	//public String toString();

	public Book(String name,int price,int year,String author) {
		setName(name);
		setPrice(price);
		setYear(year);
		setAuthorName(author);
		
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	
	
	
	@Override
	public String mediaName() {
		return name;
	}



	@Override
	public String mediaType() {
		return type;
	}

	@Override
	public int mediaPrice() {
		return price;
	}

	@Override
	public int mediaYear() {
		return year;
	}

	@Override
	public String person() {
		return authorName;
	}
}
