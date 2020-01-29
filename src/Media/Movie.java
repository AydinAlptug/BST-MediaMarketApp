package Media;

public class Movie implements IMedia{
	private String name;
	private int price;
	private int year;
	private String directorName;
	private String actressName;
	private String actorName;
	private String type = "movie";
	//public String toString();
	
	public Movie(String name,int price,int year,String directorName,
					String actressName,String actorName) {
		setName(name);
		setPrice(price);
		setYear(year);
		setDirectorName(directorName);
		setActressName(actressName);
		setActorName(actorName);
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

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public void setActressName(String actressName) {
		this.actressName = actressName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	@Override
	public String mediaName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String mediaType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public int mediaPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public int mediaYear() {
		// TODO Auto-generated method stub
		return year;
	}

	@Override
	public String person() {
		return directorName;
	}
	
}
