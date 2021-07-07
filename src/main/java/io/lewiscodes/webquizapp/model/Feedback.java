package io.lewiscodes.webquizapp.model;

public class Feedback {
    public static final Feedback CORRECT = new Feedback(true, "Congratulations, you're right!");
    public static final Feedback WRONG = new Feedback(false, "Wrong answer! Please, try again.");

    private boolean success;
    private String feedback;

    public Feedback(boolean success, String feedback) {
        this.success = success;
        this.feedback = feedback;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getFeedback() {
        return feedback;
    }
}
