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
    public String toString(){
        switch(this){
            case FEEDBACK:
                return "Feedback";
            case SCORE:
                return "Score";
        }
        return null;
    }
}
