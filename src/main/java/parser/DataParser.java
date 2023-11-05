package parser;
import spotify.*;
/*STRATEGY = dp care imi defineste familia de alg DataParser => mai multe pt fiecare tip de data*/
public interface DataParser {
    void parse(Spotify spotify, String[] args);
}