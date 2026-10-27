# icc-practica03

### Ejercicio 01 Referencias e inmutabilidad de String

- a==b imprime false por el new, referencia un nuevo objeto
- a==c imprime true porque son iguales, la creación de un objeto se realiza despues de resolver las operaciones
- a==d imprime false porque al iniciar el objeto empieza con Ja lo que crea un objeto diferente a Java y aun cuando se convierte en Java, la optimización de memoria solo se realiza en la creación de las variables por lo que el objeto no cambia 
- a.equals(d) imprime true, los objetos son diferentes pero el contedido del objeto es el mismo

System.out.println(a); // imprime Java
System.out.println(b); // imprime Java 21

como a y b eran objetos diferentes, modificar un objeto no afecta al otro

```text
    False
    True
    False
    True
    Java
    Java 21
```

### Ejercicio 02 Operaciones e índices en StringBuilder

sb.delete(1, 4); // elimina los caracteres de 1 a antes del 4 
sb.insert(1, "xyz"); // incerta xyz en la posición 1 AxyzE
sb.reverse(); // voltea la cadena 
sb.replace(1, 4, "-"); // reemplaza los caracteres del 1 a antes del 4 con un -
System.out.println(sb.length()); // imprime el tamaño de la cadena
System.out.println(sb.capacity()); // imprime el tamaño del StringBuilder 


```Text
    AE
    AxyzE
    EzyxA
    E-A
    3
    21
```

### 03 Referencias compartidas

StringBuilder a = new StringBuilder("Hola"); // crea un StringBuilder
StringBuilder b = a; // crea una referencia nueva al objeto a
StringBuilder c = new StringBuilder("Hola"); // crea un StringBuilder
a.append(" mundo"); // a;ade al final la palabra mundo
b.delete(0, 5); // elimina de la pos 0 a la 4 por lo que el StringBuilder tiene un espacio al inicio, esto afecta a a dado que son el mismo objeto
System.out.println(a);// imprime a
System.out.println(b);// imprime a dado que b es referencia de a
System.out.println(c);// imprime b
System.out.println(a == b);//evalua si la referencia de a es la misma de b cosa que si
System.out.println(a.equals(b));// evalua si el objeto que referencia a es igual al obeto que referencia b, como b y a son iguales entonces es true
System.out.println(a.equals(c));// por las modificaciones anteriores c es Hola mientras que a es mundo, asi que es false 

```Text
    mundo
    mundo
    Hola
    true
    true
    false
```

### 10 Editor de texto: clases y visibilidad

1. ¿Por qué los atributos del editor deben ser privados? para evitar modificaciones por otros objetos 

2. ¿Qué diferencia hay entre un método public y uno private? los metodos publicos se tiene acceso por cualquier clase, los privados solo se obtiene acceso por los metodos de la misma clase 

3. Si quitas public de un método, ¿qué acceso tiene y puede llamarlo PruebaEditor desde el mismo paquete? se convierte en "defaul", donde cualquier metodos del mismo paquete puede verlo y modificarlo 

4. ¿En qué se diferencia el acceso de paquete de protected? defauld solo permite acceso a metodos de las clases dentro del mismo paquete, mientras que protected tiene el adicional que puede otrogar el acceso desde otros paquetes siempre que esten emparentados con una clase del paquete que contiene el protected