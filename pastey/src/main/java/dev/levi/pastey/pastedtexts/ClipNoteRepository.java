package dev.levi.pastey.pastedtexts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClipNoteRepository extends CrudRepository<ClipNote, Long> {

}