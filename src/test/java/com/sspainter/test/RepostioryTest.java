package com.sspainter.test;


import com.silence.sspaint.entity.Style;
import com.silence.sspaint.repostiory.ArtistReponsitory;
import com.silence.sspaint.repostiory.PictureReponsitory;
import com.silence.sspaint.repostiory.StyleRepository;
import com.silence.sspaint.service.inter.ArtistService;
import com.silence.sspaint.service.inter.StyleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    StyleService styleService;


    @Test
    public void testArtist() {


//        Page<Style> styles = styleRepository.findByParentStyle_UuidOrderByStyleName("ff80808152d4e5b60152d4e5ce8c0000",new PageRequest(0,10));

        Page<Style> stylePage=styleService.loadSubStyls("ff80808152d4e5b60152d4e5ce8c0000",new PageRequest(0,10));

        stylePage.forEach(p->{
            System.out.println(p.getStyleName());
        });
    }




  @Transactional
    public void addStyle(){
        Style style = styleRepository.findOne("ff80808152d4e5b60152d4e5ce8c0000");
        Style style1=new Style();
        style1.setStyleName("古装");
        style1.setRoot(false);

        style1.setParentStyle(style);
      styleRepository.save(style1);


    }







}
