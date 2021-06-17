package com.cts.pensioner.detail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.pensioner.detail.model.PensionerDetail;

@Repository
public interface PensionerDetailRepository extends JpaRepository<PensionerDetail, Long> {

	
}
