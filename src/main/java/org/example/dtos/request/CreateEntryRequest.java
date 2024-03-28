package org.example.dtos.request;

import lombok.Data;
@Data

public class CreateEntryRequest {
    private String username;
    private String title;

    private String body;

}
