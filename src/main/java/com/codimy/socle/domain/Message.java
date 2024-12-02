package com.codimy.socle.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Data
@Entity
public class Message {

  @Id @UuidGenerator private String id;

  private String content;
}
