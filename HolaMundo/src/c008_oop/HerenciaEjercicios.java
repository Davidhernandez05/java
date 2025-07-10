package c008_oop;

import c008_oop.InheritanceExercises.*;

import java.util.ArrayList;

public class HerenciaEjercicios {
  public static void main(String[] args) {

    // 1. Crea una clase Vehicle con un método move(). Luego crea una subclase Car que herede de Vehicle y agrega el método honk().
    var carro1 = new Car();
    carro1.move();
    carro1.honk();

    // 2. Define una clase Person con los atributos name y age. Luego crea una clase Student que agregue el atributo grade y un método study().
    var estudiante1 = new Student("David", 15, 10);
    estudiante1.study();

    // 3. Crea una clase Animal con el método makeSound(). Haz que Dog diga “Woof” y Cat diga “Meow” sobrescribiendo ese método.
    var perro1 = new Dog();
    var gato1 = new Cat();
    perro1.makeSound();
    gato1.makeSound();

    // 4. La clase Employee tiene los atributos name y salary. Manager hereda de Employee y agrega el atributo department.
    var empleado1 = new Manager("David", 1000, "Desarrollo");
    empleado1.data();

    // 5. Crea una clase abstracta Shape con un método calculateArea(). Luego implementa ese método en Circle y Rectangle.
    var circulo = new Circle();
    circulo.calcularArea();
    var rectangle = new Rectangle();
    rectangle.calcularArea();

    // 6. Crea una clase Bird con el método fly(). Luego crea Eagle que sobrescriba fly() pero también llame al método original con super.fly().
    var eagle = new Eagle();
    eagle.fly();

    // 7. Haz una clase Device con un constructor que imprima “Device created”. Luego crea Phone que herede de Device y en su constructor imprima “Phone ready”.
    var phone = new Phone();

    // 8. Account tiene un saldo y métodos para deposit() y withdraw(). SavingsAccount hereda y agrega un método addInterest().
    var cuenta = new SavingsAccount(1000);
    cuenta.withdraw(100);
    System.out.println(cuenta.getBalance());
    cuenta.addInterest();

    // 9. Crea una clase Vehicle y tres subclases: Car, Bike y Truck, cada una con un método describe() sobrescrito.
    var car = new Auto();
    var bike = new Bike();
    var truck = new Truck();
    car.describe();
    bike.describe();
    truck.describe();

    // 10. Crea un ArrayList<Animal> que contenga instancias de Dog, Cat y Bird. Recorre la lista y llama a makeSound().
    var listaAnimales = new ArrayList<Animal>();
    listaAnimales.add(new Dog());
    listaAnimales.add(new Cat());
    listaAnimales.add(new Bird());

    for (Animal animal : listaAnimales) {
      animal.makeSound();
    }

  }
}
