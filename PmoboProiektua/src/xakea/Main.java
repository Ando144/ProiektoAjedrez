package xakea;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize 65001 code page
        try {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "chcp 65001").inheritIO();
        Process p = pb.start();
        p.waitFor();
        } catch (Exception e) {
            System.out.println("Error initializing 65001 code page");
        }
        Partida nirePartida = new Partida();
        nirePartida.partidaBatJolastu();
    }
}
