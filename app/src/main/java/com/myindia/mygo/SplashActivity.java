package com.myindia.mygo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Fission Labs on 3/6/2018.
 */

public class SplashActivity extends AppCompatActivity {

    private void moveToMain() {
        Intent i = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(i);
        SplashActivity.this.finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();

        TextView foo = (TextView) findViewById(R.id.txtDesc);
        foo.setText(Html.fromHtml(getString(R.string.splash_desc)));


        findViewById(R.id.btnRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToMain();
            }
        });
    }
}
