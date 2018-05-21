package pl.parkin9.IgrzyskaScierki.model;

import javax.validation.constraints.NotBlank;

public class Login {

    @NotBlank(message = "*Pole obowiązkowe.")
    private String loginName;

    @NotBlank(message = "*Pole obowiązkowe.")
    private String password;

////////////////////////////////////////////////////

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
