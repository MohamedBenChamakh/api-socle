package com.codimy.socle.mapper;

import com.codimy.socle.domain.Message;
import com.codimy.socle.model.MessageResponseBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MessageMapper {

    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    MessageResponseBody toMessageResponseBody(Message message);

    List<MessageResponseBody> toMessageResponseBodyList(List<Message> message);
}
