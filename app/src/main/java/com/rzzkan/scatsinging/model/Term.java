package com.rzzkan.scatsinging.model;

import android.graphics.drawable.Drawable;

public class Term {

    public String term;
    public String explanation;
    public boolean section = false;

    public Term() {
    }

    public Term(String term,String explanation, boolean section) {
        this.term = term;
        this.explanation = explanation;
        this.section = section;
    }

}
