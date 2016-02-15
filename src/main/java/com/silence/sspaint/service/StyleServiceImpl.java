package com.silence.sspaint.service;

import com.silence.sspaint.entity.Style;
import com.silence.sspaint.repostiory.StyleRepository;
import com.silence.sspaint.service.inter.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 杰 on 2016/2/12.
 */
@Service("styleService")
public class StyleServiceImpl implements StyleService {

    @Autowired
    StyleRepository styleRepository;


    @Override@Transactional(readOnly = true)
    public Page<Style> loadSubStyls(String styleuuid, PageRequest pageRequest) {


        Page<Style> stylePage = styleRepository.findByParentStyle_UuidOrderByStyleName(styleuuid, pageRequest);


        return stylePage;
    }











    @Override@Transactional(readOnly = true)
    public List<Style> allRootStyle() {
        List<Style> styles=styleRepository.findByIsRootOrderByStyleName(true);
        return styles;
    }
}
