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

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    TextView textNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonOk = (Button) findViewById(R.id.button_ok);
        editName = (EditText) findViewById(R.id.edit_name);
        textNames = (TextView) findViewById(R.id.text_names);


        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputName();
            }
        });

        editName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (EditorInfo.IME_ACTION_DONE == actionId) {
                    inputName();
                }
                return false;
            }
        });
    }

    /**
     * 버튼 클릭하면  입력된 이름을 텍스트뷰로 보내기<br>
     * 입력필드 비우기
     */
    private void inputName() {
        String name = editName.getText().toString();
        Log.i("###", "inputName: name = " + name);
        textNames.append("\n" + name);
        editName.setText(null);
    }
}
