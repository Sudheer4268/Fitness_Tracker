package fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fitness.models.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>{

}
