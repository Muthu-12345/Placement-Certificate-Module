package com.tnsif.pm.certificate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate,Long>
{
	//All CRUD operations
}

/*
 * findAll()
 * save
 * deleteById
 * findById
 */
