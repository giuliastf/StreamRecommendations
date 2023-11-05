package models;

import java.text.SimpleDateFormat;
import java.util.*;

public class Stream {
    private Integer streamType;  // private
    private Integer id;
    private Integer streamGenre;
    private Long noOfStreams;
    private Integer streamerId;
    private Long length;
    private Long dateAdded;
    private String name;
    public Stream(Integer type, Integer id, Integer streamGenre, Long noOfStreams, Integer streamerId, Long length, Long dateAdded, String name)
    {
        this.streamType = type;
        this.id = id;
        this.streamGenre = streamGenre;
        this.noOfStreams = noOfStreams;
        this.streamerId = streamerId;
        this.length = length;
        this.dateAdded = dateAdded;
        this.name = name;
    }

    public Integer getStreamType(){
        return streamType;
    }
    public Integer getId(){
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setNoOfStreams(long l) {
        this.noOfStreams = l;
    }
    public Integer getStreamerId(){
        return streamerId;
    }
    public Long getNoOfStreams() {
        return noOfStreams;
    }
    public Long getLength() {
        return length;
    }
    public Long getDateAdded() {
        return dateAdded;
    }
    public String getName() {
        return name;
    }
    public String convertLength(){
        long h = length / 3600;
        long m = (length % 3600) / 60;
        long s = length % 60;

        if(h == 0)
            return String.format("%02d:%02d", m, s);
        else return String.format("%02d:%02d:%02d", h, m, s);
    }
    public String convertDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String date =  sdf.format(new Date(dateAdded * 1000)); //trb in milisec
        return date;
    }
}
