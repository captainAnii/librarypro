package System;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {
    private final LibraryRepository libraryRepository;

    public LibraryController(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @PostMapping
    public Library addLibrary(@RequestBody Library library) {
        return libraryRepository.save(library);
    }

    @GetMapping
    public List<Library> getLibraries(@RequestParam(required = false) String name) {
        if (name != null) {
            return libraryRepository.findByName(name);
        }
        return libraryRepository.findAll();
    }
}