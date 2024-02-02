package com.git.hub.service.util;

import org.springframework.kafka.support.serializer.JsonSerializer;

import com.git.hub.commons.request.MessageDto;

/**
 * Message Serializer class
 * 
 * @author username@axity.com
 */
public class MessageSerializer extends JsonSerializer<MessageDto>
{

}
