package com.silence.sspaint.service.inter;

import com.silence.sspaint.entity.Artist;
import com.silence.sspaint.exception.ArtistException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;

/**
 * Created by tristan on 15/12/28.
 */
public interface ArtistService {
   public Page<Artist> seachArtistByNickName(String nickName, Pageable pageable);



}
