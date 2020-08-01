package test;
public class BookData {
	public String Code,Name,Author;
	public float Price;
	public int Qty;
	public BookData(String Code,String Name,String Author,float Price,int Qty)
	{
		this.Code=Code;
		this.Name=Name;
		this.Author=Author;
		this.Price=Price;
		this.Qty=Qty;
	}
	public String toString(){
		return Code+"\t"+Name+"\t"+Author+"\t"+Price+"\t"+Qty;
	}

	

}
