package exceptions;
import rocketDomain.RateDomainModel;

public class RateException extends Exception {

	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	//	* Add RateRomainModel as an attribute
	//	* Create a constructor, passing in RateDomainModel
	//	* Create a getter (no setter, set value only in Constructor)
	private RateDomainModel r;
	public RateException(RateDomainModel r) {
		System.out.println("Did not qualify for loan");
		
	}
	public RateDomainModel getR() {
		return r;
	}
}
