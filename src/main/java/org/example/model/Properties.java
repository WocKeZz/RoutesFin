package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Properties {

    private String description;

    private String stroke;

    @JsonProperty("stroke-width")
    private String strokeWidth;

    @JsonProperty("stroke-opacity")
    private float strokeOpacity;
}
