package com.silence.sspaint.service;

import com.silence.sspaint.entity.Artist;
import com.silence.sspaint.repostiory.ArtistReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by 杰 on 2016/2/11.
 */
@Service
public class ArtistDetailsService implements UserDetailsService{


    @Autowired
    private ArtistReponsitory artistReponsitory;
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Artist artist = artistReponsitory.findByUserName(s);
        return artist;
    }
}
