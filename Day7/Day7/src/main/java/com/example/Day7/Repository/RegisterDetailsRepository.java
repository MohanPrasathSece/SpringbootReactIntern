package com.example.Day7.Repository;


import com.example.Day7.Models.RegisterDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private RegisterDetailsRepository registerDetailsRepository;

    public List<RegisterDetails> getEmployeesByRole(String roleName) {
        return registerDetailsRepository.findByRoles_RoleName(roleName);
    }
}





















import com.example.Day7.Models.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegisterDetailsRepository extends JpaRepository<RegisterDetails,Integer> {
    RegisterDetails findByEmail(String email);

    Optional<RegisterDetails> findByUserName(String userName);
    List<RegisterDetails> findByRoles_RoleName(String roleName);

}








