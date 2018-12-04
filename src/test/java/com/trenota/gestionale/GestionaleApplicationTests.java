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
}