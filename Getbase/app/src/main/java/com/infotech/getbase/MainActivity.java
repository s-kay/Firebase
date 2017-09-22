package com.infotech.getbase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.infotech.getbase.R.id.rview;


public class MainActivity extends AppCompatActivity {

    TextView editText;
    Button btnGet;
    FirebaseDatabase database;
    DatabaseReference myRef;
    List<ListData> list;
    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (TextView) findViewById(R.id.editText);
        btnGet= (Button) findViewById(R.id.btnGet);
        recyclerview = (RecyclerView) findViewById(rview);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("applicants");

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        list = new ArrayList<>();
                        // StringBuffer stringbuffer = new StringBuffer();
                        for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){
                    ListData value = dataSnapshot1.getValue(ListData.class);
                    ListData listdata = new ListData();
                    String first_name = value.getName();
                    String job = value.getJob();
                    String gender = value.getGender();
                    String email = value.getEmail();
                    String city = value.getCity();
                    String country = value.getCountry();
                    listdata.setName(first_name);
                    listdata.setJob(job);
                    listdata.setGender(gender);
                    listdata.setEmail(email);
                    listdata.setCity(city);
                    listdata.setCountry(country);
                    list.add(listdata);

                }

                        RecyclerviewAdapter recycler = new RecyclerviewAdapter(list);
                        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(MainActivity.this);
                        recyclerview.setLayoutManager(layoutmanager);
                        recyclerview.setItemAnimator( new DefaultItemAnimator());
                        recyclerview.setAdapter(recycler);
            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //  Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

        });


    }
}