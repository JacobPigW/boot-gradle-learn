package com.jacob.learn.keepwatch.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class KeepWatchArgs {

    @NotBlank(message = "ip cannot be empty")
    private String ip;

    @NotNull(message = "port cannot be null")
    @Range(min = 1L, max = 65534l, message = "port is incorrect, 1 ~ 65534")
    private Integer port;
}
