package tw.com.abc.myonbootsrvice_15;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    private Timer timer;
    private NotificationManager nmgr;
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
        nmgr=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);

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
        //  NotificationCompat的內部類別用來建立通知物件
        NotificationCompat.Builder builder=
                new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.android);
        builder.setTicker("你看不到...");  // 只會出現一下下
        builder.setContentTitle("重要訊息");
        builder.setContentText("內容");
        builder.setAutoCancel(true); // 預設 false ,點了之後取消

        //TaskStackBuilder 任務堆疊 -這段老師上課時寫錯的
//        TaskStackBuilder stackBuilder =TaskStackBuilder.create(this);
//        PendingIntent pendingIntent=
//            stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
//
//        builder.setContentIntent(pendingIntent);
        Notification notification=builder.build();//根據 Build 建立 Notification
        nmgr.notify(1,notification);//把通知掛到系統服務 nmgr
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
