package Compareto;
public class Main {
    public static void main(String[] args){
        String str1 = "You've";
        String str2 = "your";
        System.out.println("String1 : "+str1+",\tString2 : "+str2);
        System.out.println("Comparing two equal strings, one in Upper case and another in Lower case: "+str1.compareToIgnoreCase(str2));
    }
}