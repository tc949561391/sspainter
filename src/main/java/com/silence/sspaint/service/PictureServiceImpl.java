package com.silence.sspaint.service;

import com.silence.sspaint.entity.Picture;
import com.silence.sspaint.entity.Style;
import com.silence.sspaint.repostiory.PictureReponsitory;
import com.silence.sspaint.repostiory.StyleRepository;
import com.silence.sspaint.service.inter.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 杰 on 2016/2/12.
 */
@Service("pictureService")
public class PictureServiceImpl implements PictureService {

    @Autowired
    PictureReponsitory pictureReponsitory;
    @Autowired
    StyleRepository styleRepository;


    @Override
    @Transactional
    public Page<Picture> seachPicturesByStyle(String style, Pageable pageable) {
        Page<Picture> picturePage = pictureReponsitory.findByStyles_StyleNameIn(pageable, style);
        return picturePage;
    }


}
