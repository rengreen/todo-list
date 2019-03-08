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
    private LocalDate startDate;
    private LocalDate endDate;

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
        //tasks according to Web Design Checklist https://www.beewits.com/the-ultimate-web-design-checklist-things-to-do-when-launching-a-website/#Download_a_softcopy_of_the_checklist

        //1
        task = new Task();
        task.setName("Collect briefing document ");
        task.setDescription("Setup first meeting with client. Collect basic data about the client. Define and collect briefing document from client.");
        startDate = LocalDate.parse("01-04-2019", formatter);
        endDate = LocalDate.parse("02-04-2019", formatter);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setCompleted(true);
        task.setUser(userService.getUserByEmail("mark@mail.com"));
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());


        //2
        task = new Task();
        task.setName("Define project questionnaire ");
        task.setDescription("Define and send project questionnaire to the client and wait for the client’s response. Iterate on doubts you have until everybody is in agreement. Finalize project questionnaire from client.");
        startDate = LocalDate.parse("02-04-2019", formatter);
        endDate = LocalDate.parse("03-04-2019", formatter);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setCompleted(true);
        task.setUser(userService.getUserByEmail("ann@supermail.com"));
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        //3
        task = new Task();
        task.setName("Research client’s company and industry");
        task.setDescription("Research client’s company to understand their brand, the way they communicate, their demographics, target audience. Research client’s industry to find ways of communicating specifically to the industry, strengths and weaknesses, trends and other industry specifics.");
        startDate = LocalDate.parse("03-04-2019", formatter);
        endDate = LocalDate.parse("04-04-2019", formatter);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setCompleted(true);
        task.setUser(userService.getUserByEmail("ralf@bestmail.com"));
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        //4
        task = new Task();
        task.setName("Get quotation for project");
        task.setDescription("Get quotation for development effort for project. Estimate design work with designers. Get quotation for copy/content or estimate work with your copywriters.  Get quotation for photography and video production or estimate effort involved.");
        startDate = LocalDate.parse("04-04-2019", formatter);
        endDate = LocalDate.parse("05-04-2019", formatter);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setCompleted(true);
        task.setUser(userService.getUserByEmail("kate@quickmail.com"));
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        //5
        task = new Task();
        task.setName("Get quotation for hosting and domain");
        task.setDescription("Get quotation for hosting and domain, particularly if specialized hosting is involved such as VPS hosting, cloud hosting, or special hosting or environment requirements.");
        startDate = LocalDate.parse("05-04-2019", formatter);
        endDate = LocalDate.parse("06-04-2019", formatter);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setCompleted(false);
        task.setUser(userService.getUserByEmail("kate@quickmail.com"));
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        //6
        task = new Task();
        task.setName("Check the quality of each content element");
        task.setDescription("Quality assure each piece of content you have outsourced or bought – and ask for changes where necessary. Populate the website content with the various content items you have agreed with the client.");
        startDate = LocalDate.parse("06-04-2019", formatter);
        endDate = LocalDate.parse("07-04-2019", formatter);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setCompleted(false);
        task.setUser(userService.getUserByEmail("mark@mail.com"));
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        //7
        task = new Task();
        task.setName("Define a Contact Us page and social media details");
        task.setDescription("Define a Contact Us page with correct client details and a map. Populate links and icongraphy with links to relevant social media details. Create a link to your website in the footer (make sure it has been agreed with the client to do so)");
        startDate = LocalDate.parse("07-04-2019", formatter);
        endDate = LocalDate.parse("08-04-2019", formatter);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setCompleted(false);
        task.setUser(userService.getUserByEmail("mark@mail.com"));
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        //8
        task = new Task();
        task.setName("Check all web copywriting");
        task.setDescription("Make sure web copywriting has been proofread and ran through a spelling and grammar checker to check for correctness. Use online tools such as Reverso, or Spellcheckplus.com. Check that generic content, such as lorem ipsum, has been properly removed and replaced.");
        startDate = LocalDate.parse("08-04-2019", formatter);
        endDate = LocalDate.parse("09-04-2019", formatter);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setCompleted(false);
        task.setUser(userService.getUserByEmail("ann@supermail.com"));
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' for user: "+task.getUser().getName());

        //9
        task = new Task();
        task.setName("Check all images and videos");
        task.setDescription("See that all images are in the correct places, smushed, formatted, width and height specified and working on all devices. Confirm that videos and audio files are in the correct places, formatted and working on all devices.");
        startDate = LocalDate.parse("09-04-2019", formatter);
        endDate = LocalDate.parse("10-04-2019", formatter);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setCompleted(false);
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' with no user");

        //10
        task = new Task();
        task.setName("Check all linked content");
        task.setDescription("Test all linked content, such as case studies, ebooks, and whitepapers, and verify that they are correctly linked. Test to see that all internal links across web pages are working properly. Ensure that company logo is linked to the homepage.");
        startDate = LocalDate.parse("10-04-2019", formatter);
        endDate = LocalDate.parse("11-04-2019", formatter);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setCompleted(false);
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' with no user");

        //11
        task = new Task();
        task.setName("Check Contact Us and other Forms");
        task.setDescription("Ensure that Contact Us and other forms are submitting data properly. If the form is sent to an email address ensure that email is received on a mailbox that is monitored, or ensure that content is correctly stored in your database. Verify the Thank-you message or page displayed after form is submitted. Check that Auto-responders are working properly and text in emails has been proofed.");
        startDate = LocalDate.parse("11-04-2019", formatter);
        endDate = LocalDate.parse("12-04-2019", formatter);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setCompleted(false);
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' with no user");

        //12
        task = new Task();
        task.setName("Check all external links");
        task.setDescription("External links across web pages are working properly, and open in a new tab (Fix any broken links using this tool). Ensure that Social media share icons are working properly – that there is a good image for sharing and that the description for sharing is appropriate. Correct your metadata as necessary to ensure social media sharing is working ok.");
        startDate = LocalDate.parse("12-04-2019", formatter);
        endDate = LocalDate.parse("13-04-2019", formatter);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setCompleted(false);
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' with no user");

        //13
        task = new Task();
        task.setName("Check the 404 page and redirects");
        task.setDescription("Try a non-existing address on your page to check the 404 page and 404 redirect pages are in place. Choose www vs no-www and make sure that ONLY one of them is working to ensure you don’t get penalized for duplicate content. After choosing one, make sure one redirects to the other.");
        startDate = LocalDate.parse("13-04-2019", formatter);
        endDate = LocalDate.parse("14-04-2019", formatter);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setCompleted(false);
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' with no user");

        //14
        task = new Task();
        task.setName("Check if website is mobile-friendly");
        task.setDescription("Make sure that viewport meta tag is used. Check that  website is mobile-friendly with at least a MobileOk score of 75. Check if Google sees your page as Mobile-Friendly. Make sure that correct input types for email, phone and URL input form fields are used to ensure these are rendered correctly on mobile phones.");
        startDate = LocalDate.parse("14-04-2019", formatter);
        endDate = LocalDate.parse("15-04-2019", formatter);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setCompleted(false);
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' with no user");

        //15
        task = new Task();
        task.setName("Test website on emulators and real devices");
        task.setDescription("Check how the site looks on emulators such as ipadpeek, screenfly, mobilephonesimulator. Test the site using real devices you have accessible to you or use opendevicelab.com.");
        startDate = LocalDate.parse("15-04-2019", formatter);
        endDate = LocalDate.parse("16-04-2019", formatter);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setCompleted(false);
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' with no user");

        //16
        task = new Task();
        task.setName("Check page titles, meta descriptions and keywords");
        task.setDescription("Check that all pages have unique page titles (with a recommended length of fewer than 70 characters, including any keywords). Check that all pages have unique meta descriptions (with a recommended length of fewer than 156 characters, including keywords). Verify that pages have your chosen keywords included without any keyword stuffing (do not over-emphasize particular keywords)");
        startDate = LocalDate.parse("16-04-2019", formatter);
        endDate = LocalDate.parse("17-04-2019", formatter);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setCompleted(false);
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' with no user");

        //17
        task = new Task();
        task.setName("Check page URLs");
        task.setDescription("See that all page URLs consistently reflect site information architecture. If you have had another older website, make sure you have 301 redirects in place for all old URLs (redirecting old pages to new ones).");
        startDate = LocalDate.parse("17-04-2019", formatter);
        endDate = LocalDate.parse("18-04-2019", formatter);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setCompleted(false);
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' with no user");

        //18
        task = new Task();
        task.setName("Minify and optimize files");
        task.setDescription("Minify javascript and CSS files. Optimize the size of images and replace the existing images with the optimized images. Specify image dimensions for each image. Enable gzip compression on your hosting server");
        startDate = LocalDate.parse("18-04-2019", formatter);
        endDate = LocalDate.parse("19-04-2019", formatter);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setCompleted(false);
        taskService.createTask(task);
        logger.info("saved task: '" + task.getName()+"' with no user");
    }
}

