package com.git.hub.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.git.hub.model.OfficeDO;

/**
 * Persistence interface of  de {@link com.git.hub.model.OfficeDO}
 * 
 * @author username@axity.com
 */
@Repository
public interface OfficePersistence extends JpaRepository<OfficeDO, Integer>
{
  // Agregar consultas personalizadas
}
