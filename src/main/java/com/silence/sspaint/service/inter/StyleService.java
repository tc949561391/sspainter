package com.silence.sspaint.service.inter;

import com.silence.sspaint.entity.Style;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Created by 杰 on 2016/2/12.
 */
public interface StyleService {

    public Page<Style> loadSubStyls(String styleuuid, PageRequest pageRequest);

    public List<Style> allRootStyle();
}
