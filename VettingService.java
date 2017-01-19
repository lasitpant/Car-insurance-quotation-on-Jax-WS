package vetting;

import javax.jws.WebMethod;
import javax.jws.WebService;
import core.ClientInfo;

/**
 * Interface defining for  the expected behavior of a vetting service.
 * Declaring VettingService interface as web service.
 */
@WebService
public interface VettingService {
	@WebMethod public boolean vetClient(ClientInfo info);
}
