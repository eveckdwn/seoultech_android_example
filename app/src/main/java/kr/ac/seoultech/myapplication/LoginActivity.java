package kr.ac.seoultech.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity
                            implements View.OnClickListener{

    private EditText etLoginId;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLoginId = (EditText) findViewById(R.id.et_login_id);
        etPassword = (EditText) findViewById(R.id.et_password);

        findViewById(R.id.btn_login).setOnClickListener(this);

        SharedPreferences sp = getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        //SharedPreferences를 활용하여 LOGIN을 검색
        String loginId = sp.getString("loginId", null);
        //SharedPreferences에서 LOGIN이 있다면, loginId값을 반환, 없으면 null값 반환
        if(loginId!=null){  //만약 loginId값이 null값이 아니면, etLoginId의 Text를 loginId값으로 설정
            etLoginId.setText(loginId);
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_login : {

                String loginId = etLoginId.getText().toString();
                String password = etPassword.getText().toString();

                if(loginId.equals("seoultech") && password.equals("1234")){
                    Toast.makeText(this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show();

                    SharedPreferences sp = getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
                    //SharedPreferences를 활용하여 LOGIN을 검색
                    SharedPreferences.Editor editor= sp.edit();
                    //SharedPreferences의 Editor를 활용하여 편집
                    editor.putString("loginId", loginId);
                    //loginId값을 위에서 입력받은 loginId로 설정
                    editor.commit();    //저장

                    finish();
                }
                else{
                    Toast.makeText(this, "아이디 또는 패스워드가 다릅니다.", Toast.LENGTH_SHORT).show();

                    SharedPreferences sp = getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
                    //SharedPreferences를 활용하여 LOGIN을 검색
                    SharedPreferences.Editor editor = sp.edit();
                    //SharedPreferences의 Editor를 활용하여 편집
                    editor.remove("loginId");
                    //아이디와 비밀번호가 다르므로 loginId값을 삭제
                    editor.commit();    //저장
                }

                break;
            }
        }
    }
}
