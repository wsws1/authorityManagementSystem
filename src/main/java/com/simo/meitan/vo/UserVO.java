package com.simo.meitan.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class UserVO {
    private Integer id;
    private String username;
    private String nickname;
    private List<String> roles;
    private String avatar;

}
