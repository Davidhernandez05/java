package c008_oop;


import c008_oop.Exercisses.*;
import c008_oop.Exercisses.Person;

import java.util.ArrayList;

public class ClassesExercises {
  public static void main(String[] args) {
    // 1. Crea una clase Book con atributos title y author. Crea un objeto y muestra sus datos.
    var book1 = new Book("Aquelarre", "Mario Mendoza");
    book1.dataBook();

    // 2. Crea una clase Dog con un método bark() que imprima su sonido.
    var perro = new Dog();
    perro.nombre = "Onix";
    perro.bark();

    // 3. Añade un constructor a la clase Book que reciba title y author.
    var book2 = new Book("Stephen King", "IT");
    book2.dataBook();

    // 4. Crea una clase Car con atributos brand y model y un método showData().
    var carro = new Car("Porsche", "911");
    carro.showData();

    // 5. Crea una clase Student con atributo score y un método que diga si aprobó (mayor o igual a 60).
    var student1 = new Student("David", 90);
    var student2 = new Student("Mario", 59);
    System.out.println(student1.approve());
    System.out.println(student2.approve());

    // 6. Crea una clase BankAccount con atributo balance y un método deposit() que sume el saldo.
    var cuenta = new BankAccount(200);
    cuenta.deposit();
    cuenta.balance = 500;
    cuenta.deposit();

    // 7. Crea una clase Rectangle con métodos para calcular el área y el perímetro.
    var rectangle1 = new Rectangle(22, 22);
    rectangle1.area();
    rectangle1.perimetro();

    // 8. Crea una clase Worker que reciba nombre y salario, y un método para mostrar su salario.
    var empleado1 = new Worker("Brais", 100);
    empleado1.bono = 200.44;
    empleado1.showSalary();

    // 9. Crea varios objetos Person y guárdalos en un ArrayList.
    var listName = new ArrayList<String>();
    var persona1 = new Person("David", 28);
    var persona2 = new Person("Ricardo", 28);
    var persona3 = new Person("Miguel", 28);
    var persona4 = new Person("Alejandra", 28);
    var persona5 = new Person("Betsy", 28);
    listName.add(persona1.nombre());
    listName.add(persona2.nombre());
    listName.add(persona3.nombre());
    listName.add(persona4.nombre());
    listName.add(persona5.nombre());

    System.out.println(listName);

    // 10. Crea una clase Product y un método que aplique un descuento sobre su precio.
    var computador = new Product("Computador", 2000000);
    computador.finalPrice(20);
  }
}
