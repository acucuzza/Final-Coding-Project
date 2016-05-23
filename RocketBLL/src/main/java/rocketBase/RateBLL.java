package rocketBase;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;

import java.util.ArrayList;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		//TODO - RocketBLL RateBLL.getRate - make sure you throw any exception
		
		//		Call RateDAL.getAllRates... this returns an array of rates
		//		write the code that will search the rates to determine the 
		//		interest rate for the given credit score
		//		hints:  you have to sort the rates...  you can do this by using
		//			a comparator... or by using an OrderBy statement in the HQL
		ArrayList <RateDomainModel> rates = new ArrayList <RateDomainModel> (RateDAL.getAllRates());
		double interestRate = 0;
		for(RateDomainModel rate : rates) {
			if(GivenCreditScore == rate.getiMinCreditScore()) {
				interestRate = rate.getdInterestRate();
			}
			else if(rates.contains(GivenCreditScore)) {
				continue;
			}
			else {
				throw new RateException();
			}
		}
		
		
		//TODO - RocketBLL RateBLL.getRate
		//			obviously this should be changed to return the determined rate
		return interestRate;
		
		
	}
	
	
	//TODO - RocketBLL RateBLL.getPayment 
	//		how to use:
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return Math.abs(FinanceLib.pmt(r, n, p, f, t));
	}
}
