package com.silence.sspaint.repostiory;

import com.silence.sspaint.entity.Picture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Set;

/**
 * Created by tristan on 16/1/22.
 */
public interface PictureReponsitory extends JpaRepository<Picture, String>, JpaSpecificationExecutor<Picture> {
    Page<Picture> findByStyles_StyleNameIn(Pageable pageable, String... style);


}
