package service.example.com.testremoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by wyp on 2017/7/28.
 */

public class RemoteService extends Service {


    public class MyRemoteServiceImpl extends IRemoteService.Stub{


        @Override
        public String getInfo() throws RemoteException {
            return "getInfo are 完全开发讲义";
        }

        @Override
        public Person getPerson() throws RemoteException {
             Person p =  new Person();
             p.setName("zhangsan");
            return p;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("TAG","onbind");
        return new MyRemoteServiceImpl();
    }

    @Override
    public void onCreate() {
        Log.d("TAG","onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent,   int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    public String getInfo(String name){ return name+"8dfdf";};



}
