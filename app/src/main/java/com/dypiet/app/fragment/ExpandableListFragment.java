package com.dypiet.app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import androidx.fragment.app.Fragment;

import com.dypiet.app.R;
import com.dypiet.app.advantage;
import com.dypiet.app.array;
import com.dypiet.app.breakcontinue;
import com.dypiet.app.cif;
import com.dypiet.app.cswitch;
import com.dypiet.app.definationdeclaration;
import com.dypiet.app.file;
import com.dypiet.app.functionbasic;
import com.dypiet.app.input;
import com.dypiet.app.introduction;
import com.dypiet.app.operator;
import com.dypiet.app.pointer;
import com.dypiet.app.structure;
import com.dypiet.app.variable;
import com.dypiet.app.whilefor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListFragment extends Fragment {

    private ExpandableListView expandableListView;

    private ExpandableListViewAdapter expandableListViewAdapter;

    private List<String> listDataGroup;

    private HashMap<String, List<String>> listDataChild;



    /**
     * method to initialize the views
     */

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            super.onCreateView (inflater, container, savedInstanceState);
            View rootView = inflater.inflate (R.layout.activity_expandable_list_fragment, container, false);

            expandableListView = rootView.findViewById(R.id.expandableListView);


            // initializing the listeners
            initListeners();

            // initializing the objects
            initObjects();

            // preparing list data
            initListData();
            return rootView;
    }
    /**
     * method to initialize the listeners
     */
    private void initListeners() {

        // ExpandableListView on child click listener
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                //listDataGroup.get(groupPosition) + " : " + listDataChild.get(listDataGroup.get(groupPosition)).get(childPosition);
                /*Toast.makeText(
                        getActivity(),
                        listDataGroup.get(groupPosition)
                                + " : "
                                + listDataChild.get(listDataGroup.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT)
                        .show();
*/
               final String selected = listDataChild.get(listDataGroup.get(groupPosition)).get(childPosition);

              /*final String selected = (String) ExpandableListViewAdapter.getChild(
                        groupPosition, childPosition);
*/
                Intent intent;
                switch(selected){
                    case "1.1 Introduction":
                        intent = new Intent(getActivity(), introduction.class);
                        startActivity(intent);
                        break;

                    case "1.2 Advantages of c":
                        intent = new Intent(getActivity(), advantage.class);
                        startActivity(intent);
                        break;

                    case "2.1 Structure of program":
                        intent = new Intent(getActivity(), structure.class);
                        startActivity(intent);
                        break;

                    case "3.1 Variables":
                        intent = new Intent(getActivity(), variable.class);
                        startActivity(intent);
                        break;
                    case "3.2 Operators":
                        intent = new Intent(getActivity(), operator.class);
                        startActivity(intent);
                        break;
                    case "4.1 printf & scanf":
                        intent = new Intent(getActivity(), input.class);
                        startActivity(intent);
                        break;
                    case "5.1 Conditional branching-if":
                        intent = new Intent(getActivity(), cif.class);
                        startActivity(intent);
                        break;
                    case "5.2 Conditional Selection-switch":
                        intent = new Intent(getActivity(), cswitch.class);
                        startActivity(intent);
                        break;
                    case "5.3 Loops-while & for":
                        intent = new Intent(getActivity(), whilefor.class);
                        startActivity(intent);
                        break;
                    case "5.4 Break & Continue":
                        intent = new Intent(getActivity(), breakcontinue.class);
                        startActivity(intent);
                        break;
                    case "6.1 Functions Basics":
                        intent = new Intent(getActivity(), functionbasic.class);
                        startActivity(intent);
                        break;
                    case "6.2 Defination & Declaration":
                        intent = new Intent(getActivity(), definationdeclaration.class);
                        startActivity(intent);
                        break;
                    case "7.1 Arrays":
                        intent = new Intent(getActivity(), array.class);
                        startActivity(intent);
                        break;
                    case "7.2 Pointer":
                        intent = new Intent(getActivity(), pointer.class);
                        startActivity(intent);
                        break;
                    case "8.1 File Operations & Functions":
                        intent = new Intent(getActivity(), file.class);
                        startActivity(intent);
                        break;


                }

                return true;
            }
           /* private void loadChild(String[] listDataGroup) {
                listDataChild = new HashMap<String, List<String>>();
                for (String model : listDataGroup)
                    listDataChild.put(listDataChild.get(model));
            }
           */
        });




        // ExpandableListView Group expanded listener
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
               /* Toast.makeText(getActivity(),
                        listDataGroup.get(groupPosition) + " " + getString(R.string.text_collapsed),
                        Toast.LENGTH_SHORT).show();*/
            }
        });

        // ExpandableListView Group collapsed listener
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                /*Toast.makeText(getActivity(),
                        listDataGroup.get(groupPosition) + " " + getString(R.string.text_collapsed),
                        Toast.LENGTH_SHORT).show();
*/
            }


        });

    }

    /**
     * method to initialize the objects
     */
    private void initObjects() {

        // initializing the list of groups
        listDataGroup = new ArrayList<>();

        // initializing the list of child
        listDataChild = new HashMap<>();

        // initializing the adapter object
       expandableListViewAdapter = new ExpandableListViewAdapter(getActivity(), listDataGroup, listDataChild);

        // setting list adapter
        expandableListView.setAdapter((ExpandableListAdapter) expandableListViewAdapter);

    }

    /*
     * Preparing the list data
     *
     * Dummy Items
     */
    private void initListData() {


        // Adding group data
        listDataGroup.add("1.Introduction");
        listDataGroup.add("2.Example of c program");
        listDataGroup.add("3.Variables & operators");
        listDataGroup.add("4.Input & Output");
        listDataGroup.add("5.Flow of control");
        listDataGroup.add("6.Functions");
        listDataGroup.add("7.Arrays & Pointer");
        listDataGroup.add("8.Files");

        // array of strings
        String[] array;

        // list of introduction
        List<String> introduction = new ArrayList<>();
        introduction.add("1.1 Introduction");
        introduction.add("1.2 Advantages of c");

        // list of example
        List<String> Example= new ArrayList<>();
        Example.add("2.1 Structure of program");


        // list of Variables & operators
        List<String> Variablesoperators = new ArrayList<>();
        Variablesoperators.add("3.1 Variables");
        Variablesoperators.add("3.2 Operators");


        // list of Input & Output
        List<String> InputOutput = new ArrayList<>();
        InputOutput.add("4.1 printf & scanf");

        // list of Flow of control
        List<String> Flowofcontrol = new ArrayList<>();
        Flowofcontrol.add("5.1 Conditional branching-if");
        Flowofcontrol.add("5.2 Conditional Selection-switch");
        Flowofcontrol.add("5.3 Loops-while & for");
        Flowofcontrol.add("5.4 Break & Continue");

        // list of Function
        List<String> Function = new ArrayList<>();
        Function.add("6.1 Functions Basics");
        Function.add("6.2 Defination & Declaration");

        // list of array
        List<String> arrayp = new ArrayList<>();
        arrayp.add("7.1 Arrays");
        arrayp.add("7.2 Pointer");

        // list of file
        List<String> file = new ArrayList<>();
        file.add("8.1 File Operations & Functions");


        // Adding child data
        listDataChild.put(listDataGroup.get(0), introduction);
        listDataChild.put(listDataGroup.get(1), Example);
        listDataChild.put(listDataGroup.get(2), Variablesoperators);
        listDataChild.put(listDataGroup.get(3), InputOutput);
        listDataChild.put(listDataGroup.get(4), Flowofcontrol);
        listDataChild.put(listDataGroup.get(5), Function);
        listDataChild.put(listDataGroup.get(6), arrayp);
        listDataChild.put(listDataGroup.get(7), file);

        // notify the adapter
        expandableListViewAdapter.notifyDataSetChanged();
    }

}
