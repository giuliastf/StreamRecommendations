package parser;

import models.User;
import spotify.Spotify;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserParser implements DataParser {
    public void parse(Spotify spotify, String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/" + args[2]))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", 3);
                for(int i=0; i<3; i++)
                    data[i] = data[i].substring(1, data[i].length()-1);
                Integer id = Integer.parseInt(data[0]);
                String name = data[1];
                String[] i = data[2].split(" ");
                List<Integer> streams = new ArrayList<>();
                for (String s : i)
                    streams.add(Integer.parseInt(s));
                User user = new User(id, name, streams);
                spotify.addUsers(user);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
