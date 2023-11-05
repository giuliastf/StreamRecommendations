package command;

import models.Stream;

import java.util.Comparator;

public class CompareSurprise implements Comparator<Stream>{
    public int compare(Stream s1, Stream s2)
    {
        int ret = -s1.getDateAdded().compareTo(s2.getDateAdded());
        if(ret == 0)
            ret = -s1.getNoOfStreams().compareTo(s2.getNoOfStreams());
        return ret;
    }

}
