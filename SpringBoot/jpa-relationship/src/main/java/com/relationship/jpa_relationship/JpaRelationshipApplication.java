package com.relationship.jpa_relationship;

import com.relationship.jpa_relationship.entities.*;
import com.relationship.jpa_relationship.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class JpaRelationshipApplication implements CommandLineRunner {

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private InvoiceRepositiry invoiceRepositiry;

  @Autowired
  private AddressesRepository addressesRepository;

  @Autowired
  private ClientDetailsRepository clientDetailsRepository;

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaRelationshipApplication.class, args);
	}

  @Override
  public void run(String... args) throws Exception {
    //manyToOne();
    //manyToOneFindById();
    oneToMany();
    //oneToManyFindById();
    //removeAddress();
    //removeAddressFindById();
    //oneToManyInvoiceBidireccional();
    //oneToManyInvoiceBidireccionalFindById();
    //removeInvoiceBidireccionalFindById();
    //oneToOne();
    //oneToOneFindById();
    //oneToOneBidireccional();
    //oneToOneBidireccionalFindById();
    //manyToMany();
    //manyToManyFindById();
    //manyToManyRemoveFind();
    manyToManyBidireccional();
    manyToManyRemoveBidireccional();
  }

  // Relación de uno a muchos, bidireccional.
  @Transactional
  public void oneToManyInvoiceBidireccional() {
    Client client = new Client("David", "Hernandez");

    // Al cliente le pasamos sus facturas.
    Invoice invoice1 = new Invoice("Compras de la casa", 5000);
    Invoice invoice2 = new Invoice("Compras de la oficina", 1000);

    // Por cada factura pasamos el cliente.
    client.addInvoice(invoice1);
    client.addInvoice(invoice2);

    clientRepository.save(client);
    System.out.println(client);
  }

  // Eliminación una factura bidireccional por ID.
  @Transactional
  public void removeInvoiceBidireccionalFindById() {
    Optional<Client> optionalClient = clientRepository.findOne(2);

    optionalClient.ifPresentOrElse(client -> {
      Invoice invoice1 = new Invoice("Gafas de Sol", 200);
      Invoice invoice2 = new Invoice("Maleta", 500);

      client.addInvoice(invoice1);
      client.addInvoice(invoice2);

      Client c = clientRepository.save(client);
      System.out.println(c);

    }, () -> System.out.println("No se encontró el cliente"));

    // Eliminamos una factura del cliente:
    Optional<Client> optionalClient1 = clientRepository.findOne(2);
    optionalClient1.ifPresentOrElse(c -> {
      // Buscamos la factura.
      Optional<Invoice> optionalInvoice = invoiceRepositiry.findById(1);
      optionalInvoice.ifPresentOrElse(invoice -> {

        // Eliminamos en ambos sentidos tanto del cliente como de factura.
        c.removeInvoice(invoice);

        clientRepository.save(c);
        System.out.println("Se elimino correctamente la factura indicada.");

      }, () -> System.out.println("No se encontró la factura."));

      System.out.println(c);
    }, () -> System.out.println("No se encontró el cliente"));

  }

  // Agregar a un usuario una factura de forma bidireccional.
  @Transactional
  public void oneToManyInvoiceBidireccionalFindById() {
    Optional<Client> optionalClient = clientRepository.findOne(2);

    optionalClient.ifPresentOrElse(c -> {
      Invoice invoice1 = new Invoice("gafas", 100);
      Invoice invoice2 = new Invoice("Libro", 40);

      c.addInvoice(invoice1);
      c.addInvoice(invoice2);

      clientRepository.save(c);
      System.out.println(c);

    }, () -> System.out.println("No se encontró el ID del cliente."));

  }

  // Relation de uno a muchos.
  @Transactional
  public void oneToMany() {
    // Creamos tanto las direcciones como al cliente.
    // Al crear el cliente y guardarlo este se encarga de crear las direcciones en su respectiva tabla y crear las relaciones.
    // Por este motivo tenemos él: cascade = CascadeType.ALL
    Client client = new Client("Many", "Manito");

    Address address1 = new Address("España", "El veraje", 123);
    Address address2 = new Address("EEUU", "Wall Street", 1233);

    // Por este motivo se agregan las direcciones al cliente.
    client.getAddresses().add(address1);
    client.getAddresses().add(address2);

    clientRepository.save(client);

    System.out.println(client);
  }

  // Relación de uno a muchos buscando por ID.
  @Transactional // Operaciones sobre las tablas.
  public void oneToManyFindById() {
    // Actualizamos o agregamos la dirección a un cliente que ya existe.
    Optional<Client> optionalClient = clientRepository.findById(2);

    optionalClient.ifPresentOrElse(client -> {
      Address address1 = new Address("Colombia", "San Antonio", 189);
      Address address2 = new Address("Mexico", "Calle 13", 123);

      Set<Address> addresses = new HashSet<>();
      addresses.add(address1);
      addresses.add(address2);
      client.setAddresses(addresses); // Actualizar el address de un cliente.

      Client clientDB = clientRepository.save(client);
      System.out.println(clientDB);

    }, () -> System.out.println("No se encontró el ID indicado."));
  }

  @Transactional // Operaciones sobre las tablas.
  public void removeAddress() {

    Client client = new Client("Francisco", "Matematico");

    Address address1 = new Address("Colombia", "Calle 186", 67);
    Address address2 = new Address("EEUU", "Wall Street", 123);

    client.getAddresses().add(address1);
    client.getAddresses().add(address2);

    Client clientDB = clientRepository.save(client);
    System.out.println(clientDB);

    Optional<Client> optionalClient = clientRepository.findOneWithAddresses(3);
    optionalClient.ifPresentOrElse(c -> {

      c.getAddresses().remove(address2);
      clientRepository.save(c);
      System.out.println(c);

    }, () -> System.out.println("No se encontró al cliente en la Base de Datos."));
  }

  @Transactional
  public void removeAddressFindById() {
    Optional<Client> optionalClient = clientRepository.findById(2);
    optionalClient.ifPresentOrElse(client -> {

      Address address1 = new Address("Colombia", "Calle 186", 67);
      Address address2 = new Address("EEUU", "Wall Street", 123);

      Set<Address> addresses = new HashSet<>();
      addresses.add(address1);
      addresses.add(address2);
      client.setAddresses(addresses);

      Client c = clientRepository.save(client);
      System.out.println(c);

    }, () -> System.out.println("No se encontró al cliente en la Base de Datos."));

    // Eliminamos una dirección de un cliente que ya existe en nuestra BD.
    Optional<Client> optionalClient1 = clientRepository.findOneWithAddresses(2);
    optionalClient1.ifPresentOrElse(client -> {

      // Buscamos el ID_address que queremos eliminar del cliente.
      Optional<Address> optionalAddress = addressesRepository.findById(1);
      optionalAddress.ifPresentOrElse(a -> {
        client.getAddresses().remove(a);
        Client c2 = clientRepository.save(client);
        System.out.println(c2);

      }, () -> System.out.println("No se encontró ninguna dirección con el ID indicado."));
    }, () -> System.out.println("No se encontró el Id en la BD."));
  }

  // Relación de muchos a uno.
  @Transactional
  public void manyToOne() {
    // Creamos el cliente;
    Client client = new Client("David", "Hernandez");
    clientRepository.save(client);

    //Creamos la factura:
    Invoice invoice = new Invoice("Compras de oficina", 2000);
    invoice.setClient(client); // Le asignamos la factura al cliente.
    Invoice invoiceDB = invoiceRepositiry.save(invoice);

    System.out.println("Se creo la factura: \n" + invoiceDB);
  }

  // Relación de muchos a uno buscando por ID.
  @Transactional
  public void manyToOneFindById() {
    // Agregar una factura a un usuario que ya existe en la Base de Datos.

    // Buscamos el ID del cliente:
    Optional<Client> optionalClient = clientRepository.findById(2);

    // Si existe él, id crea la factura y la relaciona al cliente que le corresponde ese ID:
    optionalClient.ifPresentOrElse(client -> {
      Invoice invoice = new Invoice("Gafas de Sol.", 100);
      invoice.setClient(client);
      Invoice invoiceBD = invoiceRepositiry.save(invoice);

      System.out.println("Se agrego correctamente la factura: \n" + invoiceBD);

    }, () -> System.out.println("No se encontró al cliente con el ID indicado."));

  }

  // Relación uno a uno unidireccional.
  @Transactional
  public void oneToOne() {
    ClientDetails clientDetails = new ClientDetails(true, 5000);
    clientDetailsRepository.save(clientDetails);

    Client client = new Client("Eva", "De Wally");
    client.setClientDetails(clientDetails);
    clientRepository.save(client);

    System.out.println(client);

  }

  @Transactional
  public void oneToOneFindById() {
    Optional<Client> optionalClient = clientRepository.findOne(2);

    optionalClient.ifPresentOrElse(client -> {
      ClientDetails clientDetails = new ClientDetails(false, 500);
      clientDetailsRepository.save(clientDetails);

      client.setClientDetails(clientDetails);
      clientRepository.save(client);

      System.out.println(client);
    }, () -> System.out.println("No existe el cliente con el ID indicado."));
  }

  @Transactional
  public void oneToOneBidireccional() {
    Client client = new Client("David", "Hernandez");
    ClientDetails clientDetails = new ClientDetails(true, 1500);

    client.setClientDetails(clientDetails);
    clientDetails.setClient(client);

    clientRepository.save(client);
    System.out.println(client);
  }

  @Transactional
  public void oneToOneBidireccionalFindById() {
    Optional<Client> optionalClient = clientRepository.findOne(1);

    optionalClient.ifPresentOrElse(client -> {
      ClientDetails clientDetails = new ClientDetails(false, 200);
      client.setClientDetails(clientDetails);
      clientDetails.setClient(client);

      Client clientBD = clientRepository.save(client);
      System.out.println(clientBD);
    }, () -> System.out.println("No se encontró el cliente."));
  }

  // Relación de muchos a muchos.
  @Transactional
  public void manyToMany() {

    // Creamos los estudiantes:
    Student student1 = new Student("David", "Hernandez", true);
    Student student2 = new Student("Malcolm", "In The Middle", true);

    // Creamos los cursos:
    Course course1 = new Course("Ing de Sistemas", "Miguel", true);
    Course course2 = new Course("Física Elemental", "Albert", true);
    Course course3 = new Course("Political", "Gregorio", true);

    // Les asignamos los cursos a cada estudiante:
    student1.setCourses(Set.of(course1, course2, course3));
    student2.setCourses(Set.of(course2));

    // Guardamos los datos de los estudiantes en la BD.
    studentRepository.saveAll(Set.of(student1, student2));

    // Imprimimos los estudiantes:
    System.out.println(student1);
    System.out.println(student2);
  }

  // Relación de muchos a muchos -> Asignamos cursos a un estudiante ya creado en la BD.
  @Transactional
  public void manyToManyFindById() {

    Optional<Student> optionalStudent = studentRepository.findById(2);

    optionalStudent.ifPresentOrElse(student -> {
      Course course1 = new Course("Java", "David", true);
      Course course2 = new Course("Spring Boot", "Andres", true);

      student.setCourses(Set.of(course1, course2));

      Student studentDB = studentRepository.save(student);
      System.out.println(studentDB);

    }, () -> System.out.println("No se encontró ningún estudiante con ese ID."));
  }

  @Transactional
  public void manyToManyRemoveFind() {
    Optional<Student> optionalStudent1 = studentRepository.findById(1);
    Optional<Student> optionalStudent2 = studentRepository.findById(2);

    Student student1 = optionalStudent1.get();
    Student student2 = optionalStudent2.get();

    Course course1 = new Course("Java", "David", true);
    Course course2 = new Course("Spring Boot", "Andres", true);

    student1.setCourses(Set.of(course1, course2));
    student2.setCourses(Set.of(course2));

    studentRepository.saveAll(Set.of(student1, student2));
    System.out.println(student1);
    System.out.println(student2);

    Optional<Student> studentOptionalDB = studentRepository.findOneWithCourses(1);
    studentOptionalDB.ifPresentOrElse(student -> {
      Student studentDB = studentOptionalDB.get();

      Optional<Course> optionalCourse = courseRepository.findById(2);
      optionalCourse.ifPresent(course -> {
        Course courseDB = optionalCourse.get();
        studentDB.getCourses().remove(courseDB);

        studentRepository.save(studentDB);
        System.out.println("Se elimino correctamente el curso al estudiante.");
      });

      System.out.println(student);

    }, () -> System.out.println("No se encontró ningún estudiante con ese ID"));
  }

  private void manyToManyBidireccional() {
    Student student1 = new Student("David", "Hernandez", true);
    Student student2 = new Student("Ricardo", "Hernandez", true);

    Course course1 = new Course("Angular", "Jose", true);
    Course course2 = new Course("React", "Miguel", true);

    student1.addCourses(course1);
    student1.addCourses(course2);
    student2.addCourses(course2);

    studentRepository.saveAll(Set.of(student1, student2));

    System.out.println(student1);
    System.out.println(student2);
  }

  public void manyToManyRemoveBidireccional() {

    Optional<Student> optionalStudent = studentRepository.findOneWithCourses(4);
    optionalStudent.ifPresentOrElse(student -> {

      Optional<Course> optionalCourse = courseRepository.findOneWhitStudents(1);
      optionalCourse.ifPresentOrElse(course -> {

        student.removeCourses(course);
        studentRepository.save(student);
        System.out.println("Se elimino correctamente el curso al estudiante indicado.");

      }, () -> System.out.println("No se encontró el curso."));

      System.out.println(student);

    }, () -> System.out.println("No se encontró el estudiante."));
  }
}
