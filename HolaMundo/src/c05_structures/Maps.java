package c05_structures;

import java.util.HashMap;

public class Maps {
  public static void main(String[] args) {

    //declaración y Creación:
    HashMap<String, String> names = new HashMap<>();
    var age = new HashMap<String, Integer>();

    //Agregar elementos al MAP:
    names.put("David", "Hernandez");
    names.put("Brais", "MoureDev");
    names.put("Moure", "MoureDev");
    age.put("David", 28);
    age.put("Miguel", 32);
    age.put("alejandra", 40);

    //Tamaño:
    System.out.println(names.size());
    System.out.println(age.size());
    System.out.println(names);

    //Buscar Elementos:
    System.out.println(names.get("David"));

    //Verificar si exite un elemento:
    System.out.println(names.containsKey("David"));
    System.out.println(names.containsKey("Juan"));
    System.out.println(names.containsValue("Hernandez"));


    //Actualizar un valor:
    names.replace("Moure", "Moure@gmail.com");
    System.out.println(names.get("Moure"));

    //Eliminar un valor:
    names.remove("Brais");
    System.out.println(names);

    //Limpiar o eliminar todos los datos:
    System.out.println(age);
    age.clear();
    System.out.println(age);

    //Insertar un valor solamente si no existe:
    age.putIfAbsent("Juliana", 22);
    age.putIfAbsent("Juliana", 28);
    age.putIfAbsent("Marco", 28);
    System.out.println(age);

    //Otras Operaciones:
    System.out.println(age.isEmpty()); //valida si el MAP esta vacío.
    var values = age.values(); //Nos trae todos los valores sin las claves, los retorna como un arraylist.
    System.out.println(age.values());
  }
}
