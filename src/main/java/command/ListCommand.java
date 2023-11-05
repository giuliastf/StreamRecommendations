package command;

import com.google.gson.JsonArray;
import models.*;
import spotify.Spotify;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ListCommand implements Command {
    Integer id;
    public ListCommand (Integer id){
        this.id = id;
    }
    @Override
    public void execute(){
        Spotify spotify = Spotify.Instance();

        for(Streamer s : spotify.getStreamers()){
            if(s.getId().equals(id)){ //streamer
                JsonArray arr = new JsonArray();
                for(Stream stream : spotify.getStreams()) {
                    if(stream.getStreamerId().equals(id))
                        spotify.ListStreams(stream,arr);
                }
                System.out.println(arr);
                return ;
            }
        }

        for(User user : spotify.getUsers()) {
            if(user.getId().equals(id)) { //am gasit user
                JsonArray arr = new JsonArray();
                for(Integer idStream : user.getStreamList()) { // parcurg lista de steams
                    for(Stream stream : spotify.getStreams()) {
                        if (stream.getId().equals(idStream)) {
                            spotify.ListStreams(stream,arr);
                        }
                    }
                }
                System.out.println(arr);
                return ;
            }
        }
    }

    public void undo(){;}
}
