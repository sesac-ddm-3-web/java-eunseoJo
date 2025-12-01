package ch12.sec05;

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder data = new StringBuilder()
                .append("DEF")
                .insert(0, "ABC")
                .delete(3, 4);

        System.out.println(data.toString());
        System.out.println(data);
    }
}