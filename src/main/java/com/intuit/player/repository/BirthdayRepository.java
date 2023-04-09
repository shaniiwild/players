package com.intuit.player.repository;

import com.intuit.player.model.Birthday;
import org.springframework.data.jpa.repository.JpaRepository;

// todo not yet used
public interface BirthdayRepository extends JpaRepository<Birthday, Long> {
}