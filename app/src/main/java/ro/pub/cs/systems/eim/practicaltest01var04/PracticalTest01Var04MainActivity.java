package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {
    public int total = 0;
    public class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            total += 1;
            //Toast.makeText(getApplicationContext(), total + "", Toast.LENGTH_LONG).show();
            if (view.getId() != R.id.navigate_button) {
                EditText inputFiled = (EditText) findViewById(R.id.button_names);
                String txt = inputFiled.getText().toString();
                String btnTxt = ((Button)view).getText().toString();
                txt = txt.concat(", ");
                txt = txt.concat(btnTxt);
                inputFiled.setText(txt);
            }
            else {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04SecondaryActivity.class);
                EditText inputFiled = (EditText) findViewById(R.id.button_names);
                String txt = inputFiled.getText().toString();
                intent.putExtra("input", txt);
                startActivityForResult(intent, 1);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);

        Button navigate = findViewById(R.id.navigate_button);
        navigate.setOnClickListener(new ButtonClickListener());

        Button topLeft = findViewById(R.id.top_left_button);
        topLeft.setOnClickListener(new ButtonClickListener());

        Button topRight = findViewById(R.id.top_right_button);
        topRight.setOnClickListener(new ButtonClickListener());

        Button center = findViewById(R.id.center_button);
        center.setOnClickListener(new ButtonClickListener());

        Button bottomLeft = findViewById(R.id.bottom_left_button);
        bottomLeft.setOnClickListener(new ButtonClickListener());

        Button bottomRight = findViewById(R.id.bottom_right_button);
        bottomRight.setOnClickListener(new ButtonClickListener());

        //Toast.makeText(getApplicationContext(), this.total + "", Toast.LENGTH_LONG).show();
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("TOTAL")){
                this.total = savedInstanceState.getInt("TOTAL", 0);
                Toast.makeText(getApplicationContext(), this.total + "", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("TOTAL", this.total);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        this.total = 0;

    }
}
