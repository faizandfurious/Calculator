package ssui.fabbasi.calculator;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	//VARIABLES
	
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
		clear = (Button) findViewById(R.id.clearButton);
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
		case R.id.clearButton:
			output.setText("");
			break;

		}
		
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }


    
}
