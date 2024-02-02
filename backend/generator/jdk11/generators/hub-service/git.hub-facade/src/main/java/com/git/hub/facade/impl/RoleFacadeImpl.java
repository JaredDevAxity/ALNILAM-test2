package com.git.hub.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.hub.commons.dto.RoleDto;
import com.git.hub.commons.request.PaginatedRequestDto;
import com.git.hub.commons.response.GenericResponseDto;
import com.git.hub.commons.response.PaginatedResponseDto;
import com.git.hub.facade.RoleFacade;
import com.git.hub.service.RoleService;

/**
 * Class RoleFacadeImpl
 * @author username@axity.com
 */
@Service
@Transactional
public class RoleFacadeImpl implements RoleFacade
{
  @Autowired
  private RoleService roleService;
  /**
   * {@inheritDoc}
   */
  @Override
  public PaginatedResponseDto<RoleDto> findRoles( PaginatedRequestDto request )
  {
    return this.roleService.findRoles( request );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public GenericResponseDto<RoleDto> find( Integer id )
  {
    return this.roleService.find( id );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public GenericResponseDto<RoleDto> create( RoleDto dto )
  {
    return this.roleService.create( dto );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public GenericResponseDto<Boolean> update( RoleDto dto )
  {
    return this.roleService.update( dto );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public GenericResponseDto<Boolean> delete( Integer id )
  {
    return this.roleService.delete( id );
  }
}
