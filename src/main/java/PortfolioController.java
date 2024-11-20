package main.java;


import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class PortfolioController {

    @GetMapping("/projects")
    public List<Project> getProjects(){
        List<Project> projects = new ArrayList<>();
        projects.add(new Project("Portfolio Website", "a personal portfolio site", "https://github.com/rachlavallee"));
        projects.add(new Project("Expense Tracker", "A Java-based budgeting app", "https://github.com/rachlavallee"));

        return projects;
    }

    @PostMapping("/contact")
    public Response sendContact(@RequestBody ContactForm form) {
        System.out.println("Message from " + form.getName() + ": " + form.getMessage());
        return new Response("Thank you for your message, " + form.getName() + "!");
    }

}

class Project{
    private String name;
    private String description;
    private String link;

    public Project(String name, String description, String link){
        this.name = name;
        this.description = description;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

class ContactForm{
    private String name;
    private String email;
    private String message;

    public ContactForm(String name, String email, String message){
        this.name = name;
        this.email = email;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

class Response{
    private String message;

    public Response(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}