package com.example.myfirstprogramhit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView result;
    Double num1= 0.0;
    Double num2= 0.0;
    String oper= "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textViewResult);

    }

    public void buttonFunctionNumber(View view) {
        if (view instanceof Button){
            Button button = (Button) view;
            String str = button.getText() +"";
            if(oper.equals("")){//אם לא הוקלד אופרטור אז נכניס את זה לנאם 1
                num1= num1*10 + Double.valueOf(str);
            }
            else{//אפ הוקלד כבר אופרטור אז נכניס את זה לנאם 2
                num2= num2*10 + Double.valueOf(str);
            }
            result.append(str);
        }
    }

    public void buttonOpera(View view) {
        if (view instanceof Button) {
            Button button = (Button) view;
            String str = button.getText() + "";
            oper = str;
            result.append(str);
        }
    }

    public void buttonEqual(View view) {
        if (view instanceof Button) {
            Button button = (Button) view;
            String str = button.getText() + "";
            String answer= null;
            answer=Calculation();
            if(answer!=null){
                result.setText("");
                result.append(answer);
                num1=Double.valueOf(answer);
                num2=0.0;
                oper="";
            }
        }
    }

    public String Calculation () {
        String answer=null;
        if(oper.equals("+")){
            answer= String.valueOf(num1+num2);
        }
        if(oper.equals("-")){
            answer= String.valueOf(num1-num2);
        }
        if(oper.equals("X")){
            answer= String.valueOf(num1*num2);
        }
        if(oper.equals("/")){
            answer= String.valueOf(num1/num2);
        }
        return answer;
    }


    public void buttonAC(View view) {

        result.setText("");
    }
}
