package edu.uic.project_2;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<String> nameList; //data: the names displayed
    private RVClickListener RVlistener; //listener defined in main activity
    private Context context;
    int[] pictures;
    String [] links;


    /*
    passing in the data and the listener defined in the main activity
     */
    public MyAdapter(ArrayList<String> theList, int[] pictures ,String [] links ,RVClickListener listener){
        nameList = theList;
        this.RVlistener = listener;
        this.pictures = pictures;
        this.links = links;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View listView = inflater.inflate(R.layout.rv_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listView, RVlistener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(nameList.get(position));
        holder.image.setImageResource(pictures[position]);
        holder.link = links[position];


    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }



    /*
       This class creates a wrapper object around a view that contains the layout for
        an individual item in the list. It also implements the onClickListener so each ViewHolder in the list is clickable.
       It's onclick method will call the onClick method of the RVClickListener defined in
       the main activity.
    */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener{

        public TextView name;
        public ImageView image;
        private RVClickListener listener;
        private View itemView;
        private String link;


        public ViewHolder(@NonNull View itemView, RVClickListener passedListener) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textView);
            image = (ImageView) itemView.findViewById(R.id.imageView);
            this.itemView = itemView;
            itemView.setOnCreateContextMenuListener(this); //set context menu for each list item (long click)
            this.listener = passedListener;

            /* don't forget to set the listener defined here to the view (list item) that was
                passed in to the constructor. */
            itemView.setOnClickListener(this); //set short click listener
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());
            Log.i("ON_CLICK", "in the onclick in view holder");
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

            //inflate menu from xml

            MenuInflater inflater = new MenuInflater(v.getContext());
            inflater.inflate(R.menu.context_menu, menu );
            menu.getItem(0).setOnMenuItemClickListener(onMenu);
            menu.getItem(1).setOnMenuItemClickListener(onMenu);
            menu.getItem(2).setOnMenuItemClickListener(onMenu);
            //menu.getItem(3).setOnMenuItemClickListener(onMenu);

          /*  //create menu in code

            menu.setHeaderTitle("My context menu");

            //add menu items and set the listener for each
            menu.add(0,v.getId(),0,"option 1").setOnMenuItemClickListener(onMenu);
            menu.add(0,v.getId(),0,"option 2").setOnMenuItemClickListener(onMenu);
            menu.add(0,v.getId(),0,"option 3").setOnMenuItemClickListener(onMenu);
            */

        }

        /*
            listener for menu items clicked
         */
        private final MenuItem.OnMenuItemClickListener onMenu = new MenuItem.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick(MenuItem item){
                Context context = itemView.getContext();
               switch (item.getItemId()){
                   case R.id.menu1:

                       Log.i("ON_CLICK", name.getText() + " adapter pos: " + image.getDrawable());
                       Intent intent = new Intent(context, ImageActivity.class);
                       intent.putExtra("img",pictures[getAdapterPosition()]);
                       //intent.putExtra("name", name.getText());
                       context.startActivity(intent);

                       return true;
                   case R.id.menu2:
                       //Log.i("ON_CLICK", name.getText() + " adapter pos: " + "Info");
                       Intent intent2 = new Intent(context, Facts.class);
                       intent2.putExtra("name", name.getText());
                       context.startActivity(intent2);

                       return true;
                   case R.id.menu3:
                       Log.i("ON_CLICK", name.getText() + " adapter pos: " + "WIki");
                       Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                       context.startActivity(intent3);

                       return true;
                   default:
                       return false;
               }

                //Log.i("ON_CLICK", name.getText() + " adapter pos: " + getAdapterPosition());


            }
        };



    }
}
