package com.example.tweeting;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesViewHolder> {
    private final List<Notes> mdata;
    private final Context context;
    private AlertDialog mDialog;
    FrameLayout frame;
    private int mListRowPosition;

    public NotesAdapter(List<Notes> mdata,Context context) {
        this.mdata = mdata;
        this.context = context;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.tweet,parent,false);
        return new NotesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.setItem(mdata.get(position));
        int realposition = position + 1;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = ((FragmentActivity)context).getSupportFragmentManager();
                int displaymode = v.getResources().getConfiguration().orientation;
                fragment1 frag = fragment1.newInstance(mdata.get(holder.getAdapterPosition()).getUser(),mdata.get(holder.getAdapterPosition()).getNote(),mdata.get(holder.getAdapterPosition()).getTweetDate());
                if (displaymode == Configuration.ORIENTATION_LANDSCAPE){
//                    trans.add(R.id.fraglay,new fragment1());
                    manager.beginTransaction().replace(R.id.fragmentNote,frag).addToBackStack(null).commit();
                }else{
                    frame = v.findViewById(R.id.fragmentNote);
                    Toast.makeText(v.getContext(), "this is item : " + realposition, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), details.class);
                    intent.putExtra("user", mdata.get(position).getUser());
                    intent.putExtra("content", mdata.get(position).getNote());
                    intent.putExtra("date", mdata.get(position).getTweetDate());
                    manager.beginTransaction().remove(frag).commit();
                    v.getContext().startActivity(intent);

                }


//
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage("Vous confirmez la suppression ?")
                        .setPositiveButton("Oui supprimer", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Use mListRowPosition for clicked list row...
//                                showDialog(position);
                                mdata.remove(position);
                                  notifyItemRemoved(position);
                                 notifyItemRangeChanged(position, mdata.size());
                            }
                        })
                        .setNegativeButton("Non annuler", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                // Create the AlertDialog object

                mDialog = builder.create();
                builder.show();
                return false;
            }
        });

    }
    @Override
    public int getItemCount() {
        return mdata.size();
    };
    private void deleteItem(int position) {
        mdata.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mdata.size());
        RecyclerView.ViewHolder holder = null;
        holder.itemView.setVisibility(View.GONE);
    }
    private void showDialog(int position)
    {
        mListRowPosition = position;
        if(mDialog != null)
            mDialog.show();
    }
}
