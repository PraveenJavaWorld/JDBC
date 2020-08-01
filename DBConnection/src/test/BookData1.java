package test;
public class BookData1 {
	public String Name,Author;
	public float Price;
	public int Qty;
	public BookData1(String Name,String Author,float Price,int Qty)
	{
		this.Name=Name;
		this.Author=Author;
		this.Price=Price;
		this.Qty=Qty;
	}
	public String toString(){
		return Name+"\t"+Author+"\t"+Price+"\t"+Qty;
	}

}
