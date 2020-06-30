package com.dypiet.app.fragment;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class SEPSem2Fragment extends PsubjectsFragment {

    private String Language;


    /**
     * @return
     */
    @Override
    protected String getLanguage() {
        return null;
    }

    @Override
    public Query getQuery() {
        Query query = FirebaseDatabase.getInstance ().getReference ().child ("Program").child ("Language");
        return query;
    }


    public void setData(String year){

        this.Language= Language;

    }




}
