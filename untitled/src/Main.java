import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Incrementer incrementer = new Incrementer();
        while (true){
            String str = reader.readLine();
            incrementer.useCommand(str);
            if(str.equals("/stop"))break;
        }
    }
}