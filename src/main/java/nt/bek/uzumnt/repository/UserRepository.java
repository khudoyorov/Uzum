package nt.bek.uzumnt.repository;

import nt.bek.uzumnt.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    Optional<Users> findByPhoneNumber(String phoneNumber);
    List<Users> findAllByIsActive(Integer isActive);
    Optional<Users> findByIdAndAndIsActive(Integer id,Integer isActive);
}
