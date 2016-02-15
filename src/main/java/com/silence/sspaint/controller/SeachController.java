package com.silence.sspaint.controller;

import com.silence.sspaint.entity.Artist;
import com.silence.sspaint.entity.Picture;
import com.silence.sspaint.entity.Style;
import com.silence.sspaint.restentity.RestPage;
import com.silence.sspaint.service.inter.ArtistService;
import com.silence.sspaint.service.inter.PictureService;
import com.silence.sspaint.service.inter.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 杰 on 2016/2/11.
 */
@RestController
@RequestMapping("/seach")
public class SeachController {
    @Autowired
    ArtistService artistService;

    @Autowired
    PictureService pictureService;

    @Autowired
    StyleService styleService;


    /**
     * 获取类型中的根类型
     * @return
     */
    @RequestMapping(value = "/rootstyles",method = RequestMethod.GET)
    public List<Style> allRootStyle(){
        List<Style> styles=styleService.allRootStyle();
        styles.forEach(s->{
            s.setParentStyle(null);
            s.setSubStyle(null);
        });

        return styles;
    }


    /**
     * 显示子类型，可通过子类型在细化搜索（层级分类只有两层）
     * @param styleuuid
     * @return
     * url=/substyles?styleuuid=asdasdasdaefsrwerwersfasadasfadf&page=1&size=10
     */
    @RequestMapping(value = "/substyles",method = RequestMethod.GET)
    public RestPage<Style> showSubStyle(String styleuuid,
                                        Integer page,
                                        Integer size){
        Page<Style> stylePage=styleService.loadSubStyls(styleuuid,new PageRequest(page,size));



        stylePage.forEach(s->{
            s.setParentStyle(null);
            s.setSubStyle(null);
        });


        RestPage restPage=new RestPage();
        restPage.setTotlePage(stylePage.getTotalPages());
        restPage.setLocalPage(page);
        restPage.setContent(stylePage.getContent());
        return  restPage;

    }

    /**
     * 使用nickname来搜索用户
     * @param nickName
     * @param page 搜索结果中的第几页，从第0页开始
     * @param size
     * @return
     * @throws Exception
     * url=/artist？nickname=asd&pagenum=1&pagesize=10
     */
    @RequestMapping(value = "/artist", method = RequestMethod.GET)
    public RestPage<Artist> seachArtist(String nickName,
                                        Integer page,
                                        Integer size) throws Exception {
        page = page < 0?0:page;
        Page<Artist> artistPage = artistService.seachArtistByNickName(nickName, new PageRequest(page, size));
        RestPage restPage = new RestPage<Artist>();
        restPage.setContent(artistPage.getContent());
        restPage.setLocalPage(page);
        restPage.setTotlePage(artistPage.getTotalPages());
        return restPage;
    }

    /**
     * 图片搜索，使用图片的类型来搜索
     * @param style 图片的类型
     * @param page 搜索结果的第几页
     * @param size 每页显示多少条记录
     * @return
     * url=/picture?style=古风&pagenum=1&pagesize=10
     */
    @RequestMapping(value = "/picture", method = RequestMethod.GET)
    public RestPage<Picture> seachPicture(String style,
                                          Integer page,
                                          Integer size) {
        page = page < 0?0:page;
        Page<Picture> picturesPage = pictureService.seachPicturesByStyle(style, new PageRequest(page, size));



       //屏蔽搜索结果中不必要的信息
        picturesPage.forEach(p->{
            p.setStyles(null);
            p.setComments(null);
        });


        RestPage restPage = new RestPage<Picture>();
        restPage.setContent(picturesPage.getContent());
        restPage.setLocalPage(page);
        restPage.setTotlePage(picturesPage.getTotalPages());


        return restPage;
    }









}
