package com.stackfloat.e_care;

public class QuestionUtils extends QuestionsArray {

    public String[][] getQuestionsAtIndex(int questionsIndex) {

        if (questionsIndex == 0) {
            return islamicExpansionQuestions;
        } else if (questionsIndex == 1) {
            return KingLeopold2Questions;
        } else if (questionsIndex == 2) {
            return mansaMusaQuestions;
        } else if (questionsIndex == 3) {
            return willieLynchQestions;
        }else if (questionsIndex == 4) {
            return augustusQuestions;
        }else if (questionsIndex == 5) {
            return activistsOf60sQuestions;
        }else {
            return null;
        }
    }

    public void setAnswer(int questionsIndex, int questionIndex, int answerIndex, String answer) {
        if (questionsIndex == 0) {
            islamicExpansionAnsers[questionIndex][answerIndex]=answer;
        } else if (questionsIndex == 1) {
            KingLeopold2Ansers[questionIndex][answerIndex]=answer;
        } else if (questionsIndex == 2) {
            mansaMusaAnsers[questionIndex][answerIndex]=answer;
        } else if (questionsIndex == 3) {
            willieLynchAnsers[questionIndex][answerIndex]=answer;
        }else if (questionsIndex == 4) {
            augustusAnsers[questionIndex][answerIndex]=answer;
        }else if (questionsIndex == 5) {
            activistsOf60sAnsers[questionIndex][answerIndex]=answer;
        }
    }
}
