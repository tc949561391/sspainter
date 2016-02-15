package com.silence.sspaint.service;

import com.silence.sspaint.entity.Artist;
import com.silence.sspaint.exception.ArtistException;
import com.silence.sspaint.repostiory.ArtistReponsitory;
import com.silence.sspaint.service.inter.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tristan on 15/12/28.
 */

@Service("artistService")
public class ArtistServiceImpl implements ArtistService {
    @Autowired
    private ArtistReponsitory artistReponsitory;


    public Page<Artist> seachArtistByNickName(String nickName, Pageable pageable) {
        Page<Artist> artistsPage = artistReponsitory.findByNickNameLike("%" + nickName + "%", pageable);


        return artistsPage;
    }
}
