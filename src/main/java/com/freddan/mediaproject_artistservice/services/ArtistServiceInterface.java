package com.freddan.mediaproject_artistservice.services;

import com.freddan.mediaproject_artistservice.entities.Artist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArtistServiceInterface {
    Artist createArtist(Artist artist);
    Artist getArtistById(Long id);
    List<Artist> getAllArtists();
    Artist updateArtist(Long id, Artist artist);
    Boolean checkIfArtistExistByName(String artistName);
    void deleteArtist(Long id);

}