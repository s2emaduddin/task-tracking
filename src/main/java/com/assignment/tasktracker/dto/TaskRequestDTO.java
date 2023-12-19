package com.assignment.tasktracker.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDTO {

    /*
    The annotations on these properties contains messages which will
    be returned if the validation is not passed
    If the title/description is null, The message will be returned
    the global exception handler will catch it and return the error
     */
    @NotNull(message = "Title of the task cannot be null")
    @Pattern(regexp = "[a-zA-Z]{4,}")
    private String title;

    @NotNull(message = "Title of the task cannot be null")
    @Pattern(regexp = "[a-zA-Z]{4,}")
    private String description;

}
