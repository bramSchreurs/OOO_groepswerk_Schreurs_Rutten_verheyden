package model;

import java.util.ArrayList;

public class EvaluatieVormFactory {
    public EvaluatieVorm getEvaluatieVorm(String Evaluatietype, ArrayList vragen) {
        if (Evaluatietype == "Score") {
            return new EvaluatieVormScore(vragen);
        } else if (Evaluatietype == "Feedback") {
            return new EvaluatieVormFeedback(vragen);
        } else return null;
    }
}
