package kr.ac.seoultech.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    private static final String TAG = SubActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "on create");

        LinearLayout layout = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        layout.setLayoutParams(params);
        layout.setOrientation(LinearLayout.VERTICAL);


        TextView textView = new TextView(this);
        ViewGroup.LayoutParams textViewLayoutParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        textView.setText("Hello World");
        layout.addView(textView);
        setContentView(layout);

        // 안드로이드에서 'rew\layout\'에서 자동으로 클래스명과 같은 xml파일로 만들어줌.
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "on start");
    }

    @Override
    protected void onResume() {
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
}
