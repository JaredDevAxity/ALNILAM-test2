package com.git.hub.service;

import java.util.List;

import com.git.hub.commons.dto.CountryDto;
import com.git.hub.commons.request.PaginatedRequestDto;
import com.git.hub.commons.response.GenericResponseDto;
import com.git.hub.commons.response.PaginatedResponseDto;

/**
 * Interface CountryService
 * 
 * @author username@axity.com
 */
public interface CountryService
{

  /**
   * Method to get Countrys
   * 
   * @param request
   * @return
   */
  PaginatedResponseDto<CountryDto> findCountrys( PaginatedRequestDto request );

  /**
   * Method to get Country by id
   * 
   * @param id
   * @return
   */
  GenericResponseDto<CountryDto> find( Integer id );

  /**
   * Method to create a Country
   * 
   * @param dto
   * @return
   */
  GenericResponseDto<CountryDto> create( CountryDto dto );

  /**
   * Method to update a Country
   * 
   * @param dto
   * @return
   */
  GenericResponseDto<Boolean> update( CountryDto dto );

  /**
   * Method to delete a Country
   * 
   * @param id
   * @return
   */
  GenericResponseDto<Boolean> delete( Integer id );
}
