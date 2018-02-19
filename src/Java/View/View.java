package Java.View;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class View {
    
    private BufferedReader bufferedReader = null;
    private Scanner reader = new Scanner(System.in);

    public void displayUserMenu(String filename){
        clearScreen();
        String userMenu = importUserMenu(filename);
            System.out.println(userMenu);
        }

    private String importUserMenu(String filename) {

        String userMenu = "";

        try {
            bufferedReader = new BufferedReader(new FileReader(filename));
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();

            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
                userMenu = stringBuilder.toString();

        } catch (FileNotFoundException exception) {
            exception.printStackTrace();

        } catch (IOException exception) {
            exception.printStackTrace();

        } finally {
            try {
                bufferedReader.close();
            } catch (IOException exception) {
                exception.printStackTrace();
        }
    }
        return userMenu;
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

    public String getUserInput(String text){
        System.out.println(text);
        String input = reader.nextLine();
        return input;
    }

    public void displayText(String text){
        System.out.println(text);
    }
}