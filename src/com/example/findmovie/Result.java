
package com.example.findmovie;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Result extends ActionBarActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        final ImageView iv = (ImageView) findViewById(R.id.imageView1);
        final Bundle extras = getIntent().getExtras();
        final String imageValue = extras.getString("Image");
        final String titleValue = extras.getString("Title");
        final ImageLoadTask teste = (ImageLoadTask) new ImageLoadTask(imageValue, iv)
                .execute(null, null);
        final TextView text2 = (TextView) findViewById(R.id.textView2);
        text2.setText(titleValue);

    }

}
