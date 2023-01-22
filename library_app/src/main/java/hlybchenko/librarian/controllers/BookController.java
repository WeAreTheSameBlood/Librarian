package hlybchenko.librarian.controllers;

import hlybchenko.librarian.models.Book;
import hlybchenko.librarian.models.Person;
import hlybchenko.librarian.services.BooksService;
import hlybchenko.librarian.services.PeopleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/book")
public class BookController {

    private final BooksService booksService;
    private final PeopleService peopleService;

    public BookController(BooksService booksService, PeopleService peopleService) {
        this.booksService = booksService;
        this.peopleService = peopleService;
    }


    @GetMapping()
    public String index(Model model,
                        @RequestParam(required = false) Integer numPage,
                        @RequestParam(required = false) Integer itemsOnPage,
                        @RequestParam(required = false) String sortBy,
                        @RequestParam(required = false) String findByTitle){
        model.addAttribute("books", booksService.findAll(numPage, itemsOnPage, sortBy));
        model.addAttribute("numPage", numPage);
        model.addAttribute("itemsOnPage", itemsOnPage);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("searchBarObjects", booksService.searchByTitle(findByTitle));
        return "views/book/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,
                       Model model,
                       @ModelAttribute("person") Person person){
        model.addAttribute("book", booksService.show(id));
        model.addAttribute("people", peopleService.findAll());
        model.addAttribute("personWithBook", booksService.getBookOwner(id));
        model.addAttribute("checkExpirationDate", booksService.checkExpirationDate(id));
        return "views/book/show";
    }

    @GetMapping("/new")
    public String newBook(Model model){
        model.addAttribute("book", new Book());
        return "views/book/new";
    }

    @PostMapping
    public String createBook(@ModelAttribute("book") @Valid Book book,
                             BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "views/book/new";
        booksService.save(book);
        return "redirect:/book";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model,
                       @PathVariable int id){
        model.addAttribute("book", booksService.show(id));
        return "views/book/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book book,
                         BindingResult bindingResult,
                         @PathVariable int id){
        if (bindingResult.hasErrors()) return "views/book/edit";
        booksService.update(id, book);
        return "redirect:/book";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        booksService.delete(id);
        return "redirect:/book";
    }

    @PatchMapping("/{id}/bind")
    public String bindBook(@ModelAttribute("person") Person person,
                           @ModelAttribute("book") Book book,
                           @PathVariable int id){
        booksService.bind(id, person.getId());
        return "redirect:/book/"+id;
    }

    @PatchMapping("/{id}/unbind")
    public String unbindBook(@ModelAttribute("book") Book book,
                             @PathVariable int id){
        booksService.unbind(id);
        return "redirect:/book/"+id;
    }
}