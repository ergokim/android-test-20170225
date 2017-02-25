package com.example.ergokim.a072225;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private final static int REQUEST_CODE_INPUT = 123;


    TextView textNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNames = (TextView) findViewById(R.id.text_names);
        findViewById(R.id.button_input).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(), InputActivity.class), REQUEST_CODE_INPUT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK)
            return;

        if (requestCode == REQUEST_CODE_INPUT) {
            String name = data.getStringExtra(InputActivity.KEY_NAME);
            String email = data.getStringExtra(InputActivity.KEY_EMAIL);
            Log.i("###", "onActivityResult: |" + name + "|" + email + "|");

            textNames.append(name + "(" + email + ")\n");
        }
    }
}

