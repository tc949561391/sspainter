package com.silence.sspaint.repostiory;

import com.silence.sspaint.entity.Artist;
import com.silence.sspaint.entity.Style;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by tristan on 16/1/24.
 */
public interface StyleRepository extends JpaRepository<Style,String> ,JpaSpecificationExecutor<Style>{

    Page<Style> findByParentStyle_UuidOrderByStyleName(String styleuuid, Pageable pageable);


    List<Style> findByIsRootOrderByStyleName(boolean b);
}
