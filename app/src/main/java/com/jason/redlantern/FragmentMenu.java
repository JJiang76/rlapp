package com.jason.redlantern;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
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
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jason.redlantern.MenuFragments.AppetizersFragment;
import com.jason.redlantern.MenuFragments.BeefFragment;
import com.jason.redlantern.MenuFragments.ChickenFragment;
import com.jason.redlantern.MenuFragments.DrinksFragment;
import com.jason.redlantern.MenuFragments.GlutenFragment;
import com.jason.redlantern.MenuFragments.KidsFragment;
import com.jason.redlantern.MenuFragments.LunchFragment;
import com.jason.redlantern.MenuFragments.PorkFragment;
import com.jason.redlantern.MenuFragments.RNFragment;
import com.jason.redlantern.MenuFragments.SeafoodFragment;
import com.jason.redlantern.MenuFragments.SignatureFragment;
import com.jason.redlantern.MenuFragments.SoupFragment;
import com.jason.redlantern.MenuFragments.VegetarianFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentMenu extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        GridView gridview = view.findViewById(R.id.gridview);

        List<ItemObject> allItems = getAllItemObject();
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), allItems);
        gridview.setAdapter(customAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        LunchFragment lf = new LunchFragment();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, lf)
                                .addToBackStack(null).commit(); break;

                    case 1:
                        AppetizersFragment af = new AppetizersFragment();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, af)
                                .addToBackStack(null).commit(); break;
                    case 2:
                        SoupFragment sf = new SoupFragment();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, sf)
                                .addToBackStack(null).commit(); break;
                    case 3:
                        ChickenFragment cf = new ChickenFragment();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, cf)
                                .addToBackStack(null).commit(); break;
                    case 4:
                        PorkFragment pf = new PorkFragment();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pf)
                                .addToBackStack(null).commit(); break;
                    case 5:
                        BeefFragment bf = new BeefFragment();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, bf)
                                .addToBackStack(null).commit(); break;
                    case 6:
                        SeafoodFragment seaf = new SeafoodFragment();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, seaf)
                                .addToBackStack(null).commit(); break;
                    case 7:
                        RNFragment rnf = new RNFragment();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, rnf)
                                .addToBackStack(null).commit(); break;
                    case 8:
                        SignatureFragment sigf = new SignatureFragment();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, sigf)
                                .addToBackStack(null).commit(); break;
                    case 9:
                        VegetarianFragment vf = new VegetarianFragment();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, vf)
                                .addToBackStack(null).commit(); break;
                    case 10:
                        GlutenFragment gf = new GlutenFragment();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, gf)
                                .addToBackStack(null).commit(); break;
                    case 11:
                        KidsFragment kf = new KidsFragment();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, kf)
                                .addToBackStack(null).commit(); break;
                    case 12:
                        DrinksFragment df = new DrinksFragment();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, df)
                                .addToBackStack(null).commit(); break;
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