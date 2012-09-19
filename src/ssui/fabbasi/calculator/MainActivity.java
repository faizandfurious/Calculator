package ssui.fabbasi.calculator;


import java.math.BigDecimal;
import java.math.RoundingMode;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnLongClickListener {

	//VARIABLES
	
	//Global
	boolean operated;
	boolean decimal;
	Context context;
	int duration;
	
	//Integer buttons
	Button doublezero;
	Button zero;
	Button one;
	Button two;
	Button three;
	Button four;
	Button five;
	Button six;
	Button seven;
	Button eight;
	Button nine;
	
	//Operator buttons
	Button mult;
	Button div;
	Button minus;
	Button plus;
	
	//Misc buttons
	Button clear;
	Button dec;
	Button equals;
	
	//Output textview
	TextView output;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        //Initialize all the variables
        initialize();
    }
    //This method attaches each button on the screen to a Button object.
    private void initialize() {
    	
    	//Operated stores the boolean condition of whether an operator has been added to the textview. If true, then
    	//the user will not be able to add another operator until the output textbox is cleared.
    	operated = false;
    	
    	//Decimal stores the boolean condition of whether a decimal has been added to the current number. If true,
    	//new decimals cannot be added until a new number is introduced.
    	decimal = false;
    	
    	//Get context for Toast messages.
    	context = getApplicationContext();
		//Create a duration int for our toast method.
		duration = Toast.LENGTH_SHORT;
    	
    	//Set all the buttons to appropriate button variables
    	doublezero = (Button) findViewById(R.id.dubZeroButton);
		zero = (Button) findViewById(R.id.zeroButton);
		one = (Button) findViewById(R.id.oneButton);
		two = (Button) findViewById(R.id.twoButton);
		three = (Button) findViewById(R.id.threeButton);
		four = (Button) findViewById(R.id.fourButton);
		five = (Button) findViewById(R.id.fiveButton);
		six = (Button) findViewById(R.id.sixButton);
		seven = (Button) findViewById(R.id.sevenButton);
		eight = (Button) findViewById(R.id.eightButton);
		nine = (Button) findViewById(R.id.nineButton);
		mult = (Button) findViewById(R.id.multButton);
		div = (Button) findViewById(R.id.divButton);
		minus = (Button) findViewById(R.id.minusButton);
		plus = (Button) findViewById(R.id.plusButton);
		dec = (Button) findViewById(R.id.decButton);
		clear = (Button) findViewById(R.id.clearButton);
		equals = (Button) findViewById(R.id.equalsButton);
		output = (TextView) findViewById(R.id.output);
		
		//Call the setOnClickListener method on each button to assign proper functionality
		doublezero.setOnClickListener(this);
		zero.setOnClickListener(this);
		one.setOnClickListener(this);
		two.setOnClickListener(this);
		three.setOnClickListener(this);
		four.setOnClickListener(this);
		five.setOnClickListener(this);
		six.setOnClickListener(this);
		seven.setOnClickListener(this);
		eight.setOnClickListener(this);
		nine.setOnClickListener(this);
		mult.setOnClickListener(this);
		div.setOnClickListener(this);
		minus.setOnClickListener(this);
		plus.setOnClickListener(this);
		dec.setOnClickListener(this);
		equals.setOnClickListener(this);
		clear.setOnClickListener(this);
		
		//EXTRA CREDIT: Add a longClickListener to the clear button.
		clear.setOnLongClickListener(this);
		
	}
    
    //This method will clear the output textview, and reset the operated and decimal booleans.
	@Override
	public boolean onLongClick(View v) {
		output.setText("");
		operated = false;
		decimal = false;
		return false;
	}
    
    //This overridden method assigns the functionality to a given Button id
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		
		
		//NUMBERS
		//Whenever a number is pressed, it is appended to the output textview.
		case R.id.dubZeroButton:
			output.append("00");
			break;
		case R.id.zeroButton:
			output.append("0");
			break;
		case R.id.oneButton:
			output.append("1");
			break;
		case R.id.twoButton:
			output.append("2");
			break;
		case R.id.threeButton:
			output.append("3");
			break;
		case R.id.fourButton:
			output.append("4");
			break;
		case R.id.fiveButton:
			output.append("5");
			break;
		case R.id.sixButton:
			output.append("6");
			break;
		case R.id.sevenButton:
			output.append("7");
			break;
		case R.id.eightButton:
			output.append("8");
			break;
		case R.id.nineButton:
			output.append("9");
			break;
		//Check if the decimal boolean is true. If so, do not add a decimal. Otherwise add a decimal and turn the decimal boolean to true.
		case R.id.decButton:
			if(!decimal)
				output.append(".");
				decimal = true;
			break;
			
		//OPERATORS
		//If an operator has already been added to the output textview, then no additional operators will be added.
		//Set the decimal boolean to false, so that the next number can have a decimal added to it.
		case R.id.divButton:
			if(!operated)
				output.append("/");
				operated = true;
				decimal = false;
			break;
		case R.id.plusButton:
			if(!operated)
				output.append("+");
				operated = true;
				decimal = false;
			break;
		case R.id.multButton:
			if(!operated)
				output.append("*");
				operated = true;
				decimal = false;
			break;
		case R.id.minusButton:
			if(!operated)
				output.append("-");
				operated = true;
				decimal = false;
			break;
			
		case R.id.equalsButton:
			//First store the CharSequence from the output textbox, then pass it to the calculate method to do the necessary operations.
			CharSequence c = output.getText();
			//If c has characters (length is greater than zero), then call the calculate method. Otherwise do nothing.
			if(c.length() > 0){
				calculate(c);
			}
			break;	
			
		//EXTRA CREDIT
		//Remove last entered char from the output textview when short clicked. If the removed char is a decimal, then
		//set the decimal boolean to false to allow another decimal place for the current integer. Otherwise if the removed
		//char is not numerical, then assume it is an operator and set the operated boolean to false to allow another operator
		//to be added. Otherwise remove the last char.
		case R.id.clearButton:
			CharSequence cs = output.getText();
			if(cs.length() > 0){
				if(cs.charAt(cs.length() - 1) == '.'){
					output.setText(cs.subSequence(0, cs.length() - 1));
					decimal = false;
					
				}
				if(Character.getNumericValue(cs.charAt(cs.length() - 1)) == -1){
					output.setText(cs.subSequence(0, cs.length() - 1));
					operated = false;
				}
				else{
					output.setText(cs.subSequence(0, cs.length() - 1));
				}
			}
			break;

		}
		
	}

	//This method is used to do calculations for the Calculator.
	private void calculate(CharSequence c) {
		//Store the size of the CharSequence.
		int size = c.length();
		
		//Create two BigDecimal objects to store the two numbers (in case they are decimals)
		BigDecimal first = null;
		BigDecimal second = null;
		
		//Create a BigDecimal object to store the answer of the operation.
		BigDecimal answer;
		
		//Use this StringBuffer to stream in the input. Resets when an operator is given.
		StringBuffer sb = new StringBuffer();
		
		//Create a char to store the operator.
		char operator = 0;
		
		//Create a boolean to indicate if an operator has been found.
		boolean curr_operate = false;
		
		//Create a counter, starting at zero.
		int i = 0;
		
		//If the value of the first is not a number, throw an error (Toast message) and reset the output textbox and operated boolean.
		if(Character.getNumericValue(c.charAt(0)) == -1){
			Toast.makeText(context, "You must start with a number.", duration).show();
			output.setText("");
			operated = false;
		}
		
		else{
			//Iterate through the CharSequence
			while(i < size){
				//This check tells us whether we are creating the first or second number. If operate is false, then we are still
				//creating the first number. Otherwise we are replicating the second.
				if(!curr_operate){
					//If the current char is a decimal, add it to the StringBuffer.
					if(c.charAt(i) == '.'){
						sb.append(c.charAt(i));
					}
					//Check to verify that the current char is a number. If so, add it to a temporary CharSequence object.
					else if(Character.getNumericValue(c.charAt(i)) != -1){
						sb.append(Character.getNumericValue(c.charAt(i)));
					}
					//If the char is not a decimal or a number, it is the operator.
					else{
						//Store the operator in a char.
						operator = c.charAt(i);
						//Change the operate boolean to true, so we know that we have the first integer and the operator.
						curr_operate = true;
						//Cast the StringBuffer object into a String, so we can convert to a BigDecimal.
						String str = sb.toString();
						//Assign the number value to the first BigDecimal object.
						first = new BigDecimal(str);
						//Reset the StringBuffer object.
						sb = new StringBuffer();
					}
				}
				//We are now looking for the second number.
				else{					
					if(c.charAt(i) == '.'){
						sb.append(c.charAt(i));
					}
					//Because we already ensured there would be only one operator, and the only other available values are integers,
					//we add the remainder of the chars to the second StringBuffer object.
					else{ 
						sb.append(Character.getNumericValue(c.charAt(i)));
					}
				}
				i++;
			}
			//If, after iterating through the whole CharSequence, there is no operator, give a toast error and reset the output textbox
			//and operated boolean;
			if(!curr_operate){
				Toast.makeText(context, "You did not provide an operation.", duration).show();
				output.setText("");
				operated = false;
			}
			
			else{
				//If the StringBuffer is null, that implies that there were no numbers after the operator, and we were given a bad
				//input. So we return an error (toast message).
				if(sb.length() == 0){
					Toast.makeText(context, "You must provide two numbers", duration).show();	
					output.setText("");
				}
				else{
					//Cast the StringBuffer object into a String, so we can convert to a BigDecimal.
					String str = sb.toString();
					//Assign the number value to the first BigDecimal object.
					second = new BigDecimal(str);
				
					//If the operator is a plus sign, do an addition operation on the two values.
					if(operator == '+'){
						answer = first.add(second);
						output.setText(answer.toString());
					}
					//If the operator is a minus sign, do a subtraction operation on the two values.
					else if(operator == '-'){
						answer = first.subtract(second);
						output.setText(answer.toString());
					}
					//If the operator is a multiplication sign, do a multiplication operation on the two values.
					if(operator == '*'){
						answer = first.multiply(second);
						output.setText(answer.toString());
					}
					//If the operator is a dividing sign, do a division operation on the two values.
					if(operator == '/'){
						if(second.compareTo(BigDecimal.ZERO) == 0){
							Toast.makeText(context, "You cannot divide by zero!", duration).show();	
							output.setText("");
						}
						else{
							//To remove chance of non-terminating decimal expansion, we must limit the size of the decimal.
							answer = first.divide(second, 10, RoundingMode.HALF_UP);
							output.setText(answer.toString());
						}
					}
				}
					
				//Allow the user to operate on the output.
				operated = false;
			}
			
		}
		
	}
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }


    
}
