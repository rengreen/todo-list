package pl.rengreen.todolist.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.rengreen.todolist.domain.Role;
import pl.rengreen.todolist.domain.Task;
import pl.rengreen.todolist.domain.User;
import pl.rengreen.todolist.service.RoleService;
import pl.rengreen.todolist.service.TaskService;
import pl.rengreen.todolist.service.UserService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private RoleService roleService;
    private UserService userService;
    private TaskService taskService;
    private final Logger logger = LoggerFactory.getLogger(DataLoader.class);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Task task;


        //ROLES --------------------------------------------------------------------------------------------------------
        Role roleAdmin = new Role("ADMIN");
        roleService.saveRole(new Role("ADMIN"));
        logger.info("saved role: " + roleAdmin.getName());

        Role roleUser = new Role("USER");
        roleService.saveRole(roleUser);
        logger.info("saved role: " + roleUser.getName());

        //USERS --------------------------------------------------------------------------------------------------------
        //1
        User admin = new User("admin@mail.com", "admin", "adminadmin");
        userService.createAdmin(admin);
        logger.info("saved user: " + admin.getName());

        //2
        User user = new User("user@mail.com", "user","useruser");
        userService.createUser(user);
        logger.info("saved user: " + user.getName());

        //3
        user = new User("mark@mail.com", "Mark", "11111111");
        userService.createUser(user);
        logger.info("saved user: " + user.getName());

        //4
        user = new User("ann@supermail.com", "Ann", "11111111");
        userService.createUser(user);
        logger.info("saved user: " + user.getName());

        //5
        user = new User("ralf@bestmail.com", "Ralf", "11111111");
        userService.createUser(user);
        logger.info("saved user: " + user.getName());

        //6
        user = new User("kate@quickmail.com", "Kate", "11111111");
        userService.createUser(user);
        logger.info("saved user: " + user.getName());
        User userKate = new User();

        //7
        user = new User("tom@fakemail.com", "Tom", "11111111");
        userService.createUser(user);
        logger.info("saved user: " + user.getName());

        //TASKS --------------------------------------------------------------------------------------------------------
        //tasks from Web Design Checklist https://www.beewits.com/the-ultimate-web-design-checklist-things-to-do-when-launching-a-website/#Download_a_softcopy_of_the_checklist
        //1
        task = new Task();
        task.setName("First meeting");
        task.setDescription("Setup first meetings with client");
        LocalDate startDate = LocalDate.parse("01-04-2019", formatter);
        LocalDate endDate = LocalDate.parse("02-04-2019", formatter);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setCompleted(true);
        task.setUser(userService.getUserByEmail("mark@mail.com"));
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        /*
        //2
        task = new Task();
        task.setName("Briefing document");
        task.setDescription("Define and collect briefing document from client");
        task.setStartDate("2019-03-02");
        task.setEndDate("2019-03-03");
        task.setCompleted(true);
        task.setUser(userService.getUserByEmail("ann@supermail.com"));
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        //3
        task = new Task();
        task.setName("Project questionnaire");
        task.setDescription("Define and send project questionnaire to the client and wait for the client’s response. Finalize project questionnaire from client");
        task.setStartDate("2019-03-03");
        task.setEndDate("2019-03-04");
        task.setCompleted(true);
        task.setUser(userService.getUserByEmail("ralf@bestmail.com"));
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        //4
        task = new Task();
        task.setName("Client’s company research");
        task.setDescription("Research client’s company to understand their brand, the way they communicate, their demographics, target audience");
        task.setStartDate("2019-03-04");
        task.setEndDate("2019-03-05");
        task.setCompleted(true);
        task.setUser(userService.getUserByEmail("kate@quickmail.com"));
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        //5
        task = new Task();
        task.setName("Client’s industry research");
        task.setDescription("Research client’s industry to find ways of communicating specifically to the industry, strengths and weaknesses, and trends");
        task.setStartDate("2019-03-05");
        task.setEndDate("2019-03-06");
        task.setCompleted(false);
        task.setUser(userService.getUserByEmail("kate@quickmail.com"));
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        //6
        task = new Task();
        task.setName("Valuation of development effort");
        task.setDescription("Get quotation for development effort for project");
        task.setStartDate("2019-03-06");
        task.setEndDate("2019-03-07");
        task.setCompleted(false);
        task.setUser(userService.getUserByEmail("mark@mail.com"));
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        //7
        task = new Task();
        task.setName("Valuation of designers work");
        task.setDescription("Get quotation for design, estimate design work with designers");
        task.setStartDate("2019-03-07");
        task.setEndDate("2019-03-08");
        task.setCompleted(false);
        task.setUser(userService.getUserByEmail("mark@mail.com"));
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        //8
        task = new Task();
        task.setName("Valuation of copywriters work");
        task.setDescription("Get quotation for copy/content, estimate work with copywriters");
        task.setStartDate("2019-03-08");
        task.setEndDate("2019-03-09");
        task.setCompleted(false);
        task.setUser(userService.getUserByEmail("ann@supermail.com"));
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        //9
        task = new Task();
        task.setName("Valuation of photos/video");
        task.setDescription("Get quotation for photography/video production or estimate effort involved");
        task.setStartDate("2019-03-09");
        task.setEndDate("2019-03-10");
        task.setCompleted(false);
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' with no user");

        //10
        task = new Task();
        task.setName("Valuation of hosting/domain");
        task.setDescription("Get quotation for Hosting/Domain, particularly if specialized hosting is involved");
        task.setStartDate("2019-03-10");
        task.setEndDate("2019-03-11");
        task.setCompleted(false);
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' with no user");

        */
    }
}

