package com.nttdata.bankclientservice.model.document;

import org.springframework.data.mongodb.core.mapping.Document;

import com.nttdata.bankclientservice.model.document.type.EmailTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "clientemails")
public class ClientEmail {

  private EmailTypeEnum emailType;

  private String email;

}
