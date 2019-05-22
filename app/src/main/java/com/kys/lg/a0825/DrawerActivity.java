package com.kys.lg.a0825;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class DrawerActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    LinearLayout drawerview;
    Button btn_open,btn_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        drawerLayout=findViewById(R.id.drawer_layout);
        drawerview=findViewById(R.id.drawer);
        btn_close=findViewById(R.id.btn_close);
        btn_open=findViewById(R.id.btn_open);

        btn_open.setOnClickListener(click);
        btn_close.setOnClickListener(click);


    }

    View.OnClickListener click  = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id. btn_open:
                    //서랍열기
                    drawerLayout.openDrawer(drawerview);
                    break;

                case R.id.btn_close:
                    //서랍닫기
                    drawerLayout.closeDrawer(drawerview);
                    //열려져 있는 모든 서랍이 닫힘.
                    drawerLayout.closeDrawers();
                    break;
            }
        }
    };
}
