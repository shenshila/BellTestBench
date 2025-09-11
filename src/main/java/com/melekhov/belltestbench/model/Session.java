package com.melekhov.belltestbench.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Session {
    private UUID uuid;
    private Instant startSession;
}
