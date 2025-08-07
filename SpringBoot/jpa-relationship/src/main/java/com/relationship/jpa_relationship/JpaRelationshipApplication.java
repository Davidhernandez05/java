package com.relationship.jpa_relationship;

import aj.org.objectweb.asm.Opcodes;
import com.relationship.jpa_relationship.entities.Address;
import com.relationship.jpa_relationship.entities.Client;
import com.relationship.jpa_relationship.entities.Invoice;
import com.relationship.jpa_relationship.repositories.AddressesRepository;
import com.relationship.jpa_relationship.repositories.ClientRepository;
import com.relationship.jpa_relationship.repositories.InvoiceRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaRelationshipApplication implements CommandLineRunner {

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private InvoiceRepositiry invoiceRepositiry;

  @Autowired
  private AddressesRepository addressesRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaRelationshipApplication.class, args);
	}

  @Override
  public void run(String... args) throws Exception {
    //manyToOne();
    //manyToOneFindById();
    //oneToMany();
    oneToManyFindById();
  }

  @Transactional
  public void oneToMany() {
    // Creamos las direcciones y al cliente.
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

  @Transactional
  public void oneToManyFindById() {
    Optional<Client> optionalClient = clientRepository.findById(2);

    optionalClient.ifPresentOrElse(client -> {
      Address address1 = new Address("Colombia", "San Antonio", 189);
      Address address2 = new Address("Mexico", "Calle 13", 123);

      client.setAddresses(Arrays.asList(address1, address2));

      Client clientDB = clientRepository.save(client);
      System.out.println(clientDB);

    }, () -> System.out.println("No se encontró el ID indicado."));
  }

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
}
