package com.silence.sspaint.service;

import com.silence.sspaint.entity.Artist;
import com.silence.sspaint.exception.ArtistException;
import com.silence.sspaint.repostiory.ArtistReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tristan on 15/12/28.
 */

@Service("artistService")
public class ArtistServiceImpl implements ArtistService {
    @Autowired
    private ArtistReponsitory artistReponsitory;

    /**
     *
     * @param loginId   输入sspainter的用户id来登陆
     * @param password  输入的密码
     * @return  返回的登陆后的artist实体对象,如果没有抛异常,则说明登陆成功
     * @throws ArtistException   登陆中的异常,比如无该用户和密码错误,错误的信息存放在ArtistException的message中
     */
    @Transactional(readOnly = true)
    public Artist basicLogin(String loginId, String password) throws ArtistException {
        Artist artist = findOneArtistByLoginId(loginId);
        if (artist!=null&&password!=null){
            if (password.equals(artist.getPassword())){
                return artist;
            }else {
                throw new ArtistException("密码错误");
            }
        }else {
            throw new ArtistException("无该用户");
        }
    }

    @Transactional
    public Artist reisterArtist(Artist artist) throws ArtistException {

        Artist user = findOneArtistByLoginId(artist.getLoginId());
        if (user != null) {
            throw new ArtistException("用户已经存在");
        } else {
            artist = artistReponsitory.save(artist);
        }
        return artist;
    }

    @Transactional
    public Artist getOtherInfo(String uuid) {
        Artist artist = artistReponsitory.getOne(uuid);
        artist.getDecorateZone().toString();
        return artist;
    }

    private  Artist findOneArtistByLoginId(String loginId) {
        Artist artist = artistReponsitory.findByLoginId(loginId);
        return artist;
    }


}
