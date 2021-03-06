package com.nonononoki.alovoa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nonononoki.alovoa.entity.UserDonation;

public interface UserDonationRepository extends JpaRepository<UserDonation, Long> {
	public List<UserDonation> findAllByOrderByDateDesc();
}

