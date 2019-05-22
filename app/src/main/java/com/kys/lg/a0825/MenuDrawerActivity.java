package com.kys.lg.a0825;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;

public class MenuDrawerActivity extends AppCompatActivity {

    MenuDrawer leftdrawer,rightdrawer;
    Button btn_open,left_close,right_close;
    ImageView menu1,menu2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_menu_drawer);
        //메뉴를 구성할 Context와 Slider가 열리는 방향 지정
        //서랍이 두개이상 열려져야 하면 behind,drag 속성이 들어가야 함.

        leftdrawer= MenuDrawer.attach(this, MenuDrawer.Type.BEHIND, Position.LEFT,MenuDrawer.MENU_DRAG_WINDOW);
        rightdrawer= MenuDrawer.attach(this, MenuDrawer.Type.BEHIND, Position.RIGHT,MenuDrawer.MENU_DRAG_WINDOW);

        //기본 레이아웃 설정
        rightdrawer.setContentView(R.layout.activity_menu_drawer);

        rightdrawer.setMenuView(R.layout.right_menu);
        leftdrawer.setMenuView(R.layout.left_menu);

        //디바이스의 화면 크기 얻어오기
        WindowManager wm= (WindowManager)getSystemService(WINDOW_SERVICE);

        DisplayMetrics dm= new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);

        rightdrawer.setMenuSize(dm.widthPixels/6*5);//휴대폰 정체 너비의 6분의 5지점
        leftdrawer.setMenuSize(dm.widthPixels/6*5);

        //손잡이(베젤) 터치 영역
        rightdrawer.setTouchBezelSize(dm.widthPixels/3);
        leftdrawer.setTouchBezelSize(dm.widthPixels/3);

        right_close=findViewById(R.id.right_close);

        menu1=(ImageView)findViewById(R.id.menu1);
        menu2=(ImageView)findViewById(R.id.menu2);
        btn_open=(Button)findViewById(R.id.btn_open);

       btn_open.setOnClickListener(click);
        right_close.setOnClickListener(click);
        menu2.setOnClickListener(click);

        leftdrawer.setOnDrawerStateChangeListener(new MenuDrawer.OnDrawerStateChangeListener() {
            @Override
            public void onDrawerStateChange(int i, int i1) {

                if(leftdrawer.isMenuVisible()){ //서랍이 열려 있는 경우
                    //서랍 잠금
                    rightdrawer.setTouchMode(MenuDrawer.STATE_CLOSED);

                }
                else{
                    //서랍 잠금해제
                    rightdrawer.setTouchMode(MenuDrawer.STATE_DRAGGING);
                }

            }

            @Override
            public void onDrawerSlide(float v, int i) {

            }
        });


    }
    View.OnClickListener click= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.menu2:
                    rightdrawer.openMenu();
                    break;
                case R.id.btn_open:
                    rightdrawer.openMenu();
                case R.id.right_close:
                    rightdrawer.closeMenu();

            }
        }
    };
}
