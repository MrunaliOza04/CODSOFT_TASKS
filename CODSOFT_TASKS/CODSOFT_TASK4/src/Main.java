public class Main {

    public static void main(String[] args) {

        Question[] questions = {

                new Question(
                        "Which language is used for Android Development?",
                        new String[]{"Python", "Java", "C", "PHP"},
                        2
                ),

                new Question(
                        "Which company developed Java?",
                        new String[]{"Microsoft", "Sun Microsystems", "Google", "Apple"},
                        2
                ),

                new Question(
                        "Which keyword is used to inherit a class?",
                        new String[]{"extends", "implements", "super", "this"},
                        1
                ),

                new Question(
                        "Which collection stores unique elements?",
                        new String[]{"List", "Array", "Set", "Queue"},
                        3
                ),

                new Question(
                        "Which package contains Scanner class?",
                        new String[]{"java.io", "java.util", "java.lang", "java.net"},
                        2
                )
        };

        Quiz quiz = new Quiz(questions);

        quiz.startQuiz();

    }
}