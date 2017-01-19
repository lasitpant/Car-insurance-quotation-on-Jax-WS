package core;

/**
 * Interface to define the data to be stored in Quotation objects.
 * 
 */
public class Quotation {
		
	// for each service to be a web service we need to 
	//transform the interfaces into data beans.
	
	private String reference;
	private ClientInfo info;
	private double price;
	
	public Quotation(String reference, ClientInfo info, double price)
	{
		this.reference=reference;
		this.info=info;
		this.price=price;
	}
	public void setReference(String reference)
	{
		this.reference = reference;
	}
	public String getReference()
	{
		return reference;
	}
	
	public void setInfo(ClientInfo info)
	{
		this.info = info;
	}
	public ClientInfo getInfo()
	{
		return info;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	public double getPrice()
	{
		return price;
	}

	public Quotation()
	{
	}
}
