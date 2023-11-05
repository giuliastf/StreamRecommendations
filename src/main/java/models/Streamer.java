package models;

public class Streamer {
    private Integer streamerType;
    private Integer id;
    private String name;

    public Streamer(int StreamerType, int id, String name)
    {
        this.streamerType = StreamerType;
        this.id = id;
        this.name = name;
    }

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toString() {
        String s = "models.Streamer{" + ", streamerType=" + streamerType + ", id=" + id +", name='" + name +'\'' + '}';
        return s;
    }
}
