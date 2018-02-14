package com.example.aayush.showcaseview;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    private ShowcaseView showcaseView;
    private int counter = 0;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    public static String Status;
    private Button textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView1 = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (Button) findViewById(R.id.textView4);

        showcaseView = new ShowcaseView.Builder(this)
                .setTarget(new ViewTarget(findViewById(R.id.textView)))
                .setOnClickListener(this)
                .build();
        showcaseView.setButtonText(getString(R.string.next));
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
                    showcaseView.setShowcase(new ViewTarget(textView2), true);
                    Log.e("Status", "counter=0   2nd test");
                    break;

                case 1:
                    showcaseView.setShowcase(new ViewTarget(textView4), true);
                    showcaseView.setContentText("Click here to navigate");
                    break;
                case 2:
                    showcaseView.setShowcase(new ViewTarget(textView3), true);
                    Log.e("Status", "counter=1  3rd test");
                    break;
                case 3:
                    showcaseView.setTarget(Target.NONE);
                    showcaseView.setContentTitle("Check it out");
                    showcaseView.setContentText("You don't always need a target to showcase");
                    showcaseView.setButtonText(getString(R.string.close));
                    setAlpha(0.4f, textView1, textView2, textView3);
                    Log.e("Status", "counter=2  default case");
                    break;

                case 4:
                    showcaseView.hide();
                    setAlpha(1.0f, textView1, textView2, textView3);
                    Log.e("Status", "counter=3  for closing");
                    Intent intent = new Intent(this,MainActivity.class);
                    this.startActivity(intent);
                    break;

            }
            counter++;
    }
}
