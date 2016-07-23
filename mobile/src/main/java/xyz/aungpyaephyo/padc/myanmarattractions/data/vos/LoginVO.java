package xyz.aungpyaephyo.padc.myanmarattractions.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nyein Nyein on 7/21/2016.
 */
public class LoginVO {

    @SerializedName("email")
    private String email;

    @SerializedName("access_token")
    private String accessToken;

    public LoginVO(String email, String accessToken) {
        this.email = email;
        this.accessToken = accessToken;
    }

    public String getEmail() {
        return email;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
