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

        //UI init
        edit = (EditText) findViewById(R.id.edit2);
        button_ok = (Button) findViewById(R.id.button_ok);
        button_cancel = (Button) findViewById(R.id.button_cancel);


        // // 입력완료 버튼을 누른경우,
        button_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //인텐트를 생성하여
                Intent intent = new Intent();

                // edit의 값을 INPUT_TEXT2로 생성하여 extra에 추가하여 결과로 전달 후 현재 인텐트 종료
                intent.putExtra("INPUT_TEXT2", edit.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        // 취소 버튼을 누른 경우 resuly를 RESULT_CANCELED로 설정하여 값이 넘어가지 않게하고 현재 엑티비티 종료
        button_cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }




}