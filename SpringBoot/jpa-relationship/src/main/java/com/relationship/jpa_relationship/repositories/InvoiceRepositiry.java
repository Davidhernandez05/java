package com.relationship.jpa_relationship.repositories;

import com.relationship.jpa_relationship.entities.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepositiry extends CrudRepository<Invoice, Integer> {
}
