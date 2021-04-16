package domain;

public class Item {
	private String Name;
	private String Id;
	private int Size;
	public void Item(String Name, String Id, int Size) {
		this.Name = Name;
		this.Id = Id;
		this.Size = Size;
	}
	public String getName() {
		return this.Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getId() {
		return this.Id;
	}
	public void setId(String Id) {
		this.Id = Id;
	}
	public int getSize() {
		return this.Size;
	}
	public void setSize(int Size) {
		this.Size = Size;
	}
}
