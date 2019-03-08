package pl.rengreen.todolist.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    @Column(length = 1200)
    @Size(max=1200)
    private String description;
    @NotNull
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @NotNull
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private boolean isCompleted;
    @ManyToOne
    @JoinColumn(name = "USER_EMAIL")
    private User user;

    public Task() {
    }

    public Task(String name, String description, LocalDate startDate, LocalDate endDate, boolean isCompleted) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isCompleted = isCompleted;
    }

    public Task(String name, String description, LocalDate startDate, LocalDate endDate, boolean isCompleted, User user) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isCompleted = isCompleted;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
