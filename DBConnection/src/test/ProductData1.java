package test;
public class ProductData1 {
	public String Name;
	public double Price;
	public int Qty;
	public ProductData1(String Name,double Price,int Qty)
	{
		this.Name=Name;
		this.Price=Price;
		this.Qty=Qty;
	}
	public String toString(){
		return Name+"\t"+Price+"\t"+Qty;
	}


}
