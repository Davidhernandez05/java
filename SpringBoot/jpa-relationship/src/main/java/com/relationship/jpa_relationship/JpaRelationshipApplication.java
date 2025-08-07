package com.relationship.jpa_relationship;

import aj.org.objectweb.asm.Opcodes;
import com.relationship.jpa_relationship.entities.Client;
import com.relationship.jpa_relationship.entities.Invoice;
import com.relationship.jpa_relationship.repositories.ClientRepository;
import com.relationship.jpa_relationship.repositories.InvoiceRepositiry;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class JpaRelationshipApplication implements CommandLineRunner {

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private InvoiceRepositiry invoiceRepositiry;

	public static void main(String[] args) {
		SpringApplication.run(JpaRelationshipApplication.class, args);
	}

  @Override
  public void run(String... args) throws Exception {
    //manyToOne();
    manyToOneFindById();
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
