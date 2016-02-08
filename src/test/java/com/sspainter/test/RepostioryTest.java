package com.sspainter.test;


import com.silence.sspaint.entity.Artist;
import com.silence.sspaint.entity.Picture;
import com.silence.sspaint.entity.Style;
import com.silence.sspaint.exception.ArtistException;
import com.silence.sspaint.repostiory.ArtistReponsitory;
import com.silence.sspaint.repostiory.PictureReponsitory;
import com.silence.sspaint.repostiory.StyleRepository;
import com.silence.sspaint.service.ArtistService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import sun.security.validator.Validator;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tristan on 16/1/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-context.xml")
public class RepostioryTest {
    @Autowired
    private ArtistReponsitory artistReponsitory;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private PictureReponsitory pictureReponsitory;


    @Autowired
    private StyleRepository styleRepository;


    @Test
    @Transactional
    public void testArtist() {
        Artist artist=new Artist();
        artist.setLoginId("tc1");
        artist.setPassword("love201314");
        Artist info = null;

        try {
            info = artistService.reisterArtist(artist);
            System.out.println(info.getLoginId()+info.getUuid());
        } catch (ArtistException e) {
            System.out.println(e.getMessage());
        }



    }


}
