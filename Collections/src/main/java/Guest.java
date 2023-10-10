import java.util.ArrayList;
import java.util.List;

public class Guest {
    private String fname;
    private String lname;
    private boolean vip;
    private List<Room> preferredRoom=new ArrayList<>();

    public Guest(String fname, String lname,boolean vip){
        this.fname=fname;
        this.lname=lname;
        this.vip=vip;
    }
    

    /**
     * @return String return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return String return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return boolean return the vip
     */
    public boolean isVip() {
        return vip;
    }

    /**
     * @param vip the vip to set
     */
    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public static void print(List<Guest> list){
        System.out.format("%n--Guest List Contents--%n");
        
    }

}
