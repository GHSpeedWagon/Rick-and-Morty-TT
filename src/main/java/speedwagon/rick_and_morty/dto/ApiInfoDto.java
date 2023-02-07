package speedwagon.rick_and_morty.dto;

import lombok.Data;

@Data
public class ApiInfoDto {
    private int count;
    private int pages;
    private String next;
    private String prev;
}
