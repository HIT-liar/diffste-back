package com.diffste.diffsteback.data;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String account;
    private String password;
}
