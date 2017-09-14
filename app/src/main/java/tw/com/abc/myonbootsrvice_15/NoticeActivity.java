package tw.com.abc.myonbootsrvice_15;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NoticeActivity extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
// Notice 傳入頁面
        tv = (TextView)findViewById(R.id.tv);
        Intent it = getIntent();
        int key = it.getIntExtra("key",-1);
        tv.setText("key:"+key);
    }
}
