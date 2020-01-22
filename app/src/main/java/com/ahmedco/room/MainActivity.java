package com.ahmedco.room;




//https://developer.android.com/training/data-storage/room

//https://www.toptal.com/android/android-threading-all-you-need-to-know

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ExampleItem> mExampleList;

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextInsert;
    private EditText editTextRemove;
    private int count = 0;
    String[] queText = {"H", "e", "l", "l", "o"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        createExampleList();
        buildRecyclerView();

        buttonInsert = findViewById(R.id.button_insert);
        buttonRemove = findViewById(R.id.button_remove);
        editTextInsert = findViewById(R.id.edittext_insert);
        editTextRemove = findViewById(R.id.edittext_remove);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  int position = Integer.parseInt(editTextInsert.getText().toString());
            //    count =count+1;
               // insertItem(count);
            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextRemove.getText().toString());
                removeItem(position);
            }
        });
    }

    public void insertItem(int position) {
        //
        /*
        if(count==0){
            mExampleList.add(position, new ExampleItem(R.drawable.ic_launcher_background, "que is" , ""+queText[0]));
            mAdapter.notifyItemInserted(position);
        }
        */
        count =count+1;
        mExampleList.add(position, new ExampleItem(R.drawable.ic_launcher_background,
                "que is" + position, ""+queText[position-1]));
        mAdapter.notifyItemInserted(position);
    }

    public void removeItem(int position) {
        mExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    public void changeItem(int position, String text) {
        mExampleList.get(position).changeText1(text);
        mAdapter.notifyItemChanged(position);
    }

    public void createExampleList() {
        mExampleList = new ArrayList<>();
        // mAdapter.notifyItemInserted(position);
        mExampleList.add(new ExampleItem(R.drawable.ic_launcher_foreground, "Line 1", " "+queText[0]));
      //  mExampleList.add(new ExampleItem(R.drawable.ic_audio, "Line 3", "Line 4"));
       // mExampleList.add(new ExampleItem(R.drawable.ic_sun, "Line 5", "Line 6"));
    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //changeItem(position, "Clicked");

                insertItem(position+1);
              //  count =count+1;
             //   mExampleList.add(position, new ExampleItem(R.drawable.ic_launcher_background, "que is" + position, ""+queText[position-1]));
               // mAdapter.notifyItemInserted(position);
                 Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_LONG).show();

            }
        });
    }
}