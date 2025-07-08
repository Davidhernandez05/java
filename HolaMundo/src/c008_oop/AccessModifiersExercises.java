package c008_oop;

import c008_oop.AccessExercises.*;
import c008_oop.AccessExercises.Person;

public class AccessModifiersExercises {
  public static void main(String[] args) {
    // 1. Crea una clase Person con atributos privados name y age. Usa los métodos getName(), setName(), getAge() y setAge() para asignar y mostrar valores desde otra clase.
    var persona = new Person("David", 22);
    System.out.println(persona.getAge());
    persona.setAge(28);
    System.out.println(persona.getAge());

    System.out.println(persona.getName());
    persona.setName("Juan");
    System.out.println(persona.getName());

    // 2. Crea una clase Product con el atributo privado price. Añade el método setPrice(double price) que solo permita precios mayores a 0.
    var laptop = new Product(1000);
    System.out.println(laptop.getPrice());
    laptop.setPrice(0);
    System.out.println("El precio del producto es: " + laptop.getPrice());

    // 3. Crea una clase BankAccount con el atributo privado balance. Implementa los métodos deposit(double amount) y withdraw(double amount) que validen las cantidades correctamente.
    var cuenta1 = new BankAccount(1000);
    System.out.println(String.format("Tienes: %.2f en tu cuenta.", cuenta1.getBalance()));
    cuenta1.withdraw(100);
    cuenta1.deposit(10);
    System.out.println(String.format("Tienes: %.2f en tu cuenta.", cuenta1.getBalance()));

    // 4. Crea una clase Book con el atributo privado title. Permite leerlo con el método getTitle() pero no modificarlo (sin setTitle()). El título debe asignarse solo por el constructor.
    var libro1 = new Book("Cien años de soledad");
    System.out.println(libro1.getTitle());

    // 5. Crea una clase Temperature con el atributo privado celsius. El método setCelsius(double celsius) solo debe aceptar valores entre -100 y 100.
    var temperatura = new Temperature(2.2);
    temperatura.setCelsius(101);
    System.out.println(temperatura.getCelsius());

    // 6. Crea una clase User con los atributos privados username y password. Implementa los métodos setUsername(String username), setPassword(String password) y checkPassword(String inputPassword) que compare contraseñas.
    var user1 = new User("David", "1234");
    user1.setPassword("0987");
    user1.checkPassword("0987");

    // 7. Crea una clase Employee con el atributo privado salary. Agrega el método raiseSalary(double percent) que solo permita aumentos positivos.
    var empleado1 = new Employee(1000);
    empleado1.getSalary();
    empleado1.setSalary(2000);
    empleado1.raiseSalary(20);

    // 8. Crea una clase Rectangle con los atributos privados width y height. Agrega setters y el método calculateArea() que devuelva el resultado de width * height.
    var rectangle = new Rectangle(5, 3);
    System.out.println(rectangle.calculateArea());

    // 9. Crea una clase Student con el atributo privado grade. Agrega los métodos setGrade(int grade) y isPassed() que retorne true si la nota es mayor o igual a 60.
    var estudiante1 = new Student(100);
    estudiante1.setGrade(100);
    if (estudiante1.isPassed()){
      System.out.println("El estudiante aprobó la asignatura.");
    }else {
      System.out.println("El estudiante reprobó la asignatura.");
    }

    // 10. Crea una clase Car con el atributo privado speed. Agrega los métodos accelerate(int amount) que aumente la velocidad (máximo 120) y brake(int amount) que reduzca la velocidad (mínimo 0).
    var ferrari = new Car(100);
    ferrari.brake(30);
    ferrari.accelerate(10);
  }
}
