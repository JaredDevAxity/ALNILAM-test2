package com.git.hub.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.git.hub.model.UserDO;

/**
 * Persistence interface of  de {@link com.git.hub.model.UserDO}
 * 
 * @author username@axity.com
 */
@Repository
public interface UserPersistence extends JpaRepository<UserDO, Integer>
{
  // Agregar consultas personalizadas
}
