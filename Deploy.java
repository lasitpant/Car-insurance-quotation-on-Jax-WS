package quotation;

import javax.xml.ws.Endpoint;

import vetting.LocalVettingService;
/*
 * deploying the 4 web services on ports 9000-9003
 */
public class Deploy {
	public static void main(String[] args) throws Exception
	{
	
	        Endpoint.publish("http://localhost:9001/QuotationService/generateQuotation", new AFQService());
	        Endpoint.publish("http://localhost:9002/QuotationService/generateQuotation", new DDQService());
	        Endpoint.publish("http://localhost:9003/QuotationService/generateQuotation", new GPQService());
	        Endpoint.publish("http://localhost:9000/VettingService/vetClient", new LocalVettingService());
	        
	  }

    }
