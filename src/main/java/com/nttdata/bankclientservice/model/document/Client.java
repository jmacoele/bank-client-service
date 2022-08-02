package com.nttdata.bankclientservice.model.document;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.nttdata.bankclientservice.model.document.type.ClientTypeEnum;

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
@Document(value = "clients")
public class Client {

  @Id
  private String id;

  private String name;

  private LocalDateTime becameCustomerDate;

  private String otherDetails;

  @CreatedDate
  private LocalDateTime createdAt;

  @LastModifiedDate
  private LocalDateTime updatedAt;

  @CreatedBy
  private String createdBy;

  @LastModifiedBy
  private String updatedBy;

  private ClientTypeEnum clientType;

  private List<ClientIdentityNumber> identityNumbers;

  private List<ClientEmail> emails;

  private List<ClientPhone> phones;


}
