package com.haoproject.chat.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "messages")
public class Message {
    @Id
    private long id;

    @NonNull
    private String message;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    private long creationTimestamp;

    @PrePersist
    protected void onCreate() {
        creationTimestamp = new Date().getTime();
    }
}
