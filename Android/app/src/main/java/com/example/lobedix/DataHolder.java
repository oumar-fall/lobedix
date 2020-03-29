package com.example.lobedix;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class DataHolder {
    private static Hashtable<String,Integer> entree = new Hashtable<String,Integer>();
    private static Hashtable<String,Integer> plat = new Hashtable<String,Integer>();
    private static Hashtable<String,Integer> dessert = new Hashtable<String,Integer>();
    private static Hashtable<String,Integer> menu = new Hashtable<String,Integer>();
    private static Hashtable<String,Integer> boisson = new Hashtable<String,Integer>();


    private static final DataHolder holder = new DataHolder();

    private  static ArrayList<String> listeEntree = new ArrayList<String>();
    private  static ArrayList<String> listePlat = new ArrayList<String>();
    private  static ArrayList<String> listeDessert = new ArrayList<String>();
    private  static ArrayList<String> listeMenus = new ArrayList<String>();
    private  static ArrayList<String> listeBoissons = new ArrayList<String>();

    private static ArrayList<String> belleListePlat = new ArrayList<String>(); //pour garder les noms entiers des plats et pas juste la clé
    private  static ArrayList<String> belleListeEntree = new ArrayList<String>();
    private  static ArrayList<String> belleListeDessert= new ArrayList<String>();
    private  static ArrayList<String> belleListeMenu= new ArrayList<String>();
    private  static ArrayList<String> belleListeBoisson= new ArrayList<String>();

    private static Hashtable<String,Integer> prix = new Hashtable<String,Integer>();

    private static int nbSoupe;
    private static int nbTaboule;
    private static int nbTomates;
    private static int nbFeuillete;

    private static int nbSpaghetti;
    private static int nbLasagnes;
    private static int nbCurry;
    private static int nbRatatouille;

    private static int nbCreme;
    private static int nbSalade;
    private static int nbMousse;
    private static int nbGlace;

    private static int nbSimple;
    private static int nbJour;
    private static int nbVege;


    private static int nbBoissonSoupe;
    private static int nbBoissonTaboule;
    private static int nbBoissonTomates;
    private static int nbBoissonFeuillete;

    private static int nbBoissonSpaghetti;
    private static int nbBoissonLasagnes;
    private static int nbBoissonCurry;
    private static int nbBoissonRatatouille;

    private static int nbBoissonCreme;
    private static int nbBoissonSalade;
    private static int nbBoissonMousse;
    private static int nbBoissonGlace;




    public void initNb(){
        nbSoupe =0;
        nbTaboule =0;
        nbTomates=0;
        nbFeuillete=0;

        nbSpaghetti=0;
        nbLasagnes=0;
        nbCurry=0;
        nbRatatouille=0;

        nbCreme=0;
        nbSalade=0;
        nbMousse=0;
        nbGlace=0;

        nbJour=0;
        nbSimple=0;
        nbVege=0;

        nbBoissonSoupe =0;
        nbBoissonTaboule =0;
        nbBoissonTomates=0;
        nbBoissonFeuillete=0;

        nbBoissonSpaghetti=0;
        nbBoissonLasagnes=0;
        nbBoissonCurry=0;
        nbBoissonRatatouille=0;

        nbBoissonCreme=0;
        nbBoissonSalade=0;
        nbBoissonMousse=0;
        nbBoissonGlace=0;

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



    public int getNbCreme(){
        return(nbCreme);
    }
    public void setNbCreme(int nbCreme){
        this.nbCreme = nbCreme;
    }

    public int getNbSalade(){ return(nbSalade); }
    public void setNbSalade(int nbSalade){
        this.nbSalade= nbSalade;
    }

    public int getNbMousse(){
        return(nbMousse);
    }
    public void setNbMousse(int nbMousse){
        this.nbMousse = nbMousse;
    }

    public int getNbGlace(){
        return(nbGlace);
    }
    public void setNbGlace(int nbGlace){
        this.nbGlace = nbGlace;
    }



    public int getNbSimple() { return(nbSimple); }
    public void setNbSimple(Integer nbSimple) { this.nbSimple = nbSimple;}

    public int getNbJour() { return(nbJour);}
    public void setNbJour(Integer nbJour) { this.nbJour = nbJour;}


    public int getNbVege() { return (nbVege); }
    public void setNbVege(Integer nbVege) { this.nbVege = nbVege;}

    public int getNbBoissonSpaghetti(){
        return(nbBoissonSpaghetti);
    }
    public void setNbBoissonSpaghetti(int nbBoissonSpaghetti){
        this.nbBoissonSpaghetti = nbBoissonSpaghetti;
    }

    public int getNbBoissonLasagnes(){
        return(nbBoissonLasagnes);
    }
    public void setNbBoissonLasagnes(int nbBoissonLasagnes){
        this.nbBoissonLasagnes= nbBoissonLasagnes;
    }

    public int getNbBoissonCurry(){
        return(nbBoissonCurry);
    }
    public void setNbBoissonCurry(int nbBoissonCurry){
        this.nbBoissonCurry = nbBoissonCurry;
    }

    public int getNbBoissonRatatouille(){
        return(nbRatatouille);
    }
    public void setNbBoissonRatatouille(int nbRatatouille){
        this.nbRatatouille = nbRatatouille;
    }



    public int getNbBoissonSoupe(){
        return(nbBoissonSoupe);
    }
    public void setNbBoissonSoupe(int nbBoissonSoupe){
        this.nbBoissonSoupe = nbBoissonSoupe;
    }

    public int getNbBoissonTaboule(){
        return(nbBoissonTaboule);
    }
    public void setNbBoissonTaboule(int nbBoissonTaboule){
        this.nbBoissonTaboule = nbBoissonTaboule;
    }

    public int getNbBoissonTomates(){
        return(nbBoissonTomates);
    }
    public void setNbBoissonTomates(int nbBoissonTomates){
        this.nbBoissonTomates = nbBoissonTomates;
    }

    public int getNbBoissonFeuillete(){
        return(nbBoissonFeuillete);
    }
    public void setNbBoissonFeuillete(int nbBoissonFeuillete){
        this.nbBoissonFeuillete = nbBoissonFeuillete;
    }



    public int getNbBoissonCreme(){
        return(nbBoissonCreme);
    }
    public void setNbBoissonCreme(int nbBoissonCreme){
        this.nbBoissonCreme = nbBoissonCreme;
    }

    public int getNbBoissonSalade(){ return(nbBoissonSalade); }
    public void setNbBoissonSalade(int nbBoissonSalade){
        this.nbBoissonSalade= nbBoissonSalade;
    }

    public int getNbBoissonMousse(){
        return(nbMousse);
    }
    public void setNbBoissonMousse(int nbMousse){
        this.nbMousse = nbMousse;
    }

    public int getNbBoissonGlace(){
        return(nbBoissonGlace);
    }
    public void setNbBoissonGlace(int nbBoissonGlace){
        this.nbBoissonGlace = nbBoissonGlace;
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
        prix.put("Creme", 7);
        prix.put("Salade", 6);
        prix.put("Mousse", 7);
        prix.put("Glace", 4);
        prix.put("Jour", 24);
        prix.put("Simple", 18);
        prix.put("Vege", 22);

        prix.put("Boisson taboule",3);
        prix.put("Boisson soupe",4);
        prix.put("Boisson tomate",3);
        prix.put("Boisson fromage",6);
        prix.put("Boisson spaghetti",8);
        prix.put("Boisson lasagnes",3);
        prix.put("Boisson curry",5);
        prix.put("Boisson ratatouille",6);
        prix.put("Boisson creme", 3);
        prix.put("Boisson salade", 5);
        prix.put("Boisson mousse", 6);
        prix.put("Boisson glace", 3);
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



    public void setBelleListeDessert(){
        belleListeDessert.add("Crème brûlée");
        belleListeDessert.add("Salade de fruits");
        belleListeDessert.add("Mousse au chocolat");
        belleListeDessert.add("Glace à la vanille");
    }

    public void setInitialDessert(){
        dessert.put("Creme",0);
        dessert.put("Salade",0);
        dessert.put("Mousse",0);
        dessert.put("Glace",0);

    }

    public void setListeDessert(){
        listeDessert.add("Creme");
        listeDessert.add("Salade");
        listeDessert.add("Mousse");
        listeDessert.add("Glace");
    }



    public void setBelleListeMenus(){
        belleListeMenu.add("Menu du jour");
        belleListeMenu.add("Formule Simple");
        belleListeMenu.add("Menu végétarien");
    }

    public void setInitialMenus(){
        menu.put("Jour",0);
        menu.put("Simple",0);
        menu.put("Vege",0);

    }

    public void setListeMenus(){
        listeMenus.add("Jour");
        listeMenus.add("Simple");
        listeMenus.add("Vege");
    }

    public void setListeBoisson(){
        listeBoissons.add("Boisson curry");
        listeBoissons.add("Boisson spaghetti");
        listeBoissons.add("Boisson ratatouille");
        listeBoissons.add("Boisson lasagnes");

        listeBoissons.add("Boisson fromage");
        listeBoissons.add("Boisson soupe");
        listeBoissons.add("Boisson tomate");
        listeBoissons.add("Boisson taboule");

        listeBoissons.add("Boisson creme");
        listeBoissons.add("Boisson mousse");
        listeBoissons.add("Boisson glace");
        listeBoissons.add("Boisson salade");

    }


    public void setBelleListeBoissons(){
        belleListeBoisson.add("Crozes-Hermitage");
        belleListeBoisson.add("Vin rouge Gevrey Chambertin Jean Bouchard");
        belleListeBoisson.add("BANDOL ROUGE - DOMAINE LA BASTIDE BLANCHE");
        belleListeBoisson.add("Vin rosé Coteaux d'Aix en Provence Château Virant");

        belleListeBoisson.add("Vin rouge Haut Médoc Cru Bourgeois Château Clément-Pichon");
        belleListeBoisson.add("Vin Rosé Côtes de Provence Cru Classé Château Roubine Réserve");
        belleListeBoisson.add("Beaujolais Villages Rouge");
        belleListeBoisson.add("Vin Rosé Tavel La Cave d'Augustin Florent");

        belleListeBoisson.add("Vin Blanc Moeulleux Monbazillac");
        belleListeBoisson.add("Domaine Madeloc Cirera - Rouge");
        belleListeBoisson.add("Muscat Petit Grain Saint Jean de Minervois");
        belleListeBoisson.add("Goose Island Sofie");
    }

    public void setInitialBoissons(){
        boisson.put("Boisson curry",0);
        boisson.put("Boisson spaghetti",0);
        boisson.put("Boisson ratatouille",0);
        boisson.put("Boisson lasagnes",0);

        boisson.put("Boisson fromage",0);
        boisson.put("Boisson soupe",0);
        boisson.put("Boisson tomate",0);
        boisson.put("Boisson taboule",0);

        boisson.put("Boisson creme",0);
        boisson.put("Boisson mousse",0);
        boisson.put("Boisson glace",0);
        boisson.put("Boisson salade",0);

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

    public Hashtable<String,Integer> getDessert() {
        return dessert;
    }
    public void setDessert(Hashtable<String,Integer> dessert) {
        this.dessert = dessert;
    }

    public Hashtable<String, Integer> getMenu() { return menu;}
    public void setMenu(Hashtable<String,Integer> menu) {
        this.menu = menu;
    }

    public Hashtable<String, Integer> getBoisson() { return boisson;}
    public void setBoisson(Hashtable<String,Integer> boisson) {
        this.boisson = boisson;
    }

    public ArrayList<String> getListeEntree(){
        return(listeEntree);
    }
    public ArrayList<String> getListePlat(){
        return(listePlat);
    }
    public ArrayList<String> getListeDessert(){
        return(listeDessert);
    }
    public ArrayList<String> getListeMenus(){ return(listeMenus); }
    public ArrayList<String> getListeBoissons(){ return(listeBoissons); }

    public void cleanListeEntree(){
        listeEntree = new ArrayList<String>();
        entree = new Hashtable<String,Integer>();
        belleListePlat = new ArrayList<String>();
    }

    public void cleanListePlat(){
        listePlat = new ArrayList<String>();
        plat = new Hashtable<String,Integer>();
        belleListePlat = new ArrayList<String>();
    }

    public void cleanListeDessert(){
        listeDessert = new ArrayList<String>();
        dessert = new Hashtable<String,Integer>();
        belleListeDessert = new ArrayList<String>();
    }

    public void cleanListeMenu(){
        listeMenus = new ArrayList<String>();
        menu = new Hashtable<String,Integer>();
        belleListeMenu = new ArrayList<String>();
    }

    public void cleanListeBoisson(){
        listeBoissons = new ArrayList<String>();
        boisson = new Hashtable<String,Integer>();
        belleListeBoisson = new ArrayList<String>();
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

        for (int i = 0; i < listeDessert.size(); i++) {
            String p1 = listeDessert.get(i);
            Integer k = dessert.get(p1);
            String p = belleListeDessert.get(i);
            Integer pr = prix.get(p1); //prix du plat en question
            prixfinal = prixfinal + k*pr;
            if (k != 0) {
                c = c + k.toString() + " " + p + "\n";
            }
        }

        for (int i = 0; i < listeMenus.size(); i++) {
            String p1 = listeMenus.get(i);
            Integer k = menu.get(p1);
            String p = belleListeMenu.get(i);
            Integer pr = prix.get(p1); //prix du plat en question
            prixfinal = prixfinal + k*pr;
            if (k != 0) {
                c = c + k.toString() + " " + p + "\n";
            }
        }

        for (int i = 0; i < listeBoissons.size(); i++) {
            String p1 = listeBoissons.get(i);
            Integer k = boisson.get(p1);
            String p = belleListeBoisson.get(i);
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