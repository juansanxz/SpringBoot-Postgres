package edu.eci.escuelaing.ieti.postgre.postgreLab.repository;


import edu.eci.escuelaing.ieti.postgre.postgreLab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
