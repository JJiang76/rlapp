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

public class AppetizersFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.menu_appetizers_fragment, container, false);


        GridView gridview = view.findViewById(R.id.gridview_appetizers);

        List<ItemObject> allItems = getAllItemObject();
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), allItems);
        gridview.setAdapter(customAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0: Toast.makeText(getActivity(), "Chicken or Vegetarian?", Toast.LENGTH_SHORT).show();break;
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
        items.add(new ItemObject("Red Lantern's Lettuce Wraps", "one")); // chicken or vegetarian
        items.add(new ItemObject("Crab Wontons", "three"));
        items.add(new ItemObject("Spring Rolls", "six"));
        items.add(new ItemObject("Edamame", "four"));
        items.add(new ItemObject("Dim Sum", "five"));
        items.add(new ItemObject("Little Steamed Bun", "six"));
        items.add(new ItemObject("Dumplings", "seven")); // pork/vegetable/shrimp, fried/steamed
        items.add(new ItemObject("BBQ Baby Back Ribs", "eight"));
        items.add(new ItemObject("Salt and Pepper Calamari", "two"));
        items.add(new ItemObject("Scallion Pancakes", "three"));
        items.add(new ItemObject("Wonton Dumplings in Chili Sauce", "four"));
        items.add(new ItemObject("Dan Dan Noodles", "five"));


        return items;
    }




}