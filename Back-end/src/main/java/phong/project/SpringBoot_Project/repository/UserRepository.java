package phong.project.SpringBoot_Project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import phong.project.SpringBoot_Project.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String name);
}

