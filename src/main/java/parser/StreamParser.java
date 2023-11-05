package parser;

import models.Stream;
import spotify.Spotify;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StreamParser implements DataParser {
    public void parse(Spotify spotify, String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/" + args[1]))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", 8);
                for(int i=0; i<8; i++)
                    data[i] = data[i].substring(1, data[i].length()-1);
                Integer StreamType = Integer.parseInt(data[0]);
                Integer id = Integer.parseInt(data[1]);
                Integer StreamGenre = Integer.parseInt(data[2]);
                Long noOfStreams = Long.parseLong(data[3]);
                Integer streamerId = Integer.parseInt(data[4]);
                Long length = Long.parseLong(data[5]);
                Long dateAdded = Long.parseLong(data[6]);
                String name = data[7];
                Stream stream = new Stream(StreamType,id,StreamGenre,noOfStreams,streamerId,length,dateAdded,name);
                spotify.addStream(stream);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}