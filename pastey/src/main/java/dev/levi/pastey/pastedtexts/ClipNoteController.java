package dev.levi.pastey.pastedtexts;

import dev.levi.pastey.utils.SimpleResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ClipNoteController {

    ClipNoteRepository clipNoteRepository;

    public ClipNoteController(ClipNoteRepository clipNoteRepository) {
        this.clipNoteRepository = clipNoteRepository;
    }
    @GetMapping("/note")
    public Iterable<ClipNote> getTexts() {
        return clipNoteRepository.findAll();
    }

    @PostMapping("/note")
    public ResponseEntity<ClipNote> postText(@RequestBody ClipNote clipNote) {
        return ResponseEntity.ok(clipNoteRepository.save(clipNote));
    }
    @GetMapping("/note/{id}")
    public ClipNote getText(@PathVariable Long id) {
        return clipNoteRepository.findById(id).get();
    }
    @DeleteMapping("/note/{id}")
    public SimpleResponse deleteText(@PathVariable Long id) {
        clipNoteRepository.deleteById(id);
        return new SimpleResponse("success");
    }

    @PutMapping("/note/{id}")
    public ClipNote updateText(@PathVariable Long id, @RequestBody ClipNote clipNote) {
        ClipNote clipNoteToUpdate = clipNoteRepository.findById(id).orElseThrow();
        clipNoteToUpdate.setText(clipNote.getText());
        clipNoteToUpdate.setDate(clipNote.getDate());
        clipNoteToUpdate.setUsername(clipNote.getUsername());
        clipNoteToUpdate.setTitle(clipNote.getTitle());
        clipNoteToUpdate.setHidden(clipNote.isHidden());
        return clipNoteRepository.save(clipNoteToUpdate);
    }

}

