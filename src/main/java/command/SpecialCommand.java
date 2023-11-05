package command;

import com.google.gson.JsonArray;
import models.Stream;
import models.User;
import spotify.Spotify;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SpecialCommand
{
    Integer idUser;
    String type;
    public SpecialCommand(Integer id, String type) {
        this.idUser = id;
        this.type = type;
    }
    public void specialExec(int command) {
        int k = 0;
        Spotify spotify = Spotify.Instance();
        Collections.sort(spotify.getStreams(), new CompareSurprise()); //am sortat streamerii
        Integer t = 0;
        if (type.equals("SONG"))
            t = 1;
        else if (type.equals("PODCAST"))
            t = 2;
        else if (type.equals("AUDIOBOOK"))
            t = 3;
        int max;
        Set<Integer> listened = new HashSet<>(); // set ce contine id-urile streamerilor ascultati
        for (User user : spotify.getUsers())
            if (user.getId().equals(idUser)) {
                JsonArray arr = new JsonArray();
                for (Integer streamId : user.getStreamList()) {//ss fie alta melodie
                    for (Stream stream : spotify.getStreams()) // parcurg toate stream urile
                        if (stream.getId().equals(streamId)) {
                            listened.add(stream.getStreamerId());
                        }
                }
                for (Stream stream : spotify.getStreams()) {// acelasi streamer, type, cantec diferit
                    if (command == 0) {
                        max = 3;
                        if (listened.contains(stream.getStreamerId()) == false && stream.getStreamType().equals(t) == true) {
                            spotify.ListStreams(stream, arr);
                            k++;
                            if (k == max)
                                break;
                        }
                    } else if (command == 1) {
                        max = 5;
                        if (listened.contains(stream.getStreamerId()) == true &&
                                stream.getStreamType().equals(t) == true &&
                                user.getStreamList().contains(stream.getId()) == false) {
                            spotify.ListStreams(stream, arr);
                            k++;
                            if (k == max)
                                break;
                        }
                    }
                }
                System.out.println(arr);
            }
    }
}
