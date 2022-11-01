package com.apress.quickpoll.apress.repository;

import com.apress.quickpoll.apress.model.Options;
import org.springframework.data.repository.CrudRepository;

public interface OptionRepository extends CrudRepository<Options,Long> {

}
