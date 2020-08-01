package test;
public class ProductData {
	public String Code,Name;
	public double Price;
	public int Qty;
	public ProductData(String Code,String Name,double Price,int Qty)
	{
		this.Code=Code;
		this.Name=Name;
		this.Price=Price;
		this.Qty=Qty;
	}
	public String toString(){
		return Code+"\t"+Name+"\t"+Price+"\t"+Qty;
	}

}
