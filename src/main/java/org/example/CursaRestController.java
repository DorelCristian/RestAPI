package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Cursa")
public class CursaRestController {

    private final ICursaSpringRepository cursaRepository;

    @Autowired
    public CursaRestController(ICursaSpringRepository cursaRepository) {
        this.cursaRepository = cursaRepository;
    }

    @GetMapping("/{id}")
    public Cursa getCompetitionById(@PathVariable Integer id) {
        return cursaRepository.findById(id).orElse(null);
    }

    @GetMapping
    public Iterable<Cursa> getAllCompetitions() {
        return cursaRepository.findAll();
    }

    @PostMapping
    public Cursa createCompetition(@RequestBody Cursa competition) {
//        competition.setId(21);
        return cursaRepository.save(competition);
    }

    @PutMapping("/{id}")
    public Cursa updateCompetition(@PathVariable Integer id, @RequestBody Cursa updatedCompetition) {
        updatedCompetition.setId(id);
        return cursaRepository.save(updatedCompetition);
    }

    @DeleteMapping("/{id}")
    public void deleteCompetition(@PathVariable Integer id) {
        cursaRepository.deleteById(id);
    }
}