package hlybchenko.librarian.controllers;

import hlybchenko.librarian.dao.BookDAO;
import hlybchenko.librarian.dao.PersonDAO;
import hlybchenko.librarian.models.Book;
import hlybchenko.librarian.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/book")
public class BookController {
    private final BookDAO bookDAO;
    private final PersonDAO personDAO;

    public BookController(BookDAO bookDAO, PersonDAO personDAO) {
        this.bookDAO = bookDAO;
        this.personDAO = personDAO;
    }


    @GetMapping()
    public String index(Model model){
        model.addAttribute("book", bookDAO.index());
        return "views/book/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model,
                       @ModelAttribute("person") Person person){
        model.addAttribute("book", bookDAO.show(id));
        model.addAttribute("people", personDAO.index());
        model.addAttribute("personWithBook", bookDAO.getBookOwner(id));
        return "views/book/show";
    }

    @GetMapping("/new")
    public String newBook(Model model){
        model.addAttribute("book", new Book());
        return "views/book/new";
    }

    @PostMapping
    public String createBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "views/book/new";
        bookDAO.save(book);
        return "redirect:/book";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id){
        model.addAttribute("book", bookDAO.show(id));
        return "views/book/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book book,
                         BindingResult bindingResult, @PathVariable int id){
        if (bindingResult.hasErrors()) return "views/book/edit";
        bookDAO.update(id, book);
        return "redirect:/book";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        bookDAO.delete(id);
        return "redirect:/book";
    }

    @PatchMapping("/{id}/bind")
    public String bindBook(@ModelAttribute("person") Person person,
                           @ModelAttribute("book") Book book,
                           @PathVariable int id){
        bookDAO.bind(id, person.getId());
        return "redirect:/book/"+id;
    }

    @PatchMapping("/{id}/unbind")
    public String unbindBook(@ModelAttribute("book") Book book,
                           @PathVariable int id){
        bookDAO.unbind(id);
        return "redirect:/book/"+id;
    }
}