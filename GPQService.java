package quotation;

import java.rmi.Remote;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.Endpoint;

import core.AbstractQuotationService;
import core.ClientInfo;
import core.Quotation;

/**
 * Implementation of the Girl Power insurance quotation service.
 *
 */

@WebService(name="QuotationService")
//@SOAPBinding(style = Style.RPC, use=Use.LITERAL)
//public class GPQService extends AbstractQuotationService implements QuotationService {
public class GPQService extends AbstractQuotationService implements QuotationService {
/* All references are to be prefixed with an AF (e.g. AF001000)
*	public static void main(String args[]) throws Exception {
*      Endpoint.publish("http://localhost:9003/QuotationService/generateQuotation", new GPQService());
*  }
*/
	// All references are to be prefixed with an DD (e.g. DD001000)
	public static final String PREFIX = "GP";
	
	/**
	 * Implementation of the Quotation interface for the Girl Power Service
	 */
		
	/**
	 * Quote generation:
	 * 50% discount for being female
	 * 20% discount for no penalty points
	 * 15% discount for < 3 penalty points
	 * no discount for 3-5 penalty points
	 * 100% penalty for > 5 penalty points
	 * 5% discount per year no claims
	 */
	@Override
	public Quotation generateQuotation(ClientInfo info) {
		// Create an initial quotation between 600 and 1000
		double price = generatePrice(600, 400);
		
		// Automatic 50% discount for being female
		int discount = (info.getSex() == ClientInfo.FEMALE) ? 50:0;
		
		// Add a points discount
		discount += getPointsDiscount(info);
		
		// Add a no claims discount
		discount += getNoClaimsDiscount(info);
		
		// Generate the quotation and send it back
		Quotation q = new Quotation();
		
		// Use the reference generator to create a reference
		//quotation.reference = generateReference(PREFIX);
		//quotation.info = info;
		//quotation.price = (price * (100-discount)) / 100;
		q.setReference(generateReference(PREFIX));
		q.setInfo(info);
		q.setPrice((price * (100-discount)) / 100);
		
		return q;
	}

	private int getNoClaimsDiscount(ClientInfo info) {
		return 5*info.getNoClaims();
	}

	private int getPointsDiscount(ClientInfo info) {
		if (info.getPoints() == 0) return 20;
		if (info.getPoints() < 3) return 15;
		if (info.getPoints() < 6) return 0;
		return -100;
		
	}

}
