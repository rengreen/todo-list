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
import pl.rengreen.todolist.repository.RoleRepository;
import pl.rengreen.todolist.repository.TaskRepository;
import pl.rengreen.todolist.repository.UserRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TaskLoader implements ApplicationListener<ContextRefreshedEvent> {

    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private TaskRepository taskRepository;
    private final Logger logger = LoggerFactory.getLogger(TaskLoader.class);

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Task task;


        //ROLES --------------------------------------------------------------------------------------------------------
        //1
        Role roleAdmin = new Role();
        roleAdmin.setName("ADMIN");
        roleRepository.save(roleAdmin);
        logger.info("saved role: " + roleAdmin.getName());

        //2
        Role roleUser = new Role();
        roleUser.setName("USER");
        roleRepository.save(roleUser);
        logger.info("saved role: " + roleUser.getName());

        //USERS --------------------------------------------------------------------------------------------------------
        //roles for Admin
        List<Role> roles = new ArrayList<>();
        roles.add(roleAdmin);

        //1
        User admin = new User();
        admin.setEmail("admin@mail.com");
        admin.setName("admin");
        admin.setPassword("adminadmin");
        roles = new ArrayList<>();
        roles.add(roleAdmin);
        admin.setRoles(roles);
        userRepository.save(admin);
        logger.info("saved user: " + admin.getName());

        //roles for Users
        roles = new ArrayList<>();
        roles.add(roleUser);

        //2
        User user = new User();
        user.setEmail("user@mail.com");
        user.setName("user");
        user.setPassword("useruser");
        user.setRoles(roles);
        userRepository.save(user);
        logger.info("saved user: " + user.getName());

        //3
        User userMark = new User();
        userMark.setEmail("mark@mail.com");
        userMark.setName("Mark");
        userMark.setPassword("11111111");
        userMark.setRoles(roles);
        userRepository.save(userMark);
        logger.info("saved user: " + userMark.getName());

        //4
        User userAnn = new User();
        userAnn.setEmail("ann@supermail.com");
        userAnn.setName("Ann");
        userAnn.setPassword("11111111");
        userAnn.setRoles(roles);
        userRepository.save(userAnn);
        logger.info("saved user: " + userAnn.getName());

        //5
        User userRalf = new User();
        userRalf.setEmail("ralf@bestmail.com");
        userRalf.setName("Ralf");
        userRalf.setPassword("11111111");
        userRalf.setRoles(roles);
        userRepository.save(userRalf);
        logger.info("saved user: " + userRalf.getName());

        //6
        User userKate = new User();
        userKate.setEmail("kate@quickmail.com");
        userKate.setName("Kate");
        userKate.setPassword("11111111");
        userKate.setRoles(roles);
        userRepository.save(userKate);
        logger.info("saved user: " + userKate.getName());

        //TASKS --------------------------------------------------------------------------------------------------------
        //tasks from Web Design Checklist https://www.beewits.com/the-ultimate-web-design-checklist-things-to-do-when-launching-a-website/#Download_a_softcopy_of_the_checklist
        //1
        task = new Task();
        task.setName("First meeting");
        task.setDescription("Setup first meetings with client");
        task.setStartDate("2019-03-01");
        task.setEndDate("2019-03-02");
        task.setCompleted(true);
        task.setUser(userMark);
        taskRepository.save(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        //2
        task = new Task();
        task.setName("Briefing document");
        task.setDescription("Define and collect briefing document from client");
        task.setStartDate("2019-03-02");
        task.setEndDate("2019-03-03");
        task.setCompleted(true);
        task.setUser(userAnn);
        taskRepository.save(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        //3
        task = new Task();
        task.setName("Project questionnaire");
        task.setDescription("Define and send project questionnaire to the client and wait for the client’s response. Finalize project questionnaire from client");
        task.setStartDate("2019-03-03");
        task.setEndDate("2019-03-04");
        task.setCompleted(true);
        task.setUser(userRalf);
        taskRepository.save(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        //4
        task = new Task();
        task.setName("Client’s company research");
        task.setDescription("Research client’s company to understand their brand, the way they communicate, their demographics, target audience");
        task.setStartDate("2019-03-04");
        task.setEndDate("2019-03-05");
        task.setCompleted(true);
        task.setUser(userKate);
        taskRepository.save(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        //5
        task = new Task();
        task.setName("Client’s industry research");
        task.setDescription("Research client’s industry to find ways of communicating specifically to the industry, strengths and weaknesses, and trends");
        task.setStartDate("2019-03-05");
        task.setEndDate("2019-03-06");
        task.setCompleted(false);
        task.setUser(userKate);
        taskRepository.save(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        //6
        task = new Task();
        task.setName("Valuation of development effort");
        task.setDescription("Get quotation for development effort for project");
        task.setStartDate("2019-03-06");
        task.setEndDate("2019-03-07");
        task.setCompleted(false);
        task.setUser(userMark);
        taskRepository.save(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        //7
        task = new Task();
        task.setName("Valuation of designers work");
        task.setDescription("Get quotation for design, estimate design work with designers");
        task.setStartDate("2019-03-07");
        task.setEndDate("2019-03-08");
        task.setCompleted(false);
        task.setUser(userMark);
        taskRepository.save(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        //8
        task = new Task();
        task.setName("Valuation of copywriters work");
        task.setDescription("Get quotation for copy/content, estimate work with copywriters");
        task.setStartDate("2019-03-08");
        task.setEndDate("2019-03-09");
        task.setCompleted(false);
        task.setUser(userAnn);
        taskRepository.save(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        //9
        task = new Task();
        task.setName("Valuation of photos/video");
        task.setDescription("Get quotation for photography/video production or estimate effort involved");
        task.setStartDate("2019-03-09");
        task.setEndDate("2019-03-10");
        task.setCompleted(false);
        taskRepository.save(task);
        logger.info("saved task: '" + task.getName()+"' with no user");

        //10
        task = new Task();
        task.setName("Valuation of hosting/domain");
        task.setDescription("Get quotation for Hosting/Domain, particularly if specialized hosting is involved");
        task.setStartDate("2019-03-10");
        task.setEndDate("2019-03-11");
        task.setCompleted(false);
        taskRepository.save(task);
        logger.info("saved task: '" + task.getName()+"' with no user");
    }
}

