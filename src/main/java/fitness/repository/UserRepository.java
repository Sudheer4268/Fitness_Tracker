package fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fitness.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

}
