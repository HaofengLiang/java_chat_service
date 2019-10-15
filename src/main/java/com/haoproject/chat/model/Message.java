package com.haoproject.chat.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "messages")
public class Message {
    @Id
    private long id;
    @NonNull
    private String message;
    @NonNull
    @ManyToOne
    private Chat chat;

    private long creationTimestamp;

    @PrePersist
    protected void onCreate() {
        creationTimestamp = new Date().getTime();
    }
}
