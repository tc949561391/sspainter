package com.silence.sspaint.repostiory;

import com.silence.sspaint.entity.Artist;
import com.silence.sspaint.entity.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by tristan on 16/1/24.
 */
public interface StyleRepository extends JpaRepository<Style,String> ,JpaSpecificationExecutor<Style>{
}
