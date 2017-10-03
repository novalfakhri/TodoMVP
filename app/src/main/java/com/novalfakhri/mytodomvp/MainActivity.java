package com.novalfakhri.mytodomvp;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TodoAdapter.ItemListener {
    private RecyclerView recyclerView;
    private TodoAdapter adapter;
    private EditText editTodo;
    private ImageView addTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    private void setupRecyclerView(){
        adapter = new TodoAdapter(MainActivity.this, this);
        recyclerView = (RecyclerView) findViewById(R.id.rv_todo);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
    private void onAddClick(){
        editTodo = (EditText) findViewById(R.id.et_todo);
        addTodo = (ImageView) findViewById(R.id.iv_add_todo);


    }
    @Override
    public void onItemChecked(int position) {

    }

    @Override
    public void onEditClick(int position) {

    }

    @Override
    public void onDeleteClick(int position) {

    }
}
