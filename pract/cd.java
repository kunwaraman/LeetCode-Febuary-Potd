package pract;

public class cd extends demo1{

    public cd(int id, String name) {
        super(id, name);
    }
    public static void main(String[] args) {
        cd c1 = new cd(1,"abc");
        System.out.println(c1.id);
        System.out.println(c1.name);
    }
}
