package c008_oop;

import c008_oop.PolimorfismoExe.E01.Animal;
import c008_oop.PolimorfismoExe.E01.Cat;
import c008_oop.PolimorfismoExe.E01.Cow;
import c008_oop.PolimorfismoExe.E01.Dog;
import c008_oop.PolimorfismoExe.E02.Circule;
import c008_oop.PolimorfismoExe.E02.Rectangle;
import c008_oop.PolimorfismoExe.E02.Shape;
import c008_oop.PolimorfismoExe.E03.Printer;
import c008_oop.PolimorfismoExe.E04.Greeter;
import c008_oop.PolimorfismoExe.E05.Bike;
import c008_oop.PolimorfismoExe.E05.Car;
import c008_oop.PolimorfismoExe.E05.Truck;
import c008_oop.PolimorfismoExe.E05.Vehicule;

import java.util.ArrayList;

public class PolimorfismoExercises {
  public static void main(String[] args) {
    // 1. Crea una clase Animal con el método makeSound(). Luego crea subclases Dog, Cat y Cow que sobrescriban ese método con sonidos diferentes. Llama al método desde una lista de Animal.
    var listAnimals = new ArrayList<Animal>();
    //listAnimals.add(new Cat("Suzie"));
    listAnimals.add(new Cat("Jack"));
    listAnimals.add(new Cat("Max"));
    listAnimals.add(new Dog("Onix"));
    //listAnimals.add(new Dog("Samy"));
    listAnimals.add(new Cow("Pepita"));


    for (Animal animal : listAnimals){
      animal.makeSound();
    }
    // 2. Crea una clase Shape con el método calculateArea(). Luego implementa subclases Circle y Rectangle con sus propias fórmulas. Usa una lista de Shape para recorrer e imprimir el área de varias figuras.
    var listShape = new ArrayList<Shape>();
    //listShape.add(new Circule(2));
    listShape.add(new Circule(3));
    //listShape.add(new Rectangle(2, 2));
    listShape.add(new Rectangle(10, 10));

    for (Shape figura : listShape){
      figura.calculateArea();
    }

    // 3. Crea una clase Printer con varios métodos print() sobrecargados que acepten diferentes tipos de parámetros (String, int, double). Llama a cada uno desde main.
    var imprimir = new Printer();
    imprimir.print("David");
    imprimir.print(22);
    imprimir.print(1.75);
    imprimir.print("David", 28);

    // 4. Crea una clase Greeter con dos métodos greet(): uno que salude con “Hello”, y otro que reciba un nombre y salude con “Hello, [nombre]”.
    var saludar = new Greeter();
    saludar.greet();
    saludar.greet("Alejandra");

    // 5. Crea una clase Vehicle con un método start(). Luego crea Car, Bike y Truck que sobrescriban ese método. Recorre una lista ArrayList<Vehicle> para llamar a start() en cada uno.
    var vehiculeList = new ArrayList<Vehicule>();
    vehiculeList.add(new Bike());
    vehiculeList.add(new Car());
    vehiculeList.add(new Truck());
    vehiculeList.add(new Bike());
    vehiculeList.add(new Truck());
    vehiculeList.add(new Car());

    for (Vehicule vehiculo : vehiculeList) {
      vehiculo.start();
    }

    // 6. Crea una clase Notification con método send(), y subclases EmailNotification, SMSNotification. Luego crea una función sendNotification(Notification n) que reciba cualquier tipo y lo ejecute.

    // 7. Crea una función showAnimalType(Animal animal) que imprima el tipo de animal. Pasa diferentes subclases (Dog, Cat, Horse) para que cada una imprima su tipo con su propio getType() sobrescrito.

    // 8. Crea una clase Converter con métodos convert(int), convert(double), y convert(String) que devuelvan diferentes formatos de texto.

    // 9. Crea una clase Product con el método getPrice(). Luego, Book y Electronic deben sobrescribirlo con su propia lógica de descuento. Recorre una lista de Product e imprime el precio final de cada uno.

    // 10. Crea una clase Character con método attack(). Luego crea subclases Warrior, Archer, Mage con ataques diferentes. En main, crea un array de Character y llama a attack() para cada uno.
  }
}
