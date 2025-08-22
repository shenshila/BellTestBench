package com.melekhov.belltestbench.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "message")
@AllArgsConstructor
@NoArgsConstructor
public class KafkaMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String msgId;
    private long timestamp;
    private String method;
    private String uri;
}
