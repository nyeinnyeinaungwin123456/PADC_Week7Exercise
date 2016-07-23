package xyz.aungpyaephyo.padc.myanmarattractions.data.models;

import de.greenrobot.event.EventBus;
import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.UserVO;

/**
 * Created by aung on 7/15/16.
 */
import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.UserVO;
import xyz.aungpyaephyo.padc.myanmarattractions.events.DataEvent;
import xyz.aungpyaephyo.padc.myanmarattractions.events.UserEvent;
import xyz.aungpyaephyo.padc.myanmarattractions.views.pods.ViewPodLogoutUser;

/**
 * Created by aung on 7/15/16.
 */
public class UserModel extends BaseModel {

    private static UserModel objInstance;

    private UserVO loginUser;

    private UserModel() {
        super();
    }

    public void init(){
        loginUser = UserVO.loadLoginUser();

        if(loginUser !=null){
            DataEvent.RefreshUserLoginStatusEvent event = new DataEvent.RefreshUserLoginStatusEvent();
            EventBus.getDefault().post(event);
        }
    }

    public static UserModel getInstance() {
        if (objInstance == null) {
            objInstance = new UserModel();
        }
        return objInstance;
    }

    public boolean isUserLogin() {
        return loginUser != null;
    }

    public void register(String name, String email, String password, String dateOfBirth, String country) {
        dataAgent.register(name, email, password, dateOfBirth, country);
    }

    public void login(String email, String password) {
        dataAgent.login(email, password);
    }

    public void setLogoutUserController(ViewPodLogoutUser.LogoutUserController logoutUserController){
//        vpLogoutUser.
    }

    public UserVO getLoginUser() {
        return loginUser;
    }

    //Success Register
    public void onEventMainThread(UserEvent.SuccessRegistrationEvent event) {
        loginUser = event.getLoginUser();
//        loginUser.serRegiste

        loginUser.saveLoginUser();

    }

    //Success Login
    public void onEventMainThread(UserEvent.SuccessLoginEvent event) {
        loginUser = event.getLoginUser();
//        loginUser.serRegiste

        loginUser.saveLoginUser();

    }

    public void logout() {
        loginUser.clearData();
        loginUser = null;

        DataEvent.RefreshUserLoginStatusEvent event = new DataEvent.RefreshUserLoginStatusEvent();
        EventBus.getDefault().post(event);
    }

    //Failed to Register
    public void onEventMainThread(UserEvent.FailedRegistrationEvent event) {
        //Do nothing on persistent layer.
    }
}