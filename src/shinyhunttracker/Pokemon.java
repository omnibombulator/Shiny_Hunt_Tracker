package shinyhunttracker;

public class Pokemon{
    String name;
    int generation;
    Boolean breedable;
    Boolean huntable;

    //array of all legendary pokemon
    String[] Legendaries = {"Articuno", "Zapdos", "Moltres", "Mewtwo", "Raikou", "Entei", "Suicune", "Lugia", "Ho-Oh", "Regirock", "Regice", "Registeel", "Latias", "Latios", "Kyogre", "Groudon", "Rayquaza", "Uxie", "Mesprit", "Azelf", "Dialga", "Palkia", "Heatran", "Regigigas", "Giratina", "Cresselia", "Cobalion", "Terrakion", "Virizion", "Tornadus", "Thundurus", "Reshiram", "Zekrom", "Landorus", "Kyurem", "Xerneas", "Yveltal", "Zygarde", "Type: Null", "Silvally","Tapu Koko","Tapu Lele","Tapu Bulu","Tapu Fini","Cosmog","Cosmoem","Solgaleo","Lunala","Necrozma","Zacian","Zamazenta","Eternatus","Kubfu","Urshifu","Nihilego","Buzzwole","Pheromosa","Zurkitree","Celesteela","Kartana","Guzzlord","Poipole","Naganadel","Stakataka","Blacephalon","Mew","Celebi","Jirachi","Deoxys","Manaphy","Darkrai","Shaymin","Arceus","Victini","Keldeo","Meloetta","Genesect", "Diancie", "Hoopa", "Volcanion", "Magearna", "Marshadow", "Zeraora", "Meltan", "Melmetal", "Zarude"};

    Pokemon(){
        name = null;
        generation = 0;
        breedable = false;
        huntable = true;
    }

    //main constructor
    Pokemon(String name, int generation){
        this.name = name;
        this.generation = generation;
        breedable = isBreedable();
        isLegendary();
    }

    //checks to see if pokemon is in the undiscovered egg group, and that it doesn't have any evolutions
    public Boolean isBreedable(){
        String[] nonBreedablePokemon = {"Unown", "Dracozolt", "Arctozolt", "Dracovish", "Arctovish"};
        for(String i: Legendaries)
            if(i.compareTo(name) == 0)
                return false;
        for(String i: nonBreedablePokemon)
            if(i.compareTo(name) == 0)
                return false;
        return true;
    }

    //checks to see if the pokemon is legendary
    //if they are we have to start by assuming that it is not available
    public void isLegendary(){
        //since unown is neither breedable or able to evolve, I needed to treat it as a legendary
        //to get it to only show games that it is wild in
        if(name.compareTo("Unown") == 0) {
            huntable = false;
            return;
        }
        for(String i: Legendaries)
            if(i.compareTo(name) == 0) {
                huntable = false;
                return;
            }
        huntable = true;
    }

    //checks to see if the pokemon has a alolan variant available
    public Boolean isAlolan(){
        String[] alolanPokemon = {"Rattata", "Raticate", "Raichu", "Sandshrew", "Sandslash", "Vulpix", "Ninetales", "Diglett", "Dugtrio", "Meowth", "Persian", "Geodude", "Graveler", "Golem", "Grimer", "Muk", "Exeggutor", "Marowak"};
        for(String i: alolanPokemon)
            if(i.compareTo(this.name) == 0)
                return true;
        return false;
    }

    //checks to see if the pokemon has a galarian variant available
    public Boolean isGalarian(){
        String[] galarianPokemon = {"Meowth", "Ponyta", "Rapidash", "Slowpoke", "Farfetch'd", "Weezing", "Mr. Mime", "Corsola", "Zigzagoon", "Linoone", "Darumaka", "Darmanitan", "Yamask", "Stunfisk", "Slowpoke", "Slowbro"};
        for(String i: galarianPokemon)
            if(i.compareTo(this.name) == 0)
                return true;
        return false;
    }

    //gets base states for generation 1 pokemon
    public int getStats(String statType){
        int dexNum = 0;
        String[] pokemonStatDex = {"Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard", "Squirtle", "Wartortle", "Blastoise", "Caterpie", "Metapod", "Butterfree", "Weedle", "Kakuna", "Beedrill", "Pidgey", "Pidgeotto", "Pidgeot", "Rattata", "Raticate", "Spearow", "Fearow", "Ekans", "Arbok", "Pikachu", "Raichu", "Sandshrew", "Sandslash", "Nidoran♀", "Nidorina", "Nidoqueen", "Nidoran♂", "Nidorino", "Nidoking", "Clefairy", "Clefable", "Vulpix", "Ninetales", "Jigglypuff", "Wigglytuff", "Zubat", "Golbat", "Oddish", "Gloom", "Vileplume", "Paras", "Parasect", "Venonat", "Venomoth", "Diglett", "Dugtrio", "Meowth", "Persian", "Psyduck", "Golduck", "Mankey", "Primeape", "Growlithe", "Arcanine", "Poliwag", "Poliwhirl", "Poliwrath", "Abra", "Kadabra", "Alakazam", "Machop", "Machoke", "Machamp", "Bellsprout", "Weepinbell", "Victreebel", "Tentacool", "Tentacruel", "Geodude", "Graveler", "Golem", "Ponyta", "Rapidash", "Slowpoke", "Slowbro", "Magnemite", "Magneton", "Farfetch'd", "Doduo", "Dodrio", "Seel", "Dewgong", "Grimer", "Muk", "Shellder", "Cloyster", "Gastly", "Haunter", "Gengar", "Onix", "Drowzee", "Hypno", "Krabby", "Kingler", "Voltorb", "Electrode", "Exeggcute", "Exeggutor", "Cubone", "Marowak", "Hitmonlee", "Hitmonchan", "Lickitung", "Koffing", "Weezing", "Rhyhorn", "Rhydon", "Chansey", "Tangela", "Kangaskhan", "Horsea", "Seadra", "Goldeen", "Seaking", "Staryu", "Starmie", "Mr. Mime", "Scyther", "Jynx", "Electabuzz", "Magmar", "Pinsir", "Tauros", "Magikarp", "Gyarados", "Lapras", "Ditto", "Eevee", "Vaporeon", "Jolteon", "Flareon", "Porygon", "Omanyte", "Omastar", "Kabuto", "Kabutops", "Aerodactyl", "Snorlax", "Articuno", "Zapdos", "Moltres", "Dratini", "Dragonair", "Dragonite", "Mewtwo", "Mew"};
        for(int i = 0; i < pokemonStatDex.length; i++)
            if(pokemonStatDex[i].compareTo(name) == 0)
                dexNum = i;

        //Pokemon base Stats (Health, Attack, Defense, Special, Speed)
        int[][] stats ={{45, 49, 49, 65, 45},   //Bulbasaur
                        {60, 62, 63, 80, 60},   //Ivysaur
                        {80, 82, 83, 100, 80},  //Venusaur
                        {39, 52, 43, 50, 65},   //Charmander
                        {58, 64, 58, 65, 80},   //Charmeleon
                        {78, 84, 78, 85, 100},  //Charizard
                        {44, 48, 65, 50, 43},   //Squirtle
                        {59, 63, 80, 65, 58},   //Wartortle
                        {79, 83, 100, 85, 78},  //Blastoise
                        {45, 30, 35, 20, 45},   //Caterpie
                        {50, 20, 44, 25, 30},   //Metapod
                        {60, 45, 50, 80, 70},   //Butterfree
                        {40, 35, 30, 20, 50},   //Weedle
                        {45, 25, 50, 25, 35},   //Kakuna
                        {65, 80, 40, 45, 75},   //Beedrill
                        {40, 45, 40, 35, 56},   //Pidgey
                        {63, 60, 55, 50, 71},   //Pidgeotto
                        {83, 80, 75, 70, 91},   //Pidgeot
                        {30, 56, 35, 25, 71},   //Rattata
                        {55, 81, 60, 50, 97},   //Raticate
                        {40, 60, 30, 31, 70},   //Spearow
                        {65, 90, 65, 61, 100},  //Fearow
                        {35, 60, 44, 40, 55},   //Ekans
                        {60, 85, 69, 65, 80},   //Arbok
                        {35, 55, 30, 50, 90},   //Pikachu
                        {60, 90, 55, 90, 100},  //Raichu
                        {50, 75, 85, 30, 40},   //Sandshrew
                        {75, 100, 110, 55, 65}, //Sandslash
                        {55, 47, 52, 40, 41},   //Nidoran F
                        {70, 62, 67, 55, 56},   //Nidorina
                        {90, 82, 87, 75, 76},   //Nidoqueen
                        {46, 57, 40, 40, 50},   //Nidroan M
                        {61, 72, 57, 55, 65},   //Nidorino
                        {81, 92, 77, 75, 85},   //Nidoking
                        {70, 45, 48, 60, 35},   //Clefairy
                        {95, 70, 73, 85, 60},   //Clefable
                        {38, 41, 40, 65, 65},   //Vulpix
                        {73, 76, 75, 100, 100}, //Ninetales
                        {115, 45, 20, 25, 20},  //Jigglypuff
                        {140, 70, 45, 50, 45},  //Wigglytuff
                        {40, 45, 35, 40, 55},   //Zubat
                        {75, 80, 70, 75, 90},   //Golbat
                        {45, 50, 55, 75, 30},   //Oddish
                        {60, 65, 70, 85, 40},   //Gloom
                        {75, 80, 85, 100, 50},  //Vileplume
                        {35, 70, 55, 55, 25},   //Paras
                        {60, 95, 80, 80, 30},   //Parasect
                        {60, 55, 50, 40, 45},   //Venonat
                        {70, 65, 60, 90, 90},   //Venomoth
                        {10, 55, 25, 45, 95},   //Diglett
                        {35, 80, 50, 70, 120},  //Dugtrio
                        {40, 45, 35, 40, 90},   //Meowth
                        {65, 70, 60, 65, 115},  //Persian
                        {50, 52, 48, 50, 55},   //Psyduck
                        {80, 82, 78, 80, 85},   //Golduck
                        {40, 80, 35, 35, 70},   //Mankey
                        {65, 105, 60, 60, 95},  //Primeape
                        {55, 70, 45, 50, 60},   //Growlithe
                        {90, 110, 80, 80, 95},  //Arcanine
                        {40, 50, 40, 40, 90},   //Poliwag
                        {65, 65, 65, 50, 90},   //Poliwhirl
                        {90, 85, 95, 70, 70},   //Poliwrath
                        {25, 50, 15, 105, 90},  //Abra
                        {40, 35, 30, 120, 105}, //Kadabra
                        {55, 50, 45, 135, 120}, //Alakazam
                        {70, 80, 50, 35, 35},   //Machop
                        {80, 100, 70, 50, 45},  //Machoke
                        {90, 130, 80, 65, 55},  //Machamp
                        {50, 75, 35, 70, 40},   //Bellsprout
                        {65, 90, 50, 85, 55},   //Weepinbell
                        {80, 105, 65, 100, 70}, //Victreebel
                        {40, 40, 35, 100, 70},  //Tentacool
                        {80, 70, 65, 120, 100}, //Tentacruel
                        {40, 80, 100, 30, 20},  //Geodude
                        {55, 95, 115, 45, 35},  //Graveler
                        {80, 110, 130, 55, 45}, //Golem
                        {50, 85, 55, 65, 90},   //Ponyta
                        {65, 100, 70, 60, 105}, //Rapidash
                        {90, 65, 65, 40, 15},   //Slowpoke
                        {95, 75, 110, 80, 30},  //Slowbro
                        {25, 35, 70, 95, 45},   //Magnemite
                        {50, 60, 95, 120, 70},  //Magneton
                        {52, 65, 55, 58, 60},   //Farfetch'd
                        {35, 85, 45, 35, 75},   //Doduo
                        {60, 110, 70, 60, 100}, //Dodrio
                        {65, 45, 55, 70, 45},   //Seel
                        {90, 70, 80, 95, 70},   //Dewgong
                        {80, 80, 50, 40, 25},   //Grimer
                        {105, 105, 75, 65, 50}, //Muk
                        {30, 65, 100, 45, 40},  //Shellder
                        {50, 95, 180, 85, 70},  //Cloyster
                        {30, 35, 30, 100, 80},  //Gastly
                        {45, 50, 45, 115, 95},  //Haunter
                        {60, 65, 60, 130, 110}, //Gengar
                        {35, 45, 160, 30, 70},  //Onix
                        {60, 48, 45, 90, 42},   //Drowzee
                        {85, 73, 70, 115, 67},  //Hypno
                        {30, 105, 90, 25, 50},  //Krabby
                        {55, 130, 115, 50, 75}, //Kingler
                        {40, 30, 50, 55, 100},  //Voltorb
                        {60, 50, 70, 80, 140},  //Electrode
                        {60, 40, 80, 60, 40},   //Exeggcute
                        {95, 95, 85, 125, 55},  //Exeggutor
                        {50, 50, 95, 40, 35},   //Cubone
                        {60, 80, 110, 50, 45},  //Marowak
                        {50, 120, 53, 35, 87},  //Hitmonlee
                        {50, 105, 79, 35, 76},  //Hitmonchan
                        {90, 55, 75, 60, 30},   //Lickitung
                        {40, 65, 95, 60, 35},   //Koffing
                        {65, 90, 120, 85, 60},  //Weezing
                        {80, 85, 95, 30, 25},   //Rhyhorn
                        {105, 130, 120, 45, 40},//Rhydon
                        {250, 5, 5, 105, 50},   //Chansey
                        {65, 55, 115, 100, 60}, //Tangela
                        {105, 95, 80, 40, 90},  //Kangaskhan
                        {30, 40, 70, 70, 60},   //Horsea
                        {55, 65, 95, 95, 85},   //Seadra
                        {45, 67, 60, 50, 63},   //Goldeen
                        {80, 92, 65, 80, 68},   //Seaking
                        {30, 45, 55, 70, 85},   //Staryu
                        {60, 75, 85, 100, 115}, //Starmie
                        {40, 45, 65, 100, 90},  //Mr. Mime
                        {70, 110, 80, 55, 105}, //Scyther
                        {65, 50, 35, 95, 95},   //Jynx
                        {65, 83, 57, 85, 105},  //Electabuzz
                        {65, 95, 57, 85, 93},   //Magmar
                        {65, 125, 100, 55, 85}, //Pinsir
                        {75, 100, 95, 70, 110}, //Tauros
                        {20, 10, 55, 20, 80},   //Magikarp
                        {95, 125, 79, 100, 81}, //Gyarados
                        {130, 85, 80, 95, 60},  //Lapras
                        {48, 48, 48, 48, 48},   //Ditto
                        {55, 55, 50, 65, 55},   //Eevee
                        {130, 65, 60, 110, 65}, //Vaporeon
                        {65, 65, 60, 110, 130}, //Jolteon
                        {65, 130, 60, 110, 65}, //Flareon
                        {65, 60, 70, 75, 40},   //Porygon
                        {35, 4, 100, 90, 35},   //Omanyte
                        {70, 60, 125, 115, 55}, //Omastar
                        {30, 80, 90, 45, 55},   //Kabuto
                        {60, 115, 105, 70, 80}, //Kabutops
                        {80, 105, 65, 65, 130}, //Aerodactyl
                        {160, 110, 65, 65, 30}, //Snorlax
                        {90, 85, 100, 125, 85}, //Articuno
                        {90, 90, 85, 125, 100}, //Zapdos
                        {90, 100, 90, 125, 90}, //Moltres
                        {41, 64, 45, 50, 50},   //Dratini
                        {61, 84, 65, 70, 70},   //Dragonair
                        {91, 134, 95, 100, 80}, //Dragonite
                        {106, 110, 90, 154, 130},//Mewtwo
                        {100, 100, 100, 100, 100}};//Mew
        switch(statType){
            case "health":
                return stats[dexNum][0];
            case "attack":
                return stats[dexNum][1];
            case "defense":
                return stats[dexNum][2];
            case "speed":
                return stats[dexNum][3];
            case "special":
                return stats[dexNum][4];
            default:
                return 0;
        }
    }

    public String getName(){
        return name;
    }

    public Boolean getBreedable(){
        return breedable;
    }

    public int getGeneration(){
        return generation;
    }

    public Boolean getHuntable(){
        return huntable;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setHuntable(Boolean huntable){
        this.huntable = huntable;
    }
}
