package command;

import models.*;
import spotify.Spotify;

public class ListenCommand implements Command{
    Integer idUser;
    Integer idStream;
    public ListenCommand (Integer idUser, Integer idStream){
        this.idUser = idUser;
        this.idStream = idStream;
    }
    @Override
    public void execute(){
        Spotify spotify = Spotify.Instance();
        for(User user : spotify.getUsers())
            if(user.getId().equals(idUser)){
                user.getStreamList().add(idStream);
                break;
            }
        for(Stream stream : spotify.getStreams())
            if(stream.getId().equals(idStream)){
                stream.setNoOfStreams(stream.getNoOfStreams()+1);
                break;
            }
    }
    public void undo(){;}
}
