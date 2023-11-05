package command;

import models.Stream;

import java.util.Comparator;

public class CompareRecommend implements Comparator<Stream> {
    public int compare(Stream s1, Stream s2)
    {
        return -s1.getNoOfStreams().compareTo(s2.getNoOfStreams());
    }
}