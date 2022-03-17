package edu.uic.project_2;

import java.util.ArrayList;

public class InfoFacts {

    String name = "" ;
    String lifespan = "";
    String weight = "";
    String habitat = "";
    String feeding = "";
    String endangered = "";


    public InfoFacts(String name) {

           switch (name){
               case "Wolf":
                   Wolf();
                   break;
               case "Bear":
                   Bear();
                   break;
               case "Leopard":
                   Leopard();
                   break;
               case "Lion":
                   Lion();
                   break;
               case "Elephant":
                   Elephant();
                   break;
               case "Otter":
                   Otter();
                   break;
               case "Zebra":
                   Zebra();
                   break;
               case "Capybara":
                   Capybara();
                   break;
               default:
                   break;
           }

    }

    public void Wolf(){
        this.name = "Wolf" ;
        this.lifespan = "14-16 years";
        this.weight = "66 - 180 pounds";
        this.habitat = "Forests, grasslands and deserts";
        this.feeding = "Large hoofed mammals";
        this.endangered = "No";

    }

    public void Bear(){
        this.name = "Bear" ;
        this.lifespan = "20 - 30 years";
        this.weight = "700 - 1700 pounds";
        this.habitat = "Forest and Mountains ";
        this.feeding = "Berries, Grain and Fish";
        this.endangered = "No";

    }

    public void Leopard(){
        this.name = "Leopard" ;
        this.lifespan = "12 - 17 years";
        this.weight = "50 - 60 pounds";
        this.habitat = "Tropical Forests";
        this.feeding = "Birds, Lizards, Fish";
        this.endangered = "No";

    }

    public void Lion(){
        this.name = "Lion" ;
        this.lifespan = "10 - 15 years";
        this.weight = "280 - 420 pounds ";
        this.habitat = "Grasslands and Savanna";
        this.feeding = "Wildebeests, Zebras, and Antelopes";
        this.endangered = "No";

    }

    public void Elephant(){
        this.name = "Elephant" ;
        this.lifespan = "60 - 70 years";
        this.weight = "6000 - 13000 pounds";
        this.habitat = "Grasslands and Savanna";
        this.feeding = "Roots, Grasses, Fruit";
        this.endangered = "No";

    }

    public void Otter(){
        this.name = "Otter" ;
        this.lifespan = "10 - 20 years";
        this.weight = "45 - 90 pounds";
        this.habitat = "Lakes and Rivers";
        this.feeding = "Crayfishes, Crabs, Fish";
        this.endangered = "No";

    }

    public void Zebra(){
        this.name = "Zebra" ;
        this.lifespan = "20 - 25 years";
        this.weight = "770 - 990 pounds";
        this.habitat = "Grasslands and Savanna";
        this.feeding = "Grass, Leaves, Bark";
        this.endangered = "No";

    }

    public void Capybara(){
        this.name = "Capybara" ;
        this.lifespan = "8 - 10 years";
        this.weight = "77 - 150 pounds";
        this.habitat = "Grassy regions";
        this.feeding = "Fresh Grass";
        this.endangered = "No";

    }


}
