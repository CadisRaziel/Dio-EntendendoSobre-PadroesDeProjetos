package com.dio.padroesprojetos.Repository;

import com.dio.padroesprojetos.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//CrudRepository -> é igual o JPARepository( o jparepository extendes dele crudRepository)
//então usa um ou outro nao tem diferença
//crudrepository e jparepository é um strategy
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
