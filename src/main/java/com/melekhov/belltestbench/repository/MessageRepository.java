package com.melekhov.belltestbench.repository;

import com.melekhov.belltestbench.model.KafkaMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<KafkaMessage, Long> {
}
