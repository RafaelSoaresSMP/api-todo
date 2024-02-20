package com.apitodo.todo.dtos;

import jakarta.validation.constraints.NotNull;

public record TaskRecordDTO(@NotNull String name, @NotNull String description, @NotNull boolean finish, @NotNull int priority ) {
}
