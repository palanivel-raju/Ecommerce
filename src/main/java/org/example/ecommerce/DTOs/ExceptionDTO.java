package org.example.ecommerce.DTOs;

import lombok.Getter;
import lombok.Setter;
import org.example.ecommerce.Models.Status;
@Getter
@Setter
public class ExceptionDTO {
    private String message;
    private Status status;
}
