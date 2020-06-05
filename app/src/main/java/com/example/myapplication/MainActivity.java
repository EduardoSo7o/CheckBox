package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.exceptions.NonNumberTypedException;
import com.example.myapplication.exceptions.NonOperationSelectedException;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private CheckBox checkBoxAdd;
    private CheckBox checkBoxSub;
    private TextView textViewRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText)findViewById(R.id.et_num1);
        editText2 = (EditText)findViewById(R.id.et_num2);
        checkBoxAdd = (CheckBox)findViewById(R.id.cb_addition);
        checkBoxSub = (CheckBox)findViewById(R.id.cb_subtraction);
        textViewRes = (TextView)findViewById(R.id.tv_result);
    }

    public void calculate(View view){
        try {
            String value1_String = editText1.getText().toString();
            String value2_String = editText2.getText().toString();

            if(value1_String.equals("") || value2_String.equals(""))
                throw new NonNumberTypedException();

            int value1 = Integer.parseInt(value1_String);
            int value2 = Integer.parseInt(value2_String);

            String result = "";

            if(checkBoxAdd.isChecked()) {
                result += "Adittion: " + String.valueOf(value1 + value2);
                if (checkBoxSub.isChecked())
                    result += "  Subtraction: " + String.valueOf(value1 - value2);
            }else if(checkBoxSub.isChecked()) {
                result += "Subtraction: " + String.valueOf(value1 - value2);
            }else
                throw new NonOperationSelectedException();

            textViewRes.setText(result);

        }catch (NonNumberTypedException e) {
            Toast.makeText(this, "Type both numbers", Toast.LENGTH_SHORT).show();
        } catch (NonOperationSelectedException e) {
            Toast.makeText(this, "Select at least one operation", Toast.LENGTH_SHORT).show(); 
        }
    }
}