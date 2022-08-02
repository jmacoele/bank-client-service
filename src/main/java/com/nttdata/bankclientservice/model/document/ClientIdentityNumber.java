package com.nttdata.bankclientservice.model.document;

import org.springframework.data.mongodb.core.mapping.Document;

import com.nttdata.bankclientservice.model.document.type.IdentityNumberTypeEnum;

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
@Document(value = "clientidentitynumbers")
public class ClientIdentityNumber {

  private IdentityNumberTypeEnum identityType;

  private String identityNumber;

}

