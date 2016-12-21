package caracter;
public class Caracter {

    public static void main(String[] args) {
        String Str1;
        Str1="Hola batos";
        System.out.println("Cadena: "+ Str1);
        System.out.println("Longitud de la cadena: "+Str1.length());
        int a=5;
        
        System.out.println("Caracter en la pocicion "+a+": "+Str1.charAt(a));
        
        char  Chr [] = new char[a];
        Str1.getChars(0, a, Chr,0);
        System.out.print("Cadena de 0 a "+a+" : ");
        for(int i=0;i<a;i++){  System.out.print(Chr[i]);}
        
        String Str2 = "HOLA BATOS";
        System.out.println("\nSon iguales "+Str1+" y "+Str2+"?: "+Str1.equals(Str2));
        
        System.out.println("\nSon iguales ignoreCase "+Str1+" y "+Str2+"?: "+Str1.equalsIgnoreCase(Str2));
        
        String Str3="Hola batos";
        System.out.println("\nTienen la misma longitud "+Str1+" y "+Str2+"?: "+Str1.compareTo(Str2));
        System.out.println("\nTienen la misma longitud "+Str1+" y "+Str3+"?: "+Str1.compareTo(Str3));
          
        System.out.println("\nComparar "+Str1+" y "+Str3+"?: "+Str1.regionMatches(0, Str3, 0, a));
        
        System.out.println("\nComparar "+Str1+" y "+Str3+"?: "+Str1.regionMatches(true, 0, Str3, 0, a));
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
