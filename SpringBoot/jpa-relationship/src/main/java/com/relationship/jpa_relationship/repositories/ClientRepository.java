package com.relationship.jpa_relationship.repositories;

import com.relationship.jpa_relationship.entities.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Integer> {

  @Query("select c from Client c join fetch c.addresses where c.id = ?1")
  Optional<Client> findOneWithAddresses(Integer id);

  @Query("SELECT c from Client c left join fetch c.invoices where c.id = :id")
  Optional<Client> findOneWithInvoice(@Param("id") Integer id);

  @Query("select c from Client c left join fetch c.addresses left join fetch c.invoices where c.id = :id")
  Optional<Client> findOne(@Param("id") Integer integer);
  //En caso de tener más de un fetch en nuestro entitie se tienen que cambiar las List por set.
}
