package model;

import java.util.ArrayList;

public class EvaluatieVormFactory {
    public EvaluatieVorm getEvaluatieVorm(FeedbackWijze feedback , ArrayList vragen) {
        if (feedback.toString()=="Score"){
            return new EvaluatieVormScore(vragen);
        } else if ("feedback" == feedback.toString()) {
            return new EvaluatieVormFeedback(vragen);
        } else return null;
    }
}
