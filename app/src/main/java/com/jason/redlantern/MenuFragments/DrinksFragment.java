package com.jason.redlantern.MenuFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.jason.redlantern.CustomAdapter;
import com.jason.redlantern.ItemObject;
import com.jason.redlantern.R;

import java.util.ArrayList;
import java.util.List;

public class DrinksFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.menu_drinks_fragment, container, false);


        GridView gridview = view.findViewById(R.id.gridview_drinks);

        List<ItemObject> allItems = getAllItemObject();
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), allItems);
        gridview.setAdapter(customAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0: break;
                    case 1: break;
                    case 2: break;
                    case 3: break;
                    case 4: break;
                    case 5: break;
                    case 6: break;
                    case 7: break;
                    case 8: break;
                    case 9: break;
                    case 10: break;
                    case 11: break;
                    case 12: break;
                }
            }
        });


        return view;

    }
/*
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
    } */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private List<ItemObject> getAllItemObject(){
        ItemObject itemObject = null;
        List<ItemObject> items = new ArrayList<>();
        items.add(new ItemObject("Lunch", "one"));
        items.add(new ItemObject("Appetizers", "two"));
        items.add(new ItemObject("Soup", "three"));
        items.add(new ItemObject("Chicken", "four"));
        items.add(new ItemObject("Pork", "five"));
        items.add(new ItemObject("Beef", "six"));
        items.add(new ItemObject("Seafood", "seven"));
        items.add(new ItemObject("Rice and Noodles", "eight"));
        items.add(new ItemObject("Signature Dishes", "two"));
        items.add(new ItemObject("Vegetarian", "three"));
        items.add(new ItemObject("Gluten Free Menu", "four"));
        items.add(new ItemObject("Kid's Menu", "five"));
        items.add(new ItemObject("Drinks", "six"));

        return items;
    }




}