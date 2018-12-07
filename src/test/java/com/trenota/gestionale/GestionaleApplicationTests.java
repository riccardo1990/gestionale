package com.trenota.gestionale;

import com.trenota.gestionale.model.Book;
import com.trenota.gestionale.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "dev")
@SpringBootTest
public class GestionaleApplicationTests {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
	private BookService bookService;

	@Test
    public void contextLoads() {
        try{
            Book b = new Book();
            b.setPrice(300.01);
            b.setId(4l);
            b.setName("Mai letto un libro");
            bookService.save(b);
            String res = bookService.findOne(1l ).isPresent()? "TROVATO" : "NON TROVATO";
            System.out.print(res);
        }catch(Exception ex){
            log.error("contextLoads err:{}", ex.getMessage());
        }
    }

    @Test
    public void testLambda() {
            List<Container> listContainer = initializeObj();

            List<Container> filteredCars = listContainer.stream()
                    .filter(containersInitial -> containersInitial.getListaUtenti()
                            .stream()
                            .anyMatch(user -> user.getProjectId().equals("3")))
                    .collect(Collectors.toList());

            filteredCars.size();
    }

    private List<Container> initializeObj(){
	    List<Container> listContainer = new ArrayList<>();

	    Container container1 =  new Container();
	    container1.setContainerCode("CONT-1");
	    container1.setListaUtenti(new ArrayList<>());
	    container1.getListaUtenti().add(new Utenti("Pino", "Gigi", "2"));
        container1.getListaUtenti().add(new Utenti("Miao", "vv", "4"));
        container1.getListaUtenti().add(new Utenti("AA", "cc", "8"));
        listContainer.add(container1);

        Container container2 =  new Container();
        container2.setContainerCode("CONT-2");
        container2.setListaUtenti(new ArrayList<>());
        container2.getListaUtenti().add(new Utenti("za", "bn", "8"));
        container2.getListaUtenti().add(new Utenti("sa", "mo", "7"));
        container2.getListaUtenti().add(new Utenti("dd", "io", "1"));
        listContainer.add(container2);

        Container container3 =  new Container();
        container3.setContainerCode("CONT-3");
        container3.setListaUtenti(new ArrayList<>());
        container3.getListaUtenti().add(new Utenti("re", "pl", "2"));
        container3.getListaUtenti().add(new Utenti("tt", "iu", "3"));
        container3.getListaUtenti().add(new Utenti("yy", "yt", "1"));
        listContainer.add(container3);

        return listContainer;
    }
}