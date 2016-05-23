package rocket.app.view;



import eNums.eAction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	private MainApp mainApp;
	
	//	TODO - RocketClient.RocketMainController
	
	//	Create private instance variables for:
	//		TextBox  - 	txtIncome
	//		TextBox  - 	txtExpenses
	//		TextBox  - 	txtCreditScore
	//		TextBox  - 	txtHouseCost
	//		ComboBox -	loan term... 15 year or 30 year
	//		Labels   -  various labels for the controls
	//		Button   -  button to calculate the loan payment
	//		Label    -  to show error messages (exception throw, payment exception)
	private TextField txtIncome;
	private TextField txtExpenses;
	private TextField txtCreditScore;
	private TextField txtHouseCost;
	private ComboBox cmbTerm;
	private Label Income;
	private Label Expenses;
	private Label CreditScore;
	private Label HouseCost;
	private Label lblMortgagePayment;
	
	
	

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	private void initialize() {
		ObservableList<String> options = FXCollections.observableArrayList("15 Years", "30 Years");
		final ComboBox cmbTerm = new ComboBox(options);
	}
	
	
	//	TODO - RocketClient.RocketMainController
	//			Call this when btnPayment is pressed, calculate the payment
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;
		//	TODO - RocketClient.RocketMainController
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		//	TODO - RocketClient.RocketMainController
		//			set the loan request details...  rate, term, amount, credit score, downpayment
		//			I've created you an instance of lq...  execute the setters in lq
		lq.setdAmount(Double.parseDouble(txtHouseCost.getText()));
		//lq.setdRate(dRate);
		lq.setiCreditScore((int)Double.parseDouble(txtCreditScore.getText()));
		//lq.setiDownPayment(iDownPayment);
		if (cmbTerm.getValue()=="15 Years") {
			lq.setiTerm(15*12);
		}
		else if(cmbTerm.getValue() == "30 Years") {
			lq.setiTerm(30*12);
		}
		

		a.setLoanRequest(lq);
		
		//	send lq as a message to RocketHub		
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		//	TODO - RocketClient.HandleLoanRequestDetails
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		double payment = lRequest.getdPayment();
		if (payment<= 0.36*(lRequest.getIncome()/12) && payment <= 0.28*(lRequest.getIncome()/12 - lRequest.getExpenses())) {
			System.out.format("%.2f", payment);
		}
		
	}
}
