package com.codingsarthak.springBootApi.repositories;

import com.codingsarthak.springBootApi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
}
