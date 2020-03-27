package com.example.lobedix;

import java.util.Hashtable;

public class DataHolder {
    private static Hashtable<String,Integer> entree = new Hashtable<String,Integer>();
    private static Hashtable<String,Integer> plat = new Hashtable<String,Integer>();
    private static final DataHolder holder = new DataHolder();

    public void setInitialEntree(){
        entree.put("Taboule",0);
        entree.put("Soupe",0);
        entree.put("Tomate",0);
        entree.put("Fromage",0);
    }

    public void setInitialPlat(){
        plat.put("Spaghetti",0);
        plat.put("Lasagnes",0);
        plat.put("Curry",0);
        plat.put("Ratatouille",0);

    }



    public static DataHolder getInstance() {
        return holder;
    }

    public Hashtable<String,Integer> getEntree() {
        return entree;
    }

    public void setEntree(Hashtable<String,Integer> entree) {
        this.entree = entree;
    }

    public Hashtable<String,Integer> getPlat() {
        return plat;
    }

    public void setPlat(Hashtable<String,Integer> plat) {
        this.plat = plat;
    }

}