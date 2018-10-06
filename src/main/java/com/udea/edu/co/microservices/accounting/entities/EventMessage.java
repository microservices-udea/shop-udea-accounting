package com.udea.edu.co.microservices.accounting.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class EventMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(hidden = true)
    private long id;

    @NotNull
    @JsonProperty("uuid")
    String uuid;
    @NotNull
    @JsonProperty("topic")
    String topic;
    @NotNull
    @JsonProperty("type")
    String type;

    @NotNull
    @JsonProperty("content")
    String content;

    public EventMessage(@NotNull String uuid, @NotNull String topic, @NotNull String type, @NotNull String content) {
        this.uuid = uuid;
        this.topic = topic;
        this.type = type;
        this.content = content;
    }



}
