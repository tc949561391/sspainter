package com.silence.sspaint.repostiory;

import com.silence.sspaint.entity.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by tristan on 15/12/28.
 */
public interface ArtistReponsitory extends JpaRepository<Artist, String>, JpaSpecificationExecutor<Artist> {
    Artist findByUserName(String userName);
    Page<Artist> findByNickNameLike(String nickName, Pageable pageable);







}
