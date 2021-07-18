package com.example.partyflipper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Game_Logic {
    private static HashMap<String, String[]> dictOfCategories;

    public Game_Logic(){
        loadDict();
    }
    private  void loadDict(){
        dictOfCategories = new HashMap<>();
        dictOfCategories.put("WK", sylwester2021);


        dictOfCategories.put("ANIMALS", animals_list);
        dictOfCategories.put("MOVIES", movies_list);
        dictOfCategories.put("FOOD", food_list);
        dictOfCategories.put("BOOKS", books_list);
        dictOfCategories.put("SPORT", sport_list);
        dictOfCategories.put("GEOGRAPHY", geography_list);
        dictOfCategories.put("GAMES", games_list);
        dictOfCategories.put("FAME", fames_list);
        dictOfCategories.put("SONGS", songs_list);
        dictOfCategories.put("DISNEY", disney_list);
    }

    private  String[] animals_list ={"Cat","Horse", "Fancy rat varieties"
    ,"Sheep"
    ,"Water"
    ,"Chicken breeds"
    ,"Goose breeds"
    ,"Turkey breeds"
    ,"Aardvark"
    ,"African buffalo"
    ,"African elephant"
    ,"African leopard"
    ,"Alpaca"
    ,"American robin"
    ,"Amphibian"
    ,"Anaconda"
    ,"Angelfish"
    ,"Anglerfish"};

    private  String[] sylwester2021 ={"MI6","Most pod prysznicem w KW", "Rezydencja Morawskich"
    ,"Patrick i Kacper rzygają do wanny"
    ,"Hadvar do spania"
    ,"Nasz mały komisarzyk"
    ,"Murek 2"
    ,"Paweł wali shotguna"
    ,"Wanna drink some vodka"
    ,"Pirulo Banani"
    ,"Turbomaskarator"
    ,"Turbobiceps"
    ,"Mały jacek rzyga za okno"
    ,"Kubańczyk lady pank"
    ,"Won kloszardzie"
    ,"Grill u gogola"
    ,"Fontanna na 18 Niemca" 
    ,"Samara bez dna"
    ,"Pigman"
    ,"Flanki"
    ,"Wóda z WZW"
    ,"Grzesiu rzyga do śmietnika w Kudowie"
    ,"Betonowe buty"
    ,"Murziny tanćują"
    ,"Somebody that i used to know"
    ,"Kacper prosi o więcej lajków"
    ,"ale czapkę to masz dojebaną"
    ,"jeden musi bez spodni"
    ,"AAAA MUSZKA"
    ,"Temat domek to jest temat trudny ziomek"
    ,"Hamryka spierdalaj"
    ,"Łajka wysłana w kosmos"
    ,"AAA ZAJEBAŁEM KURWY"};

    private String movies_list[] = { "Batman", "Troy", "Titanic", "Lord of the rings", "Star Wars", "The Godfather", "Scarface", "Dirty Dancing", "James Bond"};
    private String food_list[] = { "Pizza", "Banana", "Sandwich", "Fries", "Popcorn", "Spaghetti", "Hamburger", "Ice cream", "Cake"};
    private String books_list[] = { "Moby Dick", "Hamlet", "Odyssey", "Divine Comedy", "Heart of Darkness", "Harry Potter", "The Trial", "Shining", "Da Vinci Code"};
    private String sport_list[] = { "Football", "Basketball", "Golf", "Tennis", "Hockey", "Baseball", "Running", "Skiing", "Karate"};
    private String geography_list[] = { "USA", "Russia", "China", "India", "Vatican City", "Paris", "Brazil", "Poland", "Las Vegas"};
    private String games_list[] = { "Tekken", "FIFA", "Counter Strike", "Dota", "Gothic", "Pac-Man", "GTA", "Mario", "Diablo"};
    private String fames_list[] = { "Albert Einstein", "Barack Obama", "Will Smith", "Sean Connery", "John Lennon", "Lebron James", "Michael Jordan", "Cristiano Ronaldo", "Nelson Mandela"};
    private String songs_list[] = { "Last Christmas", "Bohemian Rhapsody", "Hey Jude", "Toxic", "Billie Jean", "Beat It", "Imagine", "Despacito", "Black and Yellow"};
    private String disney_list[] = { "Donald Duck", "Mickey Mouse", "Ratatouille", "Simba", "Mulan", "Frozen", "Pocahontas", "Aladdin", "Cars"};


    public String[] loadClues(int num_of_rounds, String category){
        Random r =  new Random();
        String [] list = dictOfCategories.get(category);
        List<Integer> nums = new ArrayList<>();
        String [] clues_arr  = new String[num_of_rounds];

        int i  =0;
        while (i < num_of_rounds) {
            int next = r.nextInt(list.length);
            if (!nums.contains(next)){
                nums.add(next);
                clues_arr[i] = list[next];
                i++;
            }
        }
        return clues_arr;
    }
    public  String[] loadRandomClues(int num_of_rounds){
        if (dictOfCategories == null)
            loadDict();

        Random r =  new Random();
        List<String[]> values = new ArrayList<>(dictOfCategories.values());
        String [] list= values.get(r.nextInt(values.size()));

        while (list ==sylwester2021)
            list= values.get(r.nextInt(values.size()));


        List<Integer> nums = new ArrayList<>();
        String [] clues_arr  = new String[num_of_rounds];

        int i  =0;
        while (i < num_of_rounds) {
            int next = r.nextInt(list.length);
            if (!nums.contains(next)){
                nums.add(next);
                clues_arr[i] = list[next];
                i++;
            }
        }
        return clues_arr;
    }


}
