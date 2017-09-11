package tw.com.abc.myonbootsrvice_15;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("brad","onReceive");
        // service 和Activity 才是content ,但content 參數會自己傳入,故先用content 即可
        Intent it =new Intent(context,MyService.class);
        context.startService(it);
    }

}
