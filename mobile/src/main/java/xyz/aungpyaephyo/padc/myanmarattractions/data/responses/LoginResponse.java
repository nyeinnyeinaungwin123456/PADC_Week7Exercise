package xyz.aungpyaephyo.padc.myanmarattractions.data.responses;

import com.google.gson.annotations.SerializedName;

import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.UserVO;

/**
 * Created by Nyein Nyein on 7/21/2016.
 */
public class LoginResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("login_user")
    private UserVO login_user;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public UserVO getLogin_user() {
        return login_user;
    }
}
