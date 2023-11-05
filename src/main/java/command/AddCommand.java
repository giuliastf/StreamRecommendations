package command;

import models.Stream;
import spotify.Spotify;

public class AddCommand implements Command{
    Integer idStreamer;
    String line;
    private Stream s;
    public AddCommand (Integer id, String line){
        this.idStreamer = id;
        this.line = line;
    }
    @Override
    public void execute(){
        String[] data = line.split(" ",7);
        Integer type = Integer.parseInt(data[2]);
        Integer idStream = Integer.parseInt(data[3]);
        Integer streamGenre = Integer.parseInt(data[4]);
        Long length = Long.parseLong(data[5]);
        String name = data[6];
        Long dateAdded = System.currentTimeMillis() / 1000;
        Stream stream = new Stream(type, idStream, streamGenre, 0L, idStreamer, length,dateAdded ,name);
        Spotify spotify = Spotify.Instance();
        spotify.addStream(stream);

        this.s = stream;
    }

    public void undo(){
        Spotify spotify = Spotify.Instance();
        spotify.getStreams().remove(s);
    }
}
