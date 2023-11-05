package command;

import models.Stream;
import models.Streamer;
import spotify.Spotify;

public class DeleteCommand implements Command{
    Integer id;
    Integer idStream;
    private Stream s;
    public DeleteCommand (Integer id, Integer idStream){
        this.id = id;
        this.idStream = idStream;
    }
    public void execute(){
        Spotify spotify = Spotify.Instance();
        s = spotify.deleteStream(id);
    }
    public void undo(){
        Spotify spotify = Spotify.Instance();
        spotify.getStreams().add(s);
    }
}
