package com.vipin.shortquiz;

import com.vipin.shortquiz.model.QuizModel;

import java.util.ArrayList;

public class QuizBank {

    static ArrayList<QuizModel> load() {

        ArrayList<QuizModel> data = new ArrayList<>();

        //Question1
        data.add(new QuizModel(
                "What is the capital of India?",
                "Maharashtra",
                "Gujarat",
                "Punjab",
                "Delhi",
                "Option4"
        ));

        //Question2
        data.add(new QuizModel(
                "What is full form of RAM?",
                "Read Access Memory",
                "Read Accumulator Memory",
                "Random Access Memory",
                "Random Accumulator Memory",
                "Option3"
        ));

        //Question3
        data.add(new QuizModel(
                "What is the capital of Uttarakhand?",
                "Tehri Garhwal",
                "Dehradun",
                "Chamoli",
                "Pauri Garhwal",
                "Option2"
        ));

        //Question4
        data.add(new QuizModel(
                "Where is 'IT Park' located in Uttarakhand?",
                "Haldwani",
                "Roorkee",
                "Dehradun",
                "Haridwar",
                "Option3"
        ));

        //Question5
        data.add(new QuizModel(
                "Who invented Java?",
                "James Ghoshling",
                "Charles Babbage",
                "Dennis Ritchie",
                "Jeff Bezos",
                "Option1"
        ));

        //Question6
        data.add(new QuizModel(
                "What is the capital of Mumbai?",
                "Maharashtra",
                "Gujarat",
                "Goa",
                "None",
                "Option4"
        ));

        //Question7
        data.add(new QuizModel(
                "What is the currency of India?",
                "Pound",
                "Dollar",
                "Rupee",
                "None",
                "Option3"
        ));

        //Question8
        data.add(new QuizModel(
                "Who is the current Prime Minister of India?",
                "Narendra Modi",
                "Arvind Kejriwal",
                "Rahul Gandhi",
                "Lalu Yadav",
                "Option1"
        ));

        //Question9
        data.add(new QuizModel(
                "Which one is not a programming language?",
                "Java",
                "Python",
                "C++",
                "None",
                "Option4"
        ));

        //Question10
        data.add(new QuizModel(
                "What is the extension of Android applications?",
                ".exe",
                ".rar",
                ".apk",
                ".xlxs",
                "Option3"
        ));

        return data;
    }


}
