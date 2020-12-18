package ru.mirea.intro.web.to;

import lombok.*;

@AllArgsConstructor
@Data
@Getter
@Setter
@NoArgsConstructor
public class RequestDto {
    private long id;
    private String requestValue;
}
