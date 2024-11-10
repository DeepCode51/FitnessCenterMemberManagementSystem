package com.spring.dao;

import com.spring.config.MapperBase;
import com.spring.entity.Kehu;
import org.springframework.stereotype.Repository;

@Repository
public interface KehuMapper extends MapperBase<Kehu> {
    Kehu login(Kehu kehu);
}
