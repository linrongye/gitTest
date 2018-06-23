package domain;

import java.util.List;

public class select {
    private String feedbackId;
    private List<TargetArr> targetArr;
    private int anonymity;

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public List <TargetArr> getTargetArr() {
        return targetArr;
    }

    public void setTargetArr(List <TargetArr> targetArr) {
        this.targetArr = targetArr;
    }

    public int getAnonymity() {
        return anonymity;
    }

    public void setAnonymity(int anonymity) {
        this.anonymity = anonymity;
    }
}
