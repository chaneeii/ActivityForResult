package kr.ac.konkuk.activityforresult_201713079;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity2 extends AppCompatActivity {


    EditText edit;
    Button button_ok, button_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        edit = (EditText) findViewById(R.id.edit2);

        button_ok = (Button) findViewById(R.id.button_ok);

        button_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("INPUT_TEXT2", edit.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        button_cancel = (Button) findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }




}