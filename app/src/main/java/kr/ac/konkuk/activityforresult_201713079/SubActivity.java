package kr.ac.konkuk.activityforresult_201713079;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    static final int GET_STRING = 1;

    EditText edit1;
    TextView tv_sub2;
    Button button_sub2, button_ok, button_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);



        edit1 = (EditText) findViewById(R.id.edit1);
        tv_sub2 = (TextView) findViewById(R.id.textview_sub2);
        button_sub2 = (Button) findViewById(R.id.button_sub2);
        button_ok = (Button) findViewById(R.id.button_ok);
        button_cancel = (Button) findViewById(R.id.button_cancel);


        button_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("INPUT_TEXT1", edit1.getText().toString());
                intent.putExtra("INPUT_TEXT2", tv_sub2.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });


        button_cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });


        //subactivity2 -  인텐트 전환
        button_sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(SubActivity.this, SubActivity2.class);
                startActivityForResult(in, GET_STRING);
            }
        });



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_STRING) {
            if (resultCode == RESULT_OK) {
                tv_sub2.setText(data.getStringExtra("INPUT_TEXT2"));
            }
        }
    }

}