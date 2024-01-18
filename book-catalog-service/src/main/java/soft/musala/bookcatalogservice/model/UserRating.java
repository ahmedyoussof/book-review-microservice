package soft.musala.bookcatalogservice.model;

import java.util.List;

public class UserRating {

    private String userId;

    private List<Rating> userRatings;

    public UserRating() {
    }

    public UserRating(String userId, List<Rating> userRatings) {
        this.userId = userId;
        this.userRatings = userRatings;
    }

    public List<Rating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
