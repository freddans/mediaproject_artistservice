package com.freddan.mediaproject_artistservice.controllers;

import com.freddan.mediaproject_artistservice.entities.Artist;
import com.freddan.mediaproject_artistservice.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @PostMapping("/createArtist")
    public ResponseEntity<Artist> createArtist(@RequestBody Artist artist) {
        return ResponseEntity.ok(artistService.createArtist(artist));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long id) {
        return ResponseEntity.ok(artistService.getArtistById(id));
    }

    @GetMapping("/getAllArtists")
    public ResponseEntity<List<Artist>> getAllArtists() {
        return ResponseEntity.ok(artistService.getAllArtists());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable Long id, @RequestBody Artist artist) {
        return ResponseEntity.ok(artistService.updateArtist(id, artist));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/exists/{name}")
    public ResponseEntity<Boolean> artistExist(@PathVariable("name") String name) {
        return ResponseEntity.ok(artistService.checkIfArtistExistByName(name));
    }
}