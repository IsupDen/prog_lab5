package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static util.TextFormat.errText;

public class Console implements ConsoleInterface{
    private final Scanner scanner;
    private boolean scriptStatus = false;
    private BufferedReader scriptReader = null;

    public Console(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String readline() throws IOException{
        return scriptReader.readLine();
    }

    @Override
    public void setScriptMode(BufferedReader scriptReader) {
        scriptStatus = true;
        this.scriptReader = scriptReader;
    }

    @Override
    public void setInteractiveMode(){
        scriptStatus = false;
        try {
            scriptReader.close();
        } catch (IOException e) {
            println(errText("Input or Output error!"));
        }
    }

    @Override
    public boolean getScriptStatus() {
        return scriptStatus;
    }

    @Override
    public String read() {
        String line;
        try {
            line = scanner.nextLine();
        } catch (NoSuchElementException e) {
            System.exit(0);
            return null;
        }
        if (line.trim().isEmpty()) {
            return null;
        }
        return line.trim();
    }

    public static void print(Object obj) {
        System.out.print(obj);
    }
    public static void println(Object obj) {
        System.out.println(obj);
    }
    public static void println() {
        System.out.println();
    }
}
