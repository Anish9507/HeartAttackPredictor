# HeartAttackPredictor
# 🫀 Heart Attack Predictor (Web App)

A simple and professional web app that predicts your heart attack risk based on user inputs like age, gender, smoking habits, etc.  
Originally built as a **Java Swing desktop app**, now upgraded into a **Spring Boot + HTML + CSS web version** — fully deployable on [Render](https://render.com).

---

## 🚀 Features

- Clean & minimal user interface  
- Backend powered by Spring Boot (Java)  
- Frontend made with HTML + CSS  
- Shows result on a separate page  
- Ready-to-deploy build for Render  

---

## 🧩 Tech Stack

| Layer | Technology |
|:------|:------------|
| Backend | Java (Spring Boot) |
| Frontend | HTML, CSS (Thymeleaf templates) |
| Build Tool | Maven |
| Server | Embedded Tomcat |
| Deployment | Render Web Service |

---

## ⚙️ How to Run Locally

### 1️⃣ Prerequisites
- Java 17+  
- Maven installed (`mvn -v` to check)

### 2️⃣ Build & Run
```bash
mvn clean package
java -jar target/heartapp-1.0.jar
