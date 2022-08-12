package hlybchenko.librarian.controllers;

import hlybchenko.librarian.dao.BookDAO;
import hlybchenko.librarian.models.Book;
import hlybchenko.librarian.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/book")
public class BookController {
    private final BookDAO bookDAO;

    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }


    @GetMapping()
    public String index(Model model){
        model.addAttribute("book", bookDAO.index());
        System.out.println(model.getAttribute("book"));
        return "views/book/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("book", bookDAO.show(id));
        return "views/book/show";
    }

    @GetMapping("/new")
    public String newBook(Model model){
        model.addAttribute("book", new Book());
        return "views/book/new";
    }

    @PostMapping
    public String createPerson(@ModelAttribute("book") Book book, BindingResult bindingResult){
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
    public String update(@ModelAttribute("book") Book book,
                         BindingResult bindingResult, @PathVariable int id){
        if (bindingResult.hasErrors()) return "views/book/edit";
        bookDAO.update(id, book);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        bookDAO.delete(id);
        return "redirect:/book";
    }
}
