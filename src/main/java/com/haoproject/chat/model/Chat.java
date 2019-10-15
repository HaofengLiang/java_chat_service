package com.haoproject.chat.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Chat {
    @Id
    private long id;
    @NonNull
    private long fromUserId;
    @NonNull
    private long toUserId;
    @OneToMany(mappedBy = "chat")
    private List<Message> messages = new ArrayList<>();
}
