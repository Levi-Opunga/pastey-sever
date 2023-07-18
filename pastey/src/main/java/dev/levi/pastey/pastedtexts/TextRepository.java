package dev.levi.pastey.pastedtexts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TextRepository extends JpaRepository<Text, Long> {

}