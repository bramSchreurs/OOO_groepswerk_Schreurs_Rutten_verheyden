package model;

public enum FeedbackWijze {
    FEEDBACK("model.EvaluatieVormFeedback;"),
    SCORE("model.EvaluatieVormScore;");
    private String clasname;

    public String getClasname() {
        return clasname;
    }

    public void setClasname(String clasname) {
        this.clasname = clasname;
    }

    FeedbackWijze(String classname){this.clasname=classname;} {
    }
}
