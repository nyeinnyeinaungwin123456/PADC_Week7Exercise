package xyz.aungpyaephyo.padc.myanmarattractions.views.pods;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.aungpyaephyo.padc.myanmarattractions.R;
import xyz.aungpyaephyo.padc.myanmarattractions.controllers.BaseController;
import xyz.aungpyaephyo.padc.myanmarattractions.controllers.UserController;
import xyz.aungpyaephyo.padc.myanmarattractions.controllers.ViewController;
import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.UserVO;

/**
 * Created by aung on 7/6/16.
 */
public class ViewPodLoginUser extends RelativeLayout implements ViewController {

    @BindView(R.id.iv_profile_cover)
    ImageView ivProfileCover;

    @BindView(R.id.iv_profile)
    ImageView ivProfile;

    @BindView(R.id.tv_name)
    TextView tvUsername;

    @BindView(R.id.tv_email)
    TextView tvEmail;

    private UserController mController;

    public ViewPodLoginUser(Context context) {
        super(context);
    }

    public ViewPodLoginUser(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewPodLoginUser(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
    }

    @OnClick(R.id.btn_logout)
    public void onTapLogout(Button btnLogout) {

        mController.onTapLogout();
    }


    @Override
    public void setController(BaseController controller) {
        mController = (UserController) controller;
    }


    public void setData(UserVO loginUser) {
//        Glide.with(getContext())
//                .load(loginUser.getCoverImageUrl())
//                .centerCrop()
//                .placeholder(R.drawable.drawer_background)
//                .error(R.drawable.drawer_background)
//                .into(ivProfileCover);
//
//        Glide.with(getContext())
//                .load(loginUser.getImageUrl())
//                .centerCrop()
//                .placeholder(R.drawable.dummy_avatar)
//                .error(R.drawable.dummy_avatar)
//                .into(ivProfile);

        tvUsername.setText(loginUser.getName());
        tvEmail.setText(loginUser.getEmail());
//        tvPhoneNumber.setText(loginUser.getPhoneNumberDisplay());
    }

}
