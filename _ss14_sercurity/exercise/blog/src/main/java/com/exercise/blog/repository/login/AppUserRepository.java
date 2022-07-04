package com.exercise.blog.repository.login;

import com.exercise.blog.model.login.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String username);
}
