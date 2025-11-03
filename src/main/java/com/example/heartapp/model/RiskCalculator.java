package com.example.heartapp.model;

import java.util.Map;

public class RiskCalculator {
    public static int calculate(Map<String, String> data) {
        int score = 0;
        int age = Integer.parseInt(data.getOrDefault("age", "0"));
        double weight = Double.parseDouble(data.getOrDefault("weight", "0"));

        if (age >= 65) score += 20;
        else if (age >= 55) score += 15;
        else if (age >= 45) score += 10;
        else if (age >= 35) score += 5;

        double bmi = weight / Math.pow(1.75, 2);
        if (bmi >= 30) score += 10;
        else if (bmi >= 25) score += 5;

        if ("Male".equals(data.get("gender"))) score += 5;
        if ("Yes".equals(data.get("chestPain"))) score += 10;
        if ("Yes".equals(data.get("bp"))) score += 8;
        if ("Yes".equals(data.get("cholesterol"))) score += 8;
        if ("Yes".equals(data.get("diabetes"))) score += 7;
        if ("Yes".equals(data.get("smoking"))) score += 7;
        if ("Yes".equals(data.get("family"))) score += 6;

        String exercise = data.getOrDefault("exercise", "");
        if (exercise.equals("Never")) score += 10;
        else if (exercise.equals("Rarely")) score += 7;
        else if (exercise.equals("3-5 times a week")) score += 2;

        String diet = data.getOrDefault("diet", "");
        if (diet.equals("High fat")) score += 8;
        else if (diet.equals("High sugar")) score += 6;
        else if (diet.equals("Low fiber")) score += 4;

        String alcohol = data.getOrDefault("alcohol", "");
        if (alcohol.equals("Regularly")) score += 5;
        else if (alcohol.equals("Occasionally")) score += 2;

        String stress = data.getOrDefault("stress", "");
        if (stress.equals("Yes")) score += 7;
        else if (stress.equals("Sometimes")) score += 3;

        return Math.min(score, 100);
    }

    public static String getCategory(int score) {
        if (score < 25) return "Low Risk";
        else if (score < 50) return "Moderate Risk";
        else if (score < 75) return "High Risk";
        else return "Critical Risk";
    }

    public static String getAdvice(String category) {
        return switch (category) {
            case "Low Risk" -> "Great news! Continue maintaining a healthy lifestyle.";
            case "Moderate Risk" -> "Your risk is moderate. Consider increasing exercise and improving diet.";
            case "High Risk" -> "High risk: consult a healthcare professional and make lifestyle changes.";
            default -> "Critical risk: seek immediate medical attention.";
        };
    }
}
