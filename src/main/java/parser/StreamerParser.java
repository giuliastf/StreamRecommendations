package parser;

import java.io.*;
import models.*;
import spotify.Spotify;


public class StreamerParser implements DataParser {
    public void parse(Spotify spotify, String[] args){
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/" + args[0]))) {
            String line;
            line = br.readLine(); //scap de header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",",3);
                for(int i=0; i<3; i++)
                    data[i] = data[i].substring(1, data[i].length()-1);
                Integer StreamerType = Integer.parseInt(data[0]);
                Integer id = Integer.parseInt(data[1]);
                String name = data[2];
                Streamer streamer = new Streamer(StreamerType, id, name);
                spotify.addStreamer(streamer);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
