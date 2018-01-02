package ser210.quinnipiac.edu.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {

    private EditText input1, input2;
    private TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        input1 = (EditText) findViewById(R.id.input1);
        input2 =  (EditText) findViewById(R.id.input2);
        res = (TextView) findViewById(R.id.result);

        Button btnAddition = (Button) findViewById(R.id.addition);
        btnAddition.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                performOp('+');
            }
        });

        Spinner opSpinner = (Spinner) findViewById(R.id.opSpinner);
        opSpinner.setSelection(0,false);
        opSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                  String item = (String) parent.getItemAtPosition(position);
                if (item.equals("*"))
                    performOp('*');
                else
                    performOp('/');
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void onClickSubtraction(View v){
        performOp('-');
    }
    private double performOp(char op){
        Log.v("Debug","method performOp called");
        if ((input1.getText() != null) && (input2.getText() != null) ) {

            double num1 = Double.valueOf(input1.getText().toString());
            double num2 = Double.valueOf(input2.getText().toString());
            Log.v("Debug","num 1 " + num1 + "num 2" + num2 );
            double result = 0;

            switch (op) {
                case '+':
                    result = num1 +num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1  * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;

            }
            res.setText(Double.toString(result));
            return result;
        }
        return 0;
    }
}
