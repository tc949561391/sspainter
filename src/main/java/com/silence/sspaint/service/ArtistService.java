package com.silence.sspaint.service;

import com.silence.sspaint.entity.Artist;
import com.silence.sspaint.exception.ArtistException;

/**
 * Created by tristan on 15/12/28.
 */
public interface ArtistService {
    public Artist basicLogin(String loginId, String password) throws ArtistException;



    public Artist reisterArtist(Artist artist) throws ArtistException;
    public Artist getOtherInfo(String uuid);



}
