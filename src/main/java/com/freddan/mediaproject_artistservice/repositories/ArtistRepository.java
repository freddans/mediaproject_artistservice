package com.freddan.mediaproject_artistservice.repositories;

import com.freddan.mediaproject_artistservice.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Artist findArtistByName(String name);
}