package com.novalfakhri.mytodomvp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.novalfakhri.mytodomvp.database.entity.Todo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toshiba on 9/29/2017.
 */

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    private List<Todo> todoList;
    private Context context;
    private ItemListener itemListener;

    public TodoAdapter(Context context, ItemListener itemListener) {
        todoList = new ArrayList<>();
        this.context = context;
        this.itemListener = itemListener;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_main, parent, false);
        return new TodoViewHolder(rootView, itemListener);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        if (todoList != null) {
            Todo toDo = todoList.get(position);
            String title = toDo.getTitle();
            boolean check = toDo.getChecked();
            holder.textTodo.setText(title);
//            holder.checkTodo.setText(title);
        }
    }

    @Override
    public int getItemCount() {
        return (todoList != null) ? todoList.size() : 0;
    }

    public void updateTodoList(List<Todo> todoList) {
        this.todoList.clear();
        this.todoList.addAll(todoList);
        notifyDataSetChanged();
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textTodo;
        private CheckBox checkTodo;
        private ImageView itemEdit, itemDelete;
        private ItemListener itemListener;

        public TodoViewHolder(View itemView, ItemListener itemListener) {
            super(itemView);
            textTodo = itemView.findViewById(R.id.tv_todo);
            checkTodo = itemView.findViewById(R.id.checkbox_todo);
            itemEdit = itemView.findViewById(R.id.iv_item_edit);
            itemDelete = itemView.findViewById(R.id.iv_item_delete);
            this.itemListener = itemListener;

            checkTodo.setOnClickListener(this);
            itemEdit.setOnClickListener(this);
            itemDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemListener.onItemChecked(getAdapterPosition());
            itemListener.onEditClick(getAdapterPosition());
            itemListener.onDeleteClick(getAdapterPosition());
        }
    }

    interface ItemListener {
        void onItemChecked(int position);
        void onEditClick(int position);
        void onDeleteClick(int position);
    }
}
