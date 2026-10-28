public class Ejercicios {
    public static void main(String[] args) {
        
        // Ejercicio1();
        // Ejercicio2();
        Ejercicio3();
    //     System.out.println(Ejercicio4(""));
    //     System.out.println(Ejercicio5("!aníta láva la tiná?"));   
    //     System.out.println(Ejercicio6("programacion"));
    //     System.out.println(Ejercicio7("java es genial","java","haskell"));
    //     System.out.println(Ejercicio8("hola y adios"));
    //     System.out.println(Ejercicio9("(a+[(b)-[c]]))"));

    //     EditorTexto Ed = new EditorTexto();
    //     Ed.escribir("Hola mundo");
    //     Ed.insertar(5, "gran ");
    //     Ed.eliminar(0, 5);
    //     System.out.println(Ed.obtenerTexto()); // gran mundo
    //     Ed.deshacer();
    //     System.out.println(Ed.obtenerTexto()); // Hola gran mundo
    }

    // Referencias e inmutabilidad de String
    public static void Ejercicio1(){
        String a = "Java";
        String b = new String("Java");
        String c = "Ja" + "va";
        String d = "Ja";
        d += "va";
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);
        System.out.println(a.equals(d));
        b = b.concat(" 21");
        System.out.println(a);
        System.out.println(b);
    }

    // Operaciones e índices en StringBuilder
    public static void Ejercicio2(){
        StringBuilder sb = new StringBuilder("ABCDE");
        sb.delete(1, 4);
        sb.insert(1, "xyz");
        sb.reverse();
        sb.replace(1, 4, "-");
        System.out.println(sb);
        System.out.println(sb.length());
        System.out.println(sb.capacity());
    }

    // Referencias compartidas
    public static void Ejercicio3(){
        StringBuilder a = new StringBuilder("Hola");
        StringBuilder b = a;
        StringBuilder c = new StringBuilder("Hola");
        a.append(" mundo");
        b.delete(0, 5);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
    }

    // Compresión de caracteres consecutivos
    public static String Ejercicio4(String texto){
        if (texto.isEmpty()) return "";
        String comprimido = new String("");
        char caracter=texto.charAt(0);
        for (int i=0, j=0; i<=texto.length();i++){
            if(i<texto.length() && caracter==texto.charAt(i)) continue;
            comprimido = comprimido + texto.charAt(i-1)+(i-j);
            if (i<texto.length()){
                caracter = texto.charAt(i);
                j=i;
            }
        }
        return comprimido;
    }

    // Palíndromos ignorando el formato
    // solo funciona si partimos que no hay 2 caracteres del string "ignorar" continuos, aunque se solucionaria con un segundo ciclo anidado
    public static boolean Ejercicio5(String texto){
        StringBuilder sb = new StringBuilder(texto.toLowerCase()); 
        String a = "áéíóú";
        String b = "aeiou";
        String ignorar = "¡!@#$%^&*()_+=-[]\\{}|;':\",./<>¿? ";
        for (int i=0,j=sb.length()-1; i<=j; i++,j--){
            // salta caracteres especiales
            if(ignorar.indexOf(sb.charAt(i))!=-1)i++;
            if(ignorar.indexOf(sb.charAt(j))!=-1)j--;
            // cambia los acentos por una vocal sin acento
            if(a.indexOf(sb.charAt(i))!=-1) sb.setCharAt(i, b.charAt(a.indexOf(sb.charAt(i))));
            if(a.indexOf(sb.charAt(j))!=-1) sb.setCharAt(j, b.charAt(a.indexOf(sb.charAt(j))));
            // si se cumple no es palindromo
            if(sb.charAt(i)!=sb.charAt(j))return false;
        }
        return true;
    }

    /*

    Eliminar caracteres duplicados
    
    Trate de hacerlo con 1 ciclo pero no pude
    lo hace bien en caracteres duplicados continuos como "aaaabbbbc" 
    pero no funciona si los caracteres duplicados no son continuos

    public static String Ejercicio6(String texto) {
        StringBuilder sb=new StringBuilder(texto);
        int i=0;
        char ca=sb.charAt(0);
        while (i<sb.length()-1){
            if (ca==sb.charAt(++i)) {
                sb.deleteCharAt(i--);
                i--;
            }
            else ca=sb.charAt(i);
        }
        return sb.toString();
    }

    */

    // Eliminar caracteres duplicados este no
    public static String Ejercicio6(String texto){
        if (texto==""||texto.isEmpty())return "";
        StringBuilder sb = new StringBuilder(texto);
        for(int i=0;i<sb.length()-1;i++){
            char c=sb.charAt(i);
            for (int j=i+1;j<sb.length()-1;j++){
                if(c==sb.charAt(j))sb.deleteCharAt(j--);
            }
        }
        return sb.toString();
    }

    // Reemplazo manual de subcadenas
    public static String Ejercicio7(String texto, String buscar, String reemplazo){
        if (buscar.equals(reemplazo)||buscar.isEmpty()||reemplazo.isEmpty())return texto;
        StringBuilder sb = new StringBuilder(texto);
        boolean f=false; // bandera que indica si hubo una insercion 
        // for para recorrer el arreglo
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i)!=buscar.charAt(0))continue;
            // for para buscar la palabra buscar en el texto e inserta reemplazo donde inicia la palabra buscar
            for(int auxi=i+1, b=1; auxi<=sb.length(); auxi++,b++){
                if(b==buscar.length()){
                    sb.insert(i, reemplazo);
                    f=true;
                    break;
                }
                if(buscar.charAt(b)!=sb.charAt(auxi)) break;
            }

            /*
            i se posiciona en el inicio de la palabra busqueda despues de insertar reemplazo
            se elimina buscar y i se recorre un numero a la izquierda para empezar el nuevo ciclo al final de la cadena reemplazar
            solo se ingresa si se reemplazo la palabra, se reinicia la bandera en caso de que vuelva a existir otro reemplazo 
            */  
            if(f){
                i=i+reemplazo.length();
                sb.delete(i,i+buscar.length());
                i--;
                f=false;
            }
        }
        return sb.toString();
    }

    // Invertir el orden de las palabras
    static public String Ejercicio8(String texto){
        StringBuilder sb = new StringBuilder(texto);
        String izquierda = new  String("");
        String derecha = new String("");
        boolean f=true; // bandera que indicara si se hizo algun reemplazo o eliminacion
        /*
        for 
        */
            for(int i=0; f && i<=sb.length(); i++){
                if(sb.charAt(i)==' ') {
                    izquierda = izquierda + sb.substring(0, i);
                    sb.delete(0, i);
                    f=false;
                }
            }
            f=true;
            for(int d=sb.length()-1; f && 0<=d; d--){
                if(sb.charAt(d)==' ') {
                    derecha = derecha + sb.substring(++d, sb.length());
                    sb.delete(d, sb.length());
                    f=false;
                }
            }
        if(izquierda == "" || derecha == "") return texto;
        sb.insert(0,derecha);
        sb.insert(sb.length(),izquierda);
        return sb.toString();
    }

    // Validar delimitadores
    public static boolean Ejercicio9(String expresion){
        StringBuilder pila = new StringBuilder();
        pila.ensureCapacity(expresion.length());
        // String a = "{[(";
        // String b = "}])";
        String c = "{[()]}";
        
        for(int i=0, j=0; i<expresion.length(); i++){
            // crear la pila
            if(c.indexOf(expresion.charAt(i))!=-1) pila.insert(j++, expresion.charAt(i));
            /* 
            valida si la ultima entrada de la pila puede ser cerrada con la antepenultima entrada de la pila 
            en caso de que no regresa el falso
            la idea de comprobar que la entrada sea equivalente a la salida salio de la suma de gauss
            donde la suma del ultimo termino y primer termino = que sumar el penultimo y segundo = .... 
            viendo Stirng c
            {=0
            [=1             {+}=0+5=5
            (=2             [+]=1+4=5
            )=3             (+)=2+3=5    
            ]=4             asi, solo evaluamos el caracter pasado y actual donde 
            }=5             la suma debe ser 5, al final la pila no vale 0, el arreglo esta mal

            Se podria hacer esto atras al momento de crear la pila, pero dado que no tengo tiempo
            porque estoy entregando esta tarea tarde, voy a hacerlo de forma mas "tosca"
            */ 
            // se agrega una condicional para evitar casos como }{ y los de por validos
            if (j>=2 && c.indexOf(pila.charAt(j-2)) + c.indexOf(pila.charAt(j-1)) == 5 && c.indexOf(pila.charAt(j-1)) < 3) { 
                pila.delete(j - 2, j); 
                j -= 2;
            }
        }
        return pila.length()==0;
    }

}

