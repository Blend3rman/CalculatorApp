package com.calc;

import com.example.calculator.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.lang.StringBuilder;
import android.view.View;

public class DispCalc extends Activity{

	Button[] btn = new Button[10];										//numeric Buttons
	Button plusBtn, minusBtn, multBtn, divBtn, decBtn, cancBtn, percBtn, eqBtn, signBtn, delBtn;		//operator Buttons
	
	boolean isSwitched = false;
	
	TextView usrInTxt, opTxt;											//Input and Output textviews
	
	StringBuilder usrIn = new StringBuilder(12);						//StringBuilder obj for storing user input
	
	    //Array to store ids of numeric buttons
	private static final int idArr[] ={R.id.Btn0, 
									   R.id.Btn1, 
									   R.id.Btn2, 
									   R.id.Btn3, 
									   R.id.Btn4, 
									   R.id.Btn5, 
									   R.id.Btn6, 
									   R.id.Btn7, 
									   R.id.Btn8, 
									   R.id.Btn9};
	
	protected void calcDo() {
		// TODO Implement stack concept of calculator
		// TODO Let's use Polish notation, infix for input, 
		//      convert to postfix and calculate
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		
		/** CAN USE findViewById() NOW **/
		
		plusBtn = (Button) findViewById(R.id.plusBtn);
		plusBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				usrIn.append('+');
			}
		});
		
		minusBtn = (Button) findViewById(R.id.minusBtn);
		minusBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				usrIn.append('-');
			}
		});
		
		multBtn = (Button) findViewById(R.id.multBtn);
		multBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				usrIn.append('x');
			}
		});
		
		divBtn = (Button) findViewById(R.id.divideBtn);
		divBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				usrIn.append('/');
			}
		});
		
		decBtn = (Button) findViewById(R.id.decBtn);
		decBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				usrIn.append('.');
			}
		});
		
		cancBtn = (Button) findViewById(R.id.cancelBtn);
		cancBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				usrIn.delete(0, usrIn.length()-1);
			}
		});
		
		percBtn = (Button) findViewById(R.id.percBtn);
		percBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				usrIn.append('p');
			}
		});
		
		eqBtn = (Button) findViewById(R.id.equalsBtn);
		eqBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				calcDo();
			}
		});
		
		signBtn = (Button) findViewById(R.id.signBtn);
		signBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				usrIn.insert(0, '-');
			}
		});
		
		delBtn = (Button) findViewById(R.id.DELBtn);
		delBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				usrIn.deleteCharAt(usrIn.length()-1);
			}
		});
		
		/** ASSIGN NUMERIC BUTTONS TO VIEWS, ATTACH onClickListeners **/
		
		for(int i=0; i<idArr.length; i++) {
			
			final int a = i;
			
			btn[a] = (Button) findViewById(idArr[a]);
			btn[a].setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					
					usrIn.append(String.valueOf(a));
				}
				
				
			});
			
		}
		
		usrInTxt = (TextView) findViewById(R.id.usrInTxt);
		usrInTxt.setText(usrIn);
		
		
	}
	

}
