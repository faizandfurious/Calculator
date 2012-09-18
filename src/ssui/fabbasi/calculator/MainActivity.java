package ssui.fabbasi.calculator;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	//VARIABLES
	
	//Global
	boolean operated;
	Context context;
	
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
	Button clear;
	Button mult;
	Button equals;
	TextView output;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        //Initialize all the buttons
        initialize();
    }
    //This method attaches each button on the screen to a Button object.
    private void initialize() {
    	operated = false;
    	context = getApplicationContext();
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
		clear = (Button) findViewById(R.id.clearButton);
		equals = (Button) findViewById(R.id.equalsButton);
		output = (TextView) findViewById(R.id.output);
		
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
		equals.setOnClickListener(this);
		clear.setOnClickListener(this);
		
	}
    
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		
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
			
		//OPERATORS
		//If an operator has already been added to the output textview, then no additional operators will be added.
		case R.id.divButton:
			if(!operated)
				output.append("/");
				operated = true;
			break;
		case R.id.plusButton:
			if(!operated)
				output.append("+");
				operated = true;
			break;
		case R.id.multButton:
			if(!operated)
				output.append("*");
				operated = true;
			break;
		case R.id.minusButton:
			if(!operated)
				output.append("-");
				operated = true;
			break;
			
		//MISC
		//Remove all text from the output when clearButton is called.
		case R.id.clearButton:
			output.setText("");
			operated = false;
			break;
		//Remove all text from the output when clearButton is called.
		case R.id.equalsButton:
			CharSequence c = output.getText();
			calculate(c);
			break;

		}
		
	}

	private void calculate(CharSequence c) {
		int size = c.length();
		int i = 0;
		int duration = Toast.LENGTH_LONG;
		if(Character.getNumericValue(c.charAt(0)) < 48 || Character.getNumericValue(c.charAt(0)) > 57){
			Toast.makeText(context, "Please enter correct information", duration).show();	
		}
		Toast.makeText(context, "Please enter correct information", duration).show();
		while(i < size){
			
			
			i++;
		}
		
	}
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }


    
}
