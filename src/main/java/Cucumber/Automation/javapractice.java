package Cucumber.Automation;


public class javapractice {

    public static void main(String[] args) {
        //Reverse a word
        String str="abba";
        String reverse="";
        char ch;
        for(int i=0;i<str.length();i++){
            ch=str.charAt(i);
            reverse=ch + reverse;
        }
        System.out.println("AFter reversing the string is: "+reverse);
        if(str.equals(reverse)){
            System.out.println("Given String is the palindrom");
        }else{
            System.out.println("Given String is the not a Palindrom");
        }

        //Another approach
        char[] chs =str.toCharArray();
        for(int i=str.length()-1;i>=0;i--){
            System.out.print(chs[i]);
        }
        //Reversing the string using the string build
        StringBuilder sb = new StringBuilder(str);
        System.out.println();
        System.out.println(sb.reverse());

        //Fibiinoic series
        int a=0, b=1, c,n = 8;

        if(n==0)
            System.out.println(a);
        for (int i=2; i<=n;i++){
            c=a+b;
            a=b;
            b=c;
            System.out.print(b+" ");
        }
        System.out.println("Fibonic of "+n+" is "+b);

        //Reversing of the each word of the string is
        String data= "Ramana Rao Reddy Shyam Radha";
        String[] words=data.split(" ");
        String strrevers="";
        for(int i=0; i<words.length;i++){
            String word=words[i];
            String strrev="";
            System.out.println(word);
            for(int j=word.length()-1;j>=0;j--){
                char starch=word.charAt(j);
                strrev=strrev+starch;
            }
            strrevers=strrevers+strrev+" ";
        }
        System.out.println(strrevers);
    }
}
