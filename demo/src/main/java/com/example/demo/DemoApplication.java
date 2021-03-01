package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    
    static List<Player> players = new ArrayList();
    
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run (String ... args) throws Exception {	
		menuSelection();
	}

	private static void menuSelection () {
        System.out.println("\nHUVUDMENY\n" );
        System.out.println("1. Add new ");
        System.out.println("2. Update player?");
        System.out.println("3. List all");
        System.out.println("100. Exit");
        int selection = Integer.parseInt(System.console().readLine());
        if(selection == 1) {
            players.add(addPlayer());
        } else if(selection == 3) {
            listPlayers();
        } 
        if(selection != 100) { 
            menuSelection();
        }
    }

	private static Player addPlayer () {
        System.out.println("Name: ");
        String name = System.console().readLine();
        System.out.println("Jersey: ");
        int jersey = Integer.parseInt(System.console().readLine());
        return new Player (name, jersey);
    }

    private static void listPlayers () {
        System.out.println("\n *** ALL PLAYERS *** \n");
        for (Player player: players) {
            System.out.println(player.name + " " + player.jersey);
        }
    }

    private static class Player {
        private String name;
        private int jersey;  

        Player (String name, int jersey) {
            this.name = name;
            this.jersey = jersey;
        }

        public String getName() {
            return name;
        }

        public void setName (String name) {
            this.name = name;
        }

        public int getJersey() {
            return jersey;
        }

        public void setJersey (int jersey) {
            this.jersey = jersey;
        }

     }
}
