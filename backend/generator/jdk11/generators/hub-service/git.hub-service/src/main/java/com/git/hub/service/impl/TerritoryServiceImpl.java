package com.git.hub.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.hub.commons.dto.TerritoryDto;
import com.git.hub.commons.enums.ErrorCode;
import com.git.hub.commons.exception.BusinessException;
import com.git.hub.commons.request.MessageDto;
import com.git.hub.commons.request.PaginatedRequestDto;
import com.git.hub.commons.response.GenericResponseDto;
import com.git.hub.commons.response.PaginatedResponseDto;
import com.git.hub.model.TerritoryDO;
import com.git.hub.model.QTerritoryDO;
import com.git.hub.persistence.TerritoryPersistence;
import com.git.hub.service.TerritoryService;
import com.github.dozermapper.core.Mapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;

import lombok.extern.slf4j.Slf4j;

/**
 * Class TerritoryServiceImpl
 * 
 * @author username@axity.com
 */
@Service
@Transactional
@Slf4j
public class TerritoryServiceImpl implements TerritoryService
{
  @Autowired
  private TerritoryPersistence territoryPersistence;

  @Autowired
  private Mapper mapper;
  
  /**
   * {@inheritDoc}
   */
  @Override
  public PaginatedResponseDto<TerritoryDto> findTerritorys( PaginatedRequestDto request )
  {
    log.debug( "%s", request );

    int page = request.getOffset() / request.getLimit();
    Pageable pageRequest = PageRequest.of( page, request.getLimit(), Sort.by( "id" ) );

    var paged = this.territoryPersistence.findAll( pageRequest );

    var result = new PaginatedResponseDto<TerritoryDto>( page, request.getLimit(), paged.getTotalElements() );

    paged.stream().forEach( x -> result.getData().add( this.transform( x ) ) );

    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public GenericResponseDto<TerritoryDto> find( Integer id )
  {
    GenericResponseDto<TerritoryDto> response = null;

    var optional = this.territoryPersistence.findById( id );
    if( optional.isPresent() )
    {
      response = new GenericResponseDto<>();
      response.setBody( this.transform( optional.get() ) );
    }

    return response;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public GenericResponseDto<TerritoryDto> create( TerritoryDto dto )
  {

    TerritoryDO entity = new TerritoryDO();
    this.mapper.map( dto, entity );
    entity.setId(null);

    this.territoryPersistence.save( entity );

    dto.setId(entity.getId());

    return new GenericResponseDto<>( dto );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public GenericResponseDto<Boolean> update( TerritoryDto dto )
  {
    var optional = this.territoryPersistence.findById( dto.getId() );
    if( optional.isEmpty() )
    {
      throw new BusinessException( ErrorCode.HUB_NOT_FOUND );
    }

    var entity = optional.get();
    
    
    entity.setName( dto.getName() );
    // TODO: Actualizar entity.Countries (?) 

    this.territoryPersistence.save( entity );

    return new GenericResponseDto<>( true );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public GenericResponseDto<Boolean> delete( Integer id )
  {
    var optional = this.territoryPersistence.findById( id );
    if( optional.isEmpty() )
    {
      throw new BusinessException( ErrorCode.HUB_NOT_FOUND );
    }

    var entity = optional.get();
    this.territoryPersistence.delete( entity );

    return new GenericResponseDto<>( true );
  }

  private TerritoryDto transform( TerritoryDO entity )
  {
    TerritoryDto dto = null;
    if( entity != null )
    {
      dto = this.mapper.map( entity, TerritoryDto.class );
    }
    return dto;
  }
}
