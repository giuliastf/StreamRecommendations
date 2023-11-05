import spotify.Spotify;

public class ProiectPOO {
    public static void main(String[] args) {
        if (args == null) {
            System.out.println("Nothing to read here");
        } else {
            Spotify.reset();
            Spotify spotify = Spotify.Instance();
            AppFacade facade = new AppFacade();
            facade.parseData(args, spotify);
        }
    }
}