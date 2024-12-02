package com.codimy.socle.controller;

import com.codimy.socle.model.MessageResponseBody;
import com.codimy.socle.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/v1/messages")
@RestController("messageResource")
public class MessageResource {

  private final MessageService messageService;

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  @Operation(summary = "Get list of messages")
  public ResponseEntity<List<MessageResponseBody>> getMessages() {
    return ResponseEntity.ok(messageService.getMessages());
  }
}
