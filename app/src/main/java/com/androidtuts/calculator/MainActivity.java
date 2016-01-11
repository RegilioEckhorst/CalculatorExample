package com.androidtuts.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static int number1; // The first number of the calculator.
    public static int number2; // The second number of the calculator.
    private String buttonPressed = ""; //buttonPressed is to check which of the math button is pressed.
    private boolean number1Selected = false; // numberSelected is to check if number 1 or 2 is selected from the calculator.
    private boolean number2Selected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }

    public void buttonOnClick(View v) {
        // buttonOnClick is to check which button has been pressed and change the text of which button you pressed.

        Button button = (Button) v;
        String btext = button.getText().toString();

        if (number1Selected == false) {
            number1 = Integer.parseInt(btext);
            TextView myTextView = (TextView)
                    findViewById(R.id.textView);
            myTextView.setText(Integer.toString(number1));
            number1Selected =true;

        }else if ( number1Selected == true && number2Selected == false) {
            number2 = Integer.parseInt(btext);
            TextView myTextView2 = (TextView)
                    findViewById(R.id.textView2);
            myTextView2.setText(Integer.toString(number2));
            number2Selected = true;

        }

    }

    public void multiplyButtonClick(View v) {
        // This method is for when the '*' button on the calculator has been pressed

        buttonPressed = "multiply";
        TextView multiply = (TextView) findViewById(R.id.textView4);
        multiply.setText("*");
    }

    public void divisionButtonClick(View v) {
        // This method is for when the '/' button on the calculator has been pressed

        buttonPressed = "division";
        TextView division = (TextView) findViewById(R.id.textView4);
        division.setText("/");
    }


    public void additionButtonClick(View v) {
        // This method is for when the '+' button on the calculator has been pressed

        buttonPressed = "plus";
        TextView plus = (TextView) findViewById(R.id.textView4);
        plus.setText("+");
    }

    public void substractionButtonClick(View v) {
        // This method is for when the '-' button on the calculator has been pressed
        buttonPressed = "minus";
        TextView minGetal = (TextView) findViewById(R.id.textView4);
        minGetal.setText("-");
    }

    public void totalButtonClick(View v) {
        // This method is for when the '=' button on the calculator has been pressed
        int total;
        TextView isGetal = (TextView) findViewById(R.id.textView5);
        isGetal.setText("=");



        /*The following if-statements are to check what we will calculate. so if the variable buttonPresed that we declared earlier is equal to, for example, "plus", then
        we will do number 1 + number 2 and if the variable */

        if (buttonPressed.equals("plus")) {
            total = number1 + number2;
            TextView totaalGetal = (TextView) findViewById(R.id.textViewTotal);
            totaalGetal.setText(Integer.toString(total));
        } else if (buttonPressed.equals("minus")) {
            total = number1 - number2;
            TextView totaalGetal = (TextView) findViewById(R.id.textViewTotal);
            totaalGetal.setText(Integer.toString(total));
        }
        else if (buttonPressed.equals("division")){
            total = (number1 / number2);
            TextView totaalGetal = (TextView) findViewById(R.id.textViewTotal);
            totaalGetal.setText(Integer.toString(total));
        }

        else if (buttonPressed.equals("multiply")){
            total = number1 * number2;
            TextView totaalGetal = (TextView) findViewById(R.id.textViewTotal);
            totaalGetal.setText(Integer.toString(total));
        }
    }


    public void clearButtonClick(View v) {

        // This method is for when the clear button is pressed. It resets every view to 0 and the selected numbers to false.

        number1 =0;
        number2 =0;

        TextView myTextView = (TextView)
                findViewById(R.id.textView);
        myTextView.setText(Integer.toString(0));

        TextView myTextView2 = (TextView)
                findViewById(R.id.textView2);
        myTextView2.setText(Integer.toString(0));

        TextView myTextView3 = (TextView)
                findViewById(R.id.textViewTotal);
        myTextView3.setText(Integer.toString(0));

        TextView myTextView4 = (TextView)
                findViewById(R.id.textView4);
        myTextView4.setText("");

        number1Selected = false;
        number2Selected = false;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
