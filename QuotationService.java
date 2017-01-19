package quotation;

import javax.jws.WebMethod;
import javax.jws.WebService;

import core.ClientInfo;
import core.Quotation;

/**
 * Interface to define the behavior of a quotation service.
 * Declaring QuotationService interface as Web service.
 *
 */
@WebService

public interface QuotationService {
	@WebMethod public Quotation generateQuotation(ClientInfo info);
	
	
	}
