package com.ppamorim.sample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

public class SampleActivity extends ActionBarActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sample);
  }

  @Override protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    //ApplicationContext applicationContext = SpringApplication.run(SampleActivity.class);
    System.out.println( "Hello World! 0:-]" );
  }
}
