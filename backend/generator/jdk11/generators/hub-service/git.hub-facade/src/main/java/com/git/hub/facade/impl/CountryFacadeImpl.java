package com.git.hub.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.hub.commons.dto.CountryDto;
import com.git.hub.commons.request.PaginatedRequestDto;
import com.git.hub.commons.response.GenericResponseDto;
import com.git.hub.commons.response.PaginatedResponseDto;
import com.git.hub.facade.CountryFacade;
import com.git.hub.service.CountryService;

/**
 * Class CountryFacadeImpl
 * @author username@axity.com
 */
@Service
@Transactional
public class CountryFacadeImpl implements CountryFacade
{
  @Autowired
  private CountryService countryService;
  /**
   * {@inheritDoc}
   */
  @Override
  public PaginatedResponseDto<CountryDto> findCountrys( PaginatedRequestDto request )
  {
    return this.countryService.findCountrys( request );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public GenericResponseDto<CountryDto> find( Integer id )
  {
    return this.countryService.find( id );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public GenericResponseDto<CountryDto> create( CountryDto dto )
  {
    return this.countryService.create( dto );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public GenericResponseDto<Boolean> update( CountryDto dto )
  {
    return this.countryService.update( dto );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public GenericResponseDto<Boolean> delete( Integer id )
  {
    return this.countryService.delete( id );
  }
}
