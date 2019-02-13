package pl.rengreen.todolist.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.rengreen.todolist.domain.Task;
import pl.rengreen.todolist.repository.TaskRepository;

@Component
public class TaskLoader implements ApplicationListener<ContextRefreshedEvent> {

    private TaskRepository productRepository;
    private final Logger logger = LoggerFactory.getLogger(TaskLoader.class);

    @Autowired
    public void setProductRepository(TaskRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Task task;
        //tasks from Web Design Checklist https://www.beewits.com/the-ultimate-web-design-checklist-things-to-do-when-launching-a-website/#Download_a_softcopy_of_the_checklist

        //1
        task = new Task();
        task.setName("first meeting");
        task.setDescription("Setup first meetings with client");
        task.setStartDate("2019-03-01");
        task.setEndDate("2019-03-02");
        task.setCompleted(true);
        task.setUser("Mark");
        productRepository.save(task);
        logger.info("saved task: " + task.getName()+ ", with id: " +task.getId());

        //2
        task = new Task();
        task.setName("briefing document");
        task.setDescription("Define and collect briefing document from client");
        task.setStartDate("2019-03-02");
        task.setEndDate("2019-03-03");
        task.setCompleted(true);
        task.setUser("Ann");
        productRepository.save(task);
        logger.info("saved task: " + task.getName()+ ", with id: " +task.getId());

        //3
        task = new Task();
        task.setName("project questionnaire");
        task.setDescription("Define and send project questionnaire to the client and wait for the client’s response. Finalize project questionnaire from client");
        task.setStartDate("2019-03-03");
        task.setEndDate("2019-03-04");
        task.setCompleted(true);
        task.setUser("Ralf");
        productRepository.save(task);
        logger.info("saved task: " + task.getName()+ ", with id: " +task.getId());

        //4
        task = new Task();
        task.setName("client’s company research");
        task.setDescription("Research client’s company to understand their brand, the way they communicate, their demographics, target audience");
        task.setStartDate("2019-03-04");
        task.setEndDate("2019-03-05");
        task.setCompleted(true);
        task.setUser("Kate");
        productRepository.save(task);
        logger.info("saved task: " + task.getName()+ ", with id: " +task.getId());

        //5
        task = new Task();
        task.setName("client’s industry research");
        task.setDescription("Research client’s industry to find ways of communicating specifically to the industry, strengths and weaknesses, and trends");
        task.setStartDate("2019-03-05");
        task.setEndDate("2019-03-06");
        task.setCompleted(false);
        task.setUser("Tom");
        productRepository.save(task);
        logger.info("saved task: " + task.getName()+ ", with id: " +task.getId());

        //6
        task = new Task();
        task.setName("valuation of development effort");
        task.setDescription("Get quotation for development effort for project");
        task.setStartDate("2019-03-06");
        task.setEndDate("2019-03-07");
        task.setCompleted(false);
        task.setUser("Mark");
        productRepository.save(task);
        logger.info("saved task: " + task.getName()+ ", with id: " +task.getId());

        //7
        task = new Task();
        task.setName("valuation of designers work");
        task.setDescription("Get quotation for design, estimate design work with designers");
        task.setStartDate("2019-03-07");
        task.setEndDate("2019-03-08");
        task.setCompleted(false);
        task.setUser("Mark");
        productRepository.save(task);
        logger.info("saved task: " + task.getName()+ ", with id: " +task.getId());

        //8
        task = new Task();
        task.setName("valuation of copywriters work");
        task.setDescription("Get quotation for copy/content, estimate work with copywriters");
        task.setStartDate("2019-03-08");
        task.setEndDate("2019-03-09");
        task.setCompleted(false);
        task.setUser("Ann");
        productRepository.save(task);
        logger.info("saved task: " + task.getName()+ ", with id: " +task.getId());

        //9
        task = new Task();
        task.setName("valuation of photos/video");
        task.setDescription("Get quotation for photography/video production or estimate effort involved");
        task.setStartDate("2019-03-09");
        task.setEndDate("2019-03-10");
        task.setCompleted(false);
        task.setUser("Ann");
        productRepository.save(task);
        logger.info("saved task: " + task.getName()+ ", with id: " +task.getId());

        //10
        task = new Task();
        task.setName("valuation of hosting/domain");
        task.setDescription("Get quotation for Hosting/Domain, particularly if specialized hosting is involved");
        task.setStartDate("2019-03-10");
        task.setEndDate("2019-03-11");
        task.setCompleted(false);
        task.setUser("Ann");
        productRepository.save(task);
        logger.info("saved task: " + task.getName()+ ", with id: " +task.getId());
    }
}

