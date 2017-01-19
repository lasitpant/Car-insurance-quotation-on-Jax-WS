package impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import core.BrokerService;
import core.ClientInfo;
import core.Quotation;
import quotation.QuotationService;
import vetting.VettingService;

public class WSBrokerService implements BrokerService
{

	public List<Quotation> getQuotations(ClientInfo info)
	{
		List<Quotation> quotations=new LinkedList<Quotation>();
		try
		{
		
            URL AFQURL = new URL("http://localhost:9001/QuotationService/generateQuotation?wsdl");
            QName qname = new QName("http://quotation/", "AFQServiceService");
            Service service = Service.create(AFQURL, qname);
            QuotationService AFQService = service.getPort(QuotationService.class);
       
            URL DDQURL = new URL("http://localhost:9002/QuotationService/generateQuotation?wsdl");
            QName qname2 = new QName("http://quotation/", "DDQServiceService");
            Service service2 = Service.create(DDQURL, qname2);
            QuotationService DDQService = service2.getPort(QuotationService.class);

            
            
            URL GPQURL = new URL("http://localhost:9003/QuotationService/generateQuotation?wsdl");
            QName qname3 = new QName("http://quotation/", "GPQServiceService");
            Service service3 = Service.create(GPQURL, qname3);
            QuotationService GPQService = service3.getPort(QuotationService.class);

           
            URL vetUrl = new URL("http://localhost:9000/VettingService/vetClient?wsdl");
            QName qname0 = new QName("http://vetting/", "LocalVettingServiceService");
            Service service0 = Service.create(vetUrl, qname0);

            VettingService LocalVettingService = service0.getPort(VettingService.class);
			
            if(LocalVettingService.vetClient(info))
            {
            	quotations.add(AFQService.generateQuotation(info));
            	quotations.add(DDQService.generateQuotation(info));
            	quotations.add(GPQService.generateQuotation(info));
            }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return quotations;
	
		}

    
   }
