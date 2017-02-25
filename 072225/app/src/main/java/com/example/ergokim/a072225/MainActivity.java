package com.example.ergokim.a072225;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonOk = (Button) findViewById(R.id.button_ok);
        final EditText editName = (EditText) findViewById(R.id.edit_name);
        final TextView textNames = (TextView) findViewById(R.id.text_names);

        /**
         * 할일
         * 1. 버튼 클릭하면  입력된 이름을 텍스트뷰포 보내기
         * 2. 입력필드 비우기
         *
         */
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString();
                Log.i("###", "onClick: name = " + name);
                textNames.append("\n" + name);
                editName.setText(null);
            }
        });

        editName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if(EditorInfo.IME_ACTION_DONE == actionId){
                    String name = editName.getText().toString();
                    Log.i("###", "onClick: name = " + name);
                    textNames.append("\n" + name);
                    editName.setText(null);
                }
                return false;
            }
        });
    }
}
