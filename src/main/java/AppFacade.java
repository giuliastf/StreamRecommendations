import parser.*;
import spotify.Spotify;
/* FACADE = ascunde o implementare complexa (toata parsarea) */
class AppFacade {
    void parseData(String[] args, Spotify spotify) {
        for (String fileType : args) {
            DataParser parser = null;
            if (fileType.endsWith("streamers.csv")) {
                parser = new StreamerParser();
            } else if (fileType.endsWith("streams.csv")) {
                parser = new StreamParser();
            } else if (fileType.endsWith("users.csv")) {
                parser = new UserParser();
            }else if (fileType.endsWith("commands.txt")) {
                parser = new CommandParser();
            }

            if (parser != null) {
                parser.parse(spotify, args);
            }
        }
    }
}
