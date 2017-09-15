package com.example.subramani_5647.simplecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText leftOperand;
    private EditText rightOperand;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftOperand = (EditText) findViewById(R.id.leftOperand);
        rightOperand = (EditText) findViewById(R.id.rightOperand);
        result = (TextView) findViewById(R.id.result);

    }

    @Override
    public void onClick(View view) {

        int viewId = view.getId();
        if ( viewId == R.id.clear ) {
            leftOperand.setText("");
            rightOperand.setText("");
            result.setText(getResources().getString(R.string.result));
            leftOperand.requestFocus();
            return;
        }

        double leftOp;
        double rightOp;
        try {
            leftOp = Double.parseDouble(leftOperand.getText().toString());
            rightOp = Double.parseDouble(rightOperand.getText().toString());
        } catch ( NumberFormatException e ) {
            result.setText(getResources().getString(R.string.result));
            return;
        }

        Calculator calculator = new Calculator(leftOp, rightOp);
        switch ( viewId ) {
            case R.id.plus :
                result.setText( String.valueOf( calculator.add() ) );
                break;
            case R.id.minus :
                result.setText( String.valueOf( calculator.subtract() ) );
                break;
            case R.id.multiply:
                result.setText( String.valueOf( calculator.multiply() ) );
                break;
            case R.id.divide :
                try {
                    result.setText(String.valueOf(calculator.divide()));
                } catch ( ArithmeticException e ) {
                    result.setText(getResources().getString(R.string.divide_by_zero));
                }
                break;
        }

    }
}
