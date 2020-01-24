package com.utkarsh.customlistview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class adapter extends BaseAdapter {

    private Context context;
    private ArrayList<Example> exampleslist;

    adapter(Context con, ArrayList<Example> list) {
        context = con;
        exampleslist = list;
    }

    @Override
    public int getCount() {
        return exampleslist.size();
    }

    @Override
    public Object getItem(int position) {
        return exampleslist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final Example currentlist = exampleslist.get(position);

        @SuppressLint({"InflateParams", "ViewHolder"})
        View view = ((Activity)context).getLayoutInflater().inflate(R.layout.note_item,null,false);

        TextView title = view.findViewById(R.id.title);
        TextView description = view.findViewById(R.id.desc);
        final ImageView delete = view.findViewById(R.id.delete);

        title.setText(currentlist.getTitle());
        description.setText(currentlist.getDescription());

        title.setSelected(true);
        description.setSelected(true);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Delete")
                        .setIcon(R.drawable.delete)
                        .setMessage("You want to delete this item ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                exampleslist.remove(position);
                                adapter.this.notifyDataSetChanged();
                                Toast.makeText(context,currentlist.getTitle()+" is deleted Successfully...",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });

        return view;
    }
}
