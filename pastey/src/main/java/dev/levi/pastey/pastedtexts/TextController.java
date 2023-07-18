package dev.levi.pastey.pastedtexts;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class TextController {

    TextRepository textRepository;

    public TextController(TextRepository textRepository) {
        this.textRepository = textRepository;
    }
    @GetMapping("/texts")
    public Iterable<Text> getTexts() {
        return textRepository.findAll();
    }

    @PostMapping("/texts")
    public Text postText(@RequestBody Text text) {
        return textRepository.save(text);
    }
    @GetMapping("/texts/{id}")
    public Text getText(@PathVariable Long id) {
        return textRepository.findById(id).get();
    }
    @DeleteMapping("/texts/{id}")
    public void deleteText(@PathVariable Long id) {
        textRepository.deleteById(id);
    }

    @PutMapping("/texts/{id}")
    public Text updateText(@PathVariable Long id, @RequestBody Text text) {
        Text textToUpdate = textRepository.findById(id).get();
        textToUpdate.setText(text.getText());
        textToUpdate.setDate(text.getDate());
        textToUpdate.setUsername(text.getUsername());
        return textRepository.save(textToUpdate);
    }

}
