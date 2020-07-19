package com.simo.meitan.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class PtUserDTO implements UserDetails {
    private String userUuid;
    /**
     * 机构ID
     */
    private String organUuid;

    private String organName;
    /**
     * 岗位id
     */
    private String dutyUuid;

    /**
     * 岗位名称
     */
    private String dutyName;
    /**
     * 登录名
     */
    private String username;

    /**
     * 密码
     */
//    @JsonIgnore
    private String password;

    private String email;

    private String mobile;

    private List<String> roles;

    /**
     * 姓名
     */
    private String niceName;

    private Boolean isAdmin;

    /**
     * 密保问题
     */
    private String pwdque;

    /**
     * 密保答案
     */
    private String pwdans;

    /**
     * 备注
     */
    private String remark;

    /**
     * 部门ID
     */
    private String depid;

    /**
     * 是否删除
     */
    private Boolean status;

    /**
     * 操作时间
     */
    private LocalDateTime modtime;

    /**
     * 操作人ID
     */
    private String modifierid;

    /**
     * 是否阳光用户（0否1是）
     */
    private Boolean isSum;





    private List<GrantedAuthority> authorities;
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

//    @JsonIgnore
//    public String getPassword() {
//        return password;
//    }
//    @JsonProperty
//    public void setPassword(String password) {
//        this.password = password;
//    }

}
