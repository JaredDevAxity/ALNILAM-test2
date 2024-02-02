package com.git.hub.service;

import java.util.List;

import com.git.hub.commons.dto.RoleDto;
import com.git.hub.commons.request.PaginatedRequestDto;
import com.git.hub.commons.response.GenericResponseDto;
import com.git.hub.commons.response.PaginatedResponseDto;

/**
 * Interface RoleService
 * 
 * @author username@axity.com
 */
public interface RoleService
{

  /**
   * Method to get Roles
   * 
   * @param request
   * @return
   */
  PaginatedResponseDto<RoleDto> findRoles( PaginatedRequestDto request );

  /**
   * Method to get Role by id
   * 
   * @param id
   * @return
   */
  GenericResponseDto<RoleDto> find( Integer id );

  /**
   * Method to create a Role
   * 
   * @param dto
   * @return
   */
  GenericResponseDto<RoleDto> create( RoleDto dto );

  /**
   * Method to update a Role
   * 
   * @param dto
   * @return
   */
  GenericResponseDto<Boolean> update( RoleDto dto );

  /**
   * Method to delete a Role
   * 
   * @param id
   * @return
   */
  GenericResponseDto<Boolean> delete( Integer id );
}
