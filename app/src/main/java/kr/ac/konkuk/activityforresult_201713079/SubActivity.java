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

        //UI init
        edit1 = (EditText) findViewById(R.id.edit1);
        tv_sub2 = (TextView) findViewById(R.id.textview_sub2);
        button_sub2 = (Button) findViewById(R.id.button_sub2);
        button_ok = (Button) findViewById(R.id.button_ok);
        button_cancel = (Button) findViewById(R.id.button_cancel);


        // 입력완료 버튼을 누른경우,
        button_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //인텐트를 생성하여
                Intent intent = new Intent();

                // edit1과 tv_sub2(subactivity2에서 받아온것) 의 내용을 extra에 추가하여 현재 엑티비티를 호출한 곳에 보내줌.
                intent.putExtra("INPUT_TEXT1", edit1.getText().toString());
                intent.putExtra("INPUT_TEXT2", tv_sub2.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        // 취소 버튼을 누른 경우 result를 RESULT_CANCELED로 설정하여 값이 넘어가지 않게하고 현재 엑티비티 종료
        button_cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });


        //subactivity2로 전환
        button_sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //subactivity2로 Result를 받는 형태로 인텐트 전환
                Intent in = new Intent(SubActivity.this, SubActivity2.class);
                startActivityForResult(in, GET_STRING);
            }
        });



    }

    // subactivity2에서 결과를 제대로 받은 경우, tv_sub2 (텍스트뷰)에 결과로 받은 extra, INPUT_TEXT2를 텍스트로 설정.
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