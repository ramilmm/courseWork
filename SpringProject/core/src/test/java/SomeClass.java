public class SomeClass {

    public static void main(String[] args) {
        String authors = "Александр Грин;Александр Куприн;";
        String country = "Германия;Россия;";
        String minCost = "232";
        String maxCost = "350";

        String[] author = authors.split(";");
        String[] countr = country.split(";");
        Integer max = Integer.parseInt(maxCost);
        Integer min = Integer.parseInt(minCost);

        for (int i = 0; i < author.length; i++) {
            System.out.println(author[i]);
        }
        for (int i = 0; i < countr.length; i++) {
            System.out.println(countr[i]);
        }
        System.out.println(max);
        System.out.println(min);
    }


}
