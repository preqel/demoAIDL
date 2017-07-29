package service.example.com.testremoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;



public class RemoteService extends Service {


    public class MyRemoteServiceImpl extends IRemoteService.Stub{


        @Override
        public String getInfo() throws RemoteException {
            return "我是一个数据来自不同的进程";
        }

        @Override
        public Person getPerson() throws RemoteException {  //模拟传递一个自定义的复杂类型数据
             Person p =  new Person();
             p.setName("zhangsan");
             Pet pet = new Pet();
             pet.setPetname("Kitty");
             p.setPet(pet);
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

}
