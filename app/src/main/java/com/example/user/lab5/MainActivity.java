package com.example.user.lab5;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        if(button != null){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("請選擇功能");
                    dialog.setMessage("請根據下方按鈕選擇顯示的物件");

                    dialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "Dialog關閉",Toast.LENGTH_SHORT).show();
                        }
                    });

                    dialog.setNegativeButton("自訂義Toast", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            showToast();
                        }
                    });
                    dialog.setPositiveButton("顯示List", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            showLisDialog();
                        }
                    });
                    dialog.show();
                }
            });
        }
    }
    private void showToast(){
        Toast toast = new Toast(MainActivity.this);
        toast.setGravity(Gravity.TOP,0,50);
        toast.setDuration(Toast.LENGTH_SHORT);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,(ViewGroup)findViewById(R.id.custom_toast_root));
        toast.setView(layout);
        toast.show();
    }
    private void showLisDialog(){
        final String[] list_item = {"message1","message2","message3","message4","message5"};
        AlertDialog.Builder dialog_list = new AlertDialog.Builder(MainActivity.this);
        dialog_list.setTitle("使用List呈現");
        dialog_list.setItems(list_item, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"你選的是"+list_item[which],Toast.LENGTH_SHORT).show();
            }
        });
        dialog_list.show();
    }
}
