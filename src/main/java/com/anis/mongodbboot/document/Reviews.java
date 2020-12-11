package com.anis.mongodbboot.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reviews {
    private String username;
    private int rate;
    private boolean approved;
}
