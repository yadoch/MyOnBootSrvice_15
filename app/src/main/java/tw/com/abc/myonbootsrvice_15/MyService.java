package tw.com.abc.myonbootsrvice_15;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    private Timer timer;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       // throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("brad","My Service:onCreate()");
        timer = new Timer();
        timer.schedule(new MyTask(),1000,3000);
    }
    private class MyTask extends TimerTask{
        @Override
        public void run()
        {
            Log.i("brad","task");
            sendNotice();
        }
    }
    private void sendNotice(){
        NotificationCompat.Builder builder=
                new NotificationCompat(this);
        builder.setSmallIcon(R.drawable.android);
        builder.setTicker("你看不到...");
        builder.setContentTitle("重用訊息");
        builder.setContentText("內容");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(timer != null){
            timer.cancel();
            timer.purge();
            timer=null;
        }

    }
}
