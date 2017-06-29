package kr.ac.seoultech.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
                            implements View.OnClickListener{

    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {// onCreate에서 열면 onDestroy에서 닫아줘야함.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "on create");    // 로그객체에 입력



        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
/*        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {    //익명 객체; 여러번 쓰지 않고 한 번만 쓸 때
                Toast.makeText(MainActivity.this, "클릭됨", Toast.LENGTH_SHORT).show();
                // 사용자의 이용을 제어하지않고 메시지를 띄울 때
                // 개발 중간에 어느 상황에 있는지 확인할 때
                // 고객에게 안내 메시지를 전할 때
            }*/
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn_startLogin).setOnClickListener(this);
        findViewById(R.id.btn_simpleListArray).setOnClickListener(this);
        findViewById(R.id.btn_todo_list).setOnClickListener(this);

        }


    @Override
    protected void onStart() {  // onStart에서 열면 onStop에서 닫아줘야함.
        super.onStart();
        Log.d(TAG, "on start");
    }

    @Override
    protected void onResume() { // onResume에서 열면 onPause에서 닫아줘야함.
        super.onResume();
        Log.d(TAG, "on resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "on pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "on stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "on destroy");
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn1 : {
                Toast.makeText(this, "버튼1 클릭됨", Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.btn2 : {
                Intent intent = new Intent(this, SubActivity.class);
                // 편지봉투라 생각하면 됨.
                // 내용물, 어디에서 ~ 어디로
                startActivity(intent);
                break;

            }

            case R.id.btn_startLogin : {
                startActivity(new Intent(this, LoginActivity.class));
                /*Intent intent_startLogin = new Intent(this, LoginActivity.class);
                startActivity(intent_startLogin);*/
                break;
            }

            case R.id.btn_simpleListArray :{
                startActivity(new Intent(this, SimpleListActivity.class));
                break;
            }

            case R.id.btn_todo_list :{
                startActivity(new Intent(this, TodoListActivity.class));
            }
        }
    }


}
