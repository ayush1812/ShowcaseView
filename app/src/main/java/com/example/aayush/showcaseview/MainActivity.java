package com.example.aayush.showcaseview;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ShowcaseView showcaseView1;
    private int counter = 0;
    private TextView textView4;
    public static String Status;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView4 = (TextView) findViewById(R.id.textView4);
        imageView = (ImageView) findViewById(R.id.imageView);

        showcaseView1 = new ShowcaseView.Builder(this)
                .setTarget(new ViewTarget(findViewById(R.id.imageView)))
                .setOnClickListener(this)
                .build();
        showcaseView1.setButtonText(getString(R.string.next));
    }
    private void setAlpha(float alpha, View... views) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            for (View view : views) {
                view.setAlpha(alpha);
            }
        }
    }

    @Override
    public void onClick(View view) {

        switch (counter) {
            case 0:
                showcaseView1.setShowcase(new ViewTarget(textView4), true);
                Log.e("Status", "counter=0   2nd test");
                break;

            case 1:
                showcaseView1.setTarget(Target.NONE);
                showcaseView1.setContentTitle("Check it out");
                showcaseView1.setContentText("You don't always need a target to showcase");
                showcaseView1.setButtonText(getString(R.string.close));
                setAlpha(0.4f, textView4,imageView);
                Log.e("Status", "counter=2  default case");
                break;

            case 2:
                showcaseView1.hide();
                setAlpha(1.0f, textView4,imageView);
                Log.e("Status", "counter=3  for closing");
                Intent intent = new Intent(this,Main2Activity.class);
                this.startActivity(intent);
                break;

        }
        counter++;
    }

}
