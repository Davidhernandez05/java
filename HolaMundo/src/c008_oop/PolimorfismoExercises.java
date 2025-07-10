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
import c008_oop.PolimorfismoExe.E06.EmailNotification;
import c008_oop.PolimorfismoExe.E06.SMSNotification;
import c008_oop.PolimorfismoExe.E07.Horse;
import c008_oop.PolimorfismoExe.E08.Converter;
import c008_oop.PolimorfismoExe.E09.Book;
import c008_oop.PolimorfismoExe.E09.Electronic;
import c008_oop.PolimorfismoExe.E09.Product;
import c008_oop.PolimorfismoExe.E10.Archer;
import c008_oop.PolimorfismoExe.E10.Character;
import c008_oop.PolimorfismoExe.E10.Mage;
import c008_oop.PolimorfismoExe.E10.Warrior;

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
    var mensajeEmail = new EmailNotification();
    mensajeEmail.sendNotification("david@gmail.com");
    var mensajeSMS = new SMSNotification();
    mensajeSMS.sendNotification(312091310);

    // 7. Crea una función showAnimalType(Animal animal) que imprima el tipo de animal. Pasa diferentes subclases (Dog, Cat, Horse) para que cada una imprima su tipo con su propio getType() sobrescrito.
    var cat = new c008_oop.PolimorfismoExe.E07.Cat();
    var dog = new c008_oop.PolimorfismoExe.E07.Dog();
    var horse = new Horse();

    cat.showAnimalType("Felino");
    dog.showAnimalType("Canino");
    horse.showAnimalType("Équinos");

    // 8. Crea una clase Converter con métodos convert(int), convert(double), y convert(String) que devuelvan diferentes formatos de texto.
    var aInt = new Converter();
    var aDouble = new Converter();
    var aString = new Converter();

    System.out.println(aInt.convert(3.14));
    System.out.println(aDouble.convert("3.19"));
    System.out.println(aString.convert(12));


    // 9. Crea una clase Product con el método getPrice(). Luego, Book y Electronic deben sobrescribirlo con su propia lógica de descuento. Recorre una lista de Product e imprime el precio final de cada uno.
    var productList = new ArrayList<Product>();
    productList.add(new Book(100, "Después"));
    productList.add(new Book(90, "Aquelarre"));
    productList.add(new Electronic(1000, "Nevera"));
    productList.add(new Electronic(900, "Lavadora"));

    for (Product producto : productList) {
      System.out.println("Precio Final: " + producto.getPrice(20));
    }
    // 10. Crea una clase Character con método attack(). Luego crea subclases Warrior, Archer, Mage con ataques diferentes. En main, crea un array de Character y llama a attack() para cada uno.
    var attackList = new ArrayList<Character>();
    attackList.add(new Warrior());
    attackList.add(new Mage());
    attackList.add(new Archer());
    attackList.add(new Mage());

    for (Character ataque : attackList) {
      ataque.attack();
    }
  }
}
