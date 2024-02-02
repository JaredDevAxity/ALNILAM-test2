package com.git.hub.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.git.hub.model.RoleDO;

/**
 * Persistence interface of  de {@link com.git.hub.model.RoleDO}
 * 
 * @author username@axity.com
 */
@Repository
public interface RolePersistence extends JpaRepository<RoleDO, Integer>
{
  // Agregar consultas personalizadas
}
