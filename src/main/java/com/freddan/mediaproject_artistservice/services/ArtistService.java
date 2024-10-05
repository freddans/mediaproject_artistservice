package com.freddan.mediaproject_artistservice.services;

import com.freddan.mediaproject_artistservice.entities.Artist;
import com.freddan.mediaproject_artistservice.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService implements ArtistServiceInterface {

    private final ArtistRepository artistRepository;


    @Autowired
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Artist createArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public Artist getArtistById(Long id) {
        return artistRepository.findById(id).orElseThrow(() -> new RuntimeException("Artist not found"));
    }

    @Override
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist updateArtist(Long id, Artist artist) {
        Artist existingArtist = getArtistById(id);
        existingArtist.setName(artist.getName());
        existingArtist.setAlbumIds(artist.getAlbumIds());
        return artistRepository.save(existingArtist);
    }

    @Override
    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfArtistExistByName(String artistName) {
        Artist artist = artistRepository.findArtistByName(artistName);
        return artist != null;
    }
}