package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class rate_test {

	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	@Test
	public void testRate(){
		try {
	
		assertTrue(RateBLL.getRate(600) == 5);
		assertTrue(RateBLL.getRate(650) == 4.5);
		assertTrue(RateBLL.getRate(700) == 4);
		assertTrue(RateBLL.getRate(750) == 3.75);
		assertTrue(RateBLL.getRate(800) == 3.5);
		
	} catch (RateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.err.println("You Do Not Qualify For A Loan");
	}
	}
	
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void RateExceptionTest() throws Exception {
		double rate = RateBLL.getRate(900);
		ArrayList <RateDomainModel> rates = new ArrayList <RateDomainModel> (RateDAL.getAllRates());
		assertTrue(!(rates.contains(rate)));
	}
	
	
	@Test
	public void paymentTest() {
		double payment = RateBLL.getPayment(4,30,300000,0,false);
		assertEquals("$1432.25",payment,1432.25);
		
	}


	@Test
	public void test() {
		assert(1==1);
	}

}
