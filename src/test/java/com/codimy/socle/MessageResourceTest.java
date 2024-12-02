package com.codimy.socle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.codimy.socle.controller.MessageResource;
import com.codimy.socle.model.MessageResponseBody;
import com.codimy.socle.service.MessageService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class MessageResourceTest {

  @Mock private MessageService messageService;

  @InjectMocks private MessageResource messageResource;

  @Test
  void getMessagesTest() {
    List<MessageResponseBody> expectedMessages =
        List.of(
            MessageResponseBody.builder()
                .id("e6cb5a25-7d20-47d8-8e16-4597a720dbb4")
                .content("test")
                .build());
    when(messageService.getMessages()).thenReturn(expectedMessages);

    ResponseEntity<List<MessageResponseBody>> response = messageResource.getMessages();

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(expectedMessages, response.getBody());
  }
}
