package sg.edu.nus.movieverse.repository;

import org.springframework.stereotype.Repository;
import sg.edu.nus.movieverse.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByName(String name);
}
