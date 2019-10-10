package com.haoproject.chat.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "messages")
public class Message {
    @Id
    private long id;
    @NonNull
    private String message;
    @NonNull
    @ManyToOne
    private Chat chat;
}
