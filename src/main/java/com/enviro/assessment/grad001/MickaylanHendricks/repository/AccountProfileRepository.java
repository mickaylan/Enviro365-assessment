package com.enviro.assessment.grad001.MickaylanHendricks.repository;


import com.enviro.assessment.grad001.MickaylanHendricks.model.AccountProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountProfileRepository extends CrudRepository<AccountProfile, Long> {
}

