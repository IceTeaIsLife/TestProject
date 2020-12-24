package ru.mirea.intro.web.to;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Data
@Getter
@Setter
@NoArgsConstructor
public class RequestDto {
    private long id;
    private String requestValue;
    private List<BookTO> bookTOList;
}
