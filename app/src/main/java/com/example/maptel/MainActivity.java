package com.example.maptel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res =  getResources();
    }

    //地図連携メソッド
    public void map(View view){
    //文字列取得
        Resources res = getResources();
        String address = res.getString(R.string.map_address);
    //地図インテント
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?q="+address));
        startActivity(intent);
    }

    //電話連携のメソッド
    public void call(View view){
    //文字列取得
        Resources res = getResources();
        String msg = res.getString(R.string.call_msg);
    //電話番号取得
        EditText textInput = (EditText)findViewById(R.id.editText1);
        String call= textInput.getText().toString();
    //先頭が0か判断
        if (call.substring(0,1).equals("0")){
    //電話インテント
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+call));
            startActivity(intent);
            finish();
        }else{
            //TextViewの作成
            TextView textView = new TextView(getApplicationContext());
            textView.setText(msg); //メッセージ
            textView.setTextSize(25); //フォント
            textView.setTextColor(Color.RED); //文字色
            textView.setBackgroundColor(Color.BLACK); //背景色

            //ToastにTextViewをセットして表示する
            Toast toast = new Toast(getApplicationContext());
            toast.setView(textView);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.show();
        }
    }

    //---------------LifeCycleLog-------------------------------------

    public void onStart(){
        Log.i("LifeCycleLog", "onStart() moved");
        super.onStart();
    }

    public void onRestart(){
        Log.i("LifeCycleLog", "onRestart() moved");
        super.onRestart();
    }

    public void onResume(){
        Log.i("LifeCycleLog", "onResume() moved");
        super.onResume();
    }

    public void onPause(){
        Log.i("LifeCycleLog", "onPause() moved");
        super.onPause();
    }

    public void onStop(){
        Log.i("LifeCycleLog", "onStop() moved");
        super.onStop();
    }

    public void onDestroy(){
        Log.i("LifeCycleLog", "onDestroy() moved");
        super.onDestroy();
    }

}