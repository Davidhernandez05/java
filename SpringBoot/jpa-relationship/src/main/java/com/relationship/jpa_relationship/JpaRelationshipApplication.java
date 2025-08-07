package com.relationship.jpa_relationship;

import com.relationship.jpa_relationship.entities.Client;
import com.relationship.jpa_relationship.entities.Invoice;
import com.relationship.jpa_relationship.repositories.ClientRepository;
import com.relationship.jpa_relationship.repositories.InvoiceRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
    manyToOne();
  }

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
}
