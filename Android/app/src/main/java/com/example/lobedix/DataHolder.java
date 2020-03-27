package com.example.lobedix;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class DataHolder {
    private static Hashtable<String,Integer> entree = new Hashtable<String,Integer>();
    private static Hashtable<String,Integer> plat = new Hashtable<String,Integer>();
    private static final DataHolder holder = new DataHolder();
    private  static ArrayList<String> listeEntree = new ArrayList<String>();
    private  static ArrayList<String> listePlat = new ArrayList<String>();
    private static ArrayList<String> belleListePlat = new ArrayList<String>(); //pour garder les noms entiers des plats et pas juste la clé
    private  static ArrayList<String> belleListeEntree = new ArrayList<String>();

    private static Hashtable<String,Integer> prix = new Hashtable<String,Integer>();

    private static int nbSoupe;
    private static int nbTaboule;
    private static int nbTomates;
    private static int nbFeuillete;

    private static int nbSpaghetti;
    private static int nbLasagnes;
    private static int nbCurry;
    private static int nbRatatouille;





    public void initNb(){
        nbSoupe =0;
        nbTaboule =0;
        nbTomates=0;
        nbFeuillete=0;
        nbSpaghetti=0;
        nbLasagnes=0;
        nbCurry=0;
        nbRatatouille=0;
    }

    public int getNbSpaghetti(){
        return(nbSpaghetti);
    }

    public void setNbSpaghetti(int nbSpaghetti){
        this.nbSpaghetti = nbSpaghetti;
    }

    public int getNbLasagnes(){
        return(nbLasagnes);
    }

    public void setNbLasagnes(int nbLasagnes){
        this.nbLasagnes= nbLasagnes;
    }

    public int getNbCurry(){
        return(nbCurry);
    }

    public void setNbCurry(int nbCurry){
        this.nbCurry = nbCurry;
    }
    public int getNbRatatouille(){
        return(nbRatatouille);
    }

    public void setNbRatatouille(int nbRatatouille){
        this.nbRatatouille = nbRatatouille;
    }
    public int getNbSoupe(){
        return(nbSoupe);
    }

    public void setNbSoupe(int nbSoupe){
        this.nbSoupe = nbSoupe;
    }

    public int getNbTaboule(){
        return(nbTaboule);
    }

    public void setNbTaboule(int nbTaboule){
        this.nbTaboule = nbTaboule;
    }

    public int getNbTomates(){
        return(nbTomates);
    }

    public void setNbTomates(int nbTomates){
        this.nbTomates = nbTomates;
    }

    public int getNbFeuillete(){
        return(nbFeuillete);
    }

    public void setNbFeuillete(int nbFeuillete){
        this.nbFeuillete = nbFeuillete;
    }

    public void setPrix(){
        prix.put("Taboule",6);
        prix.put("Soupe",5);
        prix.put("Tomate",6);
        prix.put("Fromage",7);
        prix.put("Spaghetti",12);
        prix.put("Lasagnes",15);
        prix.put("Curry",14);
        prix.put("Ratatouille",11);
    }
    public void setInitialEntree(){
        entree.put("Taboule",0);
        entree.put("Soupe",0);
        entree.put("Tomate",0);
        entree.put("Fromage",0);
    }

    public void setListeEntree(){
        listeEntree.add("Taboule");
        listeEntree.add("Soupe");
        listeEntree.add("Tomate");
        listeEntree.add("Fromage");
    }

    public void setBelleListeEntree(){
        belleListeEntree.add("Taboulé oriental");
        belleListeEntree.add("Soupe de légumes du soleil");
        belleListeEntree.add("Salade tomates mozarella");
        belleListeEntree.add("Feuilleté au fromage");
    }

    public void setBelleListePlat(){
        belleListePlat.add("Spaghetti Bolognaise");
        belleListePlat.add("Lasagnes végétariennes");
        belleListePlat.add("Curry de poulet");
        belleListePlat.add("Ratatouille");
    }


    public void setInitialPlat(){
        plat.put("Spaghetti",0);
        plat.put("Lasagnes",0);
        plat.put("Curry",0);
        plat.put("Ratatouille",0);

    }

    public void setListePlat(){
        listePlat.add("Spaghetti");
        listePlat.add("Lasagnes");
        listePlat.add("Curry");
        listePlat.add("Ratatouille");
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

    public ArrayList<String> getListeEntree(){
        return(listeEntree);
    }
    public ArrayList<String> getListePlat(){
        return(listePlat);
    }

    public String textCommande() {
        String c = "";
        Integer prixfinal =0;
        for (int i = 0; i < listeEntree.size(); i++) {
            String p1 = listeEntree.get(i);
            Integer pr = prix.get(p1); //prix du plat en question
            String p = belleListeEntree.get(i);
            Integer k = entree.get(p1);
            prixfinal = prixfinal + k*pr;
            if (k != 0) {
                c = c + k.toString() +" " + p + "\n";
            }
        }
        for (int i = 0; i < listePlat.size(); i++) {
            String p1 = listePlat.get(i);
            Integer k = plat.get(p1);
            String p = belleListePlat.get(i);
            Integer pr = prix.get(p1); //prix du plat en question
            prixfinal = prixfinal + k*pr;
            if (k != 0) {
                c = c + k.toString() + " " + p + "\n";
            }
        }
        c = c+ "\n" + "TOTAL : " + prixfinal.toString() +"€";
        return(c);
    }
}