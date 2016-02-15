package com.silence.sspaint.service.inter;

import com.silence.sspaint.entity.Picture;
import com.silence.sspaint.entity.Style;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * Created by 杰 on 2016/2/12.
 */
public interface PictureService {



    public Page<Picture> seachPicturesByStyle(String style, Pageable pageable);


}
