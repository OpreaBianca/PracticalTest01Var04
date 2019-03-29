package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {

    public class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            //Toast.makeText(getApplicationContext(), total + "", Toast.LENGTH_LONG).show();
            if (view.getId() == R.id.cancel_button) {
                setResult(RESULT_CANCELED, null);
            }
            else {
                setResult(RESULT_OK, null);
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_secondary);
        EditText inputFiled = (EditText) findViewById(R.id.button_names_second);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("input")) {
            String inputF = intent.getStringExtra("input");
            inputFiled.setText(inputF);
        }

        Button cancel = findViewById(R.id.cancel_button);
        cancel.setOnClickListener(new ButtonClickListener());

        Button verify = findViewById(R.id.verify_button);
        verify.setOnClickListener(new ButtonClickListener());
    }

}
