package com.example.ergokim.a072225;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InputActivity extends AppCompatActivity {
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";

    EditText editName;
    EditText editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        editName = (EditText) findViewById(R.id.edit_name);
        editEmail = (EditText) findViewById(R.id.edit_email);

        findViewById(R.id.button_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputName();
            }
        });
    }

    private void inputName() {
        if (!isValid()) {
            return;
        }

        String name = editName.getText().toString();
        String email = editEmail.getText().toString();
        Log.i("###", "111 onClick: name = |" + name + "|email = " + email + "|");

        Intent result = new Intent();
        result.putExtra(KEY_NAME, name);
        result.putExtra(KEY_EMAIL, email);
        setResult(RESULT_OK, result);
        finish();
    }

    private boolean isValid() {
        if (!emptyCheck(editName)) {
            return false;
        }

        if (!emptyCheck(editEmail)) {
            return false;
        }

        if (!emailCheck(editEmail)) {
            return false;
        }

        return true;
    }

    private boolean emptyCheck(TextView tv) {
        if (TextUtils.isEmpty(tv.getText().toString())) {
            tv.setError("please input");
            return false;
        }
        return true;
    }

    private boolean emailCheck(TextView tv) {
        if (!Patterns.EMAIL_ADDRESS.matcher(tv.getText().toString()).matches()) {
            tv.setError("not email address");
            return false;
        }
        return true;
    }
}

