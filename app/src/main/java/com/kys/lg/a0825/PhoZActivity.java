package com.kys.lg.a0825;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class PhoZActivity extends AppCompatActivity {


    //이미지 확대 축소 라이브러리 활용 예제
    ImageView iv_phto;
    PhotoViewAttacher photoViewAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_phto=findViewById(R.id.iv_photo);
        photoViewAttacher= new PhotoViewAttacher(iv_phto);

        photoViewAttacher.update();


    }
}
