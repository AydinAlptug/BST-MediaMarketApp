package Media;

public class Item implements Comparable{

	private IMedia media;
	private int price;
	
	public Item(IMedia media) {
		setMedia(media);
		setPrice(media.mediaPrice());
	}
	
	public IMedia getMedia() {
		return media;
	}
	public void setMedia(IMedia media) {
		this.media = media;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int compareTo(Object o) {
		if(o == null)
			throw new NullPointerException();
		if(o.getClass() != Item.class) 
			throw new IllegalArgumentException();
		else {
			if(media.mediaPrice()<((Item) o).getPrice())
				return -1;
			if(media.mediaPrice()==((Item) o).getPrice())
				return 0;
			else
				return 1;
		}	
	}
	
}
