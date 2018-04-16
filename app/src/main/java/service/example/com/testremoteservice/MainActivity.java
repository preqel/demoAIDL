package service.example.com.testremoteservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ServiceConnection {

    TextView textView;

    private IRemoteService myservice = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.mTextView);

        btn.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(v.getContext(), RemoteService.class);
               bindService(intent, MainActivity.this, Context.BIND_AUTO_CREATE);
           }
       });
       findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               try {
          //         textView.setText(myservice.getInfo());  测试例子
             //      textView.setText(myservice.getPerson().getName());i 测试例子2
                   textView.setText(myservice.getPerson().getPet().getPetname());  //测试例子3
               } catch (RemoteException e) {
                   e.printStackTrace();
               }
           }
       });
       findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               List<String> lists = new LinkedList<>();
               lists.add("abosolue");
               lists.add("buidfl");
               lists.add("uief");
               try {
                   myservice.getPersonList(lists);
               }catch (RemoteException remoteexception){
                   remoteexception.printStackTrace();;
               }
           }
       });
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        this.myservice = IRemoteService.Stub.asInterface(service);
        Log.d("TAG","onServiceConnected");
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.d("TAG","onServiceDisconnected");
    }

}
