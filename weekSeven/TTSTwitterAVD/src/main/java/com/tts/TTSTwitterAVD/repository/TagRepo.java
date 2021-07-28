package com.tts.TTSTwitterAVD.repository;

import com.tts.TTSTwitterAVD.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepo extends CrudRepository<Tag, Long> {
    Tag findByPhrase(String phrase);
}
