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
    private long userId1;
    @NonNull
    private long userId2;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "chat", cascade = CascadeType.PERSIST)
    private List<Message> messages = new ArrayList<>();
}
