public class Test {
    public static void main(String[] args) {
        String a = "saadje><sda";
        int s = a.indexOf("<");
        System.out.println(s);
        String c = a.substring(s);
        System.out.println(c);
    }
}
