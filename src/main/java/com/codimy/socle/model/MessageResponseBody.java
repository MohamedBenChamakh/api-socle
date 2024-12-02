package com.codimy.socle.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseBody {

  private String id;

  private String content;
}
