package com.botimounir.horizontal_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.botimounir.horizontal_listview.HorizListView.HorizList;
import com.botimounir.horizontal_listview.HorizListView.HorizListAdapter;
import com.botimounir.horizontal_listview.HorizListView.OnHorizListListener;

public class MainActivity extends AppCompatActivity implements OnHorizListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HorizList horizList = new HorizList(this);
        (horizList.getHorizListAdapter()).setOnHorizListListener(this);
        horizList.initData();
    }

    //if necessary implements "OnHorizListListener"
    @Override
    public void onElementSelected(int position, String name) {
        Toast.makeText(getApplicationContext(), name+" (item N°"+position+")", Toast.LENGTH_LONG).show();
    }
}
