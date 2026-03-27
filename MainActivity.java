package com.example.exp3;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    int[] image={
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7
    };

    int currentIndex=0;
    Handler handler=new Handler();

    Runnable slideshowRunnable=new Runnable(){
        @Override
        public void run(){
            imageView.setImageResource(image[currentIndex]);
            currentIndex++;

            if(currentIndex>=image.length){
                currentIndex=0;
            }

            handler.postDelayed(this,1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.imageView);
        handler.post(slideshowRunnable);
    }

    @Override
    protected  void onDestroy(){
        super.onDestroy();
        handler.removeCallbacks(slideshowRunnable);
    }
}
