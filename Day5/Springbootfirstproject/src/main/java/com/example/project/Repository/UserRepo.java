package com.example.project.Repository;
import com.example.project.Models.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserDetails,Integer> {

}
