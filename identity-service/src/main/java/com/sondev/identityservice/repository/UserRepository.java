package com.sondev.identityservice.repository;

import com.sondev.identityservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Tạo Bean Repository
public interface UserRepository extends JpaRepository<User, String> {
// ====== <User, String> Đối tượng User, Id kiểu String ======

}
