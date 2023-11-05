package spotify;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import models.*;

import java.util.*;

/* SINGLETON */
public class Spotify {
    private List<Streamer> streamers;
    private List<Stream> streams;
    private List<User> users;
    private static Spotify single_instance = null;
    public static Spotify Instance() {
        if(single_instance == null)
            single_instance = new Spotify();
        return single_instance;
    }
    private Spotify() {
        streamers = new ArrayList<>();
        streams = new ArrayList<>();
        users = new ArrayList<>();
    }

    public List<Streamer> getStreamers() {
        return this.streamers;
    }

    public List<Stream> getStreams() {
        return this.streams;
    }
    public List<User> getUsers() {
        return this.users;
    }

    public void addStreamer(Streamer streamer) {
        streamers.add(streamer);
    }

    public void addUsers(User user) {
        users.add(user);
    }

    public void addStream(Stream stream) {
        streams.add(stream);
    }

    public static void reset(){
        single_instance = null;
    }

    public String getStreamerNamebyId(Integer id) {
        for(Streamer s : streamers)
            if(s.getId().equals(id))
                return s.getName();
        return null;
    }
    public void ListStreams(Stream stream, JsonArray arr){
        JsonObject obj = new JsonObject();
        obj.addProperty("id", Integer.toString(stream.getId()));
        obj.addProperty("name", stream.getName());
        obj.addProperty("streamerName", getStreamerNamebyId(stream.getStreamerId()));
        obj.addProperty("noOfListenings", Long.toString(stream.getNoOfStreams()));
        obj.addProperty("length", stream.convertLength());
        obj.addProperty("dateAdded", stream.convertDate());

        arr.add(obj);
    }

    public Stream deleteStream(Integer id) {
        for(Stream s : streams){
            if(s.getId().equals(s)){
                streams.remove(s);
                return s;
            }
        }
        return null;
    }
}
