package bfp.stackoverflowclient.networking.users;

import com.google.gson.annotations.SerializedName;

public class UserSchema {
    @SerializedName("display_name")
    private final String mUserDisplayName;

    @SerializedName("profile_image")
    private final String mUserAvatarUrl;

    @SerializedName("reputation")
    private final int reputation;

    public UserSchema(String userDisplayName, String userAvatarUrl,int reputation) {
        mUserDisplayName = userDisplayName;
        mUserAvatarUrl = userAvatarUrl;
        this.reputation = reputation;
    }

    public String getUserAvatarUrl() {
        return mUserAvatarUrl;
    }

    public String getUserDisplayName() {
        return mUserDisplayName;
    }

    public int getReputation() {
        return reputation;
    }
}
