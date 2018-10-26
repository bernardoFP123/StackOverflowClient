package bfp.stackoverflowclient;

import com.google.gson.annotations.SerializedName;

public class User {
    private final String mUserDisplayName;
    private final String mUserAvatarUrl;
    private int reputation;

    public User(String userDisplayName, String userAvatarUrl, int reputation) {
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
