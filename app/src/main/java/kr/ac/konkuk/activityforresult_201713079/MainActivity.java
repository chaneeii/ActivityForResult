package kr.ac.konkuk.activityforresult_201713079;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final int GET_STRING = 1;
    TextView text1, text2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UI init
        Button button = (Button) findViewById(R.id.button);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);


        // 서브 액티비티로 전환해서 문자열 받아옴
        button.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View arg0) {

                //새로운 인텐트 생성
                Intent in = new Intent(MainActivity.this, SubActivity.class);
                startActivityForResult(in, GET_STRING);
            }
        });


    }

    // 만약에 액티비티를 전환하고 결과를 받게 된다면,
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_STRING) {
            if (resultCode == RESULT_OK) { // 취소가 아닌 입력완료 버튼이 제대로 눌러진 경우

                // result로 받은 extra에서 해당 값들을 가져와 텍스트뷰로 보여줌.
                text1.setText(data.getStringExtra("INPUT_TEXT1"));
                text2.setText(data.getStringExtra("INPUT_TEXT2"));
            }
        }
    }

}
