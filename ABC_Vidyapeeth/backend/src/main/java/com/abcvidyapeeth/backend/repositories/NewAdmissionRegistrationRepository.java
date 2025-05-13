package com.abcvidyapeeth.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abcvidyapeeth.backend.entities.NewAdmissionRegistration;

public interface NewAdmissionRegistrationRepository extends JpaRepository<NewAdmissionRegistration, Long>{

	public NewAdmissionRegistration findByDeletedAndId(boolean deleted, Long id);

}
