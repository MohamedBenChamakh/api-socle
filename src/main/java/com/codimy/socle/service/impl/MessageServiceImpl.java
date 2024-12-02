package com.codimy.socle.service.impl;

import com.codimy.socle.mapper.MessageMapper;
import com.codimy.socle.model.MessageResponseBody;
import com.codimy.socle.repository.MessageRepository;
import com.codimy.socle.service.MessageService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {

  private final MessageRepository messageRepository;

  @Override
  public List<MessageResponseBody> getMessages() {
    return MessageMapper.INSTANCE.toMessageResponseBodyList(messageRepository.findAll());
  }
}
