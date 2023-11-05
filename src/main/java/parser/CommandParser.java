package parser;

import command.*;
import spotify.Spotify;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CommandParser implements DataParser {
    int index = 0;
    int exec = 0;
    List <Command> commands = new ArrayList<>();
    public void parse(Spotify spotify, String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/" + args[3]))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                Integer id = Integer.parseInt(data[0]);
                Command command = null;
                if (data[1].equals("LIST")) {
                    command = new ListCommand(id);
                }
                else if(data[1].equals("ADD")) {
                    command = new AddCommand(id,line);
                }
                else if(data[1].equals("DELETE")) {
                    Integer idStream = Integer.parseInt(data[2]);
                    command = new DeleteCommand(id, idStream);
                }
                else if(data[1].equals("LISTEN")) {
                    Integer idStream = Integer.parseInt(data[2]);
                    command = new ListenCommand(id, idStream);
                }
                else if(data[1].equals("RECOMMEND")) {
                    command = new RecommendCommand(id, data[2]);
                }
                else if(data[1].equals("SURPRISE")){
                    command = new SurpriseCommand(id, data[2]);
                }

                commands.add(command);

            }
            for(Command c : commands)
                c.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}