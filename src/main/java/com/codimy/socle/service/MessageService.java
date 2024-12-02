package com.codimy.socle.service;

import com.codimy.socle.model.MessageResponseBody;
import java.util.List;

public interface MessageService {

  List<MessageResponseBody> getMessages();
}
